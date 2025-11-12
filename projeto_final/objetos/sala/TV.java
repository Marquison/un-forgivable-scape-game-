package objetos.sala;

import classes_principais.Objeto;

public class TV extends Objeto {

    public TV() {
        super("TV", "A TV está dando interferência e, tudo que se pode ver são ruídos na tela.", "A TV continua com interferência, mas agora parece que algo se move na tela.", false);
    }

    @Override
    public void interagir() {
        if (!interagiu) {
            System.out.println(this.getDescricao());
            this.interagiu = true;
        } else {
            System.out.println(this.getPosDescricao());
        }
    }
}