package application2PolymorphismHeritage;

import Entities2PolymorphismHeritage.ImportedProduct;
import Entities2PolymorphismHeritage.Product;
import Entities2PolymorphismHeritage.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductProgram {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int products = scanner.nextInt();

        for (int i = 0; i < products; i++) {
            System.out.println("Product #" + (i  + 1)+ " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char typesProducts = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();

            if (typesProducts == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = scanner.nextDouble();
                productList.add(new ImportedProduct(name, price, customsFee));
            } else if (typesProducts == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = dateFormatter.parse(scanner.next());
                productList.add(new UsedProduct(name, price, manufactureDate));
            } else {
                productList.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product product : productList) {
            System.out.println(product.priceTag());
        }

        scanner.close();
    }
}