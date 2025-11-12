package objetos.armazem;
import classes_principais.*;

public class Prateleira extends Objeto {
    private Inventario inventario;
    private Item itemContido;

    public Prateleira(String nome, String desc, String pos_desc, Inventario inv, Item item) {
        super(nome, desc, pos_desc, true);
        this.inventario = inv;
        this.itemContido = item;
    }

    @Override
    public void interagir() {
        if (getTemItem()) {
            System.out.println(getDescricao());
            inventario.adicInventario(itemContido);
            System.out.println("Você pegou: " + itemContido.getNome());
            setTemItem(false);
        } else {
            System.out.println(getPosDescricao());
        }
    }
}