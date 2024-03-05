import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US")); // Для отображения и ввода с точкой - меняем локаль

        System.out.println("Введите кол-во человек, на которых будет разделён счёт:");
        int countUsers = inputUsers();

        ArrayList<Order> orders = Calculate.inputOrders();
        System.out.println("\nДобавленные товары:");
        int countOrders = 0;
        double priceCount = 0;
        for(Order order : orders) {
            countOrders += 1;
            priceCount += order.price;
            System.out.println(countOrders + ". " + order.name + " (" + Formatter.formatMoney(order.price) + " " + Formatter.formatRub(priceCount) + ")");
        }

        System.out.println("Сумма добавленных товаров:" + Formatter.formatMoney(priceCount) + ' ' + Formatter.formatRub(priceCount));
        double multiplyPrice = priceCount / countUsers;
        System.out.println("\nКаждый человек должен заплатить: " + Formatter.formatMoney(multiplyPrice) + ' ' + Formatter.formatRub(multiplyPrice));
    }

    // Получаем количество людей
    public static int inputUsers() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int countUsers = scanner.nextInt();
            if(countUsers > 1) {
                return countUsers;
            } else if (countUsers == 1) {
                System.out.println("Ошибка: пользователь один. Нечего делить.");
            } else {
                System.out.println("Ошибка: некорректное значения для подсчёта.");
            }
        }
    }
}

// Объект товара
class Order {
    String name; // Название товара
    double price; // Цена товара
    Order(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Класс для подсчёта
class Calculate {
    public static ArrayList<Order> inputOrders() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>();
        while (true) {
            System.out.println("Введите название товара:");
            String orderName = scanner.next();
            if(orderName.equalsIgnoreCase("Завершить")) {
                return orders;
            }
            System.out.println("Введите стоимость товара:");
            double orderPrice = scanner.nextFloat();
            orders.add(new Order(orderName, orderPrice));
            System.out.println("Товар успешно добавлен!\nХотите добавить ещё товар?\nДля продолжения напишите любой символ\nДля отмены напишите \"Завершить\" в любом регистре.");
            String action = scanner.next();
            if(action.equalsIgnoreCase("Завершить")) return orders;
        }
    }
}

class Formatter {
    String rubles;
    public static String formatRub(double rubles) {
        double rublesFloor = Math.floor(rubles);
        String rub[] = new String[3];
        rub[0] = new String("рубль");
        rub[1] = new String("рубля");
        rub[2] = new String("рублей");
        String rublesOut;

        int rublesFloorInt = (int) rublesFloor % 100; // Преобразуем в int для switch/case
        if(rublesFloorInt > 19) {
            rublesFloor = rublesFloorInt % 10;
            System.out.println(rublesFloorInt);
        }
        switch (rublesFloorInt) {
            case 1: rublesOut = rub[0]; break;
            case 2:
            case 3:
            case 4: rublesOut = rub[1]; break;
            default: rublesOut = rub[2]; break;
        }
        return rublesOut;
    }
    public static String formatMoney(double rubles) {
        return String.format("%.2f", rubles);
    }
    Formatter(String rubles) {
        this.rubles = rubles;
    }

}