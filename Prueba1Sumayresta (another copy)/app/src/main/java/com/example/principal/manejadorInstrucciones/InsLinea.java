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
public class InsLinea implements Serializable {
    private double posx,posy,posx1,posy1;
    private String color;

    public InsLinea(Double[] valoresNumericos, String color) {
        this.posx = valoresNumericos[0];
        this.posy = valoresNumericos[1];
        this.posx1 = valoresNumericos[2];
        this.posy1 = valoresNumericos[3];
        this.color = color;
    }

    public double getPosx() {
        return posx;
    }

    public double getPosy() {
        return posy;
    }

    public double getPosx1() {
        return posx1;
    }

    public double getPosy1() {
        return posy1;
    }

    public String getColor() {
        return color;
    }
    
}
