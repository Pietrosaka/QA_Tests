package org.example;

// Importações necessárias para JUnit 5 (Jupiter)
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApdexTest {

    private static int TOTAL_AMOSTRAS;

    private Apdex apdex;


    @BeforeAll
    public static void setUpClass() {
        TOTAL_AMOSTRAS = 555839;
    }


    @BeforeEach
    public void setUp() {
        apdex = new Apdex();
    }



    @Test
    public void calcularApdex() {

        int satisfeitos = 500255;
        int tolerados = 0;


        double apdexBom = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        assertEquals(0.9, apdexBom, 0.01);
    }


    @Test
    public void validarApdexExcelente() {
        // ARRANGE
        int satisfeitos = 533605;
        int tolerados = 5057;

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.96, valor, 0.01);
    }


    @Test
    public void validarApdexBom() {
        // ARRANGE
        int satisfeitos = 472463;
        int tolerados = 0;

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.85, valor, 0.01);
    }


    @Test
    public void validarApdexRegular() {
        // ARRANGE
        int satisfeitos = 389087;
        int tolerados = 0;

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.70, valor, 0.01);
    }


    @Test
    public void validarApdexRuim() {
        // ARRANGE
        int satisfeitos = 333503;
        int tolerados = 0;

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.60, valor, 0.01);
    }


    @Test
    public void validarApdexInaceitavel() {
        // ARRANGE
        int satisfeitos = 127842;
        int tolerados = 0;

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.23, valor, 0.01);
    }
}
