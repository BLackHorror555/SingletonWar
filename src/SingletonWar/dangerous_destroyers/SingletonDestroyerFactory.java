package SingletonWar.dangerous_destroyers;

public class SingletonDestroyerFactory {
    public static ISingletonDestroyer createSingletonDestroyer(DestroyerType destroyerType) {
        switch (destroyerType) {
            case Reflector:
                return new ReflectorDestroyer();

            case Asynchronous:
                return new AsynchronousDestroyer();

            default:
                throw new IllegalArgumentException("No such destroyer type!");
        }
    }
}
