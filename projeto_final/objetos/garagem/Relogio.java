package objetos.garagem;

import classes_principais.Objeto;

public class Relogio extends Objeto{
    public Relogio(){
        super("Relogio", "Um relógio amarelo, parece estar quebrado", "os ponteiros são estranhos, o das horas é azul e aponta para o 3, e o dos minutos é vermelhor e aponta para o 5  ", false);
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