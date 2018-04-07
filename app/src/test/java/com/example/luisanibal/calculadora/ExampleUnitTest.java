package com.example.luisanibal.calculadora;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void sumar_dos_numeros(){
        double a=4, b=6;
        assertEquals(10,Metodos.Sumar(a,b), 0);
    }

}
