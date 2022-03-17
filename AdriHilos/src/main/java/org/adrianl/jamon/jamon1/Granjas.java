package org.adrianl.jamon.jamon1;
//Hay varias (2 en total)
//PRODUCTOR
public class Granjas extends Thread{

    //Obtienen el jamón fresco en un intervalo de un segundo.
    // Una vez listo el jamón freso lo llevan al secadero si hay espacio.

    //Producirán 30 jamon3 en total cada granja.
    // De la granja sabemos que tiene un nombre: “granja y su número”.
    // Además, sabemos que la granja 2 siempre es más eficiente obteniendo jamon3 y la 1 la menos eficiente. (MAIN)

    private Secadero secadero;
    private int cantidad;   //Cantidad a producir

    public Granjas(String nombre, Secadero secadero, int cantidad) {
        super(nombre);
        this.secadero = secadero;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        for(int i=1; i<cantidad+1; i++){
            Jamon jamon = new Jamon();
            //jamon1.setId(i);
            jamon.setIdGranja(this.getName());
            System.out.println(this.getName()+" ha producido el jamon1 "+i);
            secadero.producir(jamon);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" ha terminado de producir sus "+cantidad+" jamon3");
    }
}
