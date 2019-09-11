;.source
.class public static myResult
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "*****test3   start*****\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
ldc 10
istore 3
ldc 50
istore 2
ldc 10.0f
fstore 1
ldc 50.0f
fstore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a="
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 3
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc ",b="
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
iload 3
iload 2
if_icmple L2
L1: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a>b成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L3
L2: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a>b不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
iload 3
iload 3
if_icmpne L5
L4: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀if\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L6
L5: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀else\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L6
L6:
goto L3
L3:
iload 3
iload 2
if_icmpgt L8
L7: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a<b成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
iload 3
iload 3
if_icmpeq L11
L10: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀if\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L12
L11: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀else\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L12
L12:
goto L9
L8: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a<b不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L9
L9:
iload 3
iload 2
if_icmplt L14
L13: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a>=b成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L15
L14: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a>=b不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L15
L15:
iload 3
iload 2
if_icmpge L17
L16: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a<=b成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L18
L17: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a<=b不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L18
L18:
iload 3
iload 2
if_icmpne L20
L19: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a==b成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L21
L20: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a==b不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L21
L21:
iload 3
iload 2
if_icmpeq L23
L22: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a!=b成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L24
L23: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "a!=b不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L24
L24:
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c="
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual java/io/PrintStream/print(F)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc ",d="
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 0
invokevirtual java/io/PrintStream/print(F)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
fload 1
fload 0
fcmpl
ifle L26
L25: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c>d成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L27
L26: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c>d不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
fload 1
fload 1
fcmpl
ifne L29
L28: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀if\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L30
L29: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀else\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L30
L30:
goto L27
L27:
fload 1
fload 0
fcmpl
ifgt L32
L31: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c<d成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
fload 1
fload 1
fcmpl
ifeq L35
L34: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀if\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L36
L35: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "可巢狀else\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L36
L36:
goto L33
L32: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c<d不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L33
L33:
fload 1
fload 0
fcmpl
iflt L38
L37: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c>=d成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L39
L38: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c>=d不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L39
L39:
fload 1
fload 0
fcmpl
ifge L41
L40: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c<=d成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L42
L41: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c<=d不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L42
L42:
fload 1
fload 0
fcmpl
ifne L44
L43: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c==d成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L45
L44: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c==d不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L45
L45:
fload 1
fload 0
fcmpl
ifeq L47
L46: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c!=d成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L48
L47: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "c!=d不成立\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto L48
L48:
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "*****test3   END*****\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
return
.end method
