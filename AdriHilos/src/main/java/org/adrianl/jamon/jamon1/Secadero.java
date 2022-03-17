package org.adrianl.jamon.jamon1;

import java.util.LinkedList;

//MONITOR
public class Secadero {

    //Admite un máximo de 10 jamon3
    private int max;
    private boolean disponible = false;
    private LinkedList<Jamon> jamones = new LinkedList<>();//LinkedList
    public Secadero(int max){this.max = max;}


    public synchronized void producir(Jamon jamon){
        while(jamones.size()==max){
            try {
                wait();
                System.out.println("Espero a que se los lleven");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        jamones.add(jamon);
        System.out.println(jamones.size()+" METIDOS");
        disponible = true;
        notifyAll();
    }

    public synchronized Jamon consumir(){
        while(jamones.size()==0){
            try {
                wait();
                System.out.println("Espero a que se produzcan más");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Jamon jamon = jamones.remove();
        System.out.println(jamones.size()+" TAMAÑO");
        disponible = false;
        notifyAll();
        return jamon;
    }


}
