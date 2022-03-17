package org.adrianl.jamon.jamon4;

import java.util.ArrayList;
import java.util.List;

public class Mensajero extends Thread{

    private int cantidad;
    private int lote; //Los saca de 3 en tres cada tres segundos
    private Secadero secadero;
    private Tienda tienda;
    private List<String> misJamones = new ArrayList<>();
    //Mostrar lote


    public Mensajero(String nombre, int cantidad, int lote, Secadero secadero, Tienda tienda) {
        super(nombre);
        this.cantidad = cantidad;
        this.lote = lote;
        this.secadero = secadero;
        this.tienda = tienda;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            for(int l=0; l<lote; l++){
                Jamon j = secadero.consumir();
                j.setMensajero(this.getName());
                j.setLote((i+1));
                misJamones.add(j.toString());
                System.out.println(this.getName()+" ha cogido el Jamon "+(i+1)+" de "+cantidad+" jamon4");
            }
            System.out.println("---------- Jamones del lote "+(i+1)+" del "+this.getName());
            misJamones.forEach(System.out::println);
            tienda.escribir(misJamones);
            misJamones.clear();
        }
        System.out.println(this.getName()+" ha terminado de coger sus "+cantidad+" jamon4");
    }
}
