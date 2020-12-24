package fable;

import cart.Cart;
import creatures.Crayfish;
import creatures.Pike;
import creatures.Swan;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования класса Program.
 */
class ProgramTest {

    /**
     * Тестирование запуска потокв наблюдателя и существ,
     * сна оснвного потока и завершения потокв наблюдателя и существ.
     */
    @Test
    void testThreadWork() {
        Cart cart = new Cart();
        ArrayList<Thread> creatures = new ArrayList<>();
        creatures.add(new Thread(new Swan(cart), "Swan"));
        creatures.add(new Thread(new Crayfish(cart), "Crayfish"));
        creatures.add(new Thread(new Pike(cart), "Pike"));
        Thread observer = new Thread(new Observer(cart), "Наблюдатель");
        Program.startThreads(observer, creatures);
        // проверяем, запускаются ли потоки
        assertTrue(observer.isAlive());
        assertTrue(creatures.get(0).isAlive());

        // проверяем, длится ли сон более 25 секунд
        long timeStartSleep = System.nanoTime();
        Program.sleepOfMainThread();
        assertTrue(System.nanoTime() - timeStartSleep > 25000);

        //проверяем, завершаются ли потоки
        Program.finishThreads(observer, creatures);
        assertFalse(observer.isAlive());
        assertFalse(creatures.get(0).isAlive());
    }

    /**
     * Тестирование создание телеги с помощью аргументов, введенных через командную строку.
     */
    @Test
    void testCartCreation() {

        // Проверяем, что если введено два значения, x и y им соответствуют.
        String[] arr1 = {"2.33", "7.999"};
        Cart cart = Program.createCart(arr1);
        assertEquals(cart.getCoordinates().getX(), 2.33);
        assertEquals(cart.getCoordinates().getY(), 7.999);

        // проверяем, что если было введено только одно значение - телега
        // создается с координатой x == введенному значению и y == 0
        String[] arr2 = {"99.555"};
        cart = Program.createCart(arr2);
        assertEquals(cart.getCoordinates().getX(), 99.555);
        assertEquals(cart.getCoordinates().getY(), 0);

        // проверяем, что если данные не были введены или если введенные
        // данные некоррекны - телега создается с координатами 0 0
        String[] arr3 = {};
        cart = Program.createCart(arr3);
        assertEquals(cart.getCoordinates().getX(), 0);
        assertEquals(cart.getCoordinates().getY(), 0);

        String[] arr4 = {"4", "bdfhw"};
        cart = Program.createCart(arr4);
        assertEquals(cart.getCoordinates().getX(), 0);
        assertEquals(cart.getCoordinates().getY(), 0);

        String[] arr5 = null;
        cart = Program.createCart(arr5);
        assertEquals(cart.getCoordinates().getX(), 0);
        assertEquals(cart.getCoordinates().getY(), 0);
    }
}