package KayThread1;

import java.util.concurrent.atomic.AtomicInteger;

public class KayThread {
    private static AtomicInteger nextId = new AtomicInteger();
    private int id;
    private boolean isRunning = true;
    private boolean isFinished = false;
    private KayThreadInterface kayThreadInterface;

    public void kayRun() {

    }

    public void kayFinish() {
        kayThreadInterface.kayFinish(id);
    }

    public void kayStop() {
        isRunning = false;
    }

    public void kayStop(int id) {
        if (this.id == id) {
            isRunning = false;
        }
    }

    public int start(KayThreadInterface kayThreadInterface) {
        this.kayThreadInterface = kayThreadInterface;
        id = nextId.incrementAndGet();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                kayThreadInterface.kayRun();
                isFinished = true;
                kayFinish();
            }
        });
        thread.start();
        return id;
    }
}