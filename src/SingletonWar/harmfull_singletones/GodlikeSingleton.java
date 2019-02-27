package SingletonWar.harmfull_singletones;

/**
 * It is perfect.
 * <p>
 * Is there a better one? Don't think.
 * </p>

 */
public class GodlikeSingleton {
    // volatile instance guarantee happens-before relationship
    private static volatile GodlikeSingleton sInstance;

    private GodlikeSingleton() {
        // prevent singleton from reflection API
        if (sInstance != null) {
            throw new IllegalStateException("Oh no, singleton instance already created! Use getInstance() method to get the god instance.");
        }
    }

    public static GodlikeSingleton getInstance() {
        //Thanks to at first glance not necessary {@code resultInstance} the volatile field accessed only once
        //in cases when instance already initialized that leads to better performance.
        GodlikeSingleton resultInstance = sInstance;
        if (resultInstance == null) {
            synchronized (GodlikeSingleton.class) {
                resultInstance = sInstance;
                if (resultInstance == null) {
                    sInstance = resultInstance = new GodlikeSingleton();
                }
            }
        }
        return resultInstance;
    }
}
