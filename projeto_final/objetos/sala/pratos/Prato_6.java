package objetos.sala.pratos;

import classes_principais.Objeto;

public class Prato_6 extends Objeto {

    public Prato_6() {
        super("prato 6", "Um prato branco com o número 6 no fundo. Ele parece ter um encaixe circular.", "O número 6 continua visível.", false);
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