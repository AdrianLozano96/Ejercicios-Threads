package org.adrianl.jamon.jamon1;

import java.util.ArrayDeque;
import java.util.List;

public class Tienda {

    private boolean disponible = false;
    private ArrayDeque<Jamon> jamones = new ArrayDeque<>();

    public synchronized void enviar(List<Jamon>jamons){
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

    public synchronized Jamon entregar(){
        while(!disponible && jamones.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Jamon jamon = jamones.remove();
        disponible = false;
        notifyAll();
        return jamon;
    }


}
