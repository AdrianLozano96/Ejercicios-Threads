package org.adrianl.jamon.jamon3;

import java.util.ArrayDeque;

//MONITOR
public class Secadero {

    //Admite un máximo de 10 jamon3
    private boolean lleno = false;
    private int max;
    private ArrayDeque<Jamon> jamones = new ArrayDeque<Jamon>();

    public Secadero() {}

    public synchronized void producir(String granja, Jamon j){
        while(lleno && jamones.size()==10){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        jamones.add(j);
        System.out.println("La Granja "+granja+" ha puesto en el secadero el "+j.toString());
        if(jamones.size()==10) {
            lleno = true;
            notifyAll();
        }
    }

    public synchronized Jamon consumir(String mensajero){
        while(!lleno && jamones.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Jamon j = jamones.remove();
        System.out.println("El Mensajero "+ mensajero+" ha cogido el "+j.toString());
        lleno = false;
        notifyAll();
        return j;
    }

}
