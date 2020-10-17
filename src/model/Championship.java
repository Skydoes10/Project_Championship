package model;

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
		pilot = new Pilots[MAX_PILOTS];
	}
	
	//Methods
	public void addPilot(String name, int age, Team team, int length, int[] pScores){
		pilot.Pilots(name, age, team, length, pScores);
	}
	
	public void findPilot(String name){
		boolean found = false;
		for(int i=0; i<MAX_PILOTS && !found; i++){
			if(pilot!=null){
				if(pilot.getName().equalsIgnoreCase(name)){
					found = true;
				}
			}
		}
		showAverageTimes(found, name);
	}
	
	public String showAverageTimes(boolean found, String name){
		String pilotF = "";
		if(found==true){
			pilotF = "Piloto: "+name+" || Tiempo promedio: "+pilot.convertScore();
		}
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
}