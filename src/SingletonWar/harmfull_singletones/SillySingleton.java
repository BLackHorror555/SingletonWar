package SingletonWar.harmfull_singletones;

/**
 * He will not survive.
 *
 * <p>
 * He's too lazy to fight!
 * </p>
 */
public class SillySingleton {
    private static SillySingleton sInstance;

    private SillySingleton() {}

    public static SillySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new SillySingleton();
        }
        return sInstance;
    }
}
