package org.adrianl.basico.hilos;

public class Main {

    public static void main(String[] args) {

        /*//HILOS DE UNA CLASE QUE HEREDA DE THREAD
        Herencia hiloHeredado1 = new Herencia();    //Al heredar de thread solo llamando al constructor de la clase se crea un hilo
        Herencia hiloHeredado2 = new Herencia();
        Herencia hiloHeredado3 = new Herencia();
        hiloHeredado1.start();      //Con start() se ejecuta el método run de la clase
        hiloHeredado2.start();
        hiloHeredado3.start();
        */
        //HILOS  QUE IMPLEMENTAN LA INTERFACE RUNNABLE
        Implementacion tarea1 = new Implementacion("Primero");  //Se crea una instancia de la clase que implementa Runnable
        Thread hilo1 = new Thread(tarea1);  //Se crea un hilo con la clase Thread y se le pasa por parámetros al constructor la instancia
        Thread hilo2 = new Thread(new Implementacion("Segundo"));
        Implementacion tarea3 = new Implementacion("Tercero");
        Thread hilo3 = new Thread(tarea3);
        hilo1.start(); //Se ejecuta el hilo
        hilo2.start();
        hilo3.start();


        System.out.println("Yo Soy El Hilo Del Main");
        System.out.println("Fin Del Hilo Principal");

    }
}
