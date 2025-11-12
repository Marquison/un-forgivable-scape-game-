package objetos.sala.pratos;

import classes_principais.Objeto;

public class Prato_1 extends Objeto {

    public Prato_1() {
        super("prato 1", "Um prato branco com o número 1 no fundo. Ele parece ter um encaixe circular.", "O número 1 continua visível.", false);
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