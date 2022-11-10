package threads2;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class graphs extends JComponent implements Runnable {
    Thread random;
    double d1ventas, rangoDep2, d2ventas, rangoDep3, d3ventas, rangoDep4, d4ventas;
    double d1v,d2v,d3v,d4v;
    public graphs(){
        random = new Thread(this);
        random.start();
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Ventas de 4 departamentos (gráfica de pastel)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(240, 235, 227));
        frame.setSize(300, 300);

        graphs pie = new graphs();
        frame.add(pie);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        while(true){
            //valores de ventas aleatorias en un rango de 100 a 1500
            d1v = (100+(Math.random()*((1500-100)+1)));
            d2v = (100+(Math.random()*((1500-100)+1)));
            d3v = (100+(Math.random()*((1500-100)+1)));
            d4v = (100+(Math.random()*((1500-100)+1)));
            double sumtot = (d1v+d2v+d3v+d4v);
            
                d1ventas=(d1v*360)/sumtot;
            
                d2ventas=(d2v*360)/sumtot;
            
                d3ventas=(d3v*360)/sumtot;
            
                d4ventas=(d4v*360)/sumtot;
            
            rangoDep2 = (0 + d1ventas);
            rangoDep3 = (rangoDep2 + d2ventas);
            rangoDep4 = (rangoDep3 + d3ventas);
            repaint();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Arc2D.Double arc = new Arc2D.Double(Arc2D.PIE);
        arc.setFrame(getWidth()/4,getHeight()/4,150,150);

        arc.setAngleStart(0);
        arc.setAngleExtent(d1ventas);
        g2.setColor(new Color(0, 110, 127));
        g2.draw(arc);
        g2.fill(arc);

        arc.setAngleStart(rangoDep2);
        arc.setAngleExtent(d2ventas);
        g2.setColor(new Color(248, 203, 46));
        g2.draw(arc);
        g2.fill(arc);

        arc.setAngleStart(rangoDep3);
        arc.setAngleExtent(d3ventas);
        g2.setColor(new Color(238, 80, 7));
        g2.draw(arc);
        g2.fill(arc);

        arc.setAngleStart(rangoDep4);
        arc.setAngleExtent(d4ventas);
        g2.setColor(new Color(178, 39, 39));
        g2.draw(arc);
        g2.fill(arc);
    }
}
