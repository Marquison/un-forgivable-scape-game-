package objetos.quarto;

import java.util.Scanner;
import classes_principais.Inventario;
import classes_principais.Objeto;
import itens.ChaveBancada;

public class Cofre extends Objeto {
    private boolean trancado;
    private Inventario inventario;
    private Scanner leitor;
    private final String SENHA_CORRETA = "1415";

    public Cofre(Inventario inventario, Scanner leitor) {
        super("cofre", "Um cofre pequeno, parece precisar de uma senha numérica.", "O cofre está aberto e vazio.", true);
        this.inventario = inventario;
        this.leitor = leitor;
        this.trancado = true;
    }

    @Override
    public void interagir() {
        if (trancado) {
            System.out.print("Digite a senha de 4 dígitos: ");
            
            String senhaDigitada = this.leitor.nextLine();
            
            if (senhaDigitada.equals(SENHA_CORRETA)) {
                System.out.println("CLIQUE! O cofre destrancou.");
                this.trancado = false;
            } else {
                System.out.println("Senha incorreta.");
            }
        } else if (getTemItem()) {
            System.out.println("O cofre está aberto. Dentro você encontra uma chave.");
            inventario.adicInventario(new ChaveBancada());
            setTemItem(false);
        } else {
            System.out.println(this.getPosDescricao());
        }
    }
}