package practica1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Alex
 */
public class CanvasCola extends Canvas {

    private int cima;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private String mensaje;

    public CanvasCola(int capacidad) {
        this.capacidad = capacidad;
        setSize(new Dimension(400, 200));
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();

        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);

        og.setFont(f1);

        og.setColor(Color.BLUE);

        int xi = 150;
        int xf = 250;
        int yi = 5;
        int yf = 5;

        og.drawLine(150, 5, 150, 185); //vertical izquierda
        og.drawLine(250, 5, 250, 185); //vertical derecha
        int next = 0;
        for (int i = 0; i <= capacidad; i++) {
            og.drawLine(xi, yi + next, xf, yf + next); // horizontal
            next = next + 18;
        }

        int mostrarx = 150;
        int mostrary = 22;
        int next2 = 0;

        og.setColor(Color.PINK);
        for (int i = 0; i < 10; i++) {
            if(datos[i]!=null)
            {   
                og.drawString("Valor : " + datos[i], mostrarx, mostrary + next2);
                next2 = next2 + 18;
            }
        }

        g.drawImage(offscreen, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void avisa(String mensaje) {
       repaint();
    }

    public void representa(Object[] datos, int cima, int numele) {
        this.datos = datos;
        this.cima = cima;
        numelementos = numele;
        repaint();
    }
}
