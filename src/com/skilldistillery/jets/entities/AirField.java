package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirField {

	// String [] allJets = new String[5];
	private List<Jet> jetFleet = new ArrayList<>();

	public AirField() {
		super();
	}

	public void loadAirfield() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetFields = line.split(",");

				if (jetFields[0].contentEquals("Fighter Jet")) {
					String name = jetFields[1];
					double speed = Double.parseDouble(jetFields[2]);
					int range = Integer.parseInt(jetFields[3]);
					long price = Long.parseLong(jetFields[4]);
					FighterJet FJ = new FighterJet(name, speed, range, price);
					jetFleet.add(FJ);

				}

				else if (jetFields[0].contentEquals("Transport Jet")) {
					String name = jetFields[1];
					double speed = Double.parseDouble(jetFields[2]);
					int range = Integer.parseInt(jetFields[3]);
					long price = Long.parseLong(jetFields[4]);
					TransportJet TJ = new TransportJet(name, speed, range, price);
					jetFleet.add(TJ);
				}

				else {
					String name = jetFields[1];
					double speed = Double.parseDouble(jetFields[2]);
					int range = Integer.parseInt(jetFields[3]);
					long price = Long.parseLong(jetFields[4]);
					JetImpl IJ = new JetImpl(name, speed, range, price);
					jetFleet.add(IJ);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	/// Adds new jet to the fleet
	public void addNewJet(Jet j) {
		jetFleet.add(j);
	}

	public void displayAllJets() {
		for (Jet jet : jetFleet) {
			System.out.println(jet);
		}
	}

	public void removeJet(Scanner kb) {
		System.out.println("Please select which jet you would like to remove from the fleet: ");
		int choice = 1;
		for (int i = 0; i < jetFleet.size(); i++) {

			System.out.println(choice + " " + jetFleet.get(i).getModel());
			choice++;
		}
		int input = kb.nextInt();
		jetFleet.remove(input - 1);
	}

	// Flying method that displays entire jet fleet plus fly method.

	public void flying() {
		for (Jet jet : jetFleet) {
			System.out.println(jet);
			jet.fly();
			System.out.println("\n");
		}

	}

	// Fastest method that loops through jets and compares each one to determine
//		which one is the fastest
	public void longestRange() {

		Jet longestRange = jetFleet.get(0);
		for (int i = 0; i < jetFleet.size(); i++) {
			if (jetFleet.get(i).getRange() > longestRange.getRange()) {
				longestRange = jetFleet.get(i);

			}

		}
		System.out.println("The jet with the longest range is " + longestRange);
	}

	public void fastest() {
		Jet highestSpeed = jetFleet.get(0);
		for (int i = 0; i < jetFleet.size(); i++) {
			if (jetFleet.get(i).getSpeed() > highestSpeed.getSpeed()) {
				highestSpeed = jetFleet.get(i);

			}
		}
		System.out.println("The fastest jet in the fleet is " + highestSpeed);
	}

	public void fjDogFight() {
		for (int i = 0; i < jetFleet.size(); i++) {
			if (jetFleet.get(i) instanceof FighterJet) {
				FighterJet FJs = (FighterJet) jetFleet.get(i);
				System.out.println(jetFleet.get(i));
				FJs.dogFight();
			}
		}
	}

	public void transportAllCargo() {
		for (int i = 0; i < jetFleet.size(); i++) {
			if (jetFleet.get(i) instanceof TransportJet) {
				TransportJet TJs = (TransportJet) jetFleet.get(i);
				System.out.println(jetFleet.get(i));
				TJs.transportCargo();
			}
		}
	}
}
