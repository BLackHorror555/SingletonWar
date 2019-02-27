package SingletonWar.dangerous_destroyers;

import SingletonWar.harmfull_singletones.CleverSingleton;
import SingletonWar.harmfull_singletones.GodlikeSingleton;
import SingletonWar.harmfull_singletones.SillySingleton;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.Constructor;

/**
 * Use Java Reflection API to create two instances of singleton.
 */
public class ReflectorDestroyer extends ISingletonDestroyer {

    @Override
    public boolean tryToDestroySillySingleton() {
        firstInstance = SillySingleton.getInstance();
        secondInstance = tryToMakeInstance(SillySingleton.class);
        return isInstancesHashesDifferent();
    }

    @Override
    public boolean tryToDestroyCleverSingleton() {
        firstInstance = CleverSingleton.getInstance();
        secondInstance = tryToMakeInstance(CleverSingleton.class);
        return isInstancesHashesDifferent();
    }

    @Override
    public boolean tryToDestroyGodlikeSingleton() {
        firstInstance = GodlikeSingleton.getInstance();
        secondInstance = tryToMakeInstance(GodlikeSingleton.class);
        return isInstancesHashesDifferent();
    }

    private Object tryToGetInstance(Class <?> classObj) throws Exception {
        Constructor<?> constructor = classObj.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    @Nullable
    private Object tryToMakeInstance(Class<?> singleton) {
        try {
            return tryToGetInstance(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
