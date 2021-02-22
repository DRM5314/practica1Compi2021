package com.example.principal.manejadorInstrucciones;

import android.os.Bundle;

import com.example.principal.ManejadorIns;
import com.example.principal.Reportes;

public class MandadorDatos {

    public static Bundle enviarDatos(ManejadorIns insEntrada, Reportes reportesEntrada){
        Bundle retorno =null;
            retorno = new Bundle();
            retorno.putSerializable("manejadorInstrucciones",insEntrada);
            retorno.putSerializable("manejadorReportes",reportesEntrada);
        return retorno;
    }
}
