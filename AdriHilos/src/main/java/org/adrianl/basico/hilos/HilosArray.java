package org.adrianl.basico.hilos;

public class HilosArray extends Thread {

    @Override
    public void run() {
        System.out.println("Soy el hilo "+getName());
    }

    public static void main(String[] args) {
        HilosArray[] hilos = new HilosArray[5]; //10 hilos

        for(int i=0; i<hilos.length; i++){    //Creo los hilos
            hilos[i]=new HilosArray();
            hilos[i].start();
        }

        try {
            for (int i = 0; i < hilos.length; i++) {    //Ejecuto los hilos
                hilos[i].join(); //Con join hacemos que el hilo principal se ejecute el último, es decir que
            }   //Hasta que no se ejecuten todos los hilos que estan en el join no se ejecutará el hilo principal
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo Principal");
    }
}