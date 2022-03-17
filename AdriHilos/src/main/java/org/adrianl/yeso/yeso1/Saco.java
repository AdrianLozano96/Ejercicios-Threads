package org.adrianl.yeso.yeso1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Saco {

    private int idSaco;
    private int lote;
    private double peso;    //aleatoriamente según el proceso de producción entre 25 y 50 kilogramos ambos inclusive.
    private String fecha;
    private LocalDate actual = LocalDate.now();
    private String tipo;
    private String fabricador;
    private String empaquetador;

    public Saco() {
        peso = (Math.random()*50-25+1)+25;
        fecha = actual.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        tipoSaco();
    }

    public void tipoSaco(){
        int porcentaje = (int)(Math.random()*100+1);
        if(porcentaje<=60){ //60%
            tipo = "saco normal";
        }
        if(porcentaje>60&&porcentaje<=85){
            tipo = "saco super";
            peso+=20;
        }
        if(porcentaje>85){
            tipo = "saco extra";
            peso+=25;
        }
    }


    public int getIdSaco() {
        return idSaco;
    }

    public void setIdSaco(int idSaco) {
        this.idSaco = idSaco;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFabricador() {
        return fabricador;
    }

    public void setFabricador(String fabricador) {
        this.fabricador = fabricador;
    }

    public String getEmpaquetador() {
        return empaquetador;
    }

    public void setEmpaquetador(String empaquetador) {
        this.empaquetador = empaquetador;
    }

    @Override
    public String toString() {
        return "Saco: " +
                "idSaco=" + idSaco +
                ", lote=" + lote +
                ", peso=" + peso +
                ", fecha='" + fecha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fabricador='" + fabricador + '\'' +
                ", empaquetador='" + empaquetador;
    }
}
