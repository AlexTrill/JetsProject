package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "Fighter Jet " + "Model: " + getModel() + ", Speed: " + getSpeed() + " MPH, " + "Maximum Range: " + getRange() + " Miles, " 
				 + "Price: $" + getPrice() ;
	}

	@Override
	public void fly() {
		double maximumFlightTime = (getRange() / getSpeed());
		System.out.println("Now flying, this jet can fly for " + Math.round(maximumFlightTime * 100.0) / 100.0  + " hours at maximum speed");
		
	}
   public void dogFight() {
	   int random = (int)(Math.random() * 50);
		System.out.println("Mission successful " + random + " enemy fighters downed.");
   }
}
