
package com.example.principal.manejadorInstrucciones;

import java.io.Serializable;

public class InsCuadrado implements Serializable {
private double posx,posy,tamanioLado;
private String color;

    public InsCuadrado(Double[] valoresNumericos, String color) {
        this.posx = valoresNumericos[0];
        this.posy = valoresNumericos[1];
        this.tamanioLado = valoresNumericos[2];
        this.color = color;
    }

    public double getPosx() {
        return posx;
    }

    public double getPosy() {
        return posy;
    }

    public double getTamanioLado() {
        return tamanioLado;
    }

    public String getColor() {
        return color;
    }
    

}
