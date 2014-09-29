package br.loja.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.loja.dominio.Carrinho;
import br.loja.dominio.Item;
import br.loja.dominio.Produto;

public class TesteDeCompra {

	@Test
	public void deveTotalizarCarrinho() {
		// 1 - Cenário
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho1 = new Carrinho();

		carrinho1.getItens().add(new Item(macBookPro));
		carrinho1.getItens().add(new Item(iPhone6));
		carrinho1.getItens().add(new Item(macMini));

		Carrinho carrinho2 = new Carrinho();

		// 2 - Ação
		double totalEsperadoCarrinho1 = 10999.97;
		double totalEsperadoCarrinho2 = 0.0;
		double totalCarrinho1 = carrinho1.getTotal();
		double totalCarrinho2 = carrinho2.getTotal();

		// 3 - Validação
		assertEquals(totalEsperadoCarrinho1, totalCarrinho1, 0.01);
		assertEquals(totalEsperadoCarrinho2, totalCarrinho2, 0.01);
	}

	@Test
	public void deveTotalizarCarrinhoComApenasUmItem() {
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho = new Carrinho();

		carrinho.getItens().add(new Item(macMini));

		double totalEsperadoCarrinho = 599.99;
		double totalCarrinho = carrinho.getTotal();

		assertEquals(totalEsperadoCarrinho, totalCarrinho, 0.00001);
	}

	@Test
	public void deveCalcularValorDoFrete() {
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho = new Carrinho();
		carrinho.setCep("60320-270");
		carrinho.getItens().add(new Item(macMini));

		assertEquals(59.99, carrinho.getValorFrete(), 0.01);
	}

	@Test
	public void deveCalcularValorDoFreteParaMultiplosProdutos() {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho = new Carrinho();
		carrinho.setCep("60320-270");
		carrinho.getItens().add(new Item(iPhone6));
		carrinho.getItens().add(new Item(macBookPro));
		carrinho.getItens().add(new Item(macMini));

		assertEquals(1099.99, carrinho.getValorFrete(), 0.01);
	}

	@Test
	public void deveIncluirValorDoFreteNoTotal() {
		Produto iPhone6 = new Produto("PRD-0001", 2399.99);
		Produto macBookPro = new Produto("PRD-0009", 7999.99);
		Produto macMini = new Produto("PRD-0009", 599.99);

		Carrinho carrinho = new Carrinho();
		carrinho.setCep("60320-270");
		carrinho.getItens().add(new Item(iPhone6));
		carrinho.getItens().add(new Item(macBookPro));
		carrinho.getItens().add(new Item(macMini));

		assertEquals(12099.96, carrinho.getTotal(), 0.01);
	}

}
