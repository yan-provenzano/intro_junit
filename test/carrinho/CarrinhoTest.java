package carrinho;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;
import carrinho.Carrinho;

public class CarrinhoTest {
	
    Carrinho carrinho;
	 Produto livro;
	 Produto disco; 
	
    @BeforeEach
    public void instanciando() {
        carrinho = new Carrinho();
        livro = new Produto("Introdução ao Teste de Software", 79.00);
        disco = new Produto("Introdução ao Teste de Software - Audiobook", 49.00);
        carrinho.addItem(livro);
        carrinho.addItem(disco);
    }
	
    @DisplayName("Testa a adição e a quantidade de produtos em um carrinho")
	@Test
	public void testAddItem() {		
		Assertions.assertAll("carrinho", 
				() -> Assertions.assertEquals(2, carrinho.getQtdeItems()),
				() -> Assertions.assertTrue(livro.getNome() == "Introdução ao Teste de Software")
				);		
		 System.out.println(carrinho.getQtdeItems());
	}
    
    @DisplayName("Testa a remoção de um produto ao carrinho")
	@Test
	public void testRemoveItem() throws ProdutoNaoEncontradoException {
    	carrinho.removeItem(livro);		
		Assertions.assertEquals(1, carrinho.getQtdeItems());	
		 System.out.println(carrinho.getQtdeItems());
	}   
    
    @DisplayName("Testa o valor total de um carrinho")
	@Test
	public void testGetValorTotal() {
        
        System.out.println(carrinho.getQtdeItems());
        System.out.println(livro.getNome());
        System.out.println(disco.getNome());
        
        double valorTotal = carrinho.getValorTotal();
        
        assertTrue(valorTotal == 128.00);
        System.out.println(carrinho.getQtdeItems());
    }
    

    
    @DisplayName("Esvazia o carrinho")
   	@Test
   	public void testEsvazia() {
       	carrinho.esvazia();
        assertTrue(carrinho.getQtdeItems() == 0);	
        System.out.println(carrinho.getQtdeItems());
   	}
    
    
    

}
