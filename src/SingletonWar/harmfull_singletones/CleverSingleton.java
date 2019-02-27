package SingletonWar.harmfull_singletones;

/**
 * Protects itself from dangerous multithreading!
 */
public class CleverSingleton {
    private static CleverSingleton sInstance;

    private CleverSingleton() {}

    public static CleverSingleton getInstance() {
        // check twice to prevent synchronization overhead (double check locking pattern)
        if (sInstance == null) {
            synchronized (CleverSingleton.class) {
                // second check
                if (sInstance == null) {
                    sInstance = new CleverSingleton();
                }
            }
        }
        return sInstance;
    }
}
