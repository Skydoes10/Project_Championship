package model;

import model.Pilots.Team;

public class Championship{
	
	//Constant
    private final static int MAX_PILOTS = 15;
	
	//Attributes
	private int year;
	private int races;
	
	//Relations
	public Pilots pilot;
	
	//Builder
	public Championship(int year, int races){
		this.year = year;
		this.races = races;
	}
	
	//Methods
	public void addPilot(String name, int age, int num, int length, int[] pScores){
		boolean error = findPilot(name);
		if(num==1 && !error) {
			pilot = new Pilots(name, age, Team.SCUDERIA_FERRARI, length, pScores);
		}
		else if(num==2 && !error) {
			pilot = new Pilots(name, age, Team.MCLAREN_F1_TEAM, length, pScores);
		}
		else if(num==3 && !error) {
			pilot = new Pilots(name, age, Team.RED_BULL_RACING, length, pScores);
		}
		else if(num==4 && !error) {
			pilot = new Pilots(name, age, Team.MERCEDES_AMG, length, pScores);
		}
		else if(num==5 && !error) {
			pilot = new Pilots(name, age, Team.RACING_POINT, length, pScores);
		}
		else if(num==6 && !error) {
			pilot = new Pilots(name, age, Team.ALFAROMEO, length, pScores);
		}
		else if(num==7 && !error) {
			pilot = new Pilots(name, age, Team.RENAULT, length, pScores);
		}
		else if(num==8 && !error) {
			pilot = new Pilots(name, age, Team.WILLIAMS, length, pScores);
		}
		
	}
	
	public boolean findPilot(String name){
		boolean error= false;
		for(int i=0; i<MAX_PILOTS && !error; i++){
			if(pilot!=null){
				if(pilot.getName().equalsIgnoreCase(name)){
					error = true;
				}
			}
		}
		return error;
	}
	
	public String showAverageTimes(String name){
		String pilotF = "";
			pilotF = "Piloto: "+name+" || Tiempo promedio: "+pilot.convertScore();
		return pilotF;
	}
	
	//setters and getters
	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setRaces(int races){
		this.races = races;
	}
	
	public int getRaces(){
		return races;
	}
	
	public String showP() {
		String out = pilot.toString();
		return out;
	}
}