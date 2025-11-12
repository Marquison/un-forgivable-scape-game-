package classes_principais;

public abstract class Objeto {
    private String nome;
    private String descricao;
    private String pos_descricao;
    private boolean temItem;
    protected boolean interagiu;

    public Objeto(String nome, String descricao, String pos_descricao, boolean temItem) {
        this.nome = nome;
        this.descricao = descricao;
        this.pos_descricao = pos_descricao;
        this.temItem = temItem;
        this.interagiu = false;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getPosDescricao() { return pos_descricao; }
    public boolean getTemItem() { return temItem; }
    public void setDescricao(String novaDescricao) { this.descricao = novaDescricao; }

    public abstract void interagir();

    public void setTemItem(boolean temItem) {
    this.temItem = temItem;
    }
}