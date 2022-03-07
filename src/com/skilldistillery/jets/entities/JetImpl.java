package com.skilldistillery.jets.entities;

class JetImpl extends Jet {

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		double maximumFlightTime = (getRange() / getSpeed());
		System.out.println("Now flying, this jet can fly for" + maximumFlightTime);	
	}

}
