package org.example;

public class AtuendoConPocasPrendasException extends RuntimeException{
    public AtuendoConPocasPrendasException(){
        super("El atuendo debe estar formado por dos o más prendas");
    }

}
