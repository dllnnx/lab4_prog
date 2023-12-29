package org.example.exceptions;

public class IllegalPhraseException extends RuntimeException{

    public IllegalPhraseException(String exception){
        super(exception);
    }

    public IllegalPhraseException(){}
    @Override
    public String toString() {
        return "Мысль должна содержать слова!";
    }
}
