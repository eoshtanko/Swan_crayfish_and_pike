package creatures;

import cart.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса щуки
 */
class PikeTest {
    private static final int ANGLE = 300;
    /**
     * Тест проверяет, правильность возращаемого угла.
     */
    @Test
    void crayfishAngleTest() {
        Cart cart = new Cart();
        Pike pike = new Pike(cart);
        // проверка, соответвия угла.
        assertEquals(pike.getAngle(), ANGLE);
    }
}