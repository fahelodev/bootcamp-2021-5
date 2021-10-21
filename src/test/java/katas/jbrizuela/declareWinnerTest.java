package katas.jbrizuela;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class declareWinnerTest {
    private declareWinner objeto1;

    @Before
    public void before(){
        objeto1=new declareWinner();
    }
    

    @Test
    public void TestEjemplo1(){
        assertEquals("Lew", objeto1.declareWinner(new Fighter("Lew",10,2), new Fighter("Harry",5,4),"Lew"));
        assertEquals("Harald", objeto1.declareWinner(new Fighter("Harald",20,5), new Fighter("Harry",5,4),"Harry"));
        assertEquals("Harry", objeto1.declareWinner(new Fighter("Lew",10,2), new Fighter("Harry",5,4),"Harry"));
        assertEquals("Harald", objeto1.declareWinner(new Fighter("Jerry",30,3), new Fighter("Harald",20,5),"Jerry"));
        assertEquals("Harald", objeto1.declareWinner(new Fighter("Jerry",30,3), new Fighter("Harald",20,5),"Harald"));
    }
}
