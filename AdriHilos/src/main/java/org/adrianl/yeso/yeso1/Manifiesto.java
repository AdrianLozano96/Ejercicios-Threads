package org.adrianl.yeso.yeso1;

import java.util.ArrayDeque;

public class Manifiesto {

    ArrayDeque<Saco> misSacos = new ArrayDeque<>();
    boolean disponible = false;

    public synchronized void producir(Saco s){
        while(disponible && !misSacos.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        misSacos.add(s);
        disponible = true;
        notifyAll();
    }

    public synchronized Saco consumir(){
        while(!disponible && misSacos.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Saco s = misSacos.remove();
        disponible = false;
        notifyAll();
        return s;
    }


}
