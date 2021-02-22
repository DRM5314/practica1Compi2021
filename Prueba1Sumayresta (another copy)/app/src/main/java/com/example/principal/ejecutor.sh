#!/bin/bash
java -jar jflex-full-1.8.2.jar lexico.lex
java -jar java-cup-11b.jar cuppt.cup
echo 'Termino instrucciones'
exit
