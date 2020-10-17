package model;

public class Pilots{
	
	public enum Team{
		SCUDERIA_FERRARI, MCLAREN_F1_TEAM, RED_BULL_RACING, MERCEDES_AMG, RACING_POINT, ALFAROMEO, RENAULT, WILLIAMS;
	}
	
	//Attributes
	private String name;
	private int age;
	private Team team;
	private int[] scores;
	
	//Builder
	public Pilots(String name, int age, Team team, int length, int[] pScores){
		this.name = name;
		this.age = age;
		this.team = team;
		this.scores = pScores;
		scores = new int[length];
	}
	
	//Methods
	public double calculateAverage(){
		double averageScore = 0.0;
		for(int i=0; i<scores.length; i++){
			if(scores!=null){
				averageScore+= scores[i];
			}
		}
		averageScore = averageScore/scores.length;
		return averageScore;
	}
	
	public String convertScore(){
		String time;
		double score = calculateAverage();
		int hours, minutes, seconds;
		hours = (int) (score/3600);
		minutes = (int) ((score-(hours*3600))/60);
		seconds = (int) (score-((hours*3600)+(minutes*60)));
		time = hours+"h "+minutes+"m "+seconds+"s";
		return time;
	}
	
	//setters and getters
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Team getTeam(){
		return team;
	}
	
	public void setScores(int[] scores){
		this.scores = scores;
	}
	
	public int[] getScores(){
		return scores;
	}
}