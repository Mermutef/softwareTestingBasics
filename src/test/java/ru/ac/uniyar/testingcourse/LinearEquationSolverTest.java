package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinearEquationSolverTest {
    /**
     * Проверка решения линейного уравнения в действительных числах при не целом корне и параметрах
     * Дано: а = 23.59684, б = -288.166969764
     * Ожидаемый результат: -12.2121
     */
    @Test
    void realNumberCaseWithRealParams() {
        assertThat(LinearEquationSolver.solve(23.59684, -288.166969764)).isEqualTo(-12.2121);
    }

    /**
     * Проверка решения линейного уравнения в действительных числах при не целых параметрах
     * Дано: а = 1.3, б = 2.6
     * Ожидаемый результат: 2
     */
    @Test
    void realNumberCaseWithIntegerRoot() {
        assertThat(LinearEquationSolver.solve(1.3, 2.6)).isEqualTo(2);
    }

    /**
     * Проверка решения линейного уравнения в целых числах при одном отрицательном параметре
     * Дано: а = -7, б = 56
     * Ожидаемый результат: -8
     */
    @Test
    void integerNumbersCaseWithNegativeRoot() {
        assertThat(LinearEquationSolver.solve(-7, 56))
                .isEqualTo(-8);
    }

    /**
     * Проверка решения линейного уравнения в положительных числах
     * Дано: а = 18, б = 72
     * Ожидаемый результат: 4
     */
    @Test
    void positiveNumbersCaseWithNegativeRoot() {
        assertThat(LinearEquationSolver.solve(18, 72))
                .isEqualTo(4);
    }

    /**
     * Проверка решения линейного уравнения в действительных числах при корне - бесконечной дроби (спецификация не полна)
     * Дано: а = 3, б = 1
     * Ожидаемый результат: 0.333 +-eps
     */
    @Test
    void realNumbersCaseWithInfinityRoot() {
        assertThat(LinearEquationSolver.solve(3, 1))
                .isCloseTo(0.333, offset(0.001));
    }

    /**
     * Проверка решения линейного уравнения в случае бесконечного числа решений
     * Дано: а = 0, б = 0
     * Ожидаемый результат: метод не завершит работу с исключением LinearEquationSolver.AnyNumberIsRootException
     */
    @Test
    void infinityRootsCase() {
        /**assertThrows(LinearEquationSolver.AnyNumberIsRootException.class,
                () -> LinearEquationSolver.solve(0, 0));*/
        assertThatThrownBy(() -> LinearEquationSolver.solve(0, 0))
                .isInstanceOf(LinearEquationSolver.AnyNumberIsRootException.class);
    }

    /**
     * Проверка решения линейного уравнения в случае отсутствия решений
     * Дано: а = 0, б = 1
     * Ожидаемый результат: null
     */
    @Test
    void noRootsCase() {
        assertThat(LinearEquationSolver.solve(0, 1))
                .isEqualTo(null);
    }

    /**
     * Проверка решения линейного уравнения в случае нулевого корня
     * Дано: а = 1, б = 0
     * Ожидаемый результат: 0
     */
    @Test
    void zeroRootCase() {
        assertThat(LinearEquationSolver.solve(1, 0))
                .isEqualTo(0);
    }

}
