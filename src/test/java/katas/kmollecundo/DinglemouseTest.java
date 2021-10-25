package katas.kmollecundo;

import org.junit.*;
import static org.junit.Assert.*;

public class DinglemouseTest {
    @BeforeClass
    public static void BeforeClass(){
        System.out.println("BeforeClass()");
    }
    @Before
    public void StringOrdenado(){
        System.out.println("Cosas del zoo ordenadas por coma");
    }
    @Test
    public void DatoEntradaRetornarAnimalEatsAnimal(){
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, Dinglemouse.whoEatsWho(input));
    }
    @After
    public void ArrayPrimerElemento(){
        System.out.println("Primer Elemento inicial con todas las cosas del Zoo");
    }
    @After
    public void ArrayUltimoElemento(){
        System.out.println("Ultimo Elemento separados por coma de la ultima comida");
    }
    @After
    public void ArrayDemasElemento(){
        System.out.println("Devuelve los demas elementos en un array");
    }
    @AfterClass
    public static void StringOrdenadoFinal(){
        System.out.println("Devuelve el array con el ultimo animal vivo");
    }
}
