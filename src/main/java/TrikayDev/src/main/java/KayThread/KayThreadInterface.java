package KayThread;
/**
 * The KayThreadInterface interface should be implemented by any class that
 * wants to create a KayThread. It contains two methods: kayRun() and
 * kayFinish(). The kayRun() method specifies the code to be executed by the
 * thread, while the kayFinish() method is called when the thread has finished
 * executing.
 */
public interface KayThreadInterface {
    /**
     * Specifies the code to be executed by the thread.
     */
    public void kayRun();
    /**
     * Called when the thread has finished executing.
     *
     * @param id the ID of the thread
     */
    public void kayFinish(int id);
}