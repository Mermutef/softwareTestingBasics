package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinearEquationSolverTest {
    /**
     * Проверка решения линейного уравнения в действительных числах
     * Дано: а = 23.59684, б = -288.166969764
     * Ожидаемый результат: -12.2121
     */
    @Test
    void realNumberTest() {
        assertThat(LinearEquationSolver.solve(23.59684, -288.166969764)).isEqualTo(-12.2121);
    }

    /**
     * Проверка решения линейного уравнения в отрицательных числах
     * Дано: а = -7, б = 56
     * Ожидаемый результат: -8
     */
    @Test
    void negativeNumberTest() {
        assertThat(LinearEquationSolver.solve(-7, 56))
                .isNegative()
                .isEqualTo(-8);
    }

    /**
     * Проверка решения линейного уравнения в положительных числах
     * Дано: а = 18, б = 72
     * Ожидаемый результат: 4
     */
    @Test
    void positiveNumberTest() {
        assertThat(LinearEquationSolver.solve(-18, 72))
                .isNegative()
                .isEqualTo(-4);
    }

    /**
     * Проверка решения линейного уравнения в случае бесконечного числа решений
     * Дано: а = 0, б = 0
     * Ожидаемый результат: бесконечность
     */
    @Test
    void infinityRootsTest() {
        assertThat(LinearEquationSolver.solve(0, 0))
                .isEqualTo(Double.POSITIVE_INFINITY);
    }

}
