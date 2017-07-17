package tablePlayers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

public class Table {
	private final String nameTable;
	private final List<Player> playersList;
	private final UUID uniqueID;

	public Table(String nameTable, List<Player> playersList) {
		super();
		this.nameTable = nameTable;
		this.playersList = playersList;
		uniqueID = UUID.randomUUID();
	}

	public String getNameTable() {
		return nameTable;
	}

	public int getNumberOfPlayers() {
		return playersList.size();
	}

	public List<Player> getPlayersList() {
		return playersList;
	}

	public UUID getUniqueID() {
		return uniqueID;
	}


	public void recordToFile(String fileName) throws IOException {
		PrintWriter record = null;
		try {
			FileWriter file = new FileWriter(fileName, true);
			record = new PrintWriter(file);
			record.println("Nazwa stolika: " + nameTable);
			record.println("ID stolika: " + uniqueID);
			record.println("Ilość graczy: " + playersList.size());
			for (Player p : playersList) {
				record.println(p.getPlayerName());
			}
			record.println("*****"+ "\n");

		} finally {
			if (record != null)
				record.close();
		}
	}
}
