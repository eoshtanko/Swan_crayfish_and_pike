package tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса с конвекторами.
 */
class ConvertorTest {

    /**
     * Количество миллисекунд в секунде.
     */
    private static final int MILLISEC_IN_SEC = 1000;

    /**
     * Количество наносекунд в секунде.
     */
    private static final int NANOSEC_IN_SEC = 1000000000;

    /**
     * Тестирование конвертора из градусов в радианы.
     */
    @Test
    void fromDegToRadTest() {
        int deg = 1;
        assertEquals(Convertor.fromDegToRad(deg), deg * Math.PI / 180);
        deg = 100000;
        assertEquals((int)Convertor.fromDegToRad(deg), 1745);
    }

    /**
     * Тестирование конвертора из миллисекнд в секунды.
     */
    @Test
    void fromMilliSecToSecTest() {
        long millisec = 1;
        assertEquals(Convertor.fromMilliSecToSec(millisec), 0,001);
        millisec = 1234567;
        assertEquals(Convertor.fromMilliSecToSec(millisec), 1234,567);
        assertEquals(Convertor.fromMilliSecToSec(millisec), (double)millisec/MILLISEC_IN_SEC);
    }

    /**
     * Тестирование конвертора из наносекунд в секунды.
     */
    @Test
    void fromNanoSecToSecTest() {
        long nanosec = 1000000;
        assertEquals(Convertor.fromNanoSecToSec(nanosec), 0.001);
        nanosec = 1234567;
        assertEquals(Convertor.fromNanoSecToSec(nanosec), 0.001234567);
        assertEquals(Convertor.fromNanoSecToSec(nanosec), (double)nanosec/NANOSEC_IN_SEC);
        System.out.println("Конвертирование из наносекунд в секунды работает корректно.");
    }
}