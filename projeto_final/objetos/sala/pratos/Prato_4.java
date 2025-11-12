package objetos.sala.pratos;

import classes_principais.Objeto;

public class Prato_4 extends Objeto {

    public Prato_4() {
        super("prato 4", "Um prato branco com o número 4 no fundo. Ele parece ter um encaixe circular.", "O número 4 continua visível.", false);
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