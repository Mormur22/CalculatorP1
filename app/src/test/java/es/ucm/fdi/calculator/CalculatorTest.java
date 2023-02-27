package es.ucm.fdi.calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testSuma() {
        Calculator calculator = new Calculator();
        calculator.suma(5);
        calculator.suma(0);
        calculator.suma(2);
        assertEquals(502.0, calculator.getSumando(), 0.0);
    }

    @Test
    public void testSumaConDecimal() {
        Calculator calculator = new Calculator();
        calculator.suma(5);
        calculator.suma(0);
        calculator.setPulsacoma(true);
        calculator.suma(2);
        calculator.suma(7);
        assertEquals(50.27, calculator.getSumando(), 0.001);
    }

    @Test
    public void testSumaTotal() {
        Calculator calculator = new Calculator();
        calculator.suma(3);
        calculator.suma(4);
        calculator.suma(2);
        calculator.sumaTotal();
        assertEquals(342, calculator.getTotal(), 0.0);
        calculator.reset();
        calculator.suma(5);
        calculator.suma(6);
        calculator.sumaTotal();
        assertEquals(398, calculator.getTotal(), 0.0);
    }

    @Test
    public void testReset() {
        Calculator calculator = new Calculator();
        calculator.suma(5);
        calculator.suma(2);
        calculator.suma(1);
        calculator.setPulsacoma(true);
        calculator.suma(7);
        calculator.reset();
        assertEquals(0.0, calculator.getSumando(), 0.0);
        assertEquals(0, calculator.getEntera());
        assertEquals(0.0, calculator.getDecimal(), 0.0);
        assertEquals(1, calculator.getContadordecimal());
        assertFalse(calculator.isPulsacoma());
    }
}