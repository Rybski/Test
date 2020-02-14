package witan;

public class CreateNewThread implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    public void run() {
        while (keepRunning()) {
            System.out.println("NewThreadCreated");

        }

    }

}
