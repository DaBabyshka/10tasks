import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private int shelfLife;
    private int quantity;

    public Product(int id, String name, String upc, String manufacturer, double price, int shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    @Override
    public String toString() {
        return "Товар{" +
                "id=" + id +
                ", наименование='" + name + '\'' +
                ", upc='" + upc + '\'' +
                ", производитель='" + manufacturer + '\'' +
                ", цена=" + price +
                ", срок хранения=" + shelfLife +
                ", количество=" + quantity +
                '}';
    }
}

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
        products.add(new Product(1, "Молоко", "1234567890123", "Производитель1", 50.0, 30, 100));
        products.add(new Product(2, "Хлеб", "1234567890124", "Производитель2", 20.0, 7, 200));
        products.add(new Product(3, "Сыр", "1234567890125", "Производитель1", 150.0, 20, 50));
        products.add(new Product(4, "Мясо", "1234567890126", "Производитель3", 300.0, 10, 30));
    }

    public List<Product> getProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProductsByNameAndPrice(String name, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProductsByShelfLife(int minShelfLife) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                result.add(product);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        System.out.println("Товары с наименованием 'Молоко':");
        List<Product> milkProducts = manager.getProductsByName("Молоко");
        milkProducts.forEach(System.out::println);

        System.out.println("\nТовары с наименованием 'Молоко', цена которых не превосходит 60.0:");
        List<Product> affordableMilkProducts = manager.getProductsByNameAndPrice("Молоко", 60.0);
        affordableMilkProducts.forEach(System.out::println);

        System.out.println("\nТовары, срок хранения которых больше 15 дней:");
        List<Product> longShelfLifeProducts = manager.getProductsByShelfLife(15);
        longShelfLifeProducts.forEach(System.out::println);
    }
}
