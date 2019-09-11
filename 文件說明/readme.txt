This file describes the features of my compiler and explains
how to compile and execute my compiler.

1.編譯器特色包含
- Integer and floating-point data types: int, float.（兩種型態）
- Statements for arithmetic computation. (ex: a = b+2*(100-1))（整數與浮點數的運算）
- Comparison expression. (ex: a > b)(可支援浮點數的比較，有六種>,<,>=,<=,==,!=)
- if-then-else program construct.（可巢狀if else）
- printf() function with one/two parameters. (support types: %d, %f)（可支援的parameters為stack上限，約100）
- comment（支援/**/形式的註解）

2.執行編譯指令：

make ->將所有altlr編譯與執行一套完成，產出.j檔，透過jasmin轉成class，最後將結果用java執行

make generate  ->執行以下指令，產出 myCompilerLexer.java myCompilerParser.java
	java -cp  antlr-3.5.2-complete.jar org.antlr.Tool myCompiler.g

make compiler  ->執行以下指令，編譯antlr
	javac -cp ./antlr-3.5.2-complete.jar myCompilerLexer.java myCompilerParser.java myCompiler_test.java

make execute   ->一次執行三個測試檔	
	execute1 	execute2	execute3

make execute1  ->產出.j檔，透過jasmin轉成class，最後將結果用java執行
	java -cp ./antlr-3.5.2-complete.jar:. myCompiler_test  test1.c > test1.j
	java -jar jasmin.jar test1.j
	java myResult
make execute2: ->產出.j檔，透過jasmin轉成class，最後將結果用java執行
	java -cp ./antlr-3.5.2-complete.jar:. myCompiler_test  test2.c > test2.j
	java -jar jasmin.jar test2.j
	java myResult
make execute3: ->產出.j檔，透過jasmin轉成class，最後將結果用java執行
	java -cp ./antlr-3.5.2-complete.jar:. myCompiler_test  test3.c >test3.j
	java -jar jasmin.jar test3.j
	java myResult

