package objetos.banheiro;

import classes_principais.Objeto;

public class Vaso extends Objeto{
    public Vaso(){
        super("vaso", "você aperta a descarga", "vruuuuuuuuu...", false);
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