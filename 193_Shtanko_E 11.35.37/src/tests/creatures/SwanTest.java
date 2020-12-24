package creatures;

import cart.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса лебедя
 */
class SwanTest {
    private static final int ANGLE = 60;
    /**
     * Тест проверяет, правильность возращаемого угла.
     */
    @Test
    void crayfishAngleTest() {
        Cart cart = new Cart();
        Swan swan = new Swan(cart);
        // проверка, соответвия угла.
        assertEquals(swan.getAngle(), ANGLE);
    }
}