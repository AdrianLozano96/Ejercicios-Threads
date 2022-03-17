package org.adrianl.jamon.jamon4;

import java.util.ArrayDeque;

public class Secadero {

    private int max; //10 Jamones Máximo
    private boolean disponibilidad = false;
    ArrayDeque<Jamon> misJamones = new ArrayDeque<>();

    public Secadero(int max) {
        this.max = max;
    }

    public synchronized void producir(Jamon j){
        while(disponibilidad && misJamones.size()==max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        misJamones.add(j);
        disponibilidad = true;
        notifyAll();
    }

    public synchronized Jamon consumir(){
        while(!disponibilidad && misJamones.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Jamon j = misJamones.remove();
        disponibilidad = false;
        notifyAll();
        return j;
    }



}
