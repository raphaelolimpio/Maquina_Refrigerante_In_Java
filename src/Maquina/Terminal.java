package Maquina;


import Estoque.Estoque;
import Usuario.Usuario;


enum ErrorCode {
	Sem_Estoque,
	Valor_Inferior
}

public class Terminal {
	
	
	public int showClientMenu() {
		System.out.println("Benvindo\n\n");
		System.out.println("1 - Coca-Cola");
		System.out.println("2 - Fanta");
		System.out.println("3 - Sprite");
		System.out.println("4 - VOLTAR");
		return Console.readNumber();
	}

	public int showMainMenu() {
		System.out.println("Comprar Refrigerante\n\n");
		System.out.println("1 - Comprar");
		System.out.println("2 - Repor Estoque");
		System.out.println("3 - Sair");
		System.out.println("Escolha a sua opcao: ");
		return Console.readNumber();
	}

	public int showMenuRefri() {
		System.out.println("Escolha seu Refrigerante\n\n");
		System.out.println("1 - Coca-Cola - R$ 5,50 ");
		System.out.println("2 - Fanta - R$ 5,00 ");
		System.out.println("3 - Sprite R$ 4,00 ");
		System.out.println("5 - Sair");
		System.out.println("Escolha a sua opcao: ");
		return Console.readNumber();
	}
	

	
	public Estoque showAddEstoque() {
		Estoque estoque = new Estoque(null, 0, 0);
		System.out.println("CADASTRAR Refrigerante");
		System.out.println("Nome Refrigerante: ");
		estoque.setRefrigerante(Console.readText());;
		System.out.print("Quantidade: ");
		estoque.setQuantidade(Console.readNumber());
		System.out.print("Preco: ");
		estoque.setPreco(Console.readFloat());
		return estoque;
	}
	
	public void showUsuarioData(Usuario usuario) {
		System.out.println(/*********DADOS DA CONTA************/);
		System.out.println("Saldo: " + usuario.getDinherio());
		System.out.println(/************************************/);
	}

	public void showError(ErrorCode errorCode) {
		switch(errorCode) {
		case Sem_Estoque:
			System.out.println("Não possui Estoque");
			break;
		case Valor_Inferior:
			System.out.println("Valor inferior");
			break;
		default:
			System.out.println("Erro genérico!");
		}
	}

	public int readCustomInt(String string) {
		System.out.println(string);
		return Console.readNumber();
	}
}
