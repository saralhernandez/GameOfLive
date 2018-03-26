import java.util.List;

public final class Board {

	private final int rows;
	private final int columns;
	private final Cell[][] cells;
	private static final char DEAD_CELL = '*';
	private static final char ALIVE_CELL = '.';
	private static final String LINE_SEPARATOR = String.format("%n");

	private Board(Builder builder) {
		cells = builder.board;
		columns = builder.columns;
		rows = builder.rows;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	public static class Builder {

		private Cell[][] board;
		private int columns;
		private int rows;

		public Builder(int rows, int columns) {
			this.rows = rows;
			this.columns = columns;
			this.board = new Cell[this.rows][this.columns];
		}

		public Board build() {
			return new Board(this);
		}
	}

	public void loadBoard(List<String> loadFile) {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				cells[i][j] = loadFile.get(i).charAt(j) == DEAD_CELL ? Cell.DEAD : Cell.ALIVE;
			}
		}
	}

	public void nextGeneration(int x, int y) {
		int countAlive = 0;
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < 8; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < this.cells.length && ny < this.cells[nx].length) {
				if (this.cells[nx][ny] == Cell.ALIVE) {
					countAlive++;
				}
			}
		}
		this.cells[x][y] = this.cells[x][y].validate(countAlive);
	}

	public String showBoard() {
		StringBuilder boardCell = new StringBuilder();
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				boardCell.append(cells[i][j] == Cell.DEAD ? DEAD_CELL : ALIVE_CELL);
			}
			boardCell.append(LINE_SEPARATOR);
		}
		return boardCell.toString();
	}
}
