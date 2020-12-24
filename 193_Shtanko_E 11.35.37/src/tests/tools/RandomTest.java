package tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса генерации чисел.
 */
class RandomTest {

    /**
     * Проверка корректности работы метода генрации целого числа.
     */
    @Test
    void checkRandomInt(){
        int i = 0;
        while (i < 1000){
            int res = Random.genInt(0,2);
            assertTrue(res >= 0 && res < 2);
            i++;
        }
    }

    /**
     * Проверка корректности работы метода генрации вещественного числа.
     */
    @Test
    void checkRandomDouble(){
        int i = 0;
        while (i < 1000){
            double res = Random.genDouble(0,1);
            assertTrue(res >= 0 && res < 1);
            i++;
        }
    }
}