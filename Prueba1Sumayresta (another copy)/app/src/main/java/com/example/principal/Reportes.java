
package com.example.principal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class Reportes implements Serializable {
   private List <String[]> erroresSintacticos_Y_Lexicos = new ArrayList<>();
   private List <String[]> ocurrenciaOperador = new ArrayList<>();

    public List<String[]> getOcurrenciaOperador() {
        return ocurrenciaOperador;
    }

    private String [] nombreAnimacion = {"linea","curva"};
   private int [] contadorAnimacion = new int[nombreAnimacion.length];

   private String[] objetos = {"circulo","cuadrado","linea","rectangulo","poligono"};
   private int [] contadorObjeto = new int[objetos.length];

   private String [] colores = {"azul","rojo","verde","amarillo","naranja","morado","cafe","negro"};
   private int contadorColor [] = new int[colores.length];
   public void agregarReporte(String tipo){
       switch(tipo){
           case "circulo":
               contadorObjeto[0]++;
               break;
            case "cuadrado":
                contadorObjeto[1]++;
               break;
            case "linea":
                contadorObjeto[2]++;
               break;
            case "rectangulo":
                contadorObjeto[3]++;
               break;
            case "poligono":
                contadorObjeto[4]++;
               break;
            case "animacionLinea":
               contadorAnimacion[0]++;
               break;
            case "animacionCurva":
               contadorAnimacion[1]++;
               break;
            case "azul":
               contadorColor[0]++;
               break;
            case "rojo":
                contadorColor[1]++;
               break;
            case "verde":
                contadorColor[2]++;
               break;
            case "amarillo":
                contadorColor[3]++;
               break;
            case "naranja":
                contadorColor[4]++;
               break;
            case "morado":
                contadorColor[5]++;
               break;
            case "cafe":
                contadorColor[6]++;
               break;
            case "negro":
                contadorColor[7]++;
               break;                             
       }
   }

    public void agregarReporte (String tipo,String id, String mensaje,int linea,int columna){
        switch(tipo){
            case "error":
                erroresSintacticos_Y_Lexicos.add(new String []{id,""+linea,""+columna,mensaje});
                System.out.println("Agreggo error "+id+" "+mensaje);
                break;
            case "operador":
                this.ocurrenciaOperador.add(new String []{id,mensaje,""+linea,""+columna});
                break;
        }
    }
    public void agregarErroresLexicos (List<String[]> entrada){
       if(entrada.size()>0)this.erroresSintacticos_Y_Lexicos.addAll(0,entrada);
    }
    public void agregarReporte(String s, String mensaje, String tipoOperador){
        this.ocurrenciaOperador.add(new String []{tipoOperador,mensaje});
    }

    public List<String[]> getErroresSintacticos() {
        return erroresSintacticos_Y_Lexicos;
    }

    public String [] getNombreObjeto(){
        return objetos;
    }
    public int [] getContadorObjeto(){
       return contadorObjeto;
    }
    public String [] getNombreAnimacion(){
       return nombreAnimacion;
    }
    public int [] getContadorAnimacion(){
       return contadorAnimacion;
    }
    public String [] getColoresNombres(){
       return colores;
    }
    public int [] getContadorColor (){
       return contadorColor;
    }

    public void getInfo(){
        System.out.println("Cantidad de erroers "+erroresSintacticos_Y_Lexicos.size());
    }
    public boolean existenErroresSintacticos(){
       if(erroresSintacticos_Y_Lexicos.size()>0)return true;
       else return false;
    }
}
