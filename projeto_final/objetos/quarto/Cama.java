package objetos.quarto;

import classes_principais.Objeto;

public class Cama extends Objeto {
    public Cama() {
        super("cama", "Uma cama desfeita, com sangue espalhado no lençol.", "O sangue continua na cama.", false);
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