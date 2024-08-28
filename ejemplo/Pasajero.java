package Ejercicio6;


public class Pasajero implements Runnable{
    
    private Taxi unTaxi;

    public Pasajero(Taxi unTaxi) {
        this.unTaxi = unTaxi;
    }    
    
    public void run(){        
           // unTaxi.esperarPasajero();
            unTaxi.tomarTaxi();
            System.out.println("Cliente " + Thread.currentThread().getName() + " comienza el viaje");
            unTaxi.bajarTaxi();
            System.out.println("Cliente " + Thread.currentThread().getName() + " termina el viaje");      
    }
}
