
package com.example.principal;
/**
 *
 * @author david
 */
public class GenericoConvertidor {
    private Double [] valoresNumericos;
    private String color;

    public GenericoConvertidor(Double[] valoresNumericos, String color) {
        this.valoresNumericos = valoresNumericos;
        this.color = color;
    }

    public Double[] getValoresNumericos() {
        return valoresNumericos;
    }

    public String getColor() {
        return color;
    }
    
    
}
