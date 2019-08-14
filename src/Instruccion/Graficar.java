/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instruccion;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import Datos.Archivo;
import Datos.ItemRegistro;
import Datos.Registro;
import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import Expresion.Literal;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import static views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class Graficar extends Instruccion{
    LinkedList<Registro> registros;
    LinkedList<ItemRegistro> listaClaves;
    int indicex=0;
    int indicey=0;
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
        Registro aux=null;
        ItemRegistro auxItem=null;
        LinkedList<ItemRegistro> regi;
        DefaultCategoryDataset categoria = new DefaultCategoryDataset();
        Expresion resultadoArchivo = this.identificador.obtenerValor(ent);
        Archivo arch = (Archivo)resultadoArchivo.valor;
        indicex = arch.indiceClave(String.valueOf(this.valoresX.valor));
        indicey = arch.indiceClave(String.valueOf(this.valoresY.valor));
        listaClaves = arch.getListaClaves();
        registros = arch.getListaRegistros();   
        double y=0;
        String nombre="";
        for(int i=0; i<registros.size();i++){
            aux = registros.get(i);
            regi = aux.getLista();
            auxItem=regi.get(indicey);
            y= Double.valueOf(String.valueOf(auxItem.valor));
            auxItem=regi.get(indicex);
            nombre=(String)auxItem.valor;
            categoria.setValue(y,nombre,nombre);
        }        
        JFreeChart f = ChartFactory.createBarChart(String.valueOf(this.titulo.valor),String.valueOf(this.valoresX.valor), String.valueOf(this.valoresY.valor), categoria, PlotOrientation.VERTICAL, true, false, false);
        ChartFrame frame = new ChartFrame("Ejemplo1",f);
        frame.pack();
        try {
            ChartUtilities.saveChartAsPNG(new File(String.valueOf(this.nombre.valor)+".png"), f, 1300, 600);
        } catch (IOException ex) {
            Logger.getLogger(Graficar.class.getName()).log(Level.SEVERE, null, ex);
        }
        salidaConsola.append("Ejecutado la instruccion Graficar\n Generando Grafica\n");
    }

    @Override
    public EnumTipoIns getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
