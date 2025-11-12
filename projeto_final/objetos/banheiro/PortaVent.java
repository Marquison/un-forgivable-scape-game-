package objetos.banheiro;

import classes_principais.Objeto;
import classes_principais.Quartos;

public class PortaVent extends Objeto {
    private Quartos quartoDestino;

    public PortaVent(Quartos quartoDestino) {
        super("ventilação", "Uma pequena abertura na parede.", "A ventilação leva para outro cômodo.", false);
        this.quartoDestino = quartoDestino;
    }

    @Override
    public void interagir() {
        System.out.println("Você se espreme pela pequena abertura da ventilação e desliza para o outro lado.");
        // Lógica para mudar de quarto precisaria ser implementada no loop do jogo
    }

    public Quartos getQuartoDestino() {
        return this.quartoDestino;
    }
}