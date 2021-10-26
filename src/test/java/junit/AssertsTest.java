package junit;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class AssertsTest {

    @Test
    public void numeros(){
        //enteros
        assertEquals(4,4); //validacion positiva
        assertNotEquals(4,3); // validacion negativa
        //numeros decimales -> float
        assertEquals(2.56,2.50,0.1);
    }

    @Test
    public void cadenas(){
        String s1 = "Bootcamp";
        String s2 = "Tsoft";
        assertEquals("Para dar mas detalle de la comprobación","Hola","Hola");
        assertNotEquals(s1,s2);
    }

    @Test
    public void arrays(){
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<String>();

        for (int i = 0; i <10 ; i++) {
            String elementoDelArray = ""+(i+1);
            arrayList1.add(elementoDelArray);
            arrayList2.add(elementoDelArray);
        }
        assertEquals(arrayList1,arrayList2);

        //Convertir a arrays
        String[] array1 = arrayList1.toArray(new String[arrayList1.size()]);
        String[] array2 = arrayList2.toArray(new String[arrayList2.size()]);
        assertArrayEquals(array1,array2);
    }

    @Test
    public void objetos() throws InterruptedException {
        Date objetoFecha1 = new Date();
        Date objetoFecha2 = new Date();
        assertEquals(objetoFecha1,objetoFecha2); // atributos
        assertNotSame(objetoFecha1,objetoFecha2);
    }




}
