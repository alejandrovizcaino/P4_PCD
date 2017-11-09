package practica1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Consumidor extends Thread {
    private PilaLenta lapila;
    private Ordenador turno;
    private int id;
    
    public Consumidor(PilaLenta p){
        lapila = p;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 15; i++) {
            int fuera=0;
            try {
                fuera = (int) lapila.Desapila();
            } catch (Exception ex) {}
            System.out.println("Desapilado el numero "+fuera);
            
        }
    }
}
