package classes_principais;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicInventario(Item item) {
        this.itens.add(item);
    }

    public void remvInventario(String nome) {
        Item remvItem = null;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                remvItem = item;
                break;
            }
        }
        if (remvItem != null) {
            this.itens.remove(remvItem);
        }
    }

    public boolean requisito(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public String listarItens() {
        if (itens.isEmpty()) {
            return "O inventário está vazio.";
        }
        StringBuilder lista = new StringBuilder("Inventário: ");
        for (Item item : itens) {
            lista.append(item.getNome()).append(", ");
        }
        return lista.toString();
    }
}