public class Game {

	private Board board;
	private int generation;

	public Game(Board board, int generation) {
		this.board = board;
		this.generation = generation;
	}

	public void play() {
		// Función con complejidad cuadrática
		while (generation > 0) {
			for (int i = 0; i < this.board.getRows(); i++) {
				for (int j = 0; j < this.board.getColumns(); j++) {
					board.nextGeneration(i, j);
				}
			}
			System.out.println(board.showBoard());
			generation--;
		}
	}
}
