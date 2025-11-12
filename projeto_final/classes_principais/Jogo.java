package classes_principais;

// Importações de todas as classes do projeto
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

import itens.*;
import objetos.quarto.*;
import objetos.sala.*;
import objetos.sala.cadeiras.*;
import objetos.sala.pratos.*;
import objetos.cozinha.*;
import objetos.banheiro.*;
import objetos.garagem.*;
import objetos.armazem.*;

public class Jogo {

    private static Quartos localizacaoAtual;
    private static Inventario inventario = new Inventario();
    private static Scanner leitor = new Scanner(System.in);
    private static Map<String, Quartos> quartos = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosSala = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosMesa = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosQuarto = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosCozinha = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosBanheiro = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosGaragem = new LinkedHashMap<>();
    private static Map<String, Objeto> objetosArmazem = new LinkedHashMap<>();

    public static void main(String[] args) {
        configurarJogo();
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("O jogo começa com o cara no sofá da sala, em postura ereta e sombria. Ele se levanta...");
        loopJogo();
    }

    private static void configurarJogo() {
    
    // CRIAÇÃO DOS QUARTOS
    Quartos sala = new Quartos("Sala", "Você está na sala. As luzes da casa se acendem.");
    Quartos quarto = new Quartos("Quarto", "Você está no quarto. Parece que algo terrível aconteceu aqui.");
    Quartos cozinha = new Quartos("Cozinha", "A cozinha tem uma geladeira, fogão e uma bancada.");
    Quartos banheiro = new Quartos("Banheiro", "Você está no banheiro. Há um espelho, vaso e pia.");
    Quartos garagem = new Quartos("Garagem", "Você entrou na garagem. O portão está fechado.");
    Quartos armazem = new Quartos("Armazem", "Você entrou no armazém. O ar está pesado e cheira a mofo.");
    Quartos mesa = new Quartos("mesa", "ao se aproximar da mesa você consegue ver alguns pratos estranhos e enumerados, varias cadeiras de madeira comum e uma cadeira elegante vermelha");
    
    // QUARTO
    Cofre cofreQ = new Cofre(inventario, leitor);
    Quadro quadroQ = new Quadro(quarto, cofreQ);
    PortaRetrato portaRetratoQ = new PortaRetrato();
    Cama camaQ = new Cama();
    Armario armarioQ = new Armario();
    BancadaQuarto bancadaQ = new BancadaQuarto(inventario, new Fosforo());
    objetosQuarto.put("quadro", quadroQ);
    objetosQuarto.put("porta-retrato", portaRetratoQ);
    objetosQuarto.put("cama", camaQ);
    objetosQuarto.put("bancada do quarto", bancadaQ);
    objetosQuarto.put("armario", armarioQ);
    
    // SALA
    TV tvS = new TV();
    Sofa sofaS = new Sofa();
    objetosSala.put("tv", tvS);
    objetosSala.put("sofa", sofaS);
    
    // MESA
    Prato_1 prato1 = new Prato_1();
    Prato_2 prato2 = new Prato_2();
    Prato_3 prato3 = new Prato_3(inventario);
    Prato_4 prato4 = new Prato_4();
    Prato_5 prato5 = new Prato_5(inventario);
    Prato_6 prato6 = new Prato_6();
    CadeiraVermelha cadeiraFinal = new CadeiraVermelha(prato3, prato5);
    objetosMesa.put("prato 1", prato1);
    objetosMesa.put("prato 2", prato2);
    objetosMesa.put("prato 3", prato3);
    objetosMesa.put("prato 4", prato4);
    objetosMesa.put("prato 5", prato5);
    objetosMesa.put("prato 6", prato6);
    objetosMesa.put("cadeira vermelha", cadeiraFinal);

    // GARAGEM
    Portao portaoG = new Portao();
    Motor motorG = new Motor(inventario, portaoG);
    Carro carroG = new Carro(inventario);
    Relogio relogioG = new Relogio();
    objetosGaragem.put("portao", portaoG);
    objetosGaragem.put("motor", motorG);
    objetosGaragem.put("carro", carroG);
    objetosGaragem.put("relogio", relogioG);
    
    // COZINHA
    Geladeira geladeiraC = new Geladeira(inventario);
    Fogao fogaoC = new Fogao(inventario);
    BancadaCozinha bancadaC = new BancadaCozinha(inventario, new Oleo());
    objetosCozinha.put("geladeira", geladeiraC);
    objetosCozinha.put("fogao", fogaoC);
    objetosCozinha.put("bancada da cozinha", bancadaC);

    // BANHEIRO
    Pia piaB = new Pia(); Vaso vasoB = new Vaso();
    PortaVent portaVentB = new PortaVent(quarto);
    Espelho espelhoB = new Espelho(banheiro, portaVentB);
    objetosBanheiro.put("pia", piaB);
    objetosBanheiro.put("vaso", vasoB);
    objetosBanheiro.put("espelho", espelhoB);
    
    // ARMAZEM
    Prateleira gasolina = new Prateleira("galão de gasolina", "em cima na pratileira você encontra um galão de gasolina sujo preenchido ate a metade ", "deve dar para andar alguns quilometros", inventario, new Gasolina());
    Prateleira chaves = new Prateleira("Chave C", "as cheves de um belissimo Ford Maverick", "posso sair finalmente daqui", inventario, new ChavesCarro());
    Batman batmanA = new Batman(); Carrinho carrinhoA = new Carrinho();
    objetosArmazem.put("gasolina", gasolina);
    objetosArmazem.put("chaves do carro", chaves);
    objetosArmazem.put("batman", batmanA);
    objetosArmazem.put("carrinho", carrinhoA);

    // MONTAGEM FINAL DOS QUARTOS
    
    for (Objeto obj : objetosSala.values()) {sala.addInteracoes(obj); }
    sala.addSaida("Mesa");
    sala.addSaida("Banheiro");
    sala.addSaida("Garagem");
    sala.addSaida("Cozinha");
    sala.addSaida("Armazem");
    quartos.put("Sala", sala);

    for(Objeto obj : objetosMesa.values()){ mesa.addInteracoes(obj);}
    mesa.addSaida("Sala");
    quartos.put("Mesa", mesa);

    for(Objeto obj : objetosQuarto.values()){ if (!(obj instanceof Cofre)) { quarto.addInteracoes(obj); } }
    quarto.addSaida("Banheiro");
    quartos.put("Quarto", quarto);

    for (Objeto obj : objetosCozinha.values()) { cozinha.addInteracoes(obj); }
    cozinha.addSaida("Sala");
    quartos.put("Cozinha", cozinha);
    
    for (Objeto obj : objetosBanheiro.values()) { banheiro.addInteracoes(obj); }
    banheiro.addSaida("Sala");
    quartos.put("Banheiro", banheiro);

    for (Objeto obj : objetosGaragem.values()) { garagem.addInteracoes(obj); }
    garagem.addSaida("Sala");
    quartos.put("Garagem", garagem);

    for (Objeto obj : objetosArmazem.values()) { armazem.addInteracoes(obj); }
    armazem.addSaida("Sala");
    quartos.put("Armazem", armazem);
    
    localizacaoAtual = sala;
}

    private static int obterEscolhaDoUsuario(List<String> escolhas) {
    // Exibe as opções numeradas
    for (int i = 0; i < escolhas.size(); i++) {
        System.out.println((i + 1) + ". " + escolhas.get(i));
    }
    System.out.println(" ");

    int escolhaNumerica = -1;
    while (escolhaNumerica < 1 || escolhaNumerica > escolhas.size()) {
        System.out.print("Digite o número da sua escolha: ");
        String linhaDigitada = leitor.nextLine();
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        
        
        try {
            if (linhaDigitada.isEmpty()) {
                continue;
            }
            escolhaNumerica = Integer.parseInt(linhaDigitada);
            
            if (escolhaNumerica < 1 || escolhaNumerica > escolhas.size()) {
                System.out.println("Escolha inválida. Por favor, digite um número da lista.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite apenas um número.");
        }
    }
    return escolhaNumerica;
}
    private static void loopJogo() {
        while (true) {
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
            System.out.println("LOCALIZAÇÃO: " + localizacaoAtual.getNome());
            System.out.println(localizacaoAtual.getDescricao());
            System.out.println(inventario.listarItens());
            System.out.println("\nO que você quer fazer?");
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------");

            List<String> escolhas = localizacaoAtual.pegarEscolha();
            int escolha = obterEscolhaDoUsuario(escolhas);
            String acao = escolhas.get(escolha - 1);

            if (acao.startsWith("Interagir com")) {
                String nomeObjeto = acao.substring("Interagir com ".length()).trim().toLowerCase();
                if (localizacaoAtual.getInteracoes().stream().anyMatch(obj -> obj.getNome().equalsIgnoreCase(nomeObjeto))) {
                    localizacaoAtual.getInteracoes().stream()
                    .filter(obj -> obj.getNome().equalsIgnoreCase(nomeObjeto))
                    .findFirst().get().interagir();
                }
                else if (nomeObjeto.equals("cofre") && localizacaoAtual.getNome().equals("Quarto")) {
                    objetosQuarto.get("cofre").interagir();
                }
                else if (nomeObjeto.equals("carro") && localizacaoAtual.getNome().equals("Garagem")){
                    objetosQuarto.get("carro").interagir();
                }
                else if (nomeObjeto.equals("bancada da cozinha") && localizacaoAtual.getNome().equals("Cozinha")){
                    objetosQuarto.get("bancada da cozinha").interagir();
                }
                else if (nomeObjeto.equals("fogao") && localizacaoAtual.getNome().equals("Cozinha")){
                    objetosQuarto.get("fogao").interagir();
                }
                else { System.out.println("Objeto não encontrado."); }

            }
            else if (acao.startsWith("Ir para")) {
                String nomeQuarto = acao.substring("Ir para ".length()).split(" ")[0];
                if (nomeQuarto.equalsIgnoreCase("Armazem")) {
                    if (inventario.requisito("Chave A")) {
                        System.out.println("Você usa a Chave A para destrancar e entrar no armazém.");
                        localizacaoAtual = quartos.get(nomeQuarto);
                    } else {
                        System.out.println("A porta do armazém está trancada. Você precisa da Chave A.");
                    }
                }
                else {
                    if (quartos.containsKey(nomeQuarto)) {
                        localizacaoAtual = quartos.get(nomeQuarto);
                    } else {
                        System.out.println("Não é possível ir para este local.");
                    }
                }
            }
        }
    }
}