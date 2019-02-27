import SingletonWar.dangerous_destroyers.DestroyerType;
import SingletonWar.dangerous_destroyers.ISingletonDestroyer;
import SingletonWar.dangerous_destroyers.SingletonDestroyerFactory;

public class User {
    public static void main(String[] args) {
        ISingletonDestroyer reflectorDestroyer =
                SingletonDestroyerFactory.createSingletonDestroyer(DestroyerType.Reflector);
        System.out.println(reflectorDestroyer.tryToDestroyCleverSingleton());

        ISingletonDestroyer asynchDestroyes =
                SingletonDestroyerFactory.createSingletonDestroyer(DestroyerType.Asynchronous);
        System.out.println(asynchDestroyes.tryToDestroySillySingleton());

        // throws exception
        System.out.println(reflectorDestroyer.tryToDestroyGodlikeSingleton());
    }
}
