import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US")); // Для отображения и ввода с точкой - меняем локаль

        int countUsers = countUsers();
        double priceCount = priceCount();

        sumResult(priceCount, countUsers);
    }

    // Вывод списка товаров
    public static double priceCount() {
        ProductList products = new ProductList();
        Formatter format = new Formatter();

        ArrayList<Product> productsList = products.inputOrders();

        System.out.println("\nДобавленные товары:");
        int countOrders = 0;
        double priceCount = 0;
        for(Product product : productsList) {
            countOrders += 1;
            priceCount += product.price;
            System.out.println(countOrders + ". " + product.name + " (" + format.moneyCut(product.price) + " " + format.typeMoneyRub(product.price) + ")");
        }
        return priceCount;
    }

    // Вывод суммы товаров и того, сколько нужно заплатить каждому
    public static void sumResult(double money, int countUsers) {
        Formatter format = new Formatter();
        System.out.println("\nСумма добавленных товаров: " + format.moneyCut(money) + ' ' + format.typeMoneyRub(money));
        double multiplyPrice = money / countUsers;
        System.out.println("Каждый человек должен заплатить: " + format.moneyCut(multiplyPrice) + ' ' + format.typeMoneyRub(multiplyPrice));

    }

    // Получаем количество людей
    public static int countUsers() {
        while (true) {
            try {
                System.out.println("Введите кол-во человек, на которых будет разделён счёт:");
                Scanner scanner = new Scanner(System.in);
                int countUsers = scanner.nextInt();
                if (countUsers > 1) {
                    return countUsers;
                } else if (countUsers == 1) {
                    System.out.println("Ошибка: пользователь один. Нечего делить.");
                } else {
                    System.out.println("Ошибка: некорректное значение для подсчёта.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: некорректное значение для подсчёта.");
            }
        }
    }
}

