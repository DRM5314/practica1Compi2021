package com.example.principal.graficador;

public class AuxGraficadorPoligono {
    private double nLados,limitanteX,limitanteY;
    private float puntos[];
    public AuxGraficadorPoligono(double nLados, double limitanteX, double limitanteY){
        this.nLados = nLados;
        this.limitanteX = limitanteX;
        this.limitanteY = limitanteY;
        //this.puntos = puntosGraficar();
    }
    public float [] puntosGraficar(){
        float nGrados = (float) (360/nLados);
        float posX = (float) (limitanteX/2);
        float posY = (float) (limitanteY/2);
        float puntosr[] = new float[(int) (nLados*4)];
        double auxConvertidorRadianes = Math.PI/180;
        for (int i = 0;i < nLados;i++){
            puntosr [(4*i)] = posX+(posX * ((float) Math.cos((i*nGrados)*auxConvertidorRadianes)));
            puntosr [((4*i)+1)] = posY+(posY * ((float) Math.sin((i*nGrados)*auxConvertidorRadianes)));
            puntosr [((4*i)+2)] = posX+(posX * ((float) Math.cos(((i+1)*nGrados)*auxConvertidorRadianes)));
            puntosr [((4*i)+3)] = posY+(posY * ((float) Math.sin(((i+1)*nGrados)*auxConvertidorRadianes)));
        }
        return puntosr;
    }
    public void getInfo(){
        for(int i = 0; i<nLados;i++){
            String datos = this.puntos[(2*i)]+","+this.puntos[(2*i)+1]+","+this.puntos[(2*i)+2]+","+this.puntos[(2*i)+3];
        }
    }
}
