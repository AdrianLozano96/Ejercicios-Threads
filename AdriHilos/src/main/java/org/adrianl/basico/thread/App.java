package org.adrianl.basico.thread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MiHilo h1 = new MiHilo("Hilo 1", 20);
        MiHilo h2 = new MiHilo("Hilo 2", 5);
        MiHilo h3 = new MiHilo("Hilo 3", 12);
        MiHilo h4 = new MiHilo("Hilo 4", 19);
        MiHilo h5 = new MiHilo("Hilo 5", 8);
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        //Con el join se espera a que el último hilo se ejecute para seguir con el programa
        //El main espera a la finalización de los hilos y estos se finalizan en el orden marcado
        //Al salir del try catch los hilos (join) habrán finalizado
        try{
            h1.join(); h2.join(); h3.join(); h4.join(); h5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FIN DE LA EJECUCIÓN DE TODO LOS HILOS");
    }
}
