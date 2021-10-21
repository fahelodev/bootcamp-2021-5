package katas.kmollecundo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)

public class DigPowTest {

    private DigPow digPow;
    //Atributos variables a parametrizar
    private int expected, number, pow;

    //Constructor
    public DigPowTest(int expected,int number,int pow){
        this.expected= expected;
        this.number= number;
        this.pow= pow;
    }
    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> datosParametrizadosDigPow = new ArrayList<>();
        datosParametrizadosDigPow.add(new Object[]{1,89,1});
        datosParametrizadosDigPow.add(new Object[]{-1,92,1});
        datosParametrizadosDigPow.add(new Object[]{51,46288,3});
        return datosParametrizadosDigPow;
    }
    @Before
    public void before(){
        digPow = new DigPow();
    }
    @Test
    public void DatoEntradaRetornarDigitos(){
        assertEquals(expected, DigPow.digPow(number, pow));


    }
}
