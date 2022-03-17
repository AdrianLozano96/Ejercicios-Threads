package org.adrianl.mercado.caja;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Se necesita usar una clase que implemente de Runnable para usar Executors
public class MainExecutor {
    static int numCajeras = 2;    //Número de hilos del programa
    //static int numClientes = 8;

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2 })); // 12 Seg
        clientes.add(new Cliente("Cliente 2", new int[] { 1, 1, 5, 1, 1 })); //  9 Seg
        clientes.add(new Cliente("Cliente 3", new int[] { 5, 3, 1, 5, 2 })); // 16 Seg
        clientes.add(new Cliente("Cliente 4", new int[] { 2, 4, 3, 2, 5 })); // 16 Seg
        clientes.add(new Cliente("Cliente 5", new int[] { 1, 3, 2, 2, 3 })); // 11 Seg
        clientes.add(new Cliente("Cliente 6", new int[] { 4, 2, 1, 3, 1 })); // 11 Seg
        clientes.add(new Cliente("Cliente 7", new int[] { 3, 3, 2, 4, 7 })); // 19 Seg
        clientes.add(new Cliente("Cliente 8", new int[] { 6, 1, 3, 1, 3 })); // 14 Seg
        // Tiempo total en procesar todos los pedidos = 108 segundos

        long init = System.currentTimeMillis();  // Instante inicial del procesamiento
        //Creamos nuestro pool
        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);    //IMPORTANTE
        /*
        Hemos creado un objeto de la clase Executors en el que en el método "newFixedThreadPool()"
        le estamos diciendo que fije como número de threads a ejecutar '2' (siendo numCajeras = 2);
        es decir, que nos llevará la gestión de los procesos a ejecutar en los threads del programa.
        Lo de "ThreadPool" es porque este Framework Executors parte del concepto de que gestiona una
        piscina (pool) de threads, de ahi que a los threads que se crea les asigne nombres del tipo
        "pool-1-thread-1", "pool-1-thread-2", etc.
         */
        for (Cliente cliente: clientes) {
            Runnable cajera = new CajeraRunnable(cliente, init);
            executor.execute(cajera);
        }
        /*
        Una vez declarado el "executor",  lanzamos los procesos (es decir los clientes se ponen en cola)
        para procesarlos. Para ello recorremos el ArrayList y decimos que a cada Cliente le procese el
        pedido una cajera (Runnable cajera = new CajeraRunnable(cliente, init)) y decimos también que sea el
        Executor el encargado de gestionar la cola de threads (executor.execute(cajera)):
         */

        executor.shutdown();	// Cierro/apago el Executor  SI NO SE PONE EL PROGRAMA NO PARA DE EJECUTARSE
        //Para que hasta que no termine la ejecución de los procesos que ejecuta el "executor" no ejecute los siguientes
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos
            // para pasar a las siguientes instrucciones
        }

        long fin = System.currentTimeMillis();	// Instante final del procesamiento
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
    }
}

//Antes cada cajera atendia a un cliente. Pero si hay dos cajeras y más clientes?
// la clase "Executors" va a ser la encargada de organizar la cola de los
// Clientes y mandar a los Clientes a la Cajera correspondiente cuando
// esta haya terminado de procesar la compra del Cliente anterior.
