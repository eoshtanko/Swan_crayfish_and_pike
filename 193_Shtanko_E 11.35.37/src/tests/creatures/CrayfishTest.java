package creatures;

import cart.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса рака.
 */
class CrayfishTest {
    private static final int ANGLE = 180;
    /**
     * Тест проверяет, правильность возращаемого угла.
     */
    @Test
    void crayfishAngleTest() {
        Cart cart = new Cart();
        Crayfish crayfish = new Crayfish(cart);
        // проверка, соответвия угла.
        assertEquals(crayfish.getAngle(), ANGLE);
    }
}