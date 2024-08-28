package Ejercicio6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Taxi {
    
    private Semaphore puedeSubir = new Semaphore(1, true);
    private Semaphore puedeBajar =  new Semaphore(0);
    private Semaphore puedeViajar =  new Semaphore(0);
    
    
    public void tomarTaxi(){
        try {
            puedeSubir.acquire();         
            puedeViajar.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bajarTaxi(){
        try {
            puedeBajar.acquire();
            puedeSubir.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void comenzarViaje(){
        try {
            puedeViajar.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarViaje(){
        puedeBajar.release();
    }
}
