package org.adrianl.yeso.yeso2;

import java.util.ArrayDeque;

public class Fabrica2 {

    private boolean lleno = false;
    private ArrayDeque<Saco2> sacos = new ArrayDeque<>();

    public Fabrica2() {}

    public synchronized void producir(Saco2 saco){
        while(lleno && !sacos.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sacos.push(saco);
        lleno = true;
        notifyAll();
    }

    public synchronized Saco2 empaquetar(){
        while(!lleno && sacos.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Saco2 saco = sacos.pop();
        lleno = false;
        notifyAll();
        return saco;
    }


}
