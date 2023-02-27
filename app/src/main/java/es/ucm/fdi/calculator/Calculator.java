package es.ucm.fdi.calculator;

import android.util.Log;

public class Calculator {

    private int entera,contadordecimal;
    private double total,sumando, decimal;
    private boolean pulsacoma;

    public Calculator(){
        this.total=0;
        this.sumando=0;
        this.entera=0;
        this.decimal=0;
        this.contadordecimal=1;
        this.pulsacoma=false;
    }
    public void suma(int i){

        if(!pulsacoma)
            this.entera= this.entera*10 +i;
        else {
            this.decimal = this.decimal + i / Math.pow(10, contadordecimal);
            this.contadordecimal++;
        }
        this.sumando=this.entera+this.decimal;
    }

    public void sumaTotal(){
        this.total+=this.sumando;
    }

    public void reset(){
        this.setSumando(0);
        this.setEntera(0);
        this.setDecimal(0);
        this.setContadordecimal(1);
        this.setPulsacoma(false);
    }

    public int getEntera() {
        return entera;
    }

    public void setEntera(int entera) {
        this.entera = entera;
    }

    public int getContadordecimal() {
        return contadordecimal;
    }

    public void setContadordecimal(int contadordecimal) {
        this.contadordecimal = contadordecimal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSumando() {
        return sumando;
    }

    public void setSumando(double sumando) {
        this.sumando = sumando;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public boolean isPulsacoma() {
        return pulsacoma;
    }

    public void setPulsacoma(boolean pulsacoma) {
        this.pulsacoma = pulsacoma;
    }
}

