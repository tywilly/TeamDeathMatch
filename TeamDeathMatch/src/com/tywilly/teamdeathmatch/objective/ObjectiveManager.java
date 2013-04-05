package com.tywilly.teamdeathmatch.objective;

import java.util.ArrayList;

public class ObjectiveManager {

	
	private static ObjectiveManager instance;
	private ArrayList<Objective> ObjectivesList = new ArrayList<Objective>();
	
	public ArrayList<Objective> getObjectivesList(){
		return ObjectivesList;
	}
	
	public void addFlag(Objective obj){
		ObjectivesList.add(obj);
	}
	
	public void removeFlag(Objective obj){
		
		if(ObjectivesList.contains(obj)){
			ObjectivesList.remove(obj);
		}
		
	}
	
	public static ObjectiveManager getInstance(){
		
		if(instance == null){
			instance = new ObjectiveManager();
		}
		
		return instance;
	}
	
}
