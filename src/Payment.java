import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Payment {
    private List<Item> items;

    public Payment() {
        items = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public double getTotalAmount() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayItems() {
        System.out.println("Товары в корзине:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " - " + price + " руб.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payment payment = new Payment();

        System.out.println("Введите товары и их цены (введите 'exit' для завершения):");

        while (true) {
            System.out.print("Введите наименование товара: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Введите цену товара: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            payment.addItem(name, price);
        }

        payment.displayItems();
        System.out.printf("Общая стоимость: %.2f руб.%n", payment.getTotalAmount());

        scanner.close();
    }
}
