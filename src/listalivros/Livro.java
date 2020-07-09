package listalivros;

public class Livro implements Comparable<Livro> {

    //atributos
    private String autor;
    private String titulo;
    private int ano;
    private float preco;

    //Construtores
    public Livro() {};


    
    public Livro(String autor, String titulo, int ano, float preco) {
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.preco = preco;

    }

    // metodo usado para fazer ordenação
    @Override
    public int compareTo(Livro livro) {
        return this.getAutor().compareToIgnoreCase(livro.getAutor());
    }

    // metodo de impressao
    public String imprimir() {
        String livro = "";
        livro += "autor :" + this.getAutor() + "\ntitulo :" + this.getTitulo()
                + "\nano lancamento :" + this.getAno()
                + String.format("\npreco : %.2f\n", this.getPreco());

        return livro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
