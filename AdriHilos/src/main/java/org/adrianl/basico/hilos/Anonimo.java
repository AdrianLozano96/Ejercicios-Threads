package org.adrianl.basico.hilos;

public class Anonimo {

    public static void main(String[] args) {
        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println("Soy el hilo "+ Thread.currentThread().getName()); //Con getName obtengo el nombre del hilo
                    //También puedo crear una varible nombre, pasarsela al constructor y al crear el hilo
                    // en el main llamarle con el nombre que quiera.
                    try{
                        Thread.sleep(100);  //Al dormir el hilo este se detiene durante el tiempo indicado
                    } catch (InterruptedException e) {  //Mientras un hilo esta dormido otros hilos pueden ejecutarse
                        e.printStackTrace();
                    }
                }
            }
        });
        hilo.start();
    }
}
