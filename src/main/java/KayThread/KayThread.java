package KayThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The KayThread class represents a thread that can be controlled by the user.
 * It provides methods to start, stop, and finish the thread, as well as an
 * interface to be implemented by the user to specify the code to be executed
 * by the thread...
 */
public class KayThread {
    private static AtomicInteger nextId = new AtomicInteger();

    private static HashMap<Integer, Thread> kayThreadHashMap = new HashMap<>();

    private static HashMap<Integer, Boolean> isFinishedHashMap = new HashMap<>();

    private static HashMap<Integer, KayThreadInterface> kayThreadInterfaceHashMap = new HashMap<>();

    public static HashMap<Integer, Thread> getKayThreadHashMap() {
        return kayThreadHashMap;
    }

    /**
     * Specifies the code to be executed by the thread.
     */
    public void kayRun() {

    }

    /**
     * Finishes the thread. This method should be called when the thread has
     * completed its execution.
     */
    public void kayFinish(Integer ID) {
        KayThreadInterface kayThreadInterface = kayThreadInterfaceHashMap.get(ID);
        kayThreadInterface.kayFinish(ID);
        kayThreadInterfaceHashMap.remove(ID);
        kayThreadHashMap.remove(ID);
        isFinishedHashMap.remove(ID);
    }
    /**
     * Stops the thread with the specified ID.
     *
     * @param id the ID of the thread to stop
     */
    public void kayStop(int id) {
        if(kayThreadInterfaceHashMap.containsKey(id)){
            kayThreadInterfaceHashMap.get(id).kayFinish(id);
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
        final int id = nextId.incrementAndGet();
        isFinishedHashMap.put(id, false);
        kayThreadInterfaceHashMap.put(id, kayThreadInterface);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                kayThreadInterfaceHashMap.get(id).kayRun();
                isFinishedHashMap.replace(id, true);
                kayFinish(id);
            }
        });
        thread.start();
        return id;
    }
}