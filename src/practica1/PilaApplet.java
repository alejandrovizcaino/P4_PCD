package practica1;

import java.applet.Applet;

/**
 *
 * @author Alex
 */
public class PilaApplet extends Applet {
    
    Thread h1, h2;
            
    @Override
    public void init(){
        int capacidad = 10;
        CanvasCola vista = new CanvasCola(capacidad);
        PilaLenta miPila = new PilaLenta(capacidad, vista);
        h1 = new Thread(new Productor(miPila));
        h2 = new Thread(new Consumidor(miPila));
        this.setSize(400, 200);
        add(vista);
    }
    
    @Override
    public void start(){
        h1.start();
        h2.start();
    }
    
    @Override
    public void stop(){
        h1.interrupt();
        h2.interrupt();
    }
}
