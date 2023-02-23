package es.ucm.fdi.calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorUnitTest {
    private static double x=3.5;
    private static double y=3.5;
    public Calculator cal= new Calculator();

    @Test
    public void addition_isCorrect() {
        try{assertEquals(7, cal.suma(x,y),1);}
        catch (Exception ex){
            fail(ex.getMessage());
        }
    }
}
