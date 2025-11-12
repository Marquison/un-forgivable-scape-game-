package objetos.quarto;

import classes_principais.Objeto;
import classes_principais.Quartos;

public class Quadro extends Objeto {

    private Quartos quartoAtual;
    private Cofre cofreEscondido;

    public Quadro(Quartos quarto, Cofre cofre) {
        super(
            "quadro",
            "Um quadro esquisito de uma criança sorrindo. Algo atrás dele parece estar amassando a tela.", 
            "O quadro está torto na parede, revelando um cofre atrás dele.",
            false
        );

        this.quartoAtual = quarto;
        this.cofreEscondido = cofre;
    }

    @Override
    public void interagir() {
        if (!interagiu) {
            System.out.println(this.getDescricao());
            System.out.println("Você move o quadro e revela um cofre na parede!");
            
            quartoAtual.addInteracoes(cofreEscondido);
            
            this.interagiu = true;
            this.setDescricao(this.getPosDescricao());

        } else {
            System.out.println(this.getDescricao());
        }
    }
}