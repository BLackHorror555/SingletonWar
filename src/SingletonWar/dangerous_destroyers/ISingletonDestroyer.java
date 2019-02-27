package SingletonWar.dangerous_destroyers;

public abstract class ISingletonDestroyer {
    Object firstInstance;
    Object secondInstance;

    /**
     * Try to cheat silly singleton.
     *
     * @return is cheating successful.
     */
    public abstract boolean tryToDestroySillySingleton();

    /**
     * Tries to cheat clever singleton.
     *
     * @return is cheating successful.
     */
    public abstract boolean tryToDestroyCleverSingleton();

    /**
     * Tries to cheat godlike singleton (no chances).
     *
     * @return is cheating successful.
     */
    public abstract boolean tryToDestroyGodlikeSingleton();

    boolean isInstancesHashesDifferent() {
        if (firstInstance != null && secondInstance != null) {
            return firstInstance.hashCode() != secondInstance.hashCode();
        }
        return false;
    }

}
