package org.adrianl.yeso.yeso3;

import java.util.ArrayDeque;

public class Fabrica {
    //Poner una lista de sacos para ponerlos y sacarlos
    ArrayDeque<Saco> sacos = new ArrayDeque<Saco>();
    private boolean estaLleno = false;

    public synchronized void fabricar(Saco saco){
        while(estaLleno && sacos.size()==100){
            try {
                wait();
                System.out.println("Esperando a que se vacie");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sacos.push(saco);
        estaLleno = true;
        notifyAll();
    }

    public synchronized Saco empaquetar(){
        while(!estaLleno && sacos.isEmpty()){
            try {
                wait();
                System.out.println("Esperando a que se llene");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Saco saco = sacos.pop();
        estaLleno = false;
        notifyAll();
        return saco;
    }

}
