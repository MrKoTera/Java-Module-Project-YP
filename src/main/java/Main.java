import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите кол-во человек, на которых будет разделён счёт:");
        int countUsers = inputUsers();

        ArrayList<Order> orders = Calculate.inputOrders();
        System.out.println("\nСписок товаров:");
        int countOrders = 0;
        double priceCount = 0;
        for(Order order : orders) {
            countOrders += 1;
            priceCount += order.price;
            System.out.println(countOrders + ". " + order.name + " (" + order.price + ")");
        }

        System.out.println("Сумма товаров:" + priceCount);
        double multiplyPrice = priceCount / countUsers;
        String.format("%.2f", multiplyPrice);
        System.out.println("Каждый человек должен заплатить" + multiplyPrice);
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
            String.format("%.2f", orderPrice);
            orders.add(new Order(orderName, orderPrice));
            System.out.println("Товар успешно добавлен.");
        }
    }
}

