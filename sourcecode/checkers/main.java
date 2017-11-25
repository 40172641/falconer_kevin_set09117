package checkers;

public class main {

	public static void main(String[] args) {
		//
		Board board = new Board();
		Game game = new Game(board);
		game.gameInProgress = true;
		game.gameLoop();
	}

}
