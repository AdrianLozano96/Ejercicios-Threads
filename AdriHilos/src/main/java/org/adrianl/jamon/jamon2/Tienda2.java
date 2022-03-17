package org.adrianl.jamon.jamon2;

import java.util.ArrayDeque;
import java.util.List;

public class Tienda2 {

    private boolean disponible = false;
    private ArrayDeque<Jamon2> jamones = new ArrayDeque<>();

    public synchronized void enviar(List<Jamon2>jamons){
        while(disponible && !jamones.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        jamones.addAll(jamons);
        disponible = true;
        notifyAll();
    }

    public synchronized Jamon2 entregar(){
        while(!disponible && jamones.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Jamon2 jamon = jamones.remove();
        disponible = false;
        notifyAll();
        return jamon;
    }


}
