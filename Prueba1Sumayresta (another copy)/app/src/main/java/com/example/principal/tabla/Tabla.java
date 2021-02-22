package com.example.principal.tabla;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.principal.R;

import java.util.ArrayList;

public class Tabla {
    private TableLayout tabla;
    private ArrayList<TableRow> contenidoFila;
    private Activity actividaad;
    private Resources rs;
    private int numeroFila,numeroColumna;

    public Tabla(Activity actividad, TableLayout tabla){
        this.actividaad = actividad;
        this.tabla = tabla;
        rs = this.actividaad.getResources();
        numeroFila = numeroColumna = 0;
        contenidoFila = new ArrayList<TableRow>();
    }
    public void agregarCabecera(int numeroCabecera){
        TableRow.LayoutParams layoutCelda;
        TableRow fila = new TableRow(actividaad);
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        System.out.println("Numero cabecera es "+numeroCabecera);
        String  [] datosCabecera = rs.getStringArray(numeroCabecera);
        numeroColumna = datosCabecera.length;

        for (int i=0;i<datosCabecera.length;i++){
            TextView texto = new TextView(actividaad);
            layoutCelda = new TableRow.LayoutParams(anchoPixelesTexto(datosCabecera[i]),TableRow.LayoutParams.WRAP_CONTENT);
            texto.setText(datosCabecera[i]);
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setTextAppearance(actividaad, R.style.Theme_AppCompat_DayNight);
            //texto.setBackgroundResource(R.style.);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
        }
        tabla.addView(fila);
        contenidoFila.add(fila);
        numeroFila++;
    }

    public void agregarFila(ArrayList<String> elementos){
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividaad);
        fila.setLayoutParams(layoutFila);

        for(int i=0;i<elementos.size();i++){
            TextView texto = new TextView(actividaad);
            texto.setText(String.valueOf(elementos.get(i)));
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setTextAppearance(actividaad,R.style.Theme_AppCompat_DayNight);
            texto.setBackgroundResource(R.color.rojo);
            layoutCelda = new TableRow.LayoutParams(anchoPixelesTexto(texto.getText().toString()),TableRow.LayoutParams.WRAP_CONTENT);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
        }
        tabla.addView(fila);
        contenidoFila.add(fila);
        numeroFila++;

    }
    private int anchoPixelesTexto(String texto){
        Paint p = new Paint();
        Rect bounds = new Rect();
        p.setTextSize(100);
        p.getTextBounds(texto,0,texto.length(),bounds);
        return bounds.width();
    }
}
