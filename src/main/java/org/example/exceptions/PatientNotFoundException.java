package org.example.exceptions;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message){
        super("Нет такого пациента: "+message);
    }
}
