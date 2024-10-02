package Maquina;

import java.util.ArrayList;

import Estoque.Estoque;
import Usuario.Usuario;

enum Refrigerante {
	Coca_Cola, Fanta, Sprite

}

public class Maquina {

	private ArrayList<Estoque> estoqueList = new ArrayList<Estoque>();
	private Terminal terminal = new Terminal();
	private Usuario usuario = new Usuario();

	public void startMaquina() {
		inicializarEstoque();
		loop();
	}
	
	private void inicializarEstoque() {
	    Estoque cocaCola = new Estoque("Coca-Cola", 50, 5.50f);
	    Estoque fanta = new Estoque("Fanta", 50, 5.00f);
	    Estoque sprite = new Estoque("Sprite", 50, 4.00f);

	    estoqueList.add(cocaCola);
	    estoqueList.add(fanta);
	    estoqueList.add(sprite);

	    System.out.println("Estoque inicializado com sucesso!");
	    
	    // Depuração: Verifica se os itens foram realmente adicionados
	    for (Estoque e : estoqueList) {
	        System.out.println("Refrigerante: " + e.getRefrigerante() + ", Quantidade: " + e.getQuantidade() + ", Preço: " + e.getPreco());
	    }
	}


    private Estoque searchRefrigeranteQuantidade(String refrigerante, int quantidade) {
        for (Estoque estoque : estoqueList) {
            // Verifica se o refrigerante é o desejado e se há estoque suficiente (>= quantidade solicitada)
            if (refrigerante.equals(estoque.getRefrigerante()) && estoque.getQuantidade() >= quantidade) {
                return estoque; // Retorna o refrigerante com estoque suficiente
            }
        }
        return null; // Retorna null se o refrigerante não for encontrado ou não houver estoque suficiente
    }

	

    private void handleCocaColaQuantidadeSearch() {
        float saldo = usuario.getDinherio(); // Saldo do usuário
        float valor = 5.50f; // Preço da Fanta
        String cocacola = "Coca-Cola"; // Nome do refrigerante
        int number = terminal.readCustomInt("Quantas você deseja: "); // Quantidade solicitada pelo usuário

        // Verifica se há estoque suficiente de Fanta
        Estoque estoque = searchRefrigeranteQuantidade(cocacola, number);

        if (estoque != null) {
            float conta = valor * number; // Valor total da compra
            if (saldo >= conta) { // Verifica se o usuário tem saldo suficiente
                float resultado = saldo - conta; // Calcula o saldo restante
                usuario.setDinherio(resultado); // Atualiza o saldo do usuário
                estoque.setQuantidade(estoque.getQuantidade() - number); // Atualiza o estoque, subtraindo a quantidade comprada

                System.out.println("Compra realizada com sucesso!");
                System.out.println("Saldo restante: " + resultado + " R$");
                System.out.println("Você comprou: " + cocacola);
                System.out.println("Quantidade: " + number);
            } else {
                terminal.showError(ErrorCode.Valor_Inferior); // Saldo insuficiente
            }
        } else {
            terminal.showError(ErrorCode.Sem_Estoque); // Sem estoque suficiente ou refrigerante indisponível
        }
    }


	private void handleFantaQuantidadeSearch() {
	    float saldo = usuario.getDinherio(); // Saldo do usuário
	    float valor = 5.00f; // Preço da Fanta
	    String fanta = "Fanta"; // Nome do refrigerante
	    int number = terminal.readCustomInt("Quantas você deseja: "); // Quantidade solicitada pelo usuário

	    // Verifica se há estoque suficiente de Fanta
	    Estoque estoque = searchRefrigeranteQuantidade(fanta, number);

	    if (estoque != null) {
	        float conta = valor * number; // Valor total da compra
	        if (saldo >= conta) { // Verifica se o usuário tem saldo suficiente
	            float resultado = saldo - conta; // Calcula o saldo restante
	            usuario.setDinherio(resultado); // Atualiza o saldo do usuário
	            estoque.setQuantidade(estoque.getQuantidade() - number); // Atualiza o estoque, subtraindo a quantidade comprada

	            System.out.println("Compra realizada com sucesso!");
	            System.out.println("Saldo restante: " + resultado + " R$");
	            System.out.println("Você comprou: " + fanta);
	            System.out.println("Quantidade: " + number);
	        } else {
	            terminal.showError(ErrorCode.Valor_Inferior); // Saldo insuficiente
	        }
	    } else {
	        terminal.showError(ErrorCode.Sem_Estoque); // Sem estoque suficiente ou refrigerante indisponível
	    }
	}


	private void handleEspriteQuantidadeSearch() {
	    float saldo = usuario.getDinherio(); // Saldo do usuário
	    float valor = 4.00f; // Preço do Sprite
	    String sprite = "Sprite"; // Nome do refrigerante
	    int number = terminal.readCustomInt("Quantas você deseja: "); // Quantidade solicitada pelo usuário

	    // Verifica se há estoque suficiente de Sprite
	    Estoque estoque = searchRefrigeranteQuantidade(sprite, number);

	    if (estoque != null) {
	        float conta = valor * number; // Valor total da compra
	        if (saldo >= conta) { // Verifica se o usuário tem saldo suficiente
	            float resultado = saldo - conta; // Calcula o saldo restante
	            usuario.setDinherio(resultado); // Atualiza o saldo do usuário
	            estoque.setQuantidade(estoque.getQuantidade() - number); // Atualiza o estoque, subtraindo a quantidade comprada

	            System.out.println("Compra realizada com sucesso!");
	            System.out.println("Saldo restante: " + resultado + " R$");
	            System.out.println("Você comprou: " + sprite);
	            System.out.println("Quantidade: " + number);
	        } else {
	            terminal.showError(ErrorCode.Valor_Inferior);
	            System.out.println("Saldo restante: " + saldo + " R$");// Saldo insuficiente
	        }
	    } else {
	        terminal.showError(ErrorCode.Sem_Estoque); // Sem estoque suficiente ou refrigerante indisponível
	    }
	}



	
    private void handleValorDepositado() {
        System.out.println("Deposite o valor desejado.");
        float valor = Console.readFloat("Valor a ser depositado: ");
        usuario.setDinherio(valor);
        System.out.println("Valor depositado com sucesso! Saldo atual: " + usuario.getDinherio() + "R$");
        menuClient();
    }
    private void menuClient() {

 
        boolean running = true;
        while (running) {
        	float saldo = usuario.getDinherio();
        	System.out.println("\nSaldo: " + saldo + " R$\n");
            int opcao = terminal.showClientMenu(); // Exibe o menu para o usuário
            switch (opcao) {
                case 1:
                	handleCocaColaQuantidadeSearch();
                    break;
                case 2:
                	handleFantaQuantidadeSearch();
                    break;
                case 3:
                	handleEspriteQuantidadeSearch();
                    break;
                case 4:
                    running = false; // Sai do loop e finaliza o programa
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

	private void handleInsertEstoque() {
		estoqueList.add(terminal.showAddEstoque());
	}

	void hadleDeposit(Usuario usuario) {
		float dinheiro = Console.readNumber("valor depositado");
		usuario.setDinherio(dinheiro);
		System.out.println(dinheiro);
	}

    private void loop() {
        boolean running = true;
        while (running) {
            int opcao = terminal.showMainMenu(); // Exibe o menu principal para o usuário
            switch (opcao) {
                case 1:
                    handleValorDepositado(); // Depósito de valor no saldo do usuário
                    break;
                case 2:
                    handleInsertEstoque(); // Insere novo estoque de refrigerante
                    break;
                case 3:
                    menuClient(); // Exibe o menu de compras
                    break;
                case 4:
                    running = false; // Finaliza o loop principal e encerra o programa
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

} 


