package KayThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The KayThread class represents a thread that can be controlled by the user.
 * It provides methods to start, stop, and finish the thread, as well as an
 * interface to be implemented by the user to specify the code to be executed
 * by the thread..
 */
public class KayThread {
    private static AtomicInteger nextId = new AtomicInteger();

    private static HashMap<Integer, KayThread> kayThreadHashMap = new HashMap<>();
    private int id;
    private boolean isRunning = true;
    private boolean isFinished = false;
    private KayThreadInterface kayThreadInterface;

    /**
     * Specifies the code to be executed by the thread.
     */
    public void kayRun() {

    }

    /**
     * Finishes the thread. This method should be called when the thread has
     * completed its execution.
     */
    public void kayFinish() {
        kayThreadInterface.kayFinish(id);
        kayThreadHashMap.remove(id);
    }
    /**
     * Stops the thread.
     */
    public void kayStop() {
        isRunning = false;
    }
    /**
     * Stops the thread with the specified ID.
     *
     * @param id the ID of the thread to stop
     */
    public void kayStop(int id) {
        if (this.id == id) {
            isRunning = false;
        }
    }
    /**
     * Starts the thread. The thread will execute the code specified by the
     * KayThreadInterface provided as an argument.
     *
     * @param kayThreadInterface the interface containing the code to be executed
     *                           by the thread
     * @return the ID of the thread
     */
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
        kayThreadHashMap.put(id, this);
        thread.start();
        return id;
    }

    /**
     * Synchronizes the threads with the specified IDs.
     *
     * @param threadIds the IDs of the threads to synchronize
     */
    public static void synchronizeThreads(ArrayList<Integer> threadIds) {
        // Create a list of locks for each thread
        ArrayList<Object> locks = new ArrayList<>();
        for (int id : threadIds) {
            locks.add(new Object());
        }

        // Set the current lock index to 0
        AtomicInteger lockIndex = new AtomicInteger(0);

        // Iterate through the thread IDs and synchronize them
//        for (int id : threadIds) {
//            final int currentLockIndex = lockIndex.getAndIncrement();
//            KayThread kayThread = KayThread.getThreadById(id);
//            kayThread.kayThreadInterface = new KayThreadInterface() {
//                @Override
//                public void kayRun() {
//                    synchronized (locks.get(currentLockIndex)) {
//                        kayThread.kayThreadInterface.kayRun();
//                    }
//                }
//
//                @Override
//                public void kayFinish(int id) {
//                    synchronized (locks.get(currentLockIndex)) {
//                        kayThread.kayThreadInterface.kayFinish(id);
//                    }
//                }
//            };
//        }
    }

}