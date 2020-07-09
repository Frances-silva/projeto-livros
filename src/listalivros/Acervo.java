package listalivros;

import java.util.ArrayList;

public class Acervo {

    private static ArrayList<Livro> listaLivro = new ArrayList<>();

    // adicionar livro
    public static void inserir(Livro x) {
        listaLivro.add(x);
    }

    // lista todos os livros
    public static String listar() {
        String saida = "";
        
        for (Livro x : listaLivro) {
            
            saida += x.imprimir() + "\n";
        }

        return saida;
    }

    // REMOVER PELO TITUlO
    public static boolean remover(String titulo) {
        for (Livro x : listaLivro) {
            if (x.getTitulo().equalsIgnoreCase(titulo)) {
                listaLivro.remove(x);
                return true;
            }

        }
        System.out.println("nao foi encontrado para remover\n");
        return false;

    }

    // metodo GET
    public static ArrayList<Livro> getListaLivro() {
        return listaLivro;
    }

}
