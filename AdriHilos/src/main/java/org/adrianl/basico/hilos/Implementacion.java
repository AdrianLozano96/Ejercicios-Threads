package org.adrianl.basico.hilos;

public class Implementacion implements Runnable { //Al implementar runnable podemos heredar de otra clase
    private static int count =0;
    private String nombreHilo;
    public Implementacion(String nombreHilo) {     //De esta forma al crear un hilo le puedo poner el nombre que quiera.
        this.nombreHilo = nombreHilo;
    }
    @Override
    public void run() {     //Siempre se debe de sobreescribir, ya que indica lo que hará el hilo
        for(int i=0; i<10; i++){
            System.out.println("Soy el hilo "+nombreHilo+" Ejecucion "+(count++));
            try{
                Thread.sleep(100);  //Al dormir el hilo este se detiene durante el tiempo indicado
            } catch (InterruptedException e) {  //Mientras un hilo esta dormido otros hilos pueden ejecutarse
                e.printStackTrace();
            }
        }

    }
}
