

package listalivros;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class ListaLivros {

    public static void main(String[] args) {
        
        // chamando o metodo menu
        menu();

    }// fim do metodo principal

    // funcao static
    public static void menu() {

        Scanner n = new Scanner(System.in);
        Scanner nomes = new Scanner(System.in);
        Livro livrinho; // instancia da classe Livro

        int opcao;

        do {
            System.out.println("------------ACERVO DE LIVROS-------------\n");
            System.out.println("1 - para inserir novo livro :");
            System.out.println("2 - listar livros :");
            System.out.println("3 - remover livro pelo titulo :");
            System.out.println("4 - ordenar por autor :");
            System.out.println("5 - ordenar por preco :");
            System.out.println("0 - sair");

            System.out.println("Escolha uma opcao :");
            opcao = n.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("-------CADASTRAR LIVROS-----------\n");

                    System.out.println("Digite  o nome do autor :");
                    String nome = nomes.nextLine();
                    System.out.println("Nome do titulo :");
                    String titulo = nomes.nextLine();
                    System.out.println("Digite o ano de lancamento :");
                    int ano = n.nextInt();
                    System.out.println("Digite o preco do livro :");
                    float preco = n.nextFloat();
                    // jogando para o construtor
                    livrinho = new Livro(nome, titulo, ano, preco);
                    //adicionando o construtor dentro da lista
                    Acervo.inserir(livrinho);// metodo static
                    break;

                case 2:
                    System.out.println("--------LIVROS DENTRO DO ACERVO----\n");

                    System.out.println(Acervo.listar());
                    break;

                case 3:
                    System.out.println("--------LIVROS REMOVIDOS-----------\n");

                    System.out.println("Digite o titulo para ser removido :");
                    String t = nomes.nextLine();

                    if (!Acervo.getListaLivro().isEmpty())// se a minha lista nao esta vazia
                    {
                        if (Acervo.remover(t)) {
                            System.out.println("Livro removido com sucesso");

                        } else {
                            System.out.println("Livro nao exite no acervo\n");
                        }

                    } else {
                        System.out.println("Seu acervo de livros esta vazio\n");
                    }

                    break;

                case 4:
                    System.out.println("------LISTA ORDENADA POR AUTOR-----\n");

                    Collections.sort(Acervo.getListaLivro());// lista para ordenação
                    for (Livro l : Acervo.getListaLivro()) {
                        System.out.println(l.imprimir());
                    }
                    break;

                case 5:
                    System.out.println("--------LISTA ORDENADA POR PRECO-----\n");

                    Collections.sort(Acervo.getListaLivro(), new OrdenarPreco());
                    for (Livro x : Acervo.getListaLivro()) {
                        System.out.println(x.imprimir());
                    }
                    break;

                case 0:
                    System.out.println("Obrigado pela visita...SAIR");
                    break;

                default:
                    System.out.println("Opcao invalida!!!");

            }

        } while (opcao != 0);

    }

    // classe para realizar a ordenacao por preco
    static class OrdenarPreco implements Comparator<Livro> {

        @Override
        public int compare(Livro x , Livro y) {
            if (x.getPreco() > y.getPreco()) {
                return 1;

            } else if (x.getPreco() < y.getPreco()) {
                return -1;

            } else {

                return 0;
            }
        }

    }

}
