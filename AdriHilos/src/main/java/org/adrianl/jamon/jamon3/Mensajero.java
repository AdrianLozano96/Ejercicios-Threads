package org.adrianl.jamon.jamon3;

import java.util.ArrayDeque;

//CONSUMIDOR
public class Mensajero extends Thread{

    //agrupándolos en un lote para llevarlos a la tienda.
    // Una vez sacado imprime el lote con su identificador.
    //Opcional: hacer otro monitor (tienda al que llevar las tandas de jamon3 para que los consuma un cliente.

    private Secadero secadero;
    private int cantidad;   //Cantidad a consumir
    private int lote;

    public Mensajero(String nombre, Secadero secadero, int cantidad, int lote) {
        super(nombre);
        this.secadero = secadero;
        this.cantidad = cantidad;
        this.lote = lote;
    }

    @Override
    public void run() {
        ArrayDeque<Jamon> jamones = new ArrayDeque<>();
        ArrayDeque<Jamon> jamones2 = new ArrayDeque<>();
        for(int i=0; i<cantidad; i++){
            //Por otro lado, tenemos el mensajero que sacará tandas de tres en tres jamon3
            for(int l=0; l<lote; l++){
                Jamon j = secadero.consumir(this.getName());
                j.setLote(i);
                jamones.add(j);
            }
            System.out.println("Terminado el lote "+(i+1)+"º de "+ cantidad);
            jamones2.addAll(jamones);
            jamones.forEach(System.out::println);
            jamones.clear();
            //cada tres segundos si es posible y hay existencias en el secadero,
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        jamones2.forEach(System.out::println);


    }
}
