package objetos.garagem;

import classes_principais.Objeto;

public class Portao extends Objeto {
    private boolean estaAberto;

    public Portao() {
        super("portao", "Um portão de garagem grande e pesado. O motor ao lado parece controlar a abertura.", "O portão está aberto, a saída está livre.", false);
        this.estaAberto = false;
    }

    public void setAberto(boolean aberto) {
        this.estaAberto = aberto;
    }

    @Override
    public void interagir() {
        if (estaAberto) {
            System.out.println(this.getPosDescricao());
        } else {
            System.out.println(this.getDescricao());
        }
    }
}