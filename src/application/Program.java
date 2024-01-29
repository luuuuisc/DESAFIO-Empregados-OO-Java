package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//USANDO O GENERICS PARA ESPECIFICAR O TIPO DA MINHA LISTA
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int N = sc.nextInt();
		System.out.println();
		
		//USEI O FOR EACH PARA RODAR O INPUT N VEZES.
		for (int i=0; i<N; i++) {
			
			System.out.println("Employee #" + (i + 1) + ":");
			
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Name: ");
			
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			//PRECISO IR INSERINDO OS DADOS NA LISTA
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
			
		}
		
		
		System.out.println("Enter the employee id that will have salary increase: ");
		Integer idsalary = sc.nextInt();
		Integer pos = position(list, idsalary);
		
		if (pos == null) {
			System.out.println("This id does not exist!");
		}
		
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			//PRECISO ACESSAR NA LISTA O FUNCIONARIO ENCONTRADO NO POS E CHAMAR A FUNÇÃO PARA AUMENTAR O SALÁRIO.
			list.get(pos).increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		
		//PARA CADA EMPLOYEE EMP NA MINHA LISTA LIST EU VOU IMPRIMIR EMP
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		//COMO VER SE ESTE ID EXISTE NA LISTA? PODEMOS CRIAR UMA FUNÇÃO AUXILIAR PARA PROCURAR O ELEMENTO NA LISTA
		
		
		
		sc.close();
	}
	
	//FUNÇÃO AUXILIAR - PRECISO QUE ELA ME RETORNA A POSIÇÃO DO MEU ID NA LISTA
	
	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) { // VAI VARRER A LISTA INTEIRA
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null; // NULL - PORQUE ESTOU USANDO INTEGER SE EU USAR O INTPRECISO RETORNAR -1
	}
		
	}


