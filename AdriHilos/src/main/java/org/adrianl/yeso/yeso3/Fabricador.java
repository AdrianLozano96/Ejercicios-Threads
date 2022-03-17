package org.adrianl.yeso.yeso3;

//PRODUCTOR
public class Fabricador extends Thread{

    private Fabrica fabrica;
    private int cantidad;   //Cantidad a fabricar
    private double tiempo;

    public Fabricador(String nombre, Fabrica fabrica, int cantidad){
        super(nombre);
        this.fabrica = fabrica;
        this.cantidad = cantidad;
    }


    @Override
    public void run() {

        for(int i=0; i<cantidad; i++){
            Saco saco = new Saco();
            System.out.println(this.getName()+" ha fabricado el Saco2: "+saco.toString());
            //saco.setId(i+1);    //A los sacos ha de asignarle código del saco
            tiempo = saco.getTiempo();
            fabrica.fabricar(saco);
        }
        try {
            Thread.sleep((long) tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //Fabrica2 100 sacos y los guarda en la Fabrica2





}
