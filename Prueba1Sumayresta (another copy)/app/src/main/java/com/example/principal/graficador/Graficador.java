package com.example.principal.graficador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.example.principal.R;
import com.example.principal.manejadorInstrucciones.InsCirculo;
import com.example.principal.manejadorInstrucciones.InsCuadrado;
import com.example.principal.manejadorInstrucciones.InsLinea;
import com.example.principal.manejadorInstrucciones.InsPoligono;
import com.example.principal.manejadorInstrucciones.InsRectangulo;
import com.example.principal.ManejadorIns;

public class Graficador extends AppCompatActivity {
    private ManejadorIns auxManejadorIns = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficador);
        Intent intento = getIntent();
        if(intento!=null) {
            graficador g = new graficador(this, (ManejadorIns) intento.getExtras().getSerializable("manejadorInstrucciones"));
            setContentView(g);
        }

    }

    public class pruebaGrafico extends View{
        float cambioX,cambioY,contadorAngulo;

        public  pruebaGrafico(Context context1){
            super(context1);
        }
        public void onDraw(Canvas canvas){
            Paint pincel = new Paint();
            pincel.setStrokeWidth(20);
            pincel.setColor(Color.GREEN);
            pincel.setStyle(Paint.Style.FILL);
            //AuxGraficadorPoligono p = new AuxGraficadorPoligono(1,500+500,320+320);
            //canvas.drawLines(p.puntosGraficar(),pincel);
            //canvas.drawLines(p.puntosGraficar(),0+i,50,pincel);
            contadorAngulo+=23;
            cambioX =(float) (200*(Math.cos(Math.toDegrees(contadorAngulo))));
            cambioY =(float) (200*(Math.sin(Math.toDegrees(contadorAngulo))));
            canvas.drawCircle(300+cambioX,300+cambioY,30,pincel);

            if(contadorAngulo<=360)invalidate();
        }
    }
    public class graficador extends View{
        private ManejadorIns auxManejadorDatos;
        public graficador(Context context, ManejadorIns auxManejadorDatos){
            super(context);
            this.auxManejadorDatos = auxManejadorDatos;
            //System.out.println(auxManejadorDatos.getOrdenInstrucciones().toString());
        }
        protected  void onDraw(Canvas canvas){
            //canvas.drawRect(50,1280,1340-50,1280-100,genericoPincel(R.color.verde));
            int posicionUltima = 0;
            for(String objeto: auxManejadorDatos.getOrdenInstrucciones()){
                switch (objeto){
                    case "circulo":
                        posicionUltima = auxManejadorDatos.getInstruccionesCirculo().size();
                        InsCirculo aux = auxManejadorDatos.getInstruccionesCirculo().get(posicionUltima-1);
                        graficarCirculo(canvas,genericoObtenerColor(aux.getColor()),aux.getPosx(),aux.getPosy(),aux.getRadio());
                        auxManejadorDatos.quitarPilaCirculo();
                        break;
                    case "cuadrado":
                        posicionUltima = auxManejadorDatos.getInstruccionesCuadrado().size();
                        InsCuadrado auxCuadrado = auxManejadorDatos.getInstruccionesCuadrado().get(posicionUltima-1);
                        graficarCuadrado(canvas,genericoObtenerColor(auxCuadrado.getColor()),auxCuadrado.getPosx(),auxCuadrado.getPosy()
                                ,auxCuadrado.getTamanioLado());
                        auxManejadorDatos.quitarPilaCuadrado();
                        break;
                    case "rectangulo":
                        posicionUltima = auxManejadorDatos.getInstruccionesRectangulo().size();
                        InsRectangulo auxRectangulo = auxManejadorDatos.getInstruccionesRectangulo().get(posicionUltima-1);
                        graficarRectangulo(canvas,genericoObtenerColor(auxRectangulo.getColor()),auxRectangulo.getPosx(),auxRectangulo.getPosy()
                                ,auxRectangulo.getAncho(),auxRectangulo.getAlto());
                        auxManejadorDatos.quitarPilaRectangulo();
                        break;
                    case "linea":
                        posicionUltima = auxManejadorDatos.getInstruccionesLinea().size();
                        InsLinea auxLinea = auxManejadorDatos.getInstruccionesLinea().get(posicionUltima-1);
                        graficarLinea(canvas,genericoObtenerColor(auxLinea.getColor()),auxLinea.getPosx(),auxLinea.getPosy(),auxLinea.getPosx1()
                                ,auxLinea.getPosy1());
                        auxManejadorDatos.quitarPilaLinea();
                        break;
                    case "poligono":
                        posicionUltima = auxManejadorDatos.getInstruccionesPoligono().size();
                        InsPoligono auxPoligono = auxManejadorDatos.getInstruccionesPoligono().get(posicionUltima-1);
                        graficarPoligono(canvas,genericoObtenerColor(auxPoligono.getColor()),auxPoligono.getPosx()
                                ,auxPoligono.getPosy(),auxPoligono.getAlto(),auxPoligono.getAncho(),auxPoligono.getCantidadLados());
                        auxManejadorDatos.quitarPilaPoligono();
                        break;
                }
            }

        }
        private Paint genericoPincel(int color){
            Paint pincel = new Paint();
            pincel.setStrokeWidth(15);
            pincel.setColor(getResources().getColor(color));
            pincel.setStyle(Paint.Style.FILL);
            return pincel;
        }
        private int genericoObtenerColor(String color){
            switch (color){
                case "azul":
                    return R.color.azul;
                case "rojo":
                    return R.color.rojo;
                case "verde":
                    return R.color.verde;
                case "amarillo":
                    return R.color.amarillo;
                case "naranja":
                    return R.color.naranja;
                case "morado":
                    return R.color.morado;
                case "cafe":
                    return R.color.cafe;
                case "negro":
                   return R.color.negro;
                default:
                    System.out.println("Color negro en retorno por error en switch");
                    return R.color.negro;
            }
        }
        private void graficarCirculo(Canvas canvas, int color, double posX, double posY, double radio){
            canvas.drawCircle((float)posX,(float)posY,(float)radio,genericoPincel(color));
        }
        private void graficarCuadrado(Canvas canvas, int color, double posX, double posY, double tamanioLado){
            canvas.drawRect((float)posX,(float)posY,(float)(posX+tamanioLado),(float)(posY+tamanioLado),genericoPincel(color));
        }
        private void graficarRectangulo(Canvas canvas, int color, double posX, double posY, double ancho, double alto){
            canvas.drawRect((float)posX,(float)posY,(float)(posX+ancho),(float)(posY+alto),genericoPincel(color));
        }
        private void graficarLinea(Canvas canvas, int color, double posX, double posY, double posX1, double posY1){
            canvas.drawLine((float)posX,(float)posY,(float)posX1,(float)posY1,genericoPincel(color));
        }
        private void graficarPoligono(Canvas canvas, int color, double posX, double posY, double alto, double ancho, double cantidadLados){
            AuxGraficadorPoligono n = new AuxGraficadorPoligono(cantidadLados,(posX+ancho),(posY+alto));
            canvas.drawLines(n.puntosGraficar(),genericoPincel(color));
        }
    }

}