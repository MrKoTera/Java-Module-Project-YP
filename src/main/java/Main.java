import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите кол-во человек, на которых будет разделён счёт:");
        int countUsers = inputUsers();

        ArrayList<Order> orders = Calculate.inputOrders();
        System.out.println("\nСписок товаров:");
        int countOrders = 0;
        for(Order order : orders) {
            countOrders += 1;
            System.out.println(countOrders + ". " + order.name + " (" + order.price + ")");
        }

        System.out.println("Количество человек:" + countUsers);
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
    float price; // Цена товара
    Order(String name, float price) {
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
            float orderPrice = scanner.nextFloat();
            String.format("%.2f", orderPrice);
            orders.add(new Order(orderName, orderPrice));
            System.out.println("Товар успешно добавлен.");
        }
    }
}

