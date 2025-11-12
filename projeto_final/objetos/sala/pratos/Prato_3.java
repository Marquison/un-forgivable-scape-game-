package objetos.sala.pratos;

import classes_principais.Inventario;
import classes_principais.Item;
import classes_principais.Objeto;
import itens.BolaAzul;

public class Prato_3 extends Objeto {

    private Item itemNoPrato = null;
    private Inventario inventario;

    public Prato_3(Inventario inventario) {
        super("prato 3", "Um prato branco com o número 3 no fundo. Ele parece ter um encaixe circular.", "O número 3 continua visível.", false);
        this.inventario = inventario;
    }

    @Override
    public void interagir() {
        if (itemNoPrato != null) {
            System.out.println("A Bola de Gude Azul já está neste prato.");
            return;
        }

        if (inventario.requisito("Bola de Gude Azul")) {
            this.itemNoPrato = new BolaAzul();
            inventario.remvInventario("Bola de Gude Azul");
            this.setDescricao("Agora há uma Bola de Gude Azul sobre este prato.");
            System.out.println("Você coloca a Bola de Gude Azul sobre o prato. Ela se encaixa perfeitamente.");
        } else {
            System.out.println(this.getDescricao());
        }
    }

    public Item getItemNoPrato() {
        return this.itemNoPrato;
    }
}