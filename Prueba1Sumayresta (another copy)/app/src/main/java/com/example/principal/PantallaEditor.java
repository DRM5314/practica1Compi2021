package com.example.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.principal.tabla.AuxiliarTabla;

import java.io.StringReader;

public class PantallaEditor extends AppCompatActivity {
    public static final String textoCapturado = "com.example.Prueba1(Suma y resta)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_editor);
    }
    public void analizar(View view){
        EditText cuadroTexto = (EditText) findViewById(R.id.textoEntrada);
        String texto = cuadroTexto.getText().toString();
        Intent intento = null;
        Bundle enviarDatos = new Bundle();
        if(texto.length()>0){
            Lexico lex = new Lexico(new StringReader(texto));
            try {
                parser p = new parser(lex);
                p.parse();
                //p.getInfo();
                p.agregarReportesLexicos(lex.getReportesErrores());
                if(p.existeError()){
                    intento = new Intent(this, AuxiliarTabla.class);
                    enviarDatos.putSerializable("manejadorReportes",p.getReportes());
                    enviarDatos.putSerializable("manejadorInstrucciones",null);
                    intento.putExtra("tipoReporte","errores");
                    intento.putExtras(enviarDatos);
                    startActivity(intento);
                }else {
                    intento = new Intent(this,MainActivity.class);
                    enviarDatos.putSerializable("manejadorInstrucciones", p.getInstrucciones());
                    enviarDatos.putSerializable("manejadorReportes",p.getReportes());
                    intento.putExtras(enviarDatos);
                    startActivity(intento);
                    finish();
                }
            }catch (Exception e){
                System.out.println("Error al parsear");
                System.out.println(e);
            }
        }
    }
}