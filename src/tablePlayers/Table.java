package tablePlayers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Table {
	private final String nameTable;
	private final List<Player> playersList;
	private final UUID uniqueID;

	public Table(String nameTable) {
		super();
		this.nameTable = nameTable;
		this.playersList = new ArrayList<Player>();
		uniqueID = UUID.randomUUID();
	}

	public String getNameTable() {
		return nameTable;
	}

	public int getNumberOfPlayers() {
		return playersList.size();
	}

	public void addPlayer(Player p) {
		playersList.add(p);
	}
	public UUID getUniqueID() {
		return new UUID(uniqueID.getMostSignificantBits(), uniqueID.getLeastSignificantBits());
	}
	
	public boolean checkName(String namePl) {
		for (int i = 0; i < playersList.size(); i++) {
			if (namePl.equals(((Player) playersList.get(i)).getPlayerName())) {
				return false;
			}
		}
		return true;
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
