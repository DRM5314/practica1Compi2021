package com.example.principal;


import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
%%
%class Lexico
%line
%column
%standalone
%cup
%{
private Symbol symbol (int tipo){
    return new Symbol (tipo,yyline,yycolumn);
}   
private Symbol symbol (int tipo, Object value){
    return new Symbol (tipo,yyline,yycolumn,value);
}
private List <String[]> listaErrores = new ArrayList<>();
public List <String[]> getReportesErrores(){
	return this.listaErrores;
}
%}
%eof{
//System.out.println("Errores lexicos encontrados\n"+listaErrores.toString());
//int posiciones [] =(int []) listaErrores.get(1);
//System.out.println("Columna "+posiciones[0]+" Fila "+posiciones[1]);
System.out.println("termino leer entrada");
%eof}

digito = (0|[1-9][0-9]*)|(([1-9][0-9]*|0)\.([1-9][0-9]*))

terminaLinea = \r|\n|\r\n
espacioBlanco = {terminaLinea} | [ \t\f]
 
instruccionGraficar = graficar{espacioBlanco}

colores = azul|rojo|verde|amarillo|naranja|morado|cafe|negro
animacion = linea|curva

despuesInstruccion = " "*\(.*\)
%%
\n { /*System.out.println("\n");*/}
{espacioBlanco} {}

{instruccionGraficar}circulo/{despuesInstruccion} 
{ /*System.out.println("Detecto Instruccion Circulo");*/
 return symbol(sym.ICIRCULO);}

{instruccionGraficar}cuadrado/{despuesInstruccion}
{ /*System.out.println("Detecto Instruccion Cuadrado");*/
 return symbol(sym.ICUADRADO);}

{instruccionGraficar}rectangulo/{despuesInstruccion}
{ /*System.out.println("Detecto Instruccion Rectangulo");*/
 return symbol(sym.IRECTANGULO);}

{instruccionGraficar}linea/{despuesInstruccion}
{ /*System.out.println("Detecto Instruccion Linea");*/
 return symbol(sym.ILINEA);}

{instruccionGraficar}poligono/{despuesInstruccion}
{ /*System.out.println("Detecto Instruccion Poligono");*/
 return symbol(sym.IPOLIGONO);}

animar" "+objeto" "+anterior/{despuesInstruccion}
{ /*System.out.println("Detecto Instruccion Animar");*/
 return symbol(sym.IANIMAR);}

{colores} 
{ /*System.out.println("Detecto color: "+yytext());*/
 return symbol(sym.color,new String (yytext()));}

{animacion}
{ /*System.out.println("Detecto animacion: "+yytext());*/
 return symbol(sym.animacion,new String(yytext()));}

{digito} 
{ /*System.out.println("Digito aceptado: "+yytext());*/
return symbol (sym.digito,new Double (yytext()));
}

\,
{ /*System.out.println("Detecto coma");*/
 return symbol(sym.COMA);}

\(
{ /*System.out.println("Detecto signo parentesis abierto");*/
 return symbol(sym.PA);}

\)
{ /*System.out.println("Detecto signo parentesis cerrado");*/
 return symbol(sym.PC);}

\/
{ /*System.out.println("Detecto signo / dividir");*/
 return symbol(sym.DIV);}

\*
{ /*System.out.println("Detecto signo multiplicacion *");*/
 return symbol(sym.MULT);}

- 
{ /*System.out.println("Detecto signo restar");*/
 return symbol(sym.RES);}

\+
{ /*System.out.println("Detecto signo suma");*/
 return symbol(sym.SUM);}

. 
{
listaErrores.add(new String[]{"Lexico",""+(yyline+1),""+(yycolumn),yytext()});
} 
