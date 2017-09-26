/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mugdha
 */
public class EnqueueTimer extends TimerTask {

    int time;
    Queue servletQueue;
    int random;
    Timer timer;
    int totalReq;
   // Timer timer1;
    public EnqueueTimer(Timer t, int time, Queue q,int tr ) {

        this.time = time;
        this.servletQueue = q;
        this.timer = t;
       // this.timer1 = t1;
        this.totalReq = tr;
    }

    @Override
    public void run() {

        if (time > 0) {
            random = 1 + (int) (Math.random() * 3);

            for (int j = 1; j <= random; j++) {

                HttpRequest req = new HttpRequest();
                servletQueue.enqueue(req);
                System.out.println("Enqueuing--> " + req);
                System.out.println("ServletQueue-->");
                servletQueue.display();
                System.out.println("\n");

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            time--;
            totalReq = totalReq+random;
        } else {

            timer.cancel();
            timer.purge();


        }

    }

}
