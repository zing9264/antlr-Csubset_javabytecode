all:	generate 	compiler	execute

compiler:
	javac -cp ./antlr-3.5.2-complete.jar myCompilerLexer.java myCompilerParser.java myCompiler_test.java

execute:	execute1 	execute2	execute3

execute1:
	java -cp ./antlr-3.5.2-complete.jar:. myCompiler_test  test1.c > test1.j
	java -jar jasmin.jar test1.j
	java myResult
execute2:
	java -cp ./antlr-3.5.2-complete.jar:. myCompiler_test  test2.c > test2.j
	java -jar jasmin.jar test2.j
	java myResult
execute3:
	java -cp ./antlr-3.5.2-complete.jar:. myCompiler_test  test3.c >test3.j
	java -jar jasmin.jar test3.j
	java myResult
generate:	
	java -cp  antlr-3.5.2-complete.jar org.antlr.Tool myCompiler.g

clean:
