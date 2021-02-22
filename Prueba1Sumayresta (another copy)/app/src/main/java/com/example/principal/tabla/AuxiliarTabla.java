package com.example.principal.tabla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.principal.R;
import com.example.principal.ManejadorIns;
import com.example.principal.Reportes;

import java.util.ArrayList;
import java.util.List;

public class AuxiliarTabla extends AppCompatActivity {
    private Intent datos;
    private ManejadorIns auxManejadorIns;
    private Reportes auxManejadorReportes;
    private String tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar_tabla);
        datos = getIntent();
        if(datos!=null){
            auxManejadorIns = (ManejadorIns) datos.getExtras().getSerializable("manejadorInstrucciones");
            auxManejadorReportes = (Reportes) datos.getExtras().getSerializable("manejadorReportes");
            tipo = getIntent().getStringExtra("tipoReporte");
            llenarTabla(tipo);
        }
    }
    public void llenarTabla(String tipoReporte){
        TextView areaTitulo = findViewById(R.id.texoInfoReportes);
        Tabla nuevaTabla = new Tabla(this,(TableLayout) findViewById(R.id.tablaCaptora));
        areaTitulo.setText("Reporte de "+tipoReporte);
        switch (tipoReporte){
            case "color":
                nuevaTabla.agregarCabecera(R.array.cabeceraOcurrenciaColor);
                nuevaTabla = datosInsertar(auxManejadorReportes.getColoresNombres(),auxManejadorReportes.getContadorColor(),nuevaTabla);
                break;
            case "objeto":
                nuevaTabla.agregarCabecera(R.array.cabeceraOcurrenciaObjeto);
                nuevaTabla = datosInsertar(auxManejadorReportes.getNombreObjeto(),auxManejadorReportes.getContadorObjeto(),nuevaTabla);
                break;
            case "animacion":
                nuevaTabla.agregarCabecera(R.array.cabeceraOcurrenciaAnimacion);
                nuevaTabla = datosInsertar(auxManejadorReportes.getNombreAnimacion(),auxManejadorReportes.getContadorAnimacion(),nuevaTabla);
                break;
            case "ocurrenciaAritmetica":
                nuevaTabla.agregarCabecera(R.array.cabeceraOcurrenciaOperadoresMatematicos);
                nuevaTabla = datosInsertar(auxManejadorReportes.getOcurrenciaOperador(),nuevaTabla);
                break;
            case "errores":
                nuevaTabla.agregarCabecera(R.array.cabeceraReporteErrores);
                nuevaTabla = datosInsertar(auxManejadorReportes.getErroresSintacticos(),nuevaTabla);
                break;
        }
    }
    private Tabla datosInsertar(List<String[]> datos,Tabla entrada){
        ArrayList<String> aux;
        for(int i=0;i<datos.size();i++){
            aux = new ArrayList<String>();
            aux.add(datos.get(i)[0]);
            aux.add(datos.get(i)[1]);
            aux.add(datos.get(i)[2]);
            aux.add(datos.get(i)[3]);
            entrada.agregarFila(aux);
        }
        return entrada;
    }
    private Tabla datosInsertar(String nombres [],int contador[], Tabla entrada){
        ArrayList<String> datos=null;
        int contadorAux = 0;
        for (int i = 0; i<nombres.length;i++){
             datos = new ArrayList<String>();
            if(contador[i]>0) {
                datos.add(nombres[i]);
                datos.add(" " + contador[i]);
            }else contadorAux++;
            entrada.agregarFila(datos);
        }
        if(contador.length == contadorAux){
            datos = new ArrayList<String>();
            datos.add("Sin datos");
            datos.add("Sin datos");
            entrada.agregarFila(datos);
        }
        return entrada;

    }
}