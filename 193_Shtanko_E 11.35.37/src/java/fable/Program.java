package fable;

import cart.Cart;
import cart.Coordinates;
import creatures.*;

import java.util.ArrayList;

/**
 * Основной класс, в которм происходит запуск и завершение программы.
 * Программа написана по мотивам басни Крылова :)
 */
public class Program {

    /**
     * Продолжительность жизни потоков
     * (Через 25 секунд после начала тяги у существ заканчиваются силы окончательно.)
     */
    private static final int TIME_OF_LIVE = 25000;

    // Когда в товарищах согласья нет,
    // На лад их дело не пойдет,
    // И выйдет из него не дело, только мука.

    public static void main(String[] args) {

        Cart cart = createCart(args);

        // Можно было бы все потоки(существ и наблюдателя) поместить в ArrayList, так как
        // с ними проделываются одни и те же действия, но это все же разные по своей сути сущности
        // поэтому я решила держать их отдельно.
        ArrayList<Thread> creatures = new ArrayList<>();
        creatures.add(new Thread(new Swan(cart), "Swan"));
        creatures.add(new Thread(new Crayfish(cart), "Crayfish"));
        // и
        creatures.add(new Thread(new Pike(cart), "Pike"));
        // :)

        Thread observer = new Thread(new Observer(cart), "Наблюдатель");

        // запуск потоков
        // Однажды Лебедь, Рак, да Щука
        // Везти с поклажей воз взялись,
        // И вместе трое все в него впряглись;
        startThreads(observer, creatures);

        // основной поток засыпает на TIME_OF_LIVE сек.
        sleepOfMainThread();

        // завершение работы потоков
        finishThreads(observer, creatures);

        // вывод информации об окончательном расположении телеги
        // Кто виноват из них, кто прав, — судить не нам;
        // Да только воз ...
        printRes(cart);
    }

    // я приняла решение сделать некоторые методы, что могли бы быть private,
    // package-private, потому что сочла важным протестировать их.

    /**
     * Создаем телегу с изначальными координтами, введенными через командную строку.
     * Если данные не были введены или если введенные данные некоррекны - телега
     * создается с координатами 0 0.
     * Если было введено только одно значение - телега создается с координатой
     * x == введенному значению и y == 0.
     * Если введено два значения, x и y им соответствуют.
     *
     * @param args значение вееденное через командную строку
     * @return объект телеги
     */
    static Cart createCart(String[] args) {
        try {
            if (args.length == 0) {
                return new Cart();
            } else if (args.length == 1) {
                return new Cart(Double.parseDouble(args[0]));
            } else if (args.length == 2) {
                return new Cart(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            } else {
                throw new IllegalArgumentException("число аргументов в командной строке не может более 2.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка в данных, введенных в командную строку: " + e.getMessage());
        }
        return new Cart();
    }

    /**
     * Метод, запускающий потоки наблюдателя и существ.
     *
     * @param observer  "наблюдатель" за телегой
     * @param creatures существа, двигающие телегу
     */
    static void startThreads(Thread observer, ArrayList<Thread> creatures) {
        System.out.println(observer.getName() + " начал работу!");
        observer.start();

        for (Thread thread : creatures) {
            System.out.println(thread.getName() + " начал работу!");
            thread.start();
        }
    }

    /**
     * Метод, контролирующий время работы программы.
     * Он "усыпляет" основной поток на TIME_OF_LIVE сек.
     */
    static void sleepOfMainThread() {
        try {
            Thread.sleep(TIME_OF_LIVE);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван: " + e.getMessage());
        }
    }

    /**
     * Метод, завершающий потоки наблюдателя и существ.
     *
     * @param observer  "наблюдатель" за телегой
     * @param creatures существа, двигающие телегу
     */
    static void finishThreads(Thread observer, ArrayList<Thread> creatures) {
        for (Thread thread : creatures) {
            thread.interrupt();
            System.out.println(thread.getName() + " завершил работу...");
        }

        observer.interrupt();
        System.out.println(observer.getName() + " завершил работу...");

        // я решила сделать join, чтобы быть уверенной в корректности вывода координат
        // окончательного расположения телеги
        try {
            for (Thread thread : creatures) {
                thread.join();
            }
            observer.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван: " + e.getMessage());
        }
    }

    /**
     * Метод, выводящий информацию об окончательном расположении телеги.
     *
     * @param cart телега
     */
    private static void printRes(Cart cart) {
        Coordinates coordinates = cart.getCoordinates();
        System.out.printf("Да только воз ... имеет координаты x = %.2f y = %.2f. \n",
                coordinates.getX(), coordinates.getY());
    }
}