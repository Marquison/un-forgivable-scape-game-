package objetos.sala.cadeiras;

import classes_principais.Objeto;
import objetos.sala.pratos.Prato_3;
import objetos.sala.pratos.Prato_5;
import itens.BolaAzul;
import itens.BolaVermelha;

public class CadeiraVermelha extends Objeto {

    private Prato_3 prato3;
    private Prato_5 prato5;

    public CadeiraVermelha(Prato_3 prato3, Prato_5 prato5) {
        super("cadeira vermelha", "Uma cadeira de jantar vermelha, solitária e imponente.", "Ela parece ter alguma conexão com os pratos...", false);
        this.prato3 = prato3;
        this.prato5 = prato5;
    }

    @Override
    public void interagir() {
        if (prato3.getItemNoPrato() instanceof BolaAzul && prato5.getItemNoPrato() instanceof BolaVermelha) {
            System.out.println("Ao interagir com a cadeira, os pratos com as bolas azul e vermelha brilham intensamente.");
            System.out.println("A cadeira estremece e se move para o lado como em uma explosão de ventos cortantes e poderosos");
            System.out.println("você não entende como pode existir tanta circulação de ar em um local fechado, mas de repente...");
            System.out.println("você escuta um choro vindo do armazem, ao tentar se aproximar parece de subito uma mulher pálida escondendo o rosto");
            System.out.println("");
            System.out.println("Mulher Misteriosa: tudo isso é culpa sua, consegue ouvir o choro de minha criança?!");
            System.out.println("VOCÊ VEM COMIGO!");
            System.out.println("");
            System.out.println("\nFIM DE JOGO - VOCÊ ENCONTROU O FINAL SECRETO!");
            System.exit(0);
        } else {
            System.out.println(getDescricao());
            System.out.println("Ela parece ter alguma conexão com os pratos na mesa, mas algo ainda não está certo.");
        }
    }
}