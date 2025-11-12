package objetos.cozinha;

import classes_principais.Inventario;
import classes_principais.Objeto;
import itens.ChavesArmazem;

public class Fogao extends Objeto {
    private Inventario inventario;
    private boolean estaAceso;

    // Construtor simplificado, precisa apenas do inventário
    public Fogao(Inventario inventario) {
        super("fogão", "Um fogão a gás, a chama parece fraca.", "O fogão está aceso, pronto para ser usado.", false);
        this.inventario = inventario; // <-- CORREÇÃO: Linha que estava faltando
        this.estaAceso = false;
    }

    @Override
    public void interagir() {
        if (!estaAceso) {
            // Se o fogão estiver apagado
            if (inventario.requisito("fosforo")) {
                this.estaAceso = true;
                System.out.println("Você usa um fósforo e acende a boca do fogão. A chama agora está forte.");
                this.setDescricao(this.getPosDescricao()); // Atualiza a descrição do fogão
            } else {
                System.out.println(getDescricao() + " Você precisa de algo para acendê-lo.");
            }
        } else {
            // Se o fogão já estiver aceso
            if (inventario.requisito("Cubo de Gelo")) {
                System.out.println("Você coloca o Cubo de Gelo sobre a chama. Ele derrete rapidamente, revelando uma chave!");
                inventario.remvInventario("Cubo de Gelo");
                inventario.adicInventario(new ChavesArmazem());
                System.out.println("Você pegou: Chave A");
            } else {
                System.out.println(getDescricao());
            }
        }
    }
}