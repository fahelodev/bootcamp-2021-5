package katas.foliva;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DigPowTest {

    private DigPow digPow;
    private  int expected, number, pow;

    public DigPowTest(int expected, int number, int pow){
        this.expected = expected;
        this.number = number;
        this.pow = pow;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> dataParameterized = new ArrayList<>();
        dataParameterized.add(new Object[]{1,89,1});
        dataParameterized.add(new Object[]{-1,92,1});
        dataParameterized.add(new Object[]{51,46288,3});
        return dataParameterized;
    }

    @Before
    public void before(){
        digPow = new DigPow();
    }

    @Test
    public void digPowTests() {
        assertEquals(expected, digPow.digPow(number, pow));
    }

}
