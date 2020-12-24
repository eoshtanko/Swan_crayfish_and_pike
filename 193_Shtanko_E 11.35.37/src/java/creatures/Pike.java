package creatures;

import cart.Cart;

/**
 * Класс, соответвующий щуке, что тянет в воду.
 */
public class Pike extends Creature implements Runnable {

    /**
     * Угол, под которым щука передвигает телегу.
     * Угол в градусах!
     */
    private static final int ANGLE = 300;

    public Pike(Cart cart) {
        super(cart);
        printPersonalInfo();
    }

    /**
     * Метод, предоставляющий информацию об угле, под которым
     * щука перемещает объект.
     * Угол в градусах!
     *
     * @return угол, под которым щука перемещает объект
     */
    @Override
    int getAngle() {
        return ANGLE;
    }
}
