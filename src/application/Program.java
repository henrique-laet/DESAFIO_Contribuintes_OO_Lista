package application;

import entities.TaxPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPlayer> list = new ArrayList<>();
        TaxPlayer tax = new TaxPlayer();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println();
            System.out.println("Digite os dados do " + i + "o" +  " contribuinte: ");

            System.out.print("Renda anual com salário: ");
            double salaryAnnual = sc.nextDouble();

            System.out.print("Renda anual com prestação de serviço: ");
            double provisionServices = sc.nextDouble();

            System.out.print("Renda anual com ganho de capital: ");
            double capitalGain = sc.nextDouble();

            System.out.print("Gastos médicos: ");
            double medicalExpenses = sc.nextDouble();

            System.out.print("Gastos educacionais: ");
            double educationalExpenses = sc.nextDouble();
            list.add(new TaxPlayer(salaryAnnual, provisionServices, capitalGain, medicalExpenses, educationalExpenses));

        }

        System.out.println();
        for (int i=0; i< list.size(); i++) {
            tax = list.get(i);

            System.out.println("Resumo do " + (i + 1) + "o contribuinte");
            System.out.printf("Imposto bruto total: R$ %.2f%n", tax.grossTax());
            System.out.printf("Abatimento: R$ %.2f%n", tax.taxRebate());
            System.out.printf("Imposto devido: R$ %.2f%n", tax.netTax());
            System.out.println();
        }


        sc.close();
    }
}
