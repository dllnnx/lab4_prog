package org.example.exceptions;

public class IllegalPhraseException extends RuntimeException{
    @Override
    public String toString() {
        return "Мысль должна содержать слова!";
    }
}
