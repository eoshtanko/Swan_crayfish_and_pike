package cart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса телеги.
 */
class CartTest {

    /**
     * Проверка работы конструкторов телеги.
     */
    @Test
    void cartCreationTest(){
        // проверим, что создав телегу, испоользуя пустой
        // конструктор, значение ее координат 0 0
        Cart cart = new Cart();
        Coordinates coordinates = cart.getCoordinates();
        assertEquals(coordinates.getX(), 0);
        assertEquals(coordinates.getY(), 0);

        // проверим, что создав телегу, испоользуя конструктор
        // с одним параметром, значение координаты x == переданному
        // пармаетру, а y == 0
        cart = new Cart(5);
        coordinates = cart.getCoordinates();
        assertEquals(coordinates.getX(), 5);
        assertEquals(coordinates.getY(), 0);

        // проверим, что создав телегу, испоользуя конструктор
        // с двумя параметрами, значение координаты x == первому
        // пармаетру, а y - второму
        cart = new Cart(5, 7);
        coordinates = cart.getCoordinates();
        assertEquals(coordinates.getX(), 5);
        assertEquals(coordinates.getY(), 7);
    }

    /**
     * Проверка передвижения телеги(работы метода move)
     */
    @Test
    void cartMoveTest(){
        Cart cart = new Cart();

        // значения, на которые смещается телега
        int shiftX = 5;
        int shiftY = 10;

        // координаты телеги до передвижения
        double xBefore = cart.getCoordinates().getX();
        double yBefore = cart.getCoordinates().getY();

        cart.move(shiftX, shiftY);

        // координаты телеги после передвижения
        double xAfter = cart.getCoordinates().getX();
        double yAfter = cart.getCoordinates().getY();

        // проверяем, корректно ли изменились координаты
        assertEquals(xBefore + shiftX, xAfter);
        assertEquals(yBefore + shiftY, yAfter);
    }
}