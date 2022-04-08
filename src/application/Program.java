package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();

		List<TaxPayer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.printf("\nDigite os dados do %do contribuinte: \n", i + 1);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			TaxPayer payer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending,
					educationSpending);
			list.add(payer);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("\nResumo do %dº contribuinte:", i + 1);
			System.out.printf("\nImposto Bruto Total: %.2f", list.get(i).grossTax());
			System.out.printf("\nAbatimento: %.2f", list.get(i).taxRebate());
			System.out.printf("\nImposto Devido: %.2f\n", list.get(i).netTax());
		}

		sc.close();
	}
}
