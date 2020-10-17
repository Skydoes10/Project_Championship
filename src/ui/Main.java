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
				"Seleccione una opción para empezar\n" +
				"(1) Añadir un nuevo piloto\n" +
				"(2) Buscar un piloto\n" +
				"(0) Para salir"
			);
			int num = sc.nextInt();
			sc.nextLine();
			switch(num){
				case 0: System.out.println("Proceso terminado.");
					break;
				case 1: addPilots();
					break;
				case 2: findP();
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
		System.out.println("Digite el nombre del equipo al que pertenece el piloto:");
		String teamPilot = sc.nextLine().toUpperCase();
		System.out.println("Digite el tiempo que tuvo el piloto en cada carrera:");
		int[] scores;
		for(int i=0; i<mainChampionship.getRaces(); i++){
			scores = new int[mainChampionship.getRaces()];
			scores[i] = sc.nextInt();
		}
		sc.nextLine();
		mainChampionship.addPilot(namePilot, agePilot, teamPilot, mainChampionship.getRaces(), scores);
	}
	
	public void findP(){
		System.out.println("Digite el nombre del piloto a buscar");
		String nameP = sc.nextLine();
		mainChampionship.findPilot(nameP);
	}
}