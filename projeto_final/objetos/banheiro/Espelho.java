package objetos.banheiro;

import classes_principais.Objeto;
import classes_principais.Quartos;

public class Espelho extends Objeto {
    private Quartos banheiro;
    private PortaVent portaVentilacao;

    public Espelho(Quartos banheiro, PortaVent portaVentilacao) {
        super("espelho", "Um espelho sujo, ele mostra seu reflexo.", "O espelho caiu e revelou a entrada da ventilação.", false);
        this.banheiro = banheiro;
        this.portaVentilacao = portaVentilacao;
    }

    @Override
    public void interagir() {
        if (!interagiu) {
            System.out.println(this.getDescricao());
            this.interagiu = true;
        } else {
            this.banheiro.addSaida("Quarto (ventilação)");
            this.banheiro.addInteracoes(this.portaVentilacao);
            this.banheiro.removerObjeto(this);
            System.out.println(this.getPosDescricao());
        }
    }
}