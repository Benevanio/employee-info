import entities.Department;
import entities.HourContract;
import entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Leitura de informaçoes funcionario\n");
        Locale.setDefault(Locale.US);
        Scanner sc  = new Scanner(System.in);
        SimpleDateFormat sfdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Entre com o nome do Departamento\n");
        String departmenName = sc.nextLine();
        System.out.print("Entre com as informaçoes do Funcionario\n");
        System.out.print("Nome\n");
        String workerName = sc.nextLine();
        System.out.print("Level\n");
        String workerLevel = sc.nextLine();
        System.out.print("Salario Base\n");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, workerLevel.valueOf(workerLevel), baseSalary,new Department(departmenName));
        System.out.print("Quantos Contratos esse trabalhador tem?\n");
        int n = sc.nextInt();
        for (int i= 1; i<=n; i++){
            System.out.println("Entre com os contratos do funionario:\n" + i + "Data:\n");
            System.out.print("Dare (DD/MM/YYYY)\n");
            Date contractDate = sfdf.parse(sc.next());
            System.out.print("Valor Por hora\n");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração\n");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour, hours);
            worker.addContract(contract);

        }
        System.out.print("");
        System.out.print("Entre com o mes e o ano de contrato(MM/YYYY)\n");
        String  monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name\n" + worker.getName());
        System.out.println("Departamento\n" + worker.getDepartment().getName());
        System.out.println("Ganhos  para Calculos\n" + monthAndYear + ":"+ String.format("%.2f", worker.income(year, month)) );
        sc.close();
    }
}