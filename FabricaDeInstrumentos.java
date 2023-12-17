/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.fabricadeinstrumentos;

import java.util.ArrayList;

/**
 *
 * @author Steven Morocho
 */
public class FabricaDeInstrumentos {

    public static void main(String[] args) {
        Fabrica f=new Fabrica();
        cargarFabrica(f);
        ArrayList<Instrumento> lista=f.instrumentosPorTipo(TipoInstrumento.VIENTO);
        for (Instrumento i : lista) {
            System.out.println(i);
        }
        Instrumento borrado=f.borrarInstrumento("ABC123");
        System.out.println("Se borro: "+borrado);
        
        double [] porcs=f.porcInstrumentosPorTipo("Sucursal1");
        for (int i = 0; i < porcs.length; i++) {
            System.out.println(porcs[i]);
        }
        
    }
    private static void cargarFabrica(Fabrica f){
        Sucursal s1=new Sucursal("Sucursal1");
        Sucursal s2=new Sucursal("Sucursal2");
        
        Instrumento i1=new Instrumento("ABC123",400,TipoInstrumento.CUERDA);
        Instrumento i2=new Instrumento("DEF123",500,TipoInstrumento.PERCUSION);
        Instrumento i3=new Instrumento("GHI123",700,TipoInstrumento.VIENTO);
        Instrumento i4=new Instrumento("JKL123",400,TipoInstrumento.CUERDA);
        
        s1.agregarInstrumento(i1);
        s1.agregarInstrumento(i2);
        s2.agregarInstrumento(i3);
        s2.agregarInstrumento(i4);
        
        f.agregarSucursal(s1);
        f.agregarSucursal(s2);
    }
    
}
