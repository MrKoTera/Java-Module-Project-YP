import java.util.ArrayList;
import java.util.Scanner;

class ProductList {
    public static ArrayList<Product> inputOrders() {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите название товара:");
                String orderName = scanner.next();
                System.out.println("Введите стоимость товара:");
                double orderPrice = scanner.nextFloat();
                if(orderPrice <= 0) {
                    System.out.println("Некорректная сумма!");
                    continue;
                }

                products.add(new Product(orderName, orderPrice));

                System.out.println("Товар успешно добавлен!\n\nХотите добавить ещё товар?\n1. Для продолжения напишите любой символ\n2. Для отмены напишите \"Завершить\" в любом регистре.");
                String action = scanner.next();
                if(action.equalsIgnoreCase("Завершить")) return products;
            }
        }
    }
}
