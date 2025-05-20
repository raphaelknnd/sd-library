import java.io.Serializable;

public class Livro implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;

    // Class Constructor

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    // Getters and Setters

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public boolean estaDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "[" + getId() + "]" + getTitulo() + "por" + getAutor() + "(" + (estaDisponivel() ? "Disponivel" : "Emprestado") + ")";
    }
}
