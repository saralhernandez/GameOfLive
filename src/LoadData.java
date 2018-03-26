import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadData {

	private Board board;
	private int boardRows;
	private int generation;
	private int boardColumns;
	private List<String> loadFile;
	private final static int ROWS = 1;
	private final static int COLUMNS = 0;
	private final static int GENERATION = 2;
	private final static int FIRST_ROW_OF_FILE = 0;
	private final static String URL = "Resource/InitialDataGameOfLive";
	
	public LoadData() {
		try {
			loadFile = Files.readAllLines(Paths.get(URL));
			boardRows = Integer.parseInt(String.valueOf(loadFile.get(FIRST_ROW_OF_FILE).charAt(ROWS)));
			generation = Integer.parseInt(String.valueOf(loadFile.get(FIRST_ROW_OF_FILE).charAt(GENERATION)));
			boardColumns = Integer.parseInt(String.valueOf(loadFile.get(FIRST_ROW_OF_FILE).charAt(COLUMNS)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Board getBoard() {
		loadFile.remove(FIRST_ROW_OF_FILE);
		this.board = new Board.Builder(boardRows, boardColumns).build();
		this.board.loadBoard(loadFile);
		System.out.println(this.board.showBoard());
		return this.board;
	}

	public int getGeneration() {
		return generation;
	}
}
