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
public class Sucursal {
    private String nombre;
    private ArrayList<Instrumento> instrumentos;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.instrumentos=new ArrayList<>();
    }
    
    public void agregarInstrumento(Instrumento i){
        this.instrumentos.add(i);
    }
    public void listarInstrumentos(){
        for(Instrumento i:this.instrumentos){
            System.out.println(i);
        }
    }
    public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo){
        ArrayList<Instrumento> insTipo=new ArrayList<>();
        for(Instrumento i:instrumentos){
            if(i.getTipo().equals(tipo))
                insTipo.add(i);
        }
        return insTipo;
    }
    public Instrumento borrarInstrumento(String ID){
        Instrumento insAborrar=buscarInstrumento(ID);
        this.instrumentos.add(insAborrar);
        return insAborrar;
    }
    public double[] porcInstrumentosPorTipo(){
        final int cant_instrumentos=TipoInstrumento.values().length;
        double[] porcentajes=new double[cant_instrumentos];
        for(Instrumento i:instrumentos){
            porcentajes[i.getTipo().ordinal()]++; 
        }
        absolutoAPorcentaje(porcentajes);
        return porcentajes;
    }
    public String getNombre(){
        return nombre;
    }
    private Instrumento buscarInstrumento(String ID){
        Instrumento ins=null;
        int i=0;
        while(i<instrumentos.size() && !instrumentos.get(i).getID().equals(ID)){
            i++;
        }
        if(i<instrumentos.size())
            ins=instrumentos.get(i);
        return ins;
    }
    private void absolutoAPorcentaje(double[] listado){
        for (int i = 0; i < listado.length; i++) {
            listado[i]=listado[i]*100/instrumentos.size();
        }
    }
}
