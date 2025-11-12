package objetos.cozinha;

import classes_principais.Inventario;
import classes_principais.Item;
import classes_principais.Objeto;
import itens.Oleo;

public class BancadaCozinha extends Objeto {
    private Inventario inventario;
    private boolean trancado;

    public BancadaCozinha(Inventario inventario, Item itemContido) {
        super("bancada cozinha", "Uma bancada de cozinha com uma gaveta trancada.", "A gaveta agora está aberta e vazia.", true);
        this.inventario = inventario;
        this.trancado = true;
    }

    @Override
    public void interagir() {
        if (trancado) {
            if (inventario.requisito("Chave B")) {
                System.out.println("CLIQUE! A bancada da cozinha destrancou.");
                this.trancado = false;
            }
            else {
                System.out.println("Você precisa encontrar a chave primeiro");
            }
        } else if (getTemItem()) {
            System.out.println("dentro voce encontra um pouco de óleo");
            inventario.adicInventario(new Oleo());
            setTemItem(false);
        } else {
            System.out.println(this.getPosDescricao());
        }
    }
}