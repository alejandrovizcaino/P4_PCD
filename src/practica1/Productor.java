package practica1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Productor extends Thread {
    private PilaLenta lapila;
    private Ordenador turno;
    private int id;
    
    public Productor(PilaLenta p, int _id, Ordenador _turno, int _total){ ////parametros nuevos
        lapila = p;
        turno = _turno;
        id = _id;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 15; i++) {
            Random r = new Random();
            int aleatorio = r.nextInt(11);
            try {
                lapila.Apila(aleatorio);
                System.out.println("Apilado el numero "+aleatorio);
            } catch (Exception ex) {}
            turno.cogeturno(id);
            System.out.println("Soy el hilo " + id);
            turno.termina(id);
        }
    }
}
