import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Biblioteca extends Remote {
    List<String> listaLivros() throws RemoteException;
    String buscaLivroPeloTitulo(String titulo) throws RemoteException;
    boolean emprestaLivro(int id) throws RemoteException;
}
