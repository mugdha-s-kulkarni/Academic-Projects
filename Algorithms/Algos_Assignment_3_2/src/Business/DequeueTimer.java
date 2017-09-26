package Business;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Mugdha
 */
public class DequeueTimer extends TimerTask {

    int time;
    Queue servletQueue;
    ArrayList<HttpRequest> requestList;
    Timer timer;
    int lower;
    int upper;
    int random;

    public DequeueTimer(Timer timer, int t, Queue q, ArrayList a, int l, int u) {

        this.servletQueue = q;
        this.time = t;
        this.requestList = a;
        this.timer = timer;
        this.lower = l;
        this.upper = u;

    }

    @Override
    public void run() {

        HttpRequest req;
        random = lower + (int) (Math.random() * upper);

        if (time > 0) {

            if ((time - random) > 0) {
                try {
                    long total = random * 1000;
                    Thread.sleep(total);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                req = servletQueue.dequeue();

                req.setWaitingTime(req.getDequeueTime() - req.getEnqueueTime());
                requestList.add(req);

                System.out.println("Dequeuing-->" + req);
                System.out.println("ServletQueue-->");
                servletQueue.display();
                System.out.println("\n");
                time = time - random;
            }
        } else {
            timer.cancel();
            timer.purge();
        }
    }

}
