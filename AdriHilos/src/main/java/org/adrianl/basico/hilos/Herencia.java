package org.adrianl.basico.hilos;

public class Herencia extends Thread{ //Al heredar de Thread la clase es como un hilo
    @Override
    public void run() {     //Siempre se debe de sobreescribir, ya que indica lo que hará el hilo
        for(int i=0; i<10; i++){
            System.out.println("Soy el hilo "+ getName()); //Con getName obtengo el nombre del hilo
            try{
                Thread.sleep(100);  //Al dormir el hilo este se detiene durante el tiempo indicado
            } catch (InterruptedException e) {  //Mientras un hilo esta dormido otros hilos pueden ejecutarse
                e.printStackTrace();
            }
        }


    }

}