package objetos.sala;

import classes_principais.Objeto;

public class Sofa extends Objeto {

    public Sofa() {
        super("sofá", "Um sofá de couro gasto, parece confortável.", "Não há mais nada de interessante no sofá.", false);
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