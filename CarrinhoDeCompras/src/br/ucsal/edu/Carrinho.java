package br.ucsal.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Carrinho {
	
	// Criando um objeto Scanner para ler a entrada do usuário
	Scanner sc = new Scanner(System.in);

	// Inicializando um Map para armazenar os produtos no carrinho
	private Map<Produto, Integer> produtos = new HashMap<>();

	// Método para adicionar um produto ao carrinho
	public void adicionarProduto(Produto produto) {
		// Verificando se o produto não é nulo e se há estoque disponível
		if (produto != null && produto.getEstoque() > 0) {
			// Adicionando o produto ao carrinho ou incrementando a quantidade se já estiver no carrinho
			produtos.put(produto, produtos.getOrDefault(produto, 0) + 1);
			// Reduzindo o estoque do produto
			produto.removerEstoque(1);
			System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
		} else {
			System.out.println("Produto indisponível ou inválido para adição ao carrinho.");
		}
	}

	// Método para remover um produto do carrinho
	public void removerProduto(Produto produto) {
		// Verificando se o produto está no carrinho e se a quantidade é maior que zero
		if (produtos.containsKey(produto) && produtos.get(produto) > 0) {
			// Reduzindo a quantidade do produto no carrinho ou removendo completamente se a quantidade for 1
			produtos.put(produto, produtos.get(produto) - 1);
			// Aumentando o estoque do produto
			produto.adicionarEstoque(1);
			System.out.println("Produto removido do carrinho: " + produto.getNome());
		} else {
			System.out.println("O produto não está no carrinho.");
		}
	}

	// Método para calcular o total do carrinho
	public double calcularTotal() {
		double total = 0.0;
		// Iterando sobre cada produto no carrinho
		for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
			// Adicionando o preço do produto multiplicado pela quantidade ao total
			total += entry.getKey().getPreco() * entry.getValue();
		}
		return total;
	}

	// Método para realizar o checkout
	public void checkout() {
	    System.out.println("O total do seu carrinho é: " + calcularTotal());
	    System.out.println("Por favor, escolha seu método de pagamento:");
	    System.out.println("1. Cartão de crédito");
	    System.out.println("2. Cartão de débito");
	    System.out.println("3. Pix");
	    System.out.println("4. Boleto");

	    // Lendo a escolha do usuário
	    int escolha = sc.nextInt();

	    // Processando o pagamento de acordo com a escolha do usuário
	    switch (escolha) {
	        case 1:
	            // Processar pagamento com cartão de crédito
	            break;
	        case 2:
	            // Processar pagamento com cartão de débito
	            break;
	        case 3:
	            // Processar pagamento com Pix
	            break;
	        case 4:
	            // Processar pagamento com boleto
	            break;
	        default:
	            System.out.println("Escolha inválida. Por favor, tente novamente.");
	            checkout();
	            break;
	    }

	    // Limpando o carrinho após o checkout
	    produtos.clear();
	}

	// Sobrescrevendo o método toString para retornar uma representação em string do carrinho
	@Override
	public String toString() {
		return "Carrinho [produtos=" + produtos + "]";
	}
}
