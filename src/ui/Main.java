package ui;

import java.util.Scanner;
import model.Championship;

public class Main{
	
	private Championship mainChampionship;
	public Scanner sc;
	
	public Main(){
		sc = new Scanner(System.in);
		createChampionship();
	}
	
	public static void main(String[] args){	
		Main obj = new Main();
		obj.Menu();
	}
	
	public void Menu(){
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n------------------------------------------------------------------------\n" +
				"Seleccione una opción para empezar\n" +
				"(1) Añadir un nuevo piloto\n" +
				"(2) Buscar un piloto con su promedio de tiempo\n" +
				"(3) Mostrar el listado de pilotos\n" +
				"(0) Para salir\n" +
				"------------------------------------------------------------------------\n"
			);
			int num = sc.nextInt();
			sc.nextLine();
			switch(num){
				case 0: System.out.println("Proceso terminado.");
						menu = false;
					break;
				case 1: addPilots();
					break;
				case 2: findP();
					break;
				case 3: showPilots();
					break;
				default: System.out.println("Opcion no valida");
					break;
			}	
		}	
	}
	
	public void createChampionship(){
		System.out.println("Digite el año del campeonato:");
		int yearCship = sc.nextInt();
		System.out.println("Digite el numero de carreras que integran el campeonato:");
		int racesCship = sc.nextInt();
		sc.nextLine();
		mainChampionship = new Championship(yearCship, racesCship);
	}
	
	public void addPilots(){
		System.out.println("Digite el nombre del piloto:");
		String namePilot = sc.nextLine();
		System.out.println("Digite la edad del piloto:");
		int agePilot = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite el tiempo que tuvo el piloto en cada carrera:");
		int[] scores = null;
		for(int i=0; i<mainChampionship.getRaces(); i++){
			scores = new int[mainChampionship.getRaces()];
			scores[i] = sc.nextInt();
			System.out.println("Vuelva y digite el tiempo que tuvo el piloto en la sigiente carrera:");
		}
		sc.nextLine();
		boolean menu = true;
		while(menu){
			System.out.println(
				"Seleccione el equipo al que pertenece el piloto\n" +
				"(1) Scuderia Ferrari\n" +
				"(2) McLaren F1 Team\n" +
				"(3) Red Bull Racing\n" + 
				"(4) Mercedes Amg\n" + 
				"(5) Racing Point\n" + 
				"(6) Alfa Romeo\n" + 
				"(7) Renault\n" + 
				"(8) Williams\n"
			);
			int num = sc.nextInt();
			sc.nextLine();
			mainChampionship.addPilot(namePilot, agePilot, num, mainChampionship.getRaces(), scores);
			mainChampionship.findPilot(namePilot);
			menu = false;
			}
	}
	
	public void findP(){
		System.out.println("Digite el nombre del piloto a buscar");
		String nameP = sc.nextLine();
		System.out.println(mainChampionship.showAverageTimes(nameP));
	}
	
	public void showPilots() {
		System.out.println(mainChampionship.showP());
	}
}