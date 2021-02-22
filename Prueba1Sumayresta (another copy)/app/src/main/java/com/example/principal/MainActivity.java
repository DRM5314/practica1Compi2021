package com.example.principal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.principal.manejadorInstrucciones.MandadorDatos;
import com.example.principal.graficador.Graficador;

public class MainActivity extends AppCompatActivity  {
    EditText entrada;
    private ManejadorIns auxManejadorIns;
    private Reportes auxManejadorReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle datos = getIntent().getExtras();
        if(datos!=null){
            auxManejadorIns = (ManejadorIns) datos.getSerializable("manejadorInstrucciones");
            auxManejadorReportes = (Reportes) datos.getSerializable("manejadorReportes");
            //auxManejadorIns.getInfo();
        }else{
            findViewById(R.id.botonVistaGrafica).setEnabled(false);
            findViewById(R.id.botonReportes).setEnabled(false);
        }
    }

    public void ventanaEditor(View view){
        Intent intento = new Intent(this, PantallaEditor.class);
        startActivity(intento);
        finish();
    }
    public void enviarMensaje(View view){

    }
    public void pruebaTabla(View view){
        Intent intentoReporte = new Intent(this, PantallaReporteOcurrencias.class);
        if(auxManejadorIns!=null)intentoReporte.putExtras(MandadorDatos.enviarDatos(auxManejadorIns,auxManejadorReportes));
        startActivity(intentoReporte);
    }
    public void pintar(View view){
        Intent intentoPintar = new Intent(this, Graficador.class);
        if(auxManejadorIns!=null)intentoPintar.putExtras(MandadorDatos.enviarDatos(auxManejadorIns,auxManejadorReportes));
        startActivity(intentoPintar);
    }

}