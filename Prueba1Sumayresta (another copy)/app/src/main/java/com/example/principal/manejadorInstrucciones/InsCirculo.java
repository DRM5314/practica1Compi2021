/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.principal.manejadorInstrucciones;

import java.io.Serializable;

public class InsCirculo implements Serializable {
    private double posx,posy,radio;
    private String color;    

    public InsCirculo(Double[] valoresNumericos, String color) {
        this.posx = valoresNumericos[0];
        this.posy = valoresNumericos[1];
        this.radio = valoresNumericos[2];
        this.color = color;
    }

    public double getPosx() {
        return posx;
    }

    public double getPosy() {
        return posy;
    }

    public double getRadio() {
        return radio;
    }

    public String getColor() {
        return color;
    }
    
}
