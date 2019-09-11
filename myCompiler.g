grammar myCompiler;

options {
   language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.Queue;
    import java.util.LinkedList;

}

@members {
    boolean TRACEON = false;

    // ============================================
    // Create a symbol table.
	// ArrayList is easy to extend to add more info. into symbol table.
	//
	// The structure of symbol table:
	// <variable ID, type, memory location>
	//    - type: the variable type   (please check "enum Type")
	//    - memory location: the location (locals in VM) the variable will be stored at.
    // ============================================
    HashMap<String, ArrayList> symtab = new HashMap<String, ArrayList>();

    int labelCount = 0;
   String[] remain=new String[20];
	int maxremain;

   Queue<Integer> rqueue = new LinkedList<Integer>();

	// storageIndex is used to represent/index the location (locals) in VM.
	// The first index is 0.
	int storageIndex = 0;
   

    // Record all assembly instructions.
    List<String> TextCode = new ArrayList<String>();

    // Type information.
    public enum Type{
       INT, FLOAT, CHAR;
    }


    /*
     * Output prologue.
     */
    void prologue()
    {
       TextCode.add(";.source");
       TextCode.add(".class public static myResult");
       TextCode.add(".super java/lang/Object");
       TextCode.add(".method public static main([Ljava/lang/String;)V");

       /* The size of stack and locals should be properly set. */
       TextCode.add(".limit stack 100");
       TextCode.add(".limit locals 100");
    }
    
	
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       TextCode.add("return");
       TextCode.add(".end method");
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount ++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    
    public List<String> getTextCode()
    {
       return TextCode;
    }			

   	
}

program: VOID MAIN '(' ')'
        {
           /* Output function prologue */
           prologue();
        }

        '{' 
           declarations
           statements
        '}'
        {
		   if (TRACEON)
		      System.out.println("VOID MAIN () {declarations statements}");

           /* output function epilogue */	  
           epilogue();
        }
        ;


declarations: type Identifier ';' declarations
              {
			     if (TRACEON)
	                System.out.println("declarations: type Identifier : declarations");

                 if (symtab.containsKey($Identifier.text)) {
				    // variable re-declared.
                    System.out.println("Type Error: " + 
                                       $Identifier.getLine() + 
                                       ": Redeclared identifier.");
                    System.exit(0);
                 }
                 
				 /* Add ID and its attr_type into the symbol table. */
				 ArrayList the_list = new ArrayList();
				 the_list.add($type.attr_type);
				 the_list.add(storageIndex);
				 storageIndex = storageIndex + 1;
                 symtab.put($Identifier.text, the_list);
              }
            | 
		      {
			     if (TRACEON)
                    System.out.println("declarations: ");
			  }
            ;


type
returns [Type attr_type]
    : INT { if (TRACEON) System.out.println("type: INT"); attr_type=Type.INT; }
    | CHAR { if (TRACEON) System.out.println("type: CHAR"); attr_type=Type.CHAR; }
    | FLOAT {if (TRACEON) System.out.println("type: FLOAT"); attr_type=Type.FLOAT; }
	;

statements:statement statements
          |
          ;

statement: assign_stmt ';'
         | if_stmt
         | func_no_return_stmt ';'
      
         ;


		 
if_stmt
            : s=if_then_stmt if_else_stmt[$s.next]{
               TextCode.add($s.next+":");
            }
            ;

	   
if_then_stmt
returns [String next]
            : IF '(' b=cond_expression ')'     
            {
               next=newLabel();
               TextCode.add($b.Ctrue+": ");
            }
             block_stmt[next]{
                 TextCode.add($b.Cfalse+": ");
             }

       
            ;


if_else_stmt[String next]
            : ELSE block_stmt[next]
            |
            ;

				  
block_stmt[String next]
: '{' statements '}'
{
   TextCode.add("goto " + next);
}
	  ;


assign_stmt: Identifier '=' arith_expression
             {
			   Type the_type;
			   int the_mem;
			   
			   // get the ID's location and type from symtab.			   
			   the_type = (Type) symtab.get($Identifier.text).get(0);
			   the_mem = (int) symtab.get($Identifier.text).get(1);
			   
			   if (the_type != $arith_expression.attr_type) {
			      System.out.println("Type error!\n");
				  System.exit(0);
			   }
			   
			   // issue store insruction:
               // => store the top element of the operand stack into the locals.
			   switch (the_type) {
			   case INT:
			              TextCode.add("istore " + the_mem);
			              break;
			   case FLOAT:
                        TextCode.add("fstore " + the_mem);
			              break;

			   }
             }
           ;

		   
func_no_return_stmt: a=Identifier {
                        if($a.text.equals("printf")){
                           TextCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
                        }
                     } '(' b=argument ')'
                     {
                      
                     }
                   ;


argument returns[Type attr_type,int type,int cnt]:
         arg (',' arg)*
        ;

arg 
returns[Type attr_type,int type,int cnt]
@init {int cnt=0;}  : 
{
     TextCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
}
            a= arith_expression{
               $attr_type=$a.attr_type; 
               if($attr_type==Type.FLOAT){
               TextCode.add("invokevirtual java/io/PrintStream/print(F)V");
               }
               if($attr_type==Type.INT){
               TextCode.add("invokevirtual java/io/PrintStream/print(I)V");
               }
               if( maxremain!=0 ){
                   TextCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
                   TextCode.add("ldc "+remain[rqueue.poll()]);
                   maxremain--;
                   TextCode.add("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
               }
            }
   | STRING_LITERAL{ 
      int i=0;

      String k= $STRING_LITERAL.text.replace("\%d","\"\%\"");
      k= k.replace("\%f","\"\%\"");
      for( String tmp : k.split("\%")){
         //System.out.println(tmp);
            remain[i]=tmp;
            rqueue.offer(i);
            i++;
            maxremain=i;
      }
      $attr_type=Type.CHAR; 
      TextCode.add("ldc "+remain[rqueue.poll()]);
      maxremain--;
      TextCode.add("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
   }
   ;
		   
cond_expression
returns [boolean truth,String Ctrue,String Cfalse]
               : a=arith_expression
			     {
				    if ($a.attr_type.ordinal() != 0)
					   $truth = true;
					else
					  $truth = false;
				 }
                 (op=RelationOP b=arith_expression)*
                 {
                    $Ctrue=newLabel();
                    $Cfalse=newLabel();

					      // We need to do type checking first.
						  // ...
						  
						  // code generation.
						  if (($a.attr_type == Type.INT) &&
						      ($b.attr_type == Type.INT)){
                           switch($op.text){
                              case "==": 
                              TextCode.add("if_icmpne "+$Cfalse);
                                break;
                              case ">=": TextCode.add("if_icmplt "+$Cfalse);
                                break;
                              case ">": TextCode.add("if_icmple "+ $Cfalse);
                                break;
                              case "<": TextCode.add("if_icmpgt "+ $Cfalse);
                                break;
                              case "<=": TextCode.add("if_icmpge "+$Cfalse);
                                break;
                              case "!=": TextCode.add("if_icmpeq "+$Cfalse);
                                break;
                           }
                         
                        }
						    
             
                   if (($a.attr_type == Type.FLOAT) &&
						      ($b.attr_type == Type.FLOAT)){
                            TextCode.add("fcmpl");
                        
						     switch($op.text){
                              case "==": 
                              TextCode.add("ifne "+$Cfalse);
                                break;
                              case ">=": TextCode.add("iflt "+$Cfalse);
                                break;
                              case ">": TextCode.add("ifle "+ $Cfalse);
                                break;
                              case "<": TextCode.add("ifgt "+ $Cfalse);
                                break;
                              case "<=": TextCode.add("ifge "+$Cfalse);
                                break;
                              case "!=": TextCode.add("ifeq "+$Cfalse);
                                break;
                           }
                        }
                 }
               ;

			   
arith_expression
returns [Type attr_type]
                : a=multExpr { $attr_type = $a.attr_type; }
                 ( '+' b=multExpr
                       {
					      // We need to do type checking first.
						  // ...
						  
						  // code generation.
						  if (($attr_type == Type.INT) &&
						      ($b.attr_type == Type.INT))
						     TextCode.add("iadd");
             
                   if (($attr_type == Type.FLOAT) &&
						      ($b.attr_type == Type.FLOAT))
						     TextCode.add("fadd");
                       }

                 | '-' c=multExpr { $attr_type = $a.attr_type; }
                        {
					      // We need to do type checking first.
						  // ...
						  
						  // code generation.
						  if (($attr_type == Type.INT) &&
						      ($c.attr_type == Type.INT))
						     TextCode.add("isub");
                     
                     if (($attr_type == Type.FLOAT) &&
						      ($c.attr_type == Type.FLOAT))
						     TextCode.add("fsub");
                       }
                       
                 )*
                 ;

multExpr
returns [Type attr_type]
          : a=signExpr { $attr_type=$a.attr_type; }
          ( '*' b=signExpr {
					      // We need to do type checking first.
						  // ...
						  
						  // code generation.
						  if (($attr_type == Type.INT) &&
						      ($b.attr_type == Type.INT))
						     TextCode.add("imul");
                     
                     if (($attr_type == Type.FLOAT) &&
						      ($b.attr_type == Type.FLOAT))
						     TextCode.add("fmul");

                       }
          | '/' c=signExpr
          {
					      // We need to do type checking first.
						  // ...
						  
						  // code generation.
						  if (($attr_type == Type.INT) &&
						      ($c.attr_type == Type.INT))
						     TextCode.add("idiv");

                     if (($attr_type == Type.FLOAT) &&
						      ($c.attr_type == Type.FLOAT))
						     TextCode.add("fdiv");

                       }
	  )*
	  ;

signExpr
returns [Type attr_type]
        : a=primaryExpr { $attr_type=$a.attr_type; } 
        | '-' b=primaryExpr{ $attr_type=$a.attr_type; }
	;
		  
primaryExpr
returns [Type attr_type] 
           : Integer_constant
		     {
			    $attr_type = Type.INT;
				
				// code generation.
				// push the integer into the operand stack.
				TextCode.add("ldc " + $Integer_constant.text);
			   }
           | Floating_point_constant
           		     {
			    $attr_type = Type.FLOAT;
				
				// code generation.
				// push the integer into the operand stack.
				TextCode.add("ldc " + $Floating_point_constant.text);
			   }
           | Identifier
		     {
			    // get type information from symtab.
			    $attr_type = (Type) symtab.get($Identifier.text).get(0);
				
				switch ($attr_type) {
				case INT: 
				          // load the variable into the operand stack.
				          TextCode.add("iload " + symtab.get($Identifier.text).get(1));
				          break;
				case FLOAT:
                        // load the variable into the operand stack.
				          TextCode.add("fload " + symtab.get($Identifier.text).get(1));

				          break;
				case CHAR:
				          break;
				
				}
			 }
	   | '&' Identifier
	   | '(' b=arith_expression ')'
      {
			    $attr_type = $b.attr_type;
				
			   }
           ;

		   
/* description of the tokens */
FLOAT:'float';
INT:'int';
CHAR: 'char';

MAIN: 'main';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';

RelationOP: '>' |'>=' | '<' | '<=' | '==' | '!=';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+ 'f';

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};


fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;
