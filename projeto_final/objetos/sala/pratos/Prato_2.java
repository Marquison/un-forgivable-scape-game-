package objetos.sala.pratos;

import classes_principais.Objeto;

public class Prato_2 extends Objeto {

    public Prato_2() {
        super("prato 2", "Um prato branco com o número 2 no fundo. Ele parece ter um encaixe circular.", "O número 2 continua visível.", false);
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