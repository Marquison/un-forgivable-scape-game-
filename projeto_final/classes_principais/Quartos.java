package classes_principais;

import java.util.ArrayList;
import java.util.List;

public class Quartos {
    private String nome;
    private String descricao;
    private List<Objeto> interacoes;
    private List<String> saidas;
    
    public List<Objeto> getInteracoes() {
        return this.interacoes;
    }
    
    public Quartos(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.interacoes = new ArrayList<>();
        this.saidas = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void addInteracoes(Objeto objeto){
        this.interacoes.add(objeto);
    }

    public void addSaida(String saidaAtual){
        this.saidas.add(saidaAtual);
    }

    public void removerObjeto(Objeto objeto){
        this.interacoes.remove(objeto);
    }


    public List<String> pegarEscolha(){
        List<String> escolhas = new ArrayList<>();

        for (Objeto objeto : interacoes) {
            escolhas.add("Interagir com  " + objeto.getNome());
        }

        for (String saida : saidas) {
            escolhas.add("Ir para " + saida);
        }

        return escolhas;
    }
}
