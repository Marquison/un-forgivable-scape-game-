package objetos.quarto;

import classes_principais.Objeto;

public class PortaRetrato extends Objeto {

    public PortaRetrato() {
        super(
            "porta-retrato",
            "Um porta-retrato com a foto de uma mulher de pele opaca e branca, com uma feição feliz.",
            "Você vira o porta-retrato. Na parte de trás, arranhado na madeira, você vê os números: 1415.",
            false
        );
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