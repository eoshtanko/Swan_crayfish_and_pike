package cart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса координат.
 */
class CoordinatesTest {

    /**
     * Проверка корректности работы set и get :)
     */
    @Test
    void setAndGetTest(){
        Coordinates coordinates = new Coordinates(0, 0);

        // проверяем корректность работы конструктора и get
        assertEquals(coordinates.getX(), 0);
        assertEquals(coordinates.getY(), 0);

        // устанавливаем новые значения
        coordinates.setX(1);
        coordinates.setY(2);

        // проверяем корректность работы set и get
        assertEquals(coordinates.getX(), 1);
        assertEquals(coordinates.getY(), 2);
    }
}