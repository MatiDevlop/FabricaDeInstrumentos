/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.fabricadeinstrumentos;

import java.util.ArrayList;

/**
 *
 * @author Steven Morocho
 */
public class Fabrica {
    private ArrayList<Sucursal> sucursales;
    public Fabrica(){
        this.sucursales=new ArrayList<>();
    }
    public void agregarSucursal(Sucursal s){
        this.sucursales.add(s);
    }
    public void listarInstrumentos(){
        for(Sucursal s:sucursales){
            System.out.println(s.getNombre());
            s.listarInstrumentos();
        }
    }
    public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo){
        ArrayList<Instrumento> instEncontrados=new ArrayList<>();
        for(Sucursal s:sucursales){
            instEncontrados.addAll(s.instrumentosPorTipo(tipo));            
        }
        return instEncontrados;
    }
    public Instrumento borrarInstrumento(String ID){
        Instrumento borrado=null;
        int i=0;
        while(i<sucursales.size() && borrado==null){
            borrado=sucursales.get(i).borrarInstrumento(ID);
            i++;
        }
        return borrado;
    }
    public double[] porcInstrumentosPorTipo(String nombre){
        double [] porcentajes=null;
        Sucursal sucEncontrada=buscarSucursal(nombre);
        if(sucEncontrada != null){
            porcentajes=sucEncontrada.porcInstrumentosPorTipo();
        }
        return porcentajes;
    }
    private Sucursal buscarSucursal(String nombre){
        Sucursal ins=null;
        int i=0;
        while(i<sucursales.size() && !sucursales.get(i).getNombre().equals(nombre)){
            i++;
        }
        if(i<sucursales.size())
            ins=sucursales.get(i);
        return ins;
    }
}
