package application4PolymorphismHeritage;

import Entities4PolymorphismHeritage.Company;
import Entities4PolymorphismHeritage.Individual;
import Entities4PolymorphismHeritage.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TaxPayerProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int taxPayers = scanner.nextInt();

        for (int i = 0; i < taxPayers; i++) {
            System.out.println("Tax payer #" + (1 + i) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char person = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = scanner.nextDouble();

            if (person == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();
                taxPayerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = scanner.nextInt();
                taxPayerList.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        double sum = 0.0;
        for (TaxPayer taxPayer : taxPayerList) {
            System.out.printf("%s: $ %.2f\n", taxPayer.getName(), taxPayer.tax());
            sum += taxPayer.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", sum);

        scanner.close();
    }
}