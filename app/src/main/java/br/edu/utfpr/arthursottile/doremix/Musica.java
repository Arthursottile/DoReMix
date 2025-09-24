package br.edu.utfpr.arthursottile.doremix;


public class Musica {
    private String titulo;
    private String autor;
    private String tom;
    private int duracao; // em segundos


    public Musica(String titulo, String autor, String tom, int duracao) {
        this.titulo = titulo;
        this.autor = autor;
        this.tom = tom;
        this.duracao = duracao;
    }


    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getTom() { return tom; }
    public int getDuracao() { return duracao; }
}