// $ANTLR 3.5.2 myCompiler.g 2019-06-21 20:49:18

    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.Queue;
    import java.util.LinkedList;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "ELSE", "EscapeSequence", 
		"FLOAT", "FOR", "Floating_point_constant", "IF", "INT", "Identifier", 
		"Integer_constant", "MAIN", "RelationOP", "STRING_LITERAL", "VOID", "WS", 
		"'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'='", 
		"'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int CHAR=4;
	public static final int COMMENT=5;
	public static final int ELSE=6;
	public static final int EscapeSequence=7;
	public static final int FLOAT=8;
	public static final int FOR=9;
	public static final int Floating_point_constant=10;
	public static final int IF=11;
	public static final int INT=12;
	public static final int Identifier=13;
	public static final int Integer_constant=14;
	public static final int MAIN=15;
	public static final int RelationOP=16;
	public static final int STRING_LITERAL=17;
	public static final int VOID=18;
	public static final int WS=19;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCompilerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCompilerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myCompiler.g"; }


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

	   	



	// $ANTLR start "program"
	// myCompiler.g:93:1: program : VOID MAIN '(' ')' '{' declarations statements '}' ;
	public final void program() throws RecognitionException {
		try {
			// myCompiler.g:93:8: ( VOID MAIN '(' ')' '{' declarations statements '}' )
			// myCompiler.g:93:10: VOID MAIN '(' ')' '{' declarations statements '}'
			{
			match(input,VOID,FOLLOW_VOID_in_program36); 
			match(input,MAIN,FOLLOW_MAIN_in_program38); 
			match(input,21,FOLLOW_21_in_program40); 
			match(input,22,FOLLOW_22_in_program42); 

			           /* Output function prologue */
			           prologue();
			        
			match(input,30,FOLLOW_30_in_program63); 
			pushFollow(FOLLOW_declarations_in_program77);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_statements_in_program90);
			statements();
			state._fsp--;

			match(input,31,FOLLOW_31_in_program100); 

					   if (TRACEON)
					      System.out.println("VOID MAIN () {declarations statements}");

			           /* output function epilogue */	  
			           epilogue();
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "declarations"
	// myCompiler.g:113:1: declarations : ( type Identifier ';' declarations |);
	public final void declarations() throws RecognitionException {
		Token Identifier1=null;
		Type type2 =null;

		try {
			// myCompiler.g:113:13: ( type Identifier ';' declarations |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==CHAR||LA1_0==FLOAT||LA1_0==INT) ) {
				alt1=1;
			}
			else if ( (LA1_0==IF||LA1_0==Identifier||LA1_0==31) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// myCompiler.g:113:15: type Identifier ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations127);
					type2=type();
					state._fsp--;

					Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_declarations129); 
					match(input,28,FOLLOW_28_in_declarations131); 
					pushFollow(FOLLOW_declarations_in_declarations133);
					declarations();
					state._fsp--;


								     if (TRACEON)
						                System.out.println("declarations: type Identifier : declarations");

					                 if (symtab.containsKey((Identifier1!=null?Identifier1.getText():null))) {
									    // variable re-declared.
					                    System.out.println("Type Error: " + 
					                                       Identifier1.getLine() + 
					                                       ": Redeclared identifier.");
					                    System.exit(0);
					                 }
					                 
									 /* Add ID and its attr_type into the symbol table. */
									 ArrayList the_list = new ArrayList();
									 the_list.add(type2);
									 the_list.add(storageIndex);
									 storageIndex = storageIndex + 1;
					                 symtab.put((Identifier1!=null?Identifier1.getText():null), the_list);
					              
					}
					break;
				case 2 :
					// myCompiler.g:134:9: 
					{

								     if (TRACEON)
					                    System.out.println("declarations: ");
								  
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "type"
	// myCompiler.g:141:1: type returns [Type attr_type] : ( INT | CHAR | FLOAT );
	public final Type type() throws RecognitionException {
		Type attr_type = null;


		try {
			// myCompiler.g:143:5: ( INT | CHAR | FLOAT )
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt2=1;
				}
				break;
			case CHAR:
				{
				alt2=2;
				}
				break;
			case FLOAT:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// myCompiler.g:143:7: INT
					{
					match(input,INT,FOLLOW_INT_in_type204); 
					 if (TRACEON) System.out.println("type: INT"); attr_type=Type.INT; 
					}
					break;
				case 2 :
					// myCompiler.g:144:7: CHAR
					{
					match(input,CHAR,FOLLOW_CHAR_in_type214); 
					 if (TRACEON) System.out.println("type: CHAR"); attr_type=Type.CHAR; 
					}
					break;
				case 3 :
					// myCompiler.g:145:7: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_type224); 
					if (TRACEON) System.out.println("type: FLOAT"); attr_type=Type.FLOAT; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myCompiler.g:148:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myCompiler.g:148:11: ( statement statements |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IF||LA3_0==Identifier) ) {
				alt3=1;
			}
			else if ( (LA3_0==31) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myCompiler.g:148:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements234);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements236);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:150:11: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// myCompiler.g:152:1: statement : ( assign_stmt ';' | if_stmt | func_no_return_stmt ';' );
	public final void statement() throws RecognitionException {
		try {
			// myCompiler.g:152:10: ( assign_stmt ';' | if_stmt | func_no_return_stmt ';' )
			int alt4=3;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Identifier) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==29) ) {
					alt4=1;
				}
				else if ( (LA4_1==21) ) {
					alt4=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA4_0==IF) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// myCompiler.g:152:12: assign_stmt ';'
					{
					pushFollow(FOLLOW_assign_stmt_in_statement266);
					assign_stmt();
					state._fsp--;

					match(input,28,FOLLOW_28_in_statement268); 
					}
					break;
				case 2 :
					// myCompiler.g:153:12: if_stmt
					{
					pushFollow(FOLLOW_if_stmt_in_statement281);
					if_stmt();
					state._fsp--;

					}
					break;
				case 3 :
					// myCompiler.g:154:12: func_no_return_stmt ';'
					{
					pushFollow(FOLLOW_func_no_return_stmt_in_statement294);
					func_no_return_stmt();
					state._fsp--;

					match(input,28,FOLLOW_28_in_statement296); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "if_stmt"
	// myCompiler.g:160:1: if_stmt : s= if_then_stmt if_else_stmt[$s.next] ;
	public final void if_stmt() throws RecognitionException {
		String s =null;

		try {
			// myCompiler.g:161:13: (s= if_then_stmt if_else_stmt[$s.next] )
			// myCompiler.g:161:15: s= if_then_stmt if_else_stmt[$s.next]
			{
			pushFollow(FOLLOW_if_then_stmt_in_if_stmt340);
			s=if_then_stmt();
			state._fsp--;

			pushFollow(FOLLOW_if_else_stmt_in_if_stmt342);
			if_else_stmt(s);
			state._fsp--;


			               TextCode.add(s+":");
			            
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_stmt"



	// $ANTLR start "if_then_stmt"
	// myCompiler.g:167:1: if_then_stmt returns [String next] : IF '(' b= cond_expression ')' block_stmt[next] ;
	public final String if_then_stmt() throws RecognitionException {
		String next = null;


		ParserRuleReturnScope b =null;

		try {
			// myCompiler.g:169:13: ( IF '(' b= cond_expression ')' block_stmt[next] )
			// myCompiler.g:169:15: IF '(' b= cond_expression ')' block_stmt[next]
			{
			match(input,IF,FOLLOW_IF_in_if_then_stmt386); 
			match(input,21,FOLLOW_21_in_if_then_stmt388); 
			pushFollow(FOLLOW_cond_expression_in_if_then_stmt392);
			b=cond_expression();
			state._fsp--;

			match(input,22,FOLLOW_22_in_if_then_stmt394); 

			               next=newLabel();
			               TextCode.add((b!=null?((myCompilerParser.cond_expression_return)b).Ctrue:null)+": ");
			            
			pushFollow(FOLLOW_block_stmt_in_if_then_stmt428);
			block_stmt(next);
			state._fsp--;


			                 TextCode.add((b!=null?((myCompilerParser.cond_expression_return)b).Cfalse:null)+": ");
			             
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return next;
	}
	// $ANTLR end "if_then_stmt"



	// $ANTLR start "if_else_stmt"
	// myCompiler.g:182:1: if_else_stmt[String next] : ( ELSE block_stmt[next] |);
	public final void if_else_stmt(String next) throws RecognitionException {
		try {
			// myCompiler.g:183:13: ( ELSE block_stmt[next] |)
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ELSE) ) {
				alt5=1;
			}
			else if ( (LA5_0==IF||LA5_0==Identifier||LA5_0==31) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// myCompiler.g:183:15: ELSE block_stmt[next]
					{
					match(input,ELSE,FOLLOW_ELSE_in_if_else_stmt474); 
					pushFollow(FOLLOW_block_stmt_in_if_else_stmt476);
					block_stmt(next);
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:185:13: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_else_stmt"



	// $ANTLR start "block_stmt"
	// myCompiler.g:188:1: block_stmt[String next] : '{' statements '}' ;
	public final void block_stmt(String next) throws RecognitionException {
		try {
			// myCompiler.g:189:3: ( '{' statements '}' )
			// myCompiler.g:189:3: '{' statements '}'
			{
			match(input,30,FOLLOW_30_in_block_stmt520); 
			pushFollow(FOLLOW_statements_in_block_stmt522);
			statements();
			state._fsp--;

			match(input,31,FOLLOW_31_in_block_stmt524); 

			   TextCode.add("goto " + next);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "block_stmt"



	// $ANTLR start "assign_stmt"
	// myCompiler.g:196:1: assign_stmt : Identifier '=' arith_expression ;
	public final void assign_stmt() throws RecognitionException {
		Token Identifier3=null;
		Type arith_expression4 =null;

		try {
			// myCompiler.g:196:12: ( Identifier '=' arith_expression )
			// myCompiler.g:196:14: Identifier '=' arith_expression
			{
			Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_assign_stmt538); 
			match(input,29,FOLLOW_29_in_assign_stmt540); 
			pushFollow(FOLLOW_arith_expression_in_assign_stmt542);
			arith_expression4=arith_expression();
			state._fsp--;


						   Type the_type;
						   int the_mem;
						   
						   // get the ID's location and type from symtab.			   
						   the_type = (Type) symtab.get((Identifier3!=null?Identifier3.getText():null)).get(0);
						   the_mem = (int) symtab.get((Identifier3!=null?Identifier3.getText():null)).get(1);
						   
						   if (the_type != arith_expression4) {
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign_stmt"



	// $ANTLR start "func_no_return_stmt"
	// myCompiler.g:225:1: func_no_return_stmt : a= Identifier '(' b= argument ')' ;
	public final void func_no_return_stmt() throws RecognitionException {
		Token a=null;
		ParserRuleReturnScope b =null;

		try {
			// myCompiler.g:225:20: (a= Identifier '(' b= argument ')' )
			// myCompiler.g:225:22: a= Identifier '(' b= argument ')'
			{
			a=(Token)match(input,Identifier,FOLLOW_Identifier_in_func_no_return_stmt584); 

			                        if((a!=null?a.getText():null).equals("printf")){
			                           TextCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
			                        }
			                     
			match(input,21,FOLLOW_21_in_func_no_return_stmt588); 
			pushFollow(FOLLOW_argument_in_func_no_return_stmt592);
			b=argument();
			state._fsp--;

			match(input,22,FOLLOW_22_in_func_no_return_stmt594); 

			                      
			                     
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "func_no_return_stmt"


	public static class argument_return extends ParserRuleReturnScope {
		public Type attr_type;
		public int type;
		public int cnt;
	};


	// $ANTLR start "argument"
	// myCompiler.g:236:1: argument returns [Type attr_type,int type,int cnt] : arg ( ',' arg )* ;
	public final myCompilerParser.argument_return argument() throws RecognitionException {
		myCompilerParser.argument_return retval = new myCompilerParser.argument_return();
		retval.start = input.LT(1);

		try {
			// myCompiler.g:236:50: ( arg ( ',' arg )* )
			// myCompiler.g:237:10: arg ( ',' arg )*
			{
			pushFollow(FOLLOW_arg_in_argument657);
			arg();
			state._fsp--;

			// myCompiler.g:237:14: ( ',' arg )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==25) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// myCompiler.g:237:15: ',' arg
					{
					match(input,25,FOLLOW_25_in_argument660); 
					pushFollow(FOLLOW_arg_in_argument662);
					arg();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argument"


	public static class arg_return extends ParserRuleReturnScope {
		public Type attr_type;
		public int type;
		public int cnt;
	};


	// $ANTLR start "arg"
	// myCompiler.g:240:1: arg returns [Type attr_type,int type,int cnt] : (a= arith_expression | STRING_LITERAL );
	public final myCompilerParser.arg_return arg() throws RecognitionException {
		myCompilerParser.arg_return retval = new myCompilerParser.arg_return();
		retval.start = input.LT(1);

		Token STRING_LITERAL5=null;
		Type a =null;

		int cnt=0;
		try {
			// myCompiler.g:242:21: (a= arith_expression | STRING_LITERAL )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==Floating_point_constant||(LA7_0 >= Identifier && LA7_0 <= Integer_constant)||(LA7_0 >= 20 && LA7_0 <= 21)||LA7_0==26) ) {
				alt7=1;
			}
			else if ( (LA7_0==STRING_LITERAL) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// myCompiler.g:243:1: a= arith_expression
					{

					     TextCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");

					pushFollow(FOLLOW_arith_expression_in_arg709);
					a=arith_expression();
					state._fsp--;


					               retval.attr_type =a; 
					               if(retval.attr_type==Type.FLOAT){
					               TextCode.add("invokevirtual java/io/PrintStream/print(F)V");
					               }
					               if(retval.attr_type==Type.INT){
					               TextCode.add("invokevirtual java/io/PrintStream/print(I)V");
					               }
					               if( maxremain!=0 ){
					                   TextCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
					                   TextCode.add("ldc "+remain[rqueue.poll()]);
					                   maxremain--;
					                   TextCode.add("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
					               }
					            
					}
					break;
				case 2 :
					// myCompiler.g:261:6: STRING_LITERAL
					{
					STRING_LITERAL5=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_arg717); 
					 
					      int i=0;

					      String k= (STRING_LITERAL5!=null?STRING_LITERAL5.getText():null).replace("%d","\"%\"");
					      k= k.replace("%f","\"%\"");
					      for( String tmp : k.split("%")){
					         //System.out.println(tmp);
					            remain[i]=tmp;
					            rqueue.offer(i);
					            i++;
					            maxremain=i;
					      }
					      retval.attr_type =Type.CHAR; 
					      TextCode.add("ldc "+remain[rqueue.poll()]);
					      maxremain--;
					      TextCode.add("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
					   
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arg"


	public static class cond_expression_return extends ParserRuleReturnScope {
		public boolean truth;
		public String Ctrue;
		public String Cfalse;
	};


	// $ANTLR start "cond_expression"
	// myCompiler.g:280:1: cond_expression returns [boolean truth,String Ctrue,String Cfalse] : a= arith_expression (op= RelationOP b= arith_expression )* ;
	public final myCompilerParser.cond_expression_return cond_expression() throws RecognitionException {
		myCompilerParser.cond_expression_return retval = new myCompilerParser.cond_expression_return();
		retval.start = input.LT(1);

		Token op=null;
		Type a =null;
		Type b =null;

		try {
			// myCompiler.g:282:16: (a= arith_expression (op= RelationOP b= arith_expression )* )
			// myCompiler.g:282:18: a= arith_expression (op= RelationOP b= arith_expression )*
			{
			pushFollow(FOLLOW_arith_expression_in_cond_expression756);
			a=arith_expression();
			state._fsp--;


							    if (a.ordinal() != 0)
								   retval.truth = true;
								else
								  retval.truth = false;
							 
			// myCompiler.g:289:18: (op= RelationOP b= arith_expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==RelationOP) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// myCompiler.g:289:19: op= RelationOP b= arith_expression
					{
					op=(Token)match(input,RelationOP,FOLLOW_RelationOP_in_cond_expression788); 
					pushFollow(FOLLOW_arith_expression_in_cond_expression792);
					b=arith_expression();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}


			                    retval.Ctrue =newLabel();
			                    retval.Cfalse =newLabel();

								      // We need to do type checking first.
									  // ...
									  
									  // code generation.
									  if ((a == Type.INT) &&
									      (b == Type.INT)){
			                           switch((op!=null?op.getText():null)){
			                              case "==": 
			                              TextCode.add("if_icmpne "+retval.Cfalse);
			                                break;
			                              case ">=": TextCode.add("if_icmplt "+retval.Cfalse);
			                                break;
			                              case ">": TextCode.add("if_icmple "+ retval.Cfalse);
			                                break;
			                              case "<": TextCode.add("if_icmpgt "+ retval.Cfalse);
			                                break;
			                              case "<=": TextCode.add("if_icmpge "+retval.Cfalse);
			                                break;
			                              case "!=": TextCode.add("if_icmpeq "+retval.Cfalse);
			                                break;
			                           }
			                         
			                        }
									    
			             
			                   if ((a == Type.FLOAT) &&
									      (b == Type.FLOAT)){
			                            TextCode.add("fcmpl");
			                        
									     switch((op!=null?op.getText():null)){
			                              case "==": 
			                              TextCode.add("ifne "+retval.Cfalse);
			                                break;
			                              case ">=": TextCode.add("iflt "+retval.Cfalse);
			                                break;
			                              case ">": TextCode.add("ifle "+ retval.Cfalse);
			                                break;
			                              case "<": TextCode.add("ifgt "+ retval.Cfalse);
			                                break;
			                              case "<=": TextCode.add("ifge "+retval.Cfalse);
			                                break;
			                              case "!=": TextCode.add("ifeq "+retval.Cfalse);
			                                break;
			                           }
			                        }
			                 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cond_expression"



	// $ANTLR start "arith_expression"
	// myCompiler.g:343:1: arith_expression returns [Type attr_type] : a= multExpr ( '+' b= multExpr | '-' c= multExpr )* ;
	public final Type arith_expression() throws RecognitionException {
		Type attr_type = null;


		Type a =null;
		Type b =null;
		Type c =null;

		try {
			// myCompiler.g:345:17: (a= multExpr ( '+' b= multExpr | '-' c= multExpr )* )
			// myCompiler.g:345:19: a= multExpr ( '+' b= multExpr | '-' c= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression866);
			a=multExpr();
			state._fsp--;

			 attr_type = a; 
			// myCompiler.g:346:18: ( '+' b= multExpr | '-' c= multExpr )*
			loop9:
			while (true) {
				int alt9=3;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==24) ) {
					alt9=1;
				}
				else if ( (LA9_0==26) ) {
					alt9=2;
				}

				switch (alt9) {
				case 1 :
					// myCompiler.g:346:20: '+' b= multExpr
					{
					match(input,24,FOLLOW_24_in_arith_expression889); 
					pushFollow(FOLLOW_multExpr_in_arith_expression893);
					b=multExpr();
					state._fsp--;


										      // We need to do type checking first.
											  // ...
											  
											  // code generation.
											  if ((attr_type == Type.INT) &&
											      (b == Type.INT))
											     TextCode.add("iadd");
					             
					                   if ((attr_type == Type.FLOAT) &&
											      (b == Type.FLOAT))
											     TextCode.add("fadd");
					                       
					}
					break;
				case 2 :
					// myCompiler.g:361:20: '-' c= multExpr
					{
					match(input,26,FOLLOW_26_in_arith_expression940); 
					pushFollow(FOLLOW_multExpr_in_arith_expression944);
					c=multExpr();
					state._fsp--;

					 attr_type = a; 

										      // We need to do type checking first.
											  // ...
											  
											  // code generation.
											  if ((attr_type == Type.INT) &&
											      (c == Type.INT))
											     TextCode.add("isub");
					                     
					                     if ((attr_type == Type.FLOAT) &&
											      (c == Type.FLOAT))
											     TextCode.add("fsub");
					                       
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "arith_expression"



	// $ANTLR start "multExpr"
	// myCompiler.g:379:1: multExpr returns [Type attr_type] : a= signExpr ( '*' b= signExpr | '/' c= signExpr )* ;
	public final Type multExpr() throws RecognitionException {
		Type attr_type = null;


		Type a =null;
		Type b =null;
		Type c =null;

		try {
			// myCompiler.g:381:11: (a= signExpr ( '*' b= signExpr | '/' c= signExpr )* )
			// myCompiler.g:381:13: a= signExpr ( '*' b= signExpr | '/' c= signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr1058);
			a=signExpr();
			state._fsp--;

			 attr_type =a; 
			// myCompiler.g:382:11: ( '*' b= signExpr | '/' c= signExpr )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==23) ) {
					alt10=1;
				}
				else if ( (LA10_0==27) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// myCompiler.g:382:13: '*' b= signExpr
					{
					match(input,23,FOLLOW_23_in_multExpr1074); 
					pushFollow(FOLLOW_signExpr_in_multExpr1078);
					b=signExpr();
					state._fsp--;


										      // We need to do type checking first.
											  // ...
											  
											  // code generation.
											  if ((attr_type == Type.INT) &&
											      (b == Type.INT))
											     TextCode.add("imul");
					                     
					                     if ((attr_type == Type.FLOAT) &&
											      (b == Type.FLOAT))
											     TextCode.add("fmul");

					                       
					}
					break;
				case 2 :
					// myCompiler.g:396:13: '/' c= signExpr
					{
					match(input,27,FOLLOW_27_in_multExpr1094); 
					pushFollow(FOLLOW_signExpr_in_multExpr1098);
					c=signExpr();
					state._fsp--;


										      // We need to do type checking first.
											  // ...
											  
											  // code generation.
											  if ((attr_type == Type.INT) &&
											      (c == Type.INT))
											     TextCode.add("idiv");

					                     if ((attr_type == Type.FLOAT) &&
											      (c == Type.FLOAT))
											     TextCode.add("fdiv");

					                       
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "signExpr"
	// myCompiler.g:414:1: signExpr returns [Type attr_type] : (a= primaryExpr | '-' b= primaryExpr );
	public final Type signExpr() throws RecognitionException {
		Type attr_type = null;


		Type a =null;
		Type b =null;

		try {
			// myCompiler.g:416:9: (a= primaryExpr | '-' b= primaryExpr )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==Floating_point_constant||(LA11_0 >= Identifier && LA11_0 <= Integer_constant)||(LA11_0 >= 20 && LA11_0 <= 21)) ) {
				alt11=1;
			}
			else if ( (LA11_0==26) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// myCompiler.g:416:11: a= primaryExpr
					{
					pushFollow(FOLLOW_primaryExpr_in_signExpr1142);
					a=primaryExpr();
					state._fsp--;

					 attr_type =a; 
					}
					break;
				case 2 :
					// myCompiler.g:417:11: '-' b= primaryExpr
					{
					match(input,26,FOLLOW_26_in_signExpr1157); 
					pushFollow(FOLLOW_primaryExpr_in_signExpr1161);
					b=primaryExpr();
					state._fsp--;

					 attr_type =a; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "signExpr"



	// $ANTLR start "primaryExpr"
	// myCompiler.g:420:1: primaryExpr returns [Type attr_type] : ( Integer_constant | Floating_point_constant | Identifier | '&' Identifier | '(' b= arith_expression ')' );
	public final Type primaryExpr() throws RecognitionException {
		Type attr_type = null;


		Token Integer_constant6=null;
		Token Floating_point_constant7=null;
		Token Identifier8=null;
		Type b =null;

		try {
			// myCompiler.g:422:12: ( Integer_constant | Floating_point_constant | Identifier | '&' Identifier | '(' b= arith_expression ')' )
			int alt12=5;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				alt12=1;
				}
				break;
			case Floating_point_constant:
				{
				alt12=2;
				}
				break;
			case Identifier:
				{
				alt12=3;
				}
				break;
			case 20:
				{
				alt12=4;
				}
				break;
			case 21:
				{
				alt12=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// myCompiler.g:422:14: Integer_constant
					{
					Integer_constant6=(Token)match(input,Integer_constant,FOLLOW_Integer_constant_in_primaryExpr1192); 

								    attr_type = Type.INT;
									
									// code generation.
									// push the integer into the operand stack.
									TextCode.add("ldc " + (Integer_constant6!=null?Integer_constant6.getText():null));
								   
					}
					break;
				case 2 :
					// myCompiler.g:430:14: Floating_point_constant
					{
					Floating_point_constant7=(Token)match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primaryExpr1216); 

								    attr_type = Type.FLOAT;
									
									// code generation.
									// push the integer into the operand stack.
									TextCode.add("ldc " + (Floating_point_constant7!=null?Floating_point_constant7.getText():null));
								   
					}
					break;
				case 3 :
					// myCompiler.g:438:14: Identifier
					{
					Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpr1251); 

								    // get type information from symtab.
								    attr_type = (Type) symtab.get((Identifier8!=null?Identifier8.getText():null)).get(0);
									
									switch (attr_type) {
									case INT: 
									          // load the variable into the operand stack.
									          TextCode.add("iload " + symtab.get((Identifier8!=null?Identifier8.getText():null)).get(1));
									          break;
									case FLOAT:
					                        // load the variable into the operand stack.
									          TextCode.add("fload " + symtab.get((Identifier8!=null?Identifier8.getText():null)).get(1));

									          break;
									case CHAR:
									          break;
									
									}
								 
					}
					break;
				case 4 :
					// myCompiler.g:458:7: '&' Identifier
					{
					match(input,20,FOLLOW_20_in_primaryExpr1268); 
					match(input,Identifier,FOLLOW_Identifier_in_primaryExpr1270); 
					}
					break;
				case 5 :
					// myCompiler.g:459:7: '(' b= arith_expression ')'
					{
					match(input,21,FOLLOW_21_in_primaryExpr1278); 
					pushFollow(FOLLOW_arith_expression_in_primaryExpr1282);
					b=arith_expression();
					state._fsp--;

					match(input,22,FOLLOW_22_in_primaryExpr1284); 

								    attr_type = b;
									
								   
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "primaryExpr"

	// Delegated rules



	public static final BitSet FOLLOW_VOID_in_program36 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_MAIN_in_program38 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_program40 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_program42 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_program63 = new BitSet(new long[]{0x0000000080003910L});
	public static final BitSet FOLLOW_declarations_in_program77 = new BitSet(new long[]{0x0000000080002800L});
	public static final BitSet FOLLOW_statements_in_program90 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_program100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations127 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Identifier_in_declarations129 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_declarations131 = new BitSet(new long[]{0x0000000000001110L});
	public static final BitSet FOLLOW_declarations_in_declarations133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_in_type214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_type224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements234 = new BitSet(new long[]{0x0000000000002800L});
	public static final BitSet FOLLOW_statements_in_statements236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_stmt_in_statement266 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_statement268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stmt_in_statement281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_no_return_stmt_in_statement294 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_statement296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_then_stmt_in_if_stmt340 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_if_else_stmt_in_if_stmt342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_then_stmt386 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_if_then_stmt388 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_cond_expression_in_if_then_stmt392 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_if_then_stmt394 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_block_stmt_in_if_then_stmt428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_if_else_stmt474 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_block_stmt_in_if_else_stmt476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_block_stmt520 = new BitSet(new long[]{0x0000000080002800L});
	public static final BitSet FOLLOW_statements_in_block_stmt522 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_block_stmt524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_assign_stmt538 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_assign_stmt540 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_arith_expression_in_assign_stmt542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_func_no_return_stmt584 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_func_no_return_stmt588 = new BitSet(new long[]{0x0000000004326400L});
	public static final BitSet FOLLOW_argument_in_func_no_return_stmt592 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_func_no_return_stmt594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_in_argument657 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_argument660 = new BitSet(new long[]{0x0000000004326400L});
	public static final BitSet FOLLOW_arg_in_argument662 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_arith_expression_in_arg709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_arg717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arith_expression_in_cond_expression756 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_RelationOP_in_cond_expression788 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_arith_expression_in_cond_expression792 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression866 = new BitSet(new long[]{0x0000000005000002L});
	public static final BitSet FOLLOW_24_in_arith_expression889 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression893 = new BitSet(new long[]{0x0000000005000002L});
	public static final BitSet FOLLOW_26_in_arith_expression940 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression944 = new BitSet(new long[]{0x0000000005000002L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1058 = new BitSet(new long[]{0x0000000008800002L});
	public static final BitSet FOLLOW_23_in_multExpr1074 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1078 = new BitSet(new long[]{0x0000000008800002L});
	public static final BitSet FOLLOW_27_in_multExpr1094 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_signExpr_in_multExpr1098 = new BitSet(new long[]{0x0000000008800002L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr1142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_signExpr1157 = new BitSet(new long[]{0x0000000000306400L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primaryExpr1192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primaryExpr1216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr1251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_primaryExpr1268 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr1270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_primaryExpr1278 = new BitSet(new long[]{0x0000000004306400L});
	public static final BitSet FOLLOW_arith_expression_in_primaryExpr1282 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_primaryExpr1284 = new BitSet(new long[]{0x0000000000000002L});
}
