package objetos.quarto;

import classes_principais.Inventario;
import classes_principais.Item;
import classes_principais.Objeto;

public class BancadaQuarto extends Objeto {
    private Item itemContido;
    private Inventario inventario;

    public BancadaQuarto(Inventario inventario, Item itemContido) {
        super("bancada quarto", "Uma bancada de madeira com um item sobre ela.", "A bancada agora está vazia.", true);
        this.inventario = inventario;
        this.itemContido = itemContido;
    }

    @Override
    public void interagir() {
        if (this.itemContido != null) {
            System.out.println(this.getDescricao());
            inventario.adicInventario(this.itemContido);
            System.out.println("Você pegou: " + this.itemContido.getNome());
            this.itemContido = null;
            this.setTemItem(false);
            this.setDescricao(this.getPosDescricao());
        } else {
            System.out.println(this.getPosDescricao());
        }
    }
}