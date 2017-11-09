package practica1;

/**
 *
 * @author Alejandro
 */
public class PilaLenta implements IPila {

    private int cima;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private CanvasCola canvas;

    public PilaLenta(int capacidad, CanvasCola elcanvas) {
        this.capacidad = capacidad;
        datos = new Object[capacidad];
        cima = -1;
        canvas = elcanvas;
    }

    @Override
    public int GetNum() {
        return numelementos;
    }

    @Override
    public synchronized void Apila(Object elemento) throws Exception {
        if (!pilallena()) {
            datos[++cima] = elemento;
            Thread.sleep(200);
            numelementos++;
            Thread.sleep(200);
            canvas.representa(datos, cima, numelementos);
        } else {
            
            while (pilallena()) wait();
            
            
            canvas.avisa("La pila esta llena.");
            throw new Exception("ERROR: La pila esta llena.");
        }
    }

    @Override
    public synchronized Object Desapila() throws Exception{

        if (!pilavacia()) {

            Object aux;
            Thread.sleep(200);
            aux = datos[cima];
            Thread.sleep(200);
            datos[cima--] = null;
            canvas.representa(datos, cima, numelementos);
            //notifyAll();
            return aux;
           
        } else {
            
            
            
            
            canvas.avisa("La pila esta vacia.");
            throw new Exception("ERROR: La pila esta vacia.");
            //return null;
            
        }
    }

    @Override
    public Object Primero() throws Exception {

        if (pilavacia()) {
            return null;
            //throw new Exception("ERROR: La pila esta vacia.");
        } else {
            return datos[cima];
        }

    }

    private boolean pilavacia() {
        return (numelementos == 0);
    }

    private boolean pilallena() {
        return (numelementos == capacidad);
    }
}
