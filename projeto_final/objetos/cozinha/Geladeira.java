package objetos.cozinha;

import classes_principais.Inventario;
import classes_principais.Objeto;

import itens.BolaVermelha;
import itens.BolaAzul;
import itens.CuboDeGelo;

public class Geladeira extends Objeto {
    private Inventario inventario;

    public Geladeira(Inventario inventario) {
        super("geladeira", "Uma geladeira velha e enferrujada.", "A geladeira agora está vazia.", true);
        this.inventario = inventario;
    }

    @Override
    public void interagir() {
        if (this.getTemItem()) {
            System.out.println(this.getDescricao());
            System.out.println("Você pegou os itens da geladeira: um olho falso, uma bolinha de gude azul e um cubo de gelo com algo dentro.");

            inventario.adicInventario(new BolaVermelha());
            inventario.adicInventario(new BolaAzul());
            inventario.adicInventario(new CuboDeGelo());

            this.setTemItem(false);
            this.setDescricao(this.getPosDescricao());
        } else {
            System.out.println(this.getPosDescricao());
        }
    }
}