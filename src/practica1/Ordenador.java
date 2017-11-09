package practica1;

public class Ordenador {

    private int elturno, participantes;

    public Ordenador(int _elturno, int _participantes) {
        elturno = _elturno;
        participantes=_participantes;
    }

    public synchronized void cogeturno(int id) {
        while (elturno != id) {
            try {
                wait();
                System.out.println("El hilo "+id+" chequea condicion");
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public synchronized void termina(int id) {
        elturno = (id + 1) % participantes;
        //notify();
        notifyAll();
    }
}