/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Analizadores.a_Lexico_datos;
import Analizadores.analisis_sintacticos_datos;
import Datos.Archivo;
import Entorno.Entorno;
import Entorno.Simbolo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class FuncionLeerArchivo extends Expresion{
    LinkedList uno;
    public Expresion expRuta;
    /**
     * @param expRuta Expresión que contiene la ruta del archivo a analizar
     * @param fila Línea donde está la función leerArchivo
     * @param columna Columna donde está la función leerArchivo
     */
  
    public FuncionLeerArchivo(Expresion expRuta, int fila, int columna) {
        this.expRuta = expRuta;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Expresion obtenerValor(Entorno ent) {
          String aux = "";
            String texto = "";
        Expresion resultadoNombreArchivo = this.expRuta.obtenerValor(ent);
         File abre= new File(String.valueOf(resultadoNombreArchivo.valor));
         FileReader archivos = null;
        try {
                archivos = new FileReader(abre);
        } catch (FileNotFoundException e3) {
                e3.printStackTrace();
        }
        BufferedReader lee=new BufferedReader(archivos);
         try {
                while((aux=lee.readLine())!=null)
                  {
                     texto+= aux+ "\n";
                  }
        } catch (IOException e2) {
                e2.printStackTrace();
        }
         try {
                        lee.close();
                } catch (IOException e1) {
                        e1.printStackTrace();
                }
         System.out.println(texto);
        /** CODIGO PARA LEER EL ARCHIVO resultadoNombreArchivo.valor.toString **/
        String tex = "claves = [\n" +
        "    \"1024\" // Registro 1\n" +
        "]\n" +
        "Registros = [\n" +
        "    {1, \"Nery\", \"Galvez\"} // Registro 1\n" +
        "    {2, \"Miguel\", \"Ruano\"} // Registro 2\n" +
        "    {3, \"Erick\", \"Tejaxún\"} // Registro 3\n" +
        "    {4, \"Erick\", \"Tejaxún\"} // Registro 3\n" +
        "]";
        System.out.println(tex);
        a_Lexico_datos lexico = new a_Lexico_datos(new BufferedReader(new StringReader(texto)));
        analisis_sintacticos_datos sintactico = new analisis_sintacticos_datos(lexico);
        try{
            sintactico.parse();
            Archivo arbol = sintactico.resultado;
         
            return new Literal(Simbolo.EnumTipoDato.ARCHIVO, arbol);
        }catch(Exception e){
            System.out.println(e);
        }
        return new Literal(Simbolo.EnumTipoDato.LEERARCHIVO,
                        "Aquí debe imprimir el contenido del archivo llamado: "+resultadoNombreArchivo.valor.toString());
        
    }
    @Override
    public Simbolo.EnumTipoDato getTipo() {
        return this.tipo;
    }    
}
