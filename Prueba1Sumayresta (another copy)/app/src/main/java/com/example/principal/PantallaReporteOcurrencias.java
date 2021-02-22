package com.example.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.principal.manejadorInstrucciones.MandadorDatos;
import com.example.principal.tabla.AuxiliarTabla;

public class PantallaReporteOcurrencias extends AppCompatActivity {
    private ManejadorIns auxManejadorIns;
    private Reportes auxManejadorReportes = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_ocurrencias);
        Bundle datos = getIntent().getExtras();
        if(datos!=null){
            auxManejadorIns = (ManejadorIns) datos.getSerializable("manejadorInstrucciones");
            auxManejadorReportes = (Reportes) datos.getSerializable("manejadorReportes");
        }
    }
    public void reporteAritmetico(View view){
        Intent intento = new Intent(this, AuxiliarTabla.class);
        if(auxManejadorReportes!=null)intento.putExtras(MandadorDatos.enviarDatos(auxManejadorIns,auxManejadorReportes));
        intento.putExtra("tipoReporte","ocurrenciaAritmetica");
        startActivity(intento);
    }
    public void reporteColor(View view){
        Intent intento = new Intent(this, AuxiliarTabla.class);
        if(auxManejadorReportes!=null)intento.putExtras(MandadorDatos.enviarDatos(auxManejadorIns,auxManejadorReportes));
        intento.putExtra("tipoReporte","color");
        startActivity(intento);
    }
    public void reporteObjeto(View view){
        Intent intento = new Intent(this, AuxiliarTabla.class);
        if(auxManejadorReportes!=null)intento.putExtras(MandadorDatos.enviarDatos(auxManejadorIns,auxManejadorReportes));
        intento.putExtra("tipoReporte","objeto");
        startActivity(intento);
    }
    public void reporteAnimacion(View view){
        Intent intento = new Intent(this, AuxiliarTabla.class);
        if(auxManejadorReportes!=null)intento.putExtras(MandadorDatos.enviarDatos(auxManejadorIns,auxManejadorReportes));
        intento.putExtra("tipoReporte","animacion");
        startActivity(intento);
    }
}