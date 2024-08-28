package Ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Taxista implements Runnable {
    
    private Taxi unTaxi;

    public Taxista(Taxi unTaxi) {
        this.unTaxi = unTaxi;
    }
    
    public void run(){      
        while(true){
            try {
                unTaxi.comenzarViaje();
                Thread.sleep(2000);
                unTaxi.terminarViaje();
            } catch (InterruptedException ex) {
                Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
