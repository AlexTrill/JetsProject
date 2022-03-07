package com.skilldistillery.jets.entities;

 class TransportJet extends Jet {

	public TransportJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	
	}

	@Override
	public String toString() {
		return "Transport Jet " + "Model: " + getModel()  
				+ ", Speed: " + getSpeed() + " MPH" + ", Range: " + getRange() + " Miles, " + "Price: $" + getPrice() ;
	}

	@Override
	public void fly() {
		double maximumFlightTime = (getRange() / getSpeed());
		System.out.println("Now flying, this jet can fly for " + Math.round(maximumFlightTime * 100.0) / 100.0 + " hours at maximum speed");		
	}
  public void transportCargo() {
	  int random = (int)(Math.random() * 300);
		System.out.println(random + " pieces of cargo successfully transported by this jet");
  }
}
