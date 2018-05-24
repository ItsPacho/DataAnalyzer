package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable{
	
	ArrayList<Integer> humidityArray = new ArrayList<Integer>();
	ArrayList<Integer> velocityArray = new ArrayList<Integer>();
	ArrayList<Integer> temperatureArray = new ArrayList<Integer>();
	
	Message(ArrayList<Integer> humidityArray, ArrayList<Integer> velocityArray, ArrayList<Integer> temperatureArray){
		
		this.humidityArray = humidityArray;
		this.velocityArray = velocityArray;
		this.temperatureArray = temperatureArray;
		
	}
	
	public ArrayList<Integer> getHumidityArray(){
		return this.humidityArray;
	}
	
	public ArrayList<Integer> getVelocityArray(){
		return this.velocityArray;
	}
	
	public ArrayList<Integer> getTemperatureArray(){
		return this.temperatureArray;
	}

}
