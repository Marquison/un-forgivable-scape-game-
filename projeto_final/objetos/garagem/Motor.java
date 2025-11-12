package objetos.garagem;

import classes_principais.Inventario;
import classes_principais.Objeto;

public class Motor extends Objeto {
    private Inventario inventario;
    private Portao portao;
    private boolean consertado;
    
    public Motor(Inventario inventario, Portao portao) {
        super("motor", "Um motor grande com um sistema de engrenagens travado. Parece precisar de óleo.", "O motor está funcionando perfeitamente.", false);
        this.inventario = inventario;
        this.portao = portao;
        this.consertado = false;
    }

    @Override
    public void interagir() {
        if (!consertado) {
            if (inventario.requisito("óleo")) {
                System.out.println("Você usa o óleo nas engrenagens. O motor reage com um clique e começa a funcionar! O portão da garagem se abre.");
                inventario.remvInventario("óleo");
                this.consertado = true;
                this.portao.setAberto(true);
            } else {
                System.out.println(this.getDescricao());
            }
        } else {
            System.out.println(this.getPosDescricao());
        }
    }
}