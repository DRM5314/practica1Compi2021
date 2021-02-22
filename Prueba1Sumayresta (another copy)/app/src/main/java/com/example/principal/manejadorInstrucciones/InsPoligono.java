/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.principal.manejadorInstrucciones;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class InsPoligono implements Serializable {
    private double posx,posy,alto,ancho,cantidadLados;
    private String color;

    public InsPoligono(Double[] valoresNumericos, String color) {
        this.posx = valoresNumericos[0];
        this.posy = valoresNumericos[1];
        this.alto = valoresNumericos[2];
        this.ancho = valoresNumericos[3];
        this.cantidadLados = valoresNumericos[4];
        this.color = color;
    }

    public double getPosx() {
        return posx;
    }

    public double getPosy() {
        return posy;
    }

    public double getAlto() {
        return alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getCantidadLados() {
        return cantidadLados;
    }

    public String getColor() {
        return color;
    }
    
}
