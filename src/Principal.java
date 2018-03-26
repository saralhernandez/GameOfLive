
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoadData load = new LoadData();
		Game game = new Game(load.getBoard(), load.getGeneration());
		game.play();
	}

}
