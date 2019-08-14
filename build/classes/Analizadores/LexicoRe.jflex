/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones

package Analizadores;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.awt.TextArea;

%%
/*----------------------------------------------------------------------------
--------------------- 2da. Area: Opciones y Declaraciones
----------------------------------------------------------------------------*/

%{
    String cadena="";
    public TextArea salidaConsola;
    /*public static LinkedList<AcepErr> TablaErr=new LinkedList<AcepErr>();*/
%}

//-------> Directivas
%public
%class a_Lexico_rep
%cupsym Simbolos
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
        return new Symbol(Simbolos.cadena, yychar,yyline,temporal);   }
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

<YYINITIAL> "+"         {   System.out.println("Reconocido: <<"+yytext()+">>, mas");
                            return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}

<YYINITIAL> "-"         {   System.out.println("Reconocido: <<"+yytext()+">>, menos");
                            return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}

<YYINITIAL> "*"         {   System.out.println("Reconocido: <<"+yytext()+">>, por");
                            return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}

<YYINITIAL> "/"         {   System.out.println("Reconocido: <<"+yytext()+">>, dividir");
                            return new Symbol(Simbolos.dividir, yycolumn, yyline, yytext());}

<YYINITIAL> "("         {   System.out.println("Reconocido: <<"+yytext()+">>, apar");
                            return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}

<YYINITIAL> ")"         {   System.out.println("Reconocido: <<"+yytext()+">>, cpar");
                            return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}

<YYINITIAL> ","         {   System.out.println("Reconocido: <<"+yytext()+">>, coma");
                            return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}

<YYINITIAL> ";"         {   System.out.println("Reconocido: <<"+yytext()+">>, puntoComa");
                            return new Symbol(Simbolos.puntoComa, yycolumn, yyline, yytext());}

<YYINITIAL> "="         {   System.out.println("Reconocido: <<"+yytext()+">>, igual");
                            return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}
<YYINITIAL> "sumar"     {   System.out.println("Reconocido: <<"+yytext()+">>, tokenSumar");
                            return new Symbol(Simbolos.sumar, yycolumn, yyline, yytext());}

//-------> Reservadas, tipos de datos y del sistema

<YYINITIAL> "imprimir"       {   System.out.println("Reconocido: <<"+yytext()+">>, imprimir");
                                return new Symbol(Simbolos.imprimir, yycolumn, yyline, yytext());}

<YYINITIAL> "numerico"       {   System.out.println("Reconocido: <<"+yytext()+">>, tokenNunerico");
                                return new Symbol(Simbolos.numerico, yycolumn, yyline, yytext());}

<YYINITIAL> "archivo"       {   System.out.println("Reconocido: <<"+yytext()+">>, tokenArchivo");
                                return new Symbol(Simbolos.archivo, yycolumn, yyline, yytext());}

<YYINITIAL> "leerarchivo"       {   System.out.println("Reconocido: <<"+yytext()+">>, tokenLeerArchivo");
                                return new Symbol(Simbolos.leerarchivo, yycolumn, yyline, yytext());}

<YYINITIAL> "graficar"       {   System.out.println("Reconocido: <<"+yytext()+">>, tokenGraficar");
                                return new Symbol(Simbolos.graficar, yycolumn, yyline, yytext());}

<YYINITIAL> "contar"       {   System.out.println("Reconocido: <<"+yytext()+">>, tokenContar");
                                return new Symbol(Simbolos.contar, yycolumn, yyline, yytext());}

"\"" {yybegin(STRNG);}

<YYINITIAL> {numero}                  {   System.out.println("Reconocido: <<"+yytext()+">>, numero ");
                                return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}
<YYINITIAL> {id}                      {   System.out.println("Reconocido: <<"+yytext()+">>, id ");
                                return new Symbol(Simbolos.id, yycolumn, yyline, yytext());}




[ \t\r\n\f]                 {/* ignore white space. */ }
 
.                           {   String info = "Error Lexico: <<"+yytext()+">> ["+(yyline+1)+" , "+(yycolumn+1)+"]\n";
                                salidaConsola.append(info);
                                System.out.println(info);
                                /*AcepErr datos =new AcepErr(yytext(),"ERROR LEXICO",(yyline+1),(yycolumn+1), "Simbolo no existe en el lenguaje");
                                    TablaErr.add(datos);*/

                            }

