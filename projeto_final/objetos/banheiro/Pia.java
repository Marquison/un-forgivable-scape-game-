package objetos.banheiro;

import classes_principais.Objeto;

public class Pia extends Objeto {
    public Pia(){
        super("Pia", "Há uma mancha de sangue seco na pia. A água goteja lentamente, formando pequenas poças avermelhadas.", "A água continua gotejando. A mancha de sangue não parece mais tão intimidadora.", false);
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