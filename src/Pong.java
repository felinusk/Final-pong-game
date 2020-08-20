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
	 while(!finished) {
            logic();
            render();
            sync();
        }	
	}

	private void init() {
		
		 // setup game state
        titleFont = new Font("Verdana", Font.BOLD, 60);
        menuFont = new Font("Verdana", Font.BOLD, 10);
        scoreFont = new Font("Fixed Width", Font.BOLD, 80);
        winnerFont = new Font("Verdana", Font.BOLD, 18);
        centreStroke = new BasicStroke(BALL_RADIUS, BasicStroke.CAP_BUTT,
                                       BasicStroke.JOIN_MITER, 10f, new float[]{8f}, 0f);
        keys = new boolean[256];
        singlePlayer = false;
        state = GameState.MENU;
        resetPoint();

        // setup the game window
        window = new Frame(GAME_NAME);
        window.setIgnoreRepaint(true);
        window.setUndecorated(true);
        window.setSize(GAME_WIDTH, GAME_HEIGHT);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt){ finished = true; }
        });
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) { keys[e.getKeyCode()] = true; }
            public void keyReleased(KeyEvent e) { keys[e.getKeyCode()] = false; }
        });

        // show the window
        window.setVisible(true);
        window.requestFocus();

        // setup double buffering on the display
        window.createBufferStrategy(2);
        bufStrat = window.getBufferStrategy();
		
	}
	 /**
     * Updates the game state for a frame.
     */
    private void logic() {
        if (keys[KeyEvent.VK_ESCAPE]) {
            finished = true;
            return;
        }

        switch(state) {
            case MENU:
                updateMenu(); break;
            case INGAME:
                updateGame(); break;
            case POINTSCORED:
                updatePointScored(); break;
            case WINNER:
                updateWinner(); break;
        }
    }

	public static void main() {
	    Pong pong = new Pong();
	}
}
