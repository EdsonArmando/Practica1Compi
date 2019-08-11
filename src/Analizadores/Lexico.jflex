//Codigo Usuario


package Analizadores;

import java_cup.runtime.*;
import java.util.ArrayList;

%%
/*----------------------------------------------------------------------------
--------------------- 2da. Area: Opciones y Declaraciones
----------------------------------------------------------------------------*/

%{
    String cadena="";
    /*public static LinkedList<AcepErr> TablaErr=new LinkedList<AcepErr>();*/
%}

//-------> Directivas
%public
%class a_Lexico_datos
%cupsym simbolos_datos
%cup
%char
%line
%column
%full
%unicode
%ignorecase

//-------> Expresiones Regulares

digito = [0-9]
numero = {digito}+("." {digito}+)?
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*   

//-------> Estados    EN ORDEN
%state COMENT_SIMPLE
%state COMENT_MULTI
%state STRNG

%%
/*-------------------------------------------------------------------
--------------------- 3ra. y ultima area: Reglas Lexicas
-------------------------------------------------------------------*/

//-------> Comentarios

<STRNG>{
    [\"] {  String temporal=cadena; cadena=""; yybegin(YYINITIAL);
        return new Symbol(simbolos_datos.cadena, yychar,yyline,temporal);   }
    [^\"] { cadena+=yytext(); }
}

<YYINITIAL> "/*"                {yybegin(COMENT_MULTI);}     // Si la entrada es un comentario inicia aqui
<COMENT_MULTI> "*/"             {yybegin(YYINITIAL);}        // Si se acaba el comentario vuelve a YYINITIAL
<COMENT_MULTI> .                {}
<COMENT_MULTI> [ \t\r\n\f]      {}

<YYINITIAL> "//"                {yybegin(COMENT_SIMPLE);}   // Si la entrada es comentario simple inicia aqui
<COMENT_SIMPLE> [^"\n"]         {}                          // 
<COMENT_SIMPLE> "\n"            {yybegin(YYINITIAL);}       // aqui sale del estado

//-------> Operadores Aritmeticos

<YYINITIAL> "("         {   System.out.println("Reconocido: <<"+yytext()+">>, apar");
                            return new Symbol(simbolos_datos.apar, yycolumn, yyline, yytext());}

<YYINITIAL> ")"         {   System.out.println("Reconocido: <<"+yytext()+">>, cpar");
                            return new Symbol(simbolos_datos.cpar, yycolumn, yyline, yytext());}

<YYINITIAL> "["         {   System.out.println("Reconocido: <<"+yytext()+">>, acorhc");
                            return new Symbol(simbolos_datos.acorch, yycolumn, yyline, yytext());}

<YYINITIAL> "]"         {   System.out.println("Reconocido: <<"+yytext()+">>, ccorch");
                            return new Symbol(simbolos_datos.ccorch, yycolumn, yyline, yytext());}

<YYINITIAL> "{"         {   System.out.println("Reconocido: <<"+yytext()+">>, allave");
                            return new Symbol(simbolos_datos.allave, yycolumn, yyline, yytext());}

<YYINITIAL> "}"         {   System.out.println("Reconocido: <<"+yytext()+">>, cllave");
                            return new Symbol(simbolos_datos.cllave, yycolumn, yyline, yytext());}

<YYINITIAL> ","         {   System.out.println("Reconocido: <<"+yytext()+">>, coma");
                            return new Symbol(simbolos_datos.coma, yycolumn, yyline, yytext());}

<YYINITIAL> ";"         {   System.out.println("Reconocido: <<"+yytext()+">>, puntoComa");
                            return new Symbol(simbolos_datos.puntoComa, yycolumn, yyline, yytext());}

<YYINITIAL> "="         {   System.out.println("Reconocido: <<"+yytext()+">>, igual");
                            return new Symbol(simbolos_datos.igual, yycolumn, yyline, yytext());}

//-------> Reservadas, tipos de datos y del sistema

<YYINITIAL> "registros"       {   System.out.println("Reconocido: <<"+yytext()+">>, TokenRegistro");
                                return new Symbol(simbolos_datos.registros, yycolumn, yyline, yytext());}

<YYINITIAL> "claves"       {   System.out.println("Reconocido: <<"+yytext()+">>, TokenRegistro");
                                return new Symbol(simbolos_datos.claves, yycolumn, yyline, yytext());}

"\"" {yybegin(STRNG);}

<YYINITIAL> {numero}                  {   System.out.println("Reconocido: <<"+yytext()+">>, numero ");
                                return new Symbol(simbolos_datos.numero, yycolumn, yyline, yytext());}
<YYINITIAL> {id}                      {   System.out.println("Reconocido: <<"+yytext()+">>, id ");
                                return new Symbol(simbolos_datos.id, yycolumn, yyline, yytext());}




[ \t\r\n\f]                 {/* ignore white space. */ }
 
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");
                                /*AcepErr datos =new AcepErr(yytext(),"ERROR LEXICO",(yyline+1),(yycolumn+1), "Simbolo no existe en el lenguaje");
                                    TablaErr.add(datos);*/

                            }

