package Ejercicio6;

public class Main {

    public static void main(String[] args){
        
        Taxi unTaxi = new Taxi();
        
        Pasajero[] pasajeros = new Pasajero[5];  
        for (int i = 0; i < 5; i++) {
            Pasajero pasajero = new Pasajero(unTaxi);
            Thread hilo = new Thread(pasajero, Integer.toString(i+1));
            hilo.start();
        }
        
        Taxista unTaxista = new Taxista(unTaxi);
        Thread hilo = new Thread(unTaxista);
        hilo.start();
    }
}
