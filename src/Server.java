import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            BibliotecaImpl biblioteca = new BibliotecaImpl();
            Naming.rebind("LibraryService", biblioteca);
            System.out.println("*** Servidor pronto ***");
        } catch (Exception e) {
            System.err.println("Exception no server: " + e.getMessage());
        }
    }
}