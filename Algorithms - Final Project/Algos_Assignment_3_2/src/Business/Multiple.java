/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Mugdha
 */
public class Multiple implements Runnable {

    static Thread t1 = new Thread() {
        public synchronized void run() {
            try {
                for (;;) {
                    System.out.println("java");
                    t1.sleep(300);
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
    };
    static Thread t2 = new Thread() {
        public synchronized void run() {
            try {
                for (;;) {
                    System.out.println("world");
                    t2.sleep(300);
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
    };

    @Override
    public void run() {
        System.out.println("running");
    }
}
