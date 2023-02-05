package application3PolymorphismHeritage;

import Entities3PolymorphismHeritage.Circle;
import Entities3PolymorphismHeritage.Color;
import Entities3PolymorphismHeritage.Rectangle;
import Entities3PolymorphismHeritage.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ShapeProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int nShape = scanner.nextInt();

        List<Shape> shapeList = new ArrayList<>();

        for (int i = 0; i < nShape; i++) {
            System.out.println("Shape #" + (1 + i) + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char shapes = scanner.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(scanner.next());

            if (shapes == 'r') {
                System.out.print("Width: ");
                double width = scanner.nextDouble();
                System.out.print("Height: ");
                double height = scanner.nextDouble();
                shapeList.add(new Rectangle(color, width, height));
            } else if (shapes == 'c') {
                System.out.print("Radius: ");
                double radius = scanner.nextDouble();
                shapeList.add(new Circle(color, radius));
            }

        }

        System.out.println();
        System.out.println("SHAPE AREAS:");

        for (Shape shape : shapeList) {
            System.out.printf("%.2f\n", shape.area());
        }











        scanner.close();
    }
}