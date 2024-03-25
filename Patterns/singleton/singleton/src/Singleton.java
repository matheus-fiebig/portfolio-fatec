public class Singleton {
    private static Singleton _instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return _instance == null ? new Singleton() : _instance;
    }
}
