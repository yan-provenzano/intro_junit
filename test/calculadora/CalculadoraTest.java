package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(10, 5);		
		Assertions.assertEquals(5, subtracao);		
	}

	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(11, 2);		
		Assertions.assertEquals(22, multiplicacao);		
	}
	
	@DisplayName("Testa a somatoria")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);		
		assertTrue(somatoria == 15);		
	}
	
	@DisplayName("É positivo?")
	@Test
	public void testEhPositivo() {
		assertTrue(calc.ehPositivo(2));
	}
	
	@DisplayName("São iguais?")
	@Test
	public void testEhIgual() {
		int n =  calc.compara(2, 2);
		assertTrue(n == 0);
	}
	
	@DisplayName("A é maior?")
	@Test
	public void testEhMaior() {
		int n =  calc.compara(2, 1);
		assertTrue(n == 1);
	}
	
	@DisplayName("A é menor?")
	@Test
	public void testEhMenor() {
		int n =  calc.compara(1, 2);
		assertTrue(n == -1);
	}
}

