import java.awt.Font;
import java.awt.Frame;
import java.awt.Stroke;
import java.awt.image.BufferStrategy;

public class Pong {
	
	/*
	 * initialization of useful variables 
	 */
	public static final String GAME_NAME = "PONG!";
    private static final int GAME_WIDTH = 300;
    private static final int GAME_HEIGHT = 200;
    private static final int GAME_FPS = 60;
    private static final int PADDLE_HEIGHT = 60;
    private static final int PADDLE_HALFWIDTH = 5;
    private static final float PADDLE_SPEED = 2f;
    private static final float BALL_RADIUS = 5;
    private static final float BALL_SPEED_INCREASE = 1.05f;
    private static final int GFX_SPACER = 10;
    private static final int SCORE_TO_WIN = 5;
    private static final int INTERPOINT_DELAY = GAME_FPS;
    private static final int INTERGAME_DELAY = 3 * GAME_FPS;
    
    private Frame window;
    private BufferStrategy bufStrat;
    private boolean[] keys;

    private Font titleFont;
    private Font menuFont;
    private Font scoreFont;
    private Font winnerFont;
    private Stroke centreStroke;

    private boolean finished;

    private int timer;
    private long timeThen, timeNow, timeLate;

    private enum GameState { MENU, INGAME, POINTSCORED, WINNER };
    private GameState state;


    private float playerLY, playerRY;
    private float ballX, ballY, ballVX, ballVY;
    private int playerLScore, playerRScore;
    private boolean singlePlayer;

	
	public Pong() {
        init();
        run();
        quit();
    }
	
	private void quit() {
		
	}

	private void run() {
		
	}

	private void init() {
		
	}

	public static void main() {
	    Pong pong = new Pong();
	}
}
