package objetos.armazem;

import classes_principais.Objeto;

public class Batman extends Objeto{
    public Batman(){
        super("Boneco", "Costumava ser o meu personagem favorito...", "o muleque tinha bom gosto", false);
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