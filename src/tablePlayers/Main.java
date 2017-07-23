package tablePlayers;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	private static boolean checkPlayers(int n) {
		if (n < 1) {
			System.out.println("Musi być przynajmniej jeden gracz."
					+ "\n Wprowadź liczbę graczy (od 1 do 4).");
			return false;
		} else if (n > 4) {
			System.out.println("Za dużo. Wprowadź liczbę graczy (od 1 do 4).");
			return false;
		}

		return true;
	}

	private static int readNumberOfPlayers() {
		boolean check = false;
		int numberOfPlayers = -1;

		while (!check) {
			try {
				numberOfPlayers = Integer.parseInt(sc.next());
				check = checkPlayers(numberOfPlayers);
			} catch (NumberFormatException e) {
				System.out.println("Nieprawidłowe dane. "
						+ "\n Wprowadź liczbę graczy (cyfra od 1 do 4).");
			}
		}
		return numberOfPlayers;
	}
	
	



	private static void createPlayersList(Table table, int numberOfPlayers) {
		while (table.getNumberOfPlayers() < numberOfPlayers) {
			System.out.println("Podaj imię " + (table.getNumberOfPlayers() + 1)
					+ " gracza.");
			String namePl = sc.next();
			if (!table.checkName(namePl)) {
				System.out.println("Masz już tego gracza.");
			} else {
				Player player = new Player(namePl);
				table.addPlayer(player);
			}
		}
	}

	public static void main(String[] args) throws Exception {
 
		System.out.println("Podaj nazwę stolika.");
		String nameTable = sc.next();
		System.out.println("Podaj liczbę graczy.");

		int numberOfPlayers = readNumberOfPlayers();
		Table table = new Table(nameTable);
		
		createPlayersList(table, numberOfPlayers);

		

		System.out.println("Utworzono stolik o nazwie: " + table.getNameTable()
				+ ", ID nr: " + table.getUniqueID() + ", liczba graczy "
				+ table.getNumberOfPlayers() + "."
				+ "\n Dane zapisano do pliku pod nazwą records.txt.");

		table.recordToFile(args[0]);
	}

}
