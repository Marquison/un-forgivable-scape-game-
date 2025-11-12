package objetos.armazem;

import classes_principais.Objeto;

public class Carrinho extends Objeto{
    public Carrinho(){
        super("carrinho", "um carrinho vermelho, acho que estou muito velho para essas coisas", "deixa pra lá", false);
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