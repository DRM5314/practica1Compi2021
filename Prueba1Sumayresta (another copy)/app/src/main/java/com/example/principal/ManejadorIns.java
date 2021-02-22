/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.principal;

import com.example.principal.manejadorInstrucciones.InsCirculo;
import com.example.principal.manejadorInstrucciones.InsCuadrado;
import com.example.principal.manejadorInstrucciones.InsLinea;
import com.example.principal.manejadorInstrucciones.InsPoligono;
import com.example.principal.manejadorInstrucciones.InsRectangulo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class ManejadorIns implements Serializable {
    private List <InsCirculo> instruccionesCirculo = new ArrayList<>();
    private List <InsCuadrado> instruccionesCuadrado = new ArrayList<>();
    private List <InsRectangulo> instruccionesRectangulo = new ArrayList<>();
    private List <InsLinea> instruccionesLinea = new ArrayList<>();
    private List <InsPoligono> instruccionesPoligono = new ArrayList<>();
    private List <String> ordenInstrucciones = new ArrayList<String>();
    public void addInsCirculo(GenericoConvertidor entrada, String nombreObjeto){
        this.instruccionesCirculo.add(new InsCirculo(entrada.getValoresNumericos(),entrada.getColor()));
        this.ordenInstrucciones.add(nombreObjeto);
    }
    
    public void addInsCuadrado(GenericoConvertidor entrada, String nombreObjeto){
        this.instruccionesCuadrado.add(new InsCuadrado(entrada.getValoresNumericos(),entrada.getColor()));
        this.ordenInstrucciones.add(nombreObjeto);
    }
    
    public void addInsRectangulo (GenericoConvertidor entrada, String nombreObjeto){
        this.instruccionesRectangulo.add(new InsRectangulo(entrada.getValoresNumericos(),entrada.getColor()));
        this.ordenInstrucciones.add(nombreObjeto);
    }
    
    public void addInsLinea (GenericoConvertidor entrada, String nombreObjeto){
        this.instruccionesLinea.add(new InsLinea(entrada.getValoresNumericos(),entrada.getColor()));
        this.ordenInstrucciones.add(nombreObjeto);
    }
    
    public void addInsPoligono (GenericoConvertidor entrada, String nombreObjeto){
        this.instruccionesPoligono.add(new InsPoligono(entrada.getValoresNumericos(),entrada.getColor()));
        this.ordenInstrucciones.add(nombreObjeto);
    }

    public List<String> getOrdenInstrucciones() {
        return ordenInstrucciones;
    }

    public void getInfo(){
        System.out.println("#Circulos: "+instruccionesCirculo.size());
        System.out.println("#Cuadrados: "+instruccionesCuadrado.size());
        System.out.println("#Rectangulos: "+instruccionesRectangulo.size());
        System.out.println("#Lineas: "+instruccionesLinea.size());
        System.out.println("#Poligonos: "+instruccionesPoligono.size());
        for (String orden: ordenInstrucciones) {
            System.out.println(orden);
        }
    }
    public void quitarPilaCirculo(){
        if(instruccionesCirculo.size()>0)instruccionesCirculo.remove((instruccionesCirculo.size()-1));
    }
    public void quitarPilaCuadrado(){
        if(instruccionesCuadrado.size()>0)instruccionesCuadrado.remove((instruccionesCuadrado.size()-1));
    }
    public void quitarPilaRectangulo(){
        if(instruccionesRectangulo.size()>0)instruccionesRectangulo.remove((instruccionesRectangulo.size()-1));
    }
    public void quitarPilaLinea(){
        if(instruccionesLinea.size()>0)instruccionesLinea.remove((instruccionesLinea.size()-1));
    }
    public void quitarPilaPoligono(){
        if(instruccionesPoligono.size()>0)instruccionesPoligono.remove((instruccionesPoligono.size()-1));
    }

    public List<InsCirculo> getInstruccionesCirculo() {
        return instruccionesCirculo;
    }

    public List<InsCuadrado> getInstruccionesCuadrado() {
        return instruccionesCuadrado;
    }

    public List<InsRectangulo> getInstruccionesRectangulo() {
        return instruccionesRectangulo;
    }

    public List<InsLinea> getInstruccionesLinea() {
        return instruccionesLinea;
    }

    public List<InsPoligono> getInstruccionesPoligono() {
        return instruccionesPoligono;
    }
}
