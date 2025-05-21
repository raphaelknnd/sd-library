import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = (Biblioteca)Naming.lookup("rmi://localhost/LibraryService");
            System.out.println("*** Cliente conectado ao serviço da biblioteca ***");
            Scanner option = new Scanner(System.in);

            // Variavel de saida do laço
            boolean x = true;
            while(x){
                System.out.println("1. Listar livros\n2. Buscar livro pelo titulo\n3. Emprestar livro pelo ID\n0. Sair");
                System.out.println("Escolha uma opcao: ");
                int opcao = option.nextInt();
                option.nextLine();

                switch(opcao){
                    case 1:
                        biblioteca.listaLivros().forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Informe o titulo do livro: ");
                        String titulo = option.nextLine();
                        System.out.println(biblioteca.buscaLivroPeloTitulo(titulo));
                        break;
                    case 3:
                        System.out.print("Informe o ID do livro: ");
                        int id = option.nextInt();
                        biblioteca.emprestaLivro(id);
                        break;
                    case 0:
                        x = false;
                        break;
                    default:
                        System.out.println("Opcao inválida!");
                }
            }

        } catch (Exception e) {
            System.err.println("Exception no client: " + e.getMessage());
        }
    }
}
