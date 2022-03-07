package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.FighterJet;

public class JetsApplication {
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		AirField af = new AirField();

		af.loadAirfield();
		boolean loop = true;
		int choice = 0;
		while (loop) {
			System.out.println("------------------------------------------");
			System.out.println("1. List fleet ");
			System.out.println("2. Fly all jets     ");
			System.out.println("3. View fastest jet   ");
			System.out.println("4. View jet with the longest range                                       ");
			System.out.println("5. Transport cargo");
			System.out.println("6. Dogfight   ");
			System.out.println("7. Add a fighter jet to the fleet  ");
			System.out.println("8. Remove a jet from the fleet");
			System.out.println("9. quit");
			System.out.println("------------------------------------------");
			choice = kb.nextInt();

			JetsApplication app = new JetsApplication();

			if (choice >= 0 || choice <= 9) {
			}
			switch (choice) {
			case 1:

				af.displayAllJets();
				break;

			case 2:
				af.flying();
				break;

			case 3:
				af.fastest();

				break;

			case 4:
				af.longestRange();
				break;

			case 5:
				af.transportAllCargo();
				break;

			case 6:
				af.fjDogFight();
				break;
			case 7:
				app.createNewJet(af);
				break;

			case 8:
				af.removeJet(kb);
				break;
			case 9:
				System.out.println("Goodbye!");
				loop = false;
			default:
				System.out.println(("Invalid selection, please try again"));
				break;
			}
		}
	}

	///
	public void createNewJet(AirField af) {
		System.out.println("Please enter a model");
		String model = kb.next();
		System.out.println("Please enter a speed");
		double speed = kb.nextDouble();
		System.out.println("Please enter the range of this jet");
		int range = kb.nextInt();
		System.out.println("Please enter the price of this jet");
		long price = kb.nextLong();
		FighterJet fJ = new FighterJet(model, speed, range, price);
		af.addNewJet(fJ);
		
		kb.close();
	}

}
