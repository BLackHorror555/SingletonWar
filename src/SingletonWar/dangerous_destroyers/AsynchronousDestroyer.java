package SingletonWar.dangerous_destroyers;

import SingletonWar.harmfull_singletones.CleverSingleton;
import SingletonWar.harmfull_singletones.SillySingleton;

/**
 * Tries to cheat singleton by creating instances from different threads (may require several attempts).
 *
 */
public class AsynchronousDestroyer extends ISingletonDestroyer {
    private Thread t1;
    private Thread t2;

    @Override
    public boolean tryToDestroySillySingleton() {
        t1 = new Thread(() -> firstInstance = SillySingleton.getInstance());
        t2 = new Thread(() -> secondInstance = SillySingleton.getInstance());
        runThreadsAndJoin();

        return isInstancesHashesDifferent();
    }

    @Override
    public boolean tryToDestroyCleverSingleton() {
        t1 = new Thread(() -> firstInstance = CleverSingleton.getInstance());
        t2 = new Thread(() -> secondInstance = CleverSingleton.getInstance());
        runThreadsAndJoin();

        return isInstancesHashesDifferent();
    }

    @Override
    public boolean tryToDestroyGodlikeSingleton() {
        t1 = new Thread(() -> firstInstance = CleverSingleton.getInstance());
        t2 = new Thread(() -> secondInstance = CleverSingleton.getInstance());
        runThreadsAndJoin();

        return isInstancesHashesDifferent();
    }

    private void runThreadsAndJoin() {
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
