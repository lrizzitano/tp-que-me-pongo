package org.example;

public class AtuendoConPocasPrendasException extends Exception{
    public AtuendoConPocasPrendasException(){
        super("El atuendo debe estar formado por dos o más prendas");
    }

}
