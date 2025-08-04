package org.example.Exceptions;

public class AtuendoConPocasPrendasException extends RuntimeException{
    public AtuendoConPocasPrendasException(){
        super("El atuendo debe estar formado por dos o más prendas");
    }

}
