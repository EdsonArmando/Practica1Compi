/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instruccion;

import Datos.Archivo;
import Datos.ItemRegistro;
import Datos.Registro;
import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import java.util.LinkedList;
import static views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class Graficar extends Instruccion{
    LinkedList<Registro> registros;
    LinkedList<ItemRegistro> listaClaves;
    
    Expresion nombre;
    Expresion titulo;
    Expresion identificador;
    Expresion valoresX;
    Expresion valoresY;
    public Graficar(Expresion nombre, Expresion titulo, Expresion identificador, Expresion valoresX, Expresion valoresY,int fila, int columna){
        this.nombre = nombre;
        this.titulo = titulo;
        this.identificador = identificador;
        this.valoresX = valoresX;
        this.valoresY = valoresY;
        this.fila = fila;
        this.columna = columna;
        
    }

    @Override
    public void ejecutar(Entorno ent) {
        Expresion resultadoArchivo = this.identificador.obtenerValor(ent);
        Archivo arch = (Archivo)resultadoArchivo.valor;
        listaClaves = arch.getListaClaves();
        registros = arch.getListaRegistros();
       
        for(int i=0; i<listaClaves.size(); i++){
           ItemRegistro item = listaClaves.get(i);
            salidaConsola.append(item.valor.toString());
        }
        
        Registro aux=null;
        
        LinkedList regi;
     
        salidaConsola.append("Ejecutado la instruccion Graficar");
    }

    @Override
    public EnumTipoIns getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
