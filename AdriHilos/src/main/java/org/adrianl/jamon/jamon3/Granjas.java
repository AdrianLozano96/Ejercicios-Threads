package org.adrianl.jamon.jamon3;
//Hay varias (2 en total)
//PRODUCTOR
public class Granjas extends Thread{

    // Una vez listo el jamón fresco lo llevan al secadero si hay espacio.
    // Además, sabemos que la granja 2 siempre es más eficiente obteniendo jamon3 y la 1 la menos eficiente. (MAIN)

    private Secadero secadero;
    //Producirán 30 jamon3 en total cada granja.
    private int cantidad; //Cantidad a producir

    public Granjas(String nombre, Secadero secadero, int cantidad) {
        super(nombre);
        this.secadero = secadero;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad;i++){
            Jamon j = new Jamon();
            // De la granja sabemos que tiene un nombre: “granja y su número”.
            j.setId(i+1);
            j.setIdGranja(this.getName());
            secadero.producir(this.getName(),j);
            System.out.println("La "+this.getName()+" envia el "+j.toString());
            //Obtienen el jamón fresco en un intervalo de un segundo.
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
