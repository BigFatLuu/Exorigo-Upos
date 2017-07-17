package tablePlayers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static boolean checkPlayers(int n) {
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

	private static boolean checkName(String namePl, List<Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
			if (namePl.equals(((Player) playerList.get(i)).getPlayerName())) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Podaj nazwę stolika.");
		String nameTable = sc.next();
		System.out.println("Podaj liczbę graczy.");
		int numberOfPlayers = -1;

		boolean check = false;

		while (!check) {
			try {
				numberOfPlayers = Integer.parseInt(sc.next());
				check = checkPlayers(numberOfPlayers);
			} catch (NumberFormatException e) {
				System.out.println("Nieprawidłowe dane."
						+ "\n Wprowadź liczbę graczy (cyfra od 1 do 4).");
			}
		}

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

		Table table = new Table(nameTable, playersList);

		System.out.println("Utworzono stolik o nazwie: " + table.getNameTable()
				+ ", ID nr: " + table.getUniqueID() + ", liczba graczy "
				+ playersList.size() + "." + "\n Zapisano do pliku pod nazwą records.txt.");

		table.recordToFile(args[0]);
	}

}
