package junit;

/*  Pruebas a realizar para metodo Multiplicacion
            +*+ = +  -> 5,5,25
            +*- = -  -> 5,-5,-25
            -*+ = - -> -5,5,-25
            -*- = + -> -5,-5,25
  */

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class TestParametrizados {

    //atributos -> variables a parametrizar
    private int num1,num2,resultados;

    //Constructor
    public TestParametrizados(int num1, int num2, int resultados){
        this.num1 =num1;
        this.num2 = num2;
        this.resultados=resultados;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> datosParametrizados = new ArrayList<Object[]>();
        datosParametrizados.add(new Object[] {5,5,25});
        datosParametrizados.add(new Object[] {5,-5,-25});
        datosParametrizados.add(new Object[] {-5,5,-25});
        datosParametrizados.add(new Object[] {-5,-5,25});
        return  datosParametrizados;
    }


    @Test
    public void signosDeMultiplicacion(){
        Calculadora objCalculadora = new Calculadora();
        int res = objCalculadora.mult(num1,num2);
        assertEquals(resultados,res);

    }

}
