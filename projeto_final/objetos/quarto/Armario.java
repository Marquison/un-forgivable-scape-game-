package objetos.quarto;

import classes_principais.Objeto;

public class Armario extends Objeto {
    public Armario() {
        super("armario", "Um grande armário pesado caido bloqueando a porta do quarto ", "tão sujo e desgastado quanto qualquer outra coisa nessa quarto", false);
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