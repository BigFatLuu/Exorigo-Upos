package tablePlayers;

import java.util.ArrayList;
import java.util.List;
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

	private static boolean checkName(String namePl, List<Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
			if (namePl.equals(((Player) playerList.get(i)).getPlayerName())) {
				return false;
			}
		}
		return true;
	}

	private static List<Player> createPlayersList(int numberOfPlayers) {
		List<Player> playersList = new ArrayList<Player>();
		while (playersList.size() < numberOfPlayers) {
			System.out.println("Podaj imię " + (playersList.size() + 1)
					+ " gracza.");
			String namePl = sc.next();
			if (!checkName(namePl, playersList)) {
				System.out.println("Masz już tego gracza.");
			} else {
				Player player = new Player(namePl);
				playersList.add(player);
			}
		}
		return playersList;
	}

	public static void main(String[] args) throws Exception {
 
		System.out.println("Podaj nazwę stolika.");
		String nameTable = sc.next();
		System.out.println("Podaj liczbę graczy.");

		int numberOfPlayers = readNumberOfPlayers();

		List<Player> playersList = createPlayersList(numberOfPlayers);

		Table table = new Table(nameTable, playersList);

		System.out.println("Utworzono stolik o nazwie: " + table.getNameTable()
				+ ", ID nr: " + table.getUniqueID() + ", liczba graczy "
				+ playersList.size() + "."
				+ "\n Dane zapisano do pliku pod nazwą records.txt.");

		table.recordToFile(args[0]);
	}

}
