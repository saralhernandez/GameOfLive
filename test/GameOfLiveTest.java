import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class GameOfLiveTest {
	
	private static final String LINE_SEPARATOR = String.format("%n");

	@Test
	public void matrix1x1WithOneAliveCellsReturnOneAliveCells(){
		Board board = new Board.Builder(1, 1).build();
		this.initGame(board, Arrays.asList("."));
		StringBuilder boardNext = new StringBuilder();
	    boardNext.append("*").append(LINE_SEPARATOR);
		assertThat(board.showBoard(), is(boardNext.toString()));
	}

	@Test
	public void matrix1x2WithTwoAliveCellsReturnTwoDeadCells(){
		Board board = new Board.Builder(1, 2).build();
		this.initGame(board, Arrays.asList(".."));
		StringBuilder boardNext = new StringBuilder();
	    boardNext.append("**").append(LINE_SEPARATOR);
		assertThat(board.showBoard(), is(boardNext.toString()));
	}

	@Test
	public void matrix2x3WithFourAliveCellsReturnFiveAliveCells(){
		Board board = new Board.Builder(2, 3).build();
		this.initGame(board, Arrays.asList("...", "*.*"));
		StringBuilder boardNext = new StringBuilder();
	    boardNext.append("...").append(LINE_SEPARATOR)
	             .append(".*.").append(LINE_SEPARATOR);
		assertThat(board.showBoard(), is(boardNext.toString()));
	}

	@Test
	public void matrix4x3WithSixAliveCellsReturnFourAliveCells(){
		Board board = new Board.Builder(4, 3).build();
		this.initGame(board, Arrays.asList(".*.", "..*","*..", "***"));
		StringBuilder boardNext = new StringBuilder();
	    boardNext.append(".**").append(LINE_SEPARATOR)
	             .append(".*.").append(LINE_SEPARATOR)
			     .append(".**").append(LINE_SEPARATOR)
			     .append("***").append(LINE_SEPARATOR);
		assertThat(board.showBoard(), is(boardNext.toString()));
	}
	
	private void initGame(Board board, List<String> cells) {
		board.loadBoard(cells);
		Game game = new Game(board, 1);
		game.play();
	}

}
