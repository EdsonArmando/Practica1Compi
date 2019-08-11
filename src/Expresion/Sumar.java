/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Datos.Archivo;
import Entorno.Entorno;
import Entorno.Simbolo;

/**
 *
 * @author EG
 */
public class Sumar extends Expresion{
    String id;
    
    @Override
    public Expresion obtenerValor(Entorno ent) {
        Simbolo s = ent.obtener(id);
        if(s.getTipo() == Simbolo.EnumTipoDato.ARCHIVO){
            Archivo arch = (Archivo)s.getValor();
            arch.sumar();
            
        }
        return new Literal(Simbolo.EnumTipoDato.ERROR, "%ERROR%");
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        return this.tipo;
    }
}
