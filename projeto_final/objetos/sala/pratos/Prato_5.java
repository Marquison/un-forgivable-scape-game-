package objetos.sala.pratos; 

import classes_principais.Inventario;
import classes_principais.Item;
import classes_principais.Objeto;
import itens.BolaVermelha;

public class Prato_5 extends Objeto {

    private Item itemNoPrato = null;
    private Inventario inventario;

    public Prato_5(Inventario inventario) {
        super("prato 5", "Um prato branco com o número 5 no fundo. Ele parece ter um encaixe circular.", "O número 5 continua visível.", false);
        this.inventario = inventario;
    }

    @Override
    public void interagir() {
        if (itemNoPrato != null) {
            System.out.println("A Prótese de Olho já está neste prato.");
            return;
        }

        if (inventario.requisito("Prótese de Olho")) {
            this.itemNoPrato = new BolaVermelha();
            inventario.remvInventario("Prótese de Olho");
            this.setDescricao("Agora há uma Prótese de Olho sobre este prato.");
            System.out.println("Você coloca a Prótese de Olho sobre o prato. Ela se encaixa perfeitamente.");
        } else {
            System.out.println("Você examina o prato, mas não encontra nada de interessante.");
        }
    }

    public Item getItemNoPrato() {
        return this.itemNoPrato;
    }
}