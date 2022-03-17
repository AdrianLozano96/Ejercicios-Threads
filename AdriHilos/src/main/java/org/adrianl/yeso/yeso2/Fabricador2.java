package org.adrianl.yeso.yeso2;

//PRODUCTOR
public class Fabricador2 extends Thread{
    //Fabrica2 100 sacos y los guarda en la Fabrica2
    //A los sacos ha de asignarle código del saco

    private Fabrica2 fabrica;
    private int cantidad;   //Cantidad a producir

    public Fabricador2(String nombre, Fabrica2 fabrica, int cantidad) {
        super(nombre);
        this.fabrica = fabrica;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        for(int i=0; i<cantidad; i++){
            Saco2 saco = new Saco2();
            //saco.setId(i);
            fabrica.producir(saco);
            System.out.println(this.getName()+" ha enviado el saco "+i);
            try {
                Thread.sleep((long) saco.getPeso());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" ha enviado sus "+cantidad+" sacos");
    }

}
