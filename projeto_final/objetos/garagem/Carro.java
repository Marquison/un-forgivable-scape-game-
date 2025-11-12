package objetos.garagem;

import classes_principais.Inventario;
import classes_principais.Objeto;

public class Carro extends Objeto {
    private Inventario inventario;

    public Carro(Inventario inventario) {
        super("carro", "Um carro antigo coberto de poeira com o porta-malas escorrendo sangue. Os pneus estão murchos. O tanque parece vazio e a ignição não tem chave.", "O carro parece pronto para partir.", false);
        this.inventario = inventario;
    }

    @Override
    public void interagir() {
     boolean temGasolina = inventario.requisito("gasolina");
     boolean temChave = inventario.requisito("Chave C");

        if (temGasolina && temChave) {
            System.out.println("Com a gasolina e as chaves em mãos, você entra no carro.");
            System.out.println("O motor liga com um rugido, e você consegue sair desse inferno!");
            System.out.println("\nFIM DE JOGO: Você fugiu.");
    
            inventario.remvInventario("gasolina");
            inventario.remvInventario("Chave C");
    
            System.exit(0);
        } else if (!temGasolina && !temChave) {
            System.out.println(this.getDescricao());
        } else if (!temGasolina) {
            System.out.println("O carro ainda está sem gasolina.");
        } else {
            System.out.println("Você ainda não encontrou as Chave C.");
        }
    }
}