package creatures;

import cart.Cart;
import cart.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса существ.
 */
class CreatureTest {

    /**
     * Время "передвижения" телеги.
     */
    private static final int INTERVAL = 7000;

    /**
     * Тест проверяет, смещает ли существо телегу.
     */
    @Test
    void creatueRunTest() {
        Cart cart = new Cart();
        Thread creatureThread = new Thread(new Swan(cart), "Swan");

        // координаты телеги до передвижения
        double xBefore = cart.getCoordinates().getX();
        double yBefore = cart.getCoordinates().getY();

        creatureThread.start();

        // засыпаем на 7 сек, ожидая пока существо переместит телегу
        try {
            Thread.sleep(INTERVAL);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван: " + e.getMessage());
        }

        creatureThread.interrupt();

        // координаты телеги после перемещения
        Coordinates coordinatesAfter = cart.getCoordinates();

        // проверка, произошло ли перемещение
        assertNotEquals(coordinatesAfter.getX(), xBefore);
        assertNotEquals(coordinatesAfter.getY(), yBefore);
    }
}