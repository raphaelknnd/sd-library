import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaImpl extends UnicastRemoteObject implements Biblioteca {
    private List<Livro> livros;

    protected BibliotecaImpl () throws RemoteException {
        super();
        livros = new ArrayList<>();
        livros.add(new Livro(1, "Dom Quixote de La Mancha", "Miguel de Cervantes"));
        livros.add(new Livro(2, "Ensaio Sobre a Cegueira", "Fiodor Dostoievsky"));
        livros.add(new Livro(3, "A Divina Comedia", "Dante Alighieri"));
    }

    @Override
    public List<String> listaLivros() throws RemoteException {
        List<String> result = new ArrayList<>();
        for (Livro b : livros) {
            result.add(b.toString());
        }
        return result;
    }

    @Override
    public String buscaLivroPeloTitulo(String titulo) throws RemoteException {
        for (Livro b : livros) {
            if (b.getTitulo().equalsIgnoreCase(titulo)) {
                return b.toString();
            }
        }
        return "Livro não encontrado";
    }

    @Override
    public boolean emprestaLivro(int id) throws RemoteException {
        for (Livro b : livros) {
            if (b.getId() == id && b.estaDisponivel()) {
                b.setDisponivel(false);
                return true;
            }
        }
        return false;
    }
}
