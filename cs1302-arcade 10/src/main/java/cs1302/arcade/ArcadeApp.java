
package cs1302.arcade;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.lang.Integer;
import java.time.LocalTime;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javax.swing.*;
import javafx.scene.Group;  
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.event.*;
import java.util.*;


/**
 * In the following class, I created a snake and sudoku,
 * within a set GUI as well as populating the GUI with random
 * food objects which increase the length of the snake.
 *
 * @author Stephen Embler&Shuhan Yang
 * @version 66
 */
public class ArcadeApp extends Application {

    Random rng = new Random();
    int scoreNum = 0;
    int row, col;
    GridPane playArea;
    Button[] numbers = new Button[]{
                                         new Button("1"), new Button("2"), new Button("3"),
                                         new Button("4"), new Button("5"), new Button("6"),
                                         new Button("7"), new Button("8"), new Button("9")
        };//buttons for people to use to play game
    Button[][] playNumbers;//buttons in the game field
    int[][][] board;
    Label score;
    GridPane buttonField;
    Timeline timeline;
    private boolean gameRunning = true;
    Circle circ1 = new Circle();
    Circle snakeFood = new Circle();
    ArrayList<Circle> circle = new ArrayList<Circle>();
    private Group group = new Group();
    private HBox hbox0 = new HBox();
    private int z=2, s = 0, lives = 3, highScore = 0, t = 0, apple = 0,
	 ranger = 0;
    private double i = 220.0, x0, y0, x1, y1;
    private KeyFrame keyFrame;
    private Menu blank0, changeDiff, ease, fileButton, helpButton, optionsButton,
	scoreMenu, livesMenu;
    private MenuBar menuBar = new MenuBar();
    private MenuItem about, easy, exitButton, hard, medium;
    private Scene snakeScene;
    private Stage snakeStage = new Stage();
    private String diffLVL = "BEGINNER", score0, directions = "";
    private Timeline timeline0 = new Timeline();





    @Override
    public void start(Stage stage) {

	HBox hbox = new HBox();           // main container
	Button snake = new Button("SNAKE");
	Button sudoku = new Button("SUDOKU");
        hbox.getChildren().addAll(snake,sudoku);
	hbox.setMargin(snake,new Insets(10));
	hbox.setMargin(sudoku,new Insets(10));
	snake.setOnAction( e -> playSnake() );
	sudoku.setOnAction( e -> playSudoku() );
	snake.setPadding(new Insets(30));
	sudoku.setPadding(new Insets(30));
	hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox, 300, 200);
        stage.setTitle("cs1302-arcade!");
        stage.setScene(scene);
	stage.sizeToScene();
        stage.show();
	
	
    } // start

     /**
     *      
     * This Method is to play Sudoku game.
     *
     */
    private void playSnake(){
	initialDialog();
	initialAssortment();
	fileAndExit();
	changingDifficulty();
	helpAbout();
	assortedMenus();
	difficultyRating();
	//EventHandler that controls the movement of the snake.
	EventHandler<ActionEvent> handler = event-> {
	    directMovements();
	};
	//i is set based on the difficulty level.
	keyFrame = new KeyFrame(Duration.millis(i), handler); 
        timeline0.setCycleCount(Timeline.INDEFINITE);
        timeline0.getKeyFrames().add(keyFrame);
	timeline0.play();
        menuBar.prefWidthProperty().bind(snakeStage.widthProperty());
        snakeStage.setTitle("cs1302-arcade!");
        snakeStage.setScene(snakeScene);
        snakeStage.sizeToScene();
        snakeStage.show();
        group.requestFocus();		



     }


     /** 
      * Reoccuring infoBox.
      * Used to display pertinent information to user.
      */
    public void infoBox(String popUpMessage, String titleMessage) {
	JOptionPane.showMessageDialog(null, popUpMessage, titleMessage,
				      JOptionPane.INFORMATION_MESSAGE);
    } // infoBox
    
    /** Displays initial instructional dialog. */
    public void initialDialog() {
	JOptionPane.showMessageDialog(null, "Welcome to Snake!\nThe exit" +
				      " can be found under FILE." +
				      "\nTo change difficulty, please look under OPTIONS.\n" +
				       "To find out more about my group, please look under HELP." +
				      "\nPlease press a directional arrow to" +
				      " begin the game! Best of luck!");
    } // initialDialog

    /** Set the max/min for the stage. */
    public void initialAssortment() {	
        snakeStage.setMaxWidth(640);
	snakeStage.setMinWidth(640);
	snakeStage.setMaxHeight(480);
	snakeStage.setMinHeight(480);
	snakeScene = new Scene(group, 640, 480);
	// This method is called to create my intial game's setup.
	initialSetup();
    } // initialAssortment

    /** Exit button. */
    public void fileAndExit() {
        fileButton = new Menu("File");
	exitButton = new MenuItem("Exit");
	exitButton.setOnAction(e -> {
		Platform.exit();
		System.exit(0);
	    }); // exitButton.setOnAction
	fileButton.getItems().add(exitButton);
	menuBar.getMenus().add(fileButton);
    } // fileAndExit

     /** Change difficulty buttons. */
    public void changingDifficulty() {
        optionsButton = new Menu("Options");
	changeDiff = new Menu("Change Difficulty");
	//Default setting.
	easy = new MenuItem("Easy");
	medium = new MenuItem("Medium");
	hard = new MenuItem("Hard");
	changeDiff.getItems().addAll(easy, medium, hard);
	optionsButton.getItems().add(changeDiff);
	menuBar.getMenus().add(optionsButton);
    } // changingDifficulty

    /** About button. */
    public void helpAbout() {
	helpButton = new Menu("Help");
	about = new MenuItem("About");
	about.setOnAction(e -> {
		// Pause timeline for when the window is displayed.
		timeline0.pause();
		infoBox("Version: 69\nGroup Name: Aviato\n\nGroup Members:\nStephen" +
				 " Embler\nShuhan Yang\n\nInstructions:\n" +
				 "The exit can be found under FILE\n"
				 + "Different difficulties can be found under" +
				 " OPTIONS\nDirectional" +
				 " arrow keys control the snake\nA directional arrow" +
				 " begins the game!", "Snake");
	    });
	helpButton.getItems().add(about);
	menuBar.getMenus().add(helpButton);
    } // helpAbout
    

    /** Initialization and declaration of assorted menus. */
    public void assortedMenus() {
	blank0 = new Menu("                               ");
	menuBar.getMenus().add(blank0);

	//Difficulty levels.
	ease = new Menu(diffLVL);
	menuBar.getMenus().add(ease);

	//Display of pertinent information.
	scoreMenu = new Menu("Score: 0");
	menuBar.getMenus().add(scoreMenu);
	livesMenu = new Menu("Lives: " + lives);
	menuBar.getMenus().add(livesMenu);
	
	hbox0.getChildren().add(menuBar);
    } // assortedMenus


    /** 
     * Buttons for changing difficulty.
     * Speed at which the ball moves is increased per difficulty setting.
     * Default setting is at Easy to help the grader.
     */
    public void difficultyRating() {
	//Easy mode. Default setting.
	easy.setOnAction(e -> {
                circ1.setCenterX(312);
		circ1.setCenterY(393);
                circ1.setRadius(10);
		
		i = 220.0;
		ease.setText("BEGINNER");
		resetOnDiffChange();
	    });
	//Medium mode.
	medium.setOnAction(e -> {
		circ1.setCenterX(312);
                circ1.setCenterY(393);
                circ1.setRadius(10);

		i = 200.0;
                t=1;
                ease.setText("INTERMEDIATE");
		resetOnDiffChange();
            });
	//Hard mode.
        hard.setOnAction(e -> {
                circ1.setCenterX(312);
                circ1.setCenterY(393);
                circ1.setRadius(10);
		
		i=175.0;
                t=2;
		ease.setText("EXPERT");
		resetOnDiffChange();
	    });
	circle.clear();
	circle.add(circ1);
    } // difficultyRating


    /** 
     * Reset specific stored values.
     * These values are specific to a change in difficulty.
     */
     public void resetOnDiffChange() {
	lives = 3;
	// apple is equivalent to score.
	apple = 0;
	highScore = 0;
	// Display these changes.
	livesMenu.setText("Lives: " + lives);
	scoreMenu.setText("Score: " + apple);
    } // resetOnDiffChange
   
    
    /** 
     * The user dies.
     * Display messages depending on lives spent.
     */
     public void lossOfLife() {
	lives--;
	//Sets the highScore.
	if(apple > highScore) {
	    highScore = apple;
	} // if
	//If you have faced the ultimate death.
	if(lives == 0) {
	    gameRunning = false;
	    timeline0.pause();
	    infoBox("I'm terribly sorry\nYou've lost!\nYour highscore is: "
			     + highScore +
			     "\nYou have no lives left!", "YOU HAVE BEEN DEFEATED");
	    gameRunning = true;
	    Platform.exit();
	    System.exit(0);
	} // if
        //Ahhh, it's just a flesh wound.
	else {
	    gameRunning = false;
	    timeline0.pause();
	    infoBox("No worries! Keep at it! \nYour highscore is: " + highScore +
			     "\nYou have this many lives left: " + lives, "A TEMPORARY SETBACK!");
	    livesMenu.setText("Lives: " + lives);
	    apple = 0;
	    scoreMenu.setText("Score: " + apple);
	    gameRunning = true;
	    // Reset the game.
	    initialSetup();
	} // else
     } // lossOfLife
	    
    
    /**
     * Determine the difficulty.
     * Construct initial setup appropriately.
     */
     public void initialSetup() {
	//Medium difficulty.
	if(t == 1) {
	    circ1.setCenterX(312);
	    circ1.setCenterY(393);
	    circ1.setRadius(10);
	    snakeFood.setCenterX(rng.nextInt(400) + 100);
	    snakeFood.setCenterY(rng.nextInt(200) + 100);
	    snakeFood.setRadius(3);
	    i = 200.0;
	    snakeStage.sizeToScene();
	    timeline0.pause();
	} // if
	//Hard difficulty.
	else if(t == 2) {
	    circ1.setCenterX(312);
	    circ1.setCenterY(393);
	    circ1.setRadius(10);
	    snakeFood.setCenterX(rng.nextInt(400) + 100);
	    snakeFood.setCenterY(rng.nextInt(200) + 100);
	    snakeFood.setRadius(3);
	    i=175.0;
	    snakeStage.sizeToScene();
	    timeline0.pause();
	} // else if
	//Default setting. Easy difficulty.
	else {
	    circ1.setCenterX(312);
	    circ1.setCenterY(393);
	    circ1.setRadius(10);	    
	    snakeFood.setCenterX(rng.nextInt(400) + 100);
	    snakeFood.setCenterY(rng.nextInt(200) + 100);
	    snakeFood.setRadius(3);
	    i = 220.0;
	    snakeStage.sizeToScene();
	    timeline0.pause();
	} // else
	circle.clear();
	circle.add(circ1);
	group.getChildren().clear();
	group.getChildren().addAll(hbox0, snakeFood, circ1);
    } // initialSetup

     /** Helper method for directMovements(). */
    public void directMoveHelper() {
	for(int l = 1;l < circle.size();l++) {
	    x1=circle.get(l).getCenterX();
	    y1=circle.get(l).getCenterY();
	    circle.get(l).setCenterX(x0);
	    circle.get(l).setCenterY(y0);
	    x0=x1;
	    y0=y1;
	} // for
	nomNomNom();
    } // directMoveHelper

    
    /** 
    * First part of directMovements. 
    * Broken apart to accomodate method size. 
    */
    public void directMovementsOne() {
	if(directions.equalsIgnoreCase("left")) {
	    if((circ1.getCenterX() + circ1.getRadius()) > 21) {
		x0 = circ1.getCenterX();
		y0 = circ1.getCenterY();
		circ1.setCenterX(circ1.getCenterX() - 20);
		//Call my helper method.
		directMoveHelper();
		//Check if snake hits itself.
		eatTheTail();
	    } // if
	    else {
		//If the snake goes out of bounds.
		lossOfLife();
	    } // else
	} // if
	if(directions.equalsIgnoreCase("right")) {
	    if((circ1.getCenterX() + circ1.getRadius()) < 639) {
		x0 = circ1.getCenterX();
		y0 = circ1.getCenterY();
		circ1.setCenterX(circ1.getCenterX() + 20);
		//Call my helper method.
		directMoveHelper();
		//Check if snake hits itself.
		eatTheTail();
	    } // if
            else {
		//If the snake goes out of bounds.
		lossOfLife();
	    } // else	    
	} //  if
    } // directMovementsOne

    /** 
     * Movement of my snake.
     * Movement is based off the KeyCode derived from my setOnKeyPressed.
     */
     public void directMovements() {
	//Get my setOnKeyPressed.
	movement();
	//I call the first part of this method.
	directMovementsOne();
	if(directions.equalsIgnoreCase("up")) {
	    if((circ1.getCenterY() + circ1.getRadius() - 20) < 49) {
		//Out of bounds.
		lossOfLife();
	    } // if
            else {
		x0 = circ1.getCenterX();
		y0 = circ1.getCenterY();
		circ1.setCenterY(circ1.getCenterY() - 20);
		 //Call my helper method.
		directMoveHelper();
		//Check if snake hits itself.
		eatTheTail();
	    } // else	    
	} // if
	if(directions.equalsIgnoreCase("down")) {
	    if((circ1.getCenterY() + circ1.getRadius()) > 479) {
		//Out of bounds.
		lossOfLife();
	    } // if
            else {
		x0 = circ1.getCenterX();
		y0 = circ1.getCenterY();
		circ1.setCenterY(circ1.getCenterY() + 20);
		//Call my helper method.
		directMoveHelper();
		//Check if snake hits itself.
		eatTheTail();
	    } // else	    
	} // if
    } // directMovements
 
    /** 
     * Accept my setOnKeyPressed.
     * I use this in my directMovements method.
     */
    public void movement() {
	group.setOnKeyPressed((e)->{
		if(e.getCode() == KeyCode.LEFT) {
		    if(!(directions.equalsIgnoreCase("right"))) {
			directions = "left";
			timeline0.play();
		    } // if
		} // if 
		if(e.getCode() == KeyCode.RIGHT) {
		    if(!(directions.equalsIgnoreCase("left"))) {
			directions = "right";
			timeline0.play();
		    } // if
		} // if 
		if(e.getCode() == KeyCode.DOWN) {
		    if(!(directions.equalsIgnoreCase("up"))) {
			directions = "down";
			timeline0.play();
		    } // if
		} // if
		if(e.getCode() == KeyCode.UP) {
		    if(!(directions.equalsIgnoreCase("down"))) {
			directions = "up";
			timeline0.play();
		    } // if
		} // if
	    });
    } // movement 

   /**
    * Snake eats food.
    * Make the snake longer, randomly generate more food.
    */
    public void nomNomNom() {
	if(circ1.intersects(snakeFood.getBoundsInLocal())) {
	    //Score is increased.
	    apple++;
	    scoreMenu.setText("Score: " + apple);
	    group.getChildren().remove(snakeFood);
	    // Randomly generate more food.
	    snakeFood = new Circle();
	    snakeFood.setCenterX(rng.nextInt(400) + 100);
	    snakeFood.setCenterY(rng.nextInt(200) + 100);
	    snakeFood.setRadius(3);
	    group.getChildren().add(snakeFood);
	    //Make my snake grow.
	    growSnake();
	    snakeStage.sizeToScene();
	} // if
    } // nomNomNom


    /**
     * Snake grows.
     * Position the new portion of the snake's length.
     */    
     public void growSnake() {
	//New portion of the snake.
	Circle newCircle = new Circle();
	//If the head is moving left.
	if(directions.equalsIgnoreCase("left")) {
		newCircle.setCenterX((circle.get(circle.size()-1).getCenterX() +
				      circle.get(circle.size()-1).getRadius()*2));
		newCircle.setCenterY((circle.get(circle.size()-1).getCenterY()));
	} // if
	//If the head is moving right.
	if(directions.equalsIgnoreCase("right")) {
		newCircle.setCenterX((circle.get(circle.size()-1).getCenterX() -
				      circle.get(circle.size()-1).getRadius()*2));
		newCircle.setCenterY((circle.get(circle.size()-1).getCenterY()));
	} // if
        //If the head is moving up.
	if(directions.equalsIgnoreCase("up")) {
		newCircle.setCenterY((circle.get(circle.size()-1).getCenterY() +
				      circle.get(circle.size()-1).getRadius()*2));
		newCircle.setCenterX((circle.get(circle.size()-1).getCenterX()));
	} // if
	//If the head is moving down.
	if(directions.equalsIgnoreCase("down")) {
		newCircle.setCenterY((circle.get(circle.size()-1).getCenterY() -
				      circle.get(circle.size()-1).getRadius()*2));
		newCircle.setCenterX((circle.get(circle.size()-1).getCenterX()));
	} // if
	newCircle.setRadius(10);
	circle.add(newCircle);
	group.getChildren().add(newCircle);
    } // growSnake

     /** Eventuality of snake hitting itself. */
    public void eatTheTail() {
	if(circle.size() > 1) {
	    for(int l = 1;l < circle.size();l++) {
		if((circ1.intersects(circle.get(l).getBoundsInLocal())) &&
		   l > 3 && (circ1.getCenterX() - circle.get(l).getCenterX()) < 17) {
		    System.out.println(l);
		    lossOfLife();
		} // if
	    } // for
	} // if
    } // eatTheTail


    

    /**
     *
     * This Method is to play Sudoku game.
     *
     */
    private void playSudoku(){
	HBox h = new HBox();//to contain vbox and gridpane.
	playArea = new GridPane();
	playNumbers = new Button[9][9];
	setInitial();//make the basic board
	setInitialBoard();
	VBox v = new VBox();//to contain score and number buttons.
	score = new Label( "Score: " + scoreNum);
	buttonField = new GridPane();
	int count = 0;
	for(int i = 0; i < 3; i++){
		for (int j = 0; j < 3; j++){
			buttonField.add(numbers[count],j,i);
			setPlayArea(count, row, col);
			count++;
		}
	}
	setScore();
	setGridStyle();
	v.getChildren().addAll(score, buttonField);
	v.setMargin(score, new Insets(40));
	h.getChildren().addAll(playArea, v);
	h.setMargin(playArea,new Insets(20));
	Stage sudokuStage = new Stage();
	sudokuStage.initModality(Modality.APPLICATION_MODAL);
	Scene sudokuScene = new Scene(h,500,400);
	sudokuStage.setTitle("SUDOKU");
	sudokuStage.setScene(sudokuScene);
	sudokuStage.sizeToScene();
	sudokuStage.setOnCloseRequest( e -> {
		timeline.stop();
	});
	sudokuStage.show();
    }//playSudoku

    /**
     *This is to set all values in the play board.
     *
     */	
    private void setInitialBoard(){
	int random = rng.nextInt(3);
	for(int i = 0; i < 9; i++){
	        for (int j = 0; j < 9; j++){
                        playNumbers[i][j] = new Button(Integer.toString(board[random][i][j]));
                        playNumbers[i][j].setStyle("-fx-background-color: #A78732;");
                }//for
        }//for
        for(int i = 0; i < 30; i++){
                playNumbers[rng.nextInt(9)][rng.nextInt(9)].setText("  ");
        }
        for(int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                        playArea.add(playNumbers[i][j],i,j);
                        if (playNumbers[i][j].getText()=="  "){
                             setRowAndCol(i,j);
                             playNumbers[i][j].setStyle( "-fx-background-color: #DFB951;");
                        }
                }
        }
    }

    /**
     *This is to keep track of time so people have score.
     *
     */  
    private void setScore(){
	long startTime = System.currentTimeMillis();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), e -> {
                score.setText("Score: " + (System.currentTimeMillis()-startTime)/1000.00);

        });
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
     }

    /**
     *This is for styling in Grid pane.
     */
     private void setGridStyle(){
        playArea.setStyle(
                 "-fx-control-inner-background; "
                + "-fx-background-insets: 2, 2; " 
                + "-fx-padding: 4; "
                + "-fx-grid-lines-visible: true;");
        buttonField.setStyle(
		 "-fx-control-inner-background; "
                + "-fx-background-insets: 2, 2; "
                + "-fx-padding: 4; "
                + "-fx-grid-lines-visible: true;");
	playArea.setAlignment(Pos.CENTER);
        buttonField.setAlignment(Pos.CENTER);

     }
    /**
     *      
     *This method is for set row and column.
     *                
     */
    private void setRowAndCol(int i, int j){
	playNumbers[i][j].setOnAction(event -> {
               row = i;
               col = j;
	      // System.out.println(playNumbers[i][j].getText());
               
	});

    }
    
    /**
     *
     * This is the complete sudoku.
     */
    
    private void setInitial(){
	board = new int[][][] { 
			{ {3,1,6,5,2,4,8,7,9}, {9,5,8,7,1,3,4,2,6}, {2,4,7,6,8,9,1,3,5},
			  {5,3,1,4,9,2,6,8,7}, {8,2,9,1,7,6,5,4,3}, {7,6,4,3,5,8,2,9,1},
			  {1,9,5,8,4,7,3,6,2}, {4,7,3,2,6,5,9,1,8}, {6,8,2,9,3,1,7,5,4} },
			{ {7,1,2,9,8,4,3,5,6}, {5,3,4,1,6,7,2,8,9}, {9,6,8,3,5,2,7,1,4},
			  {2,8,1,5,3,9,6,4,7}, {6,7,3,2,4,1,5,9,8}, {4,5,9,6,7,8,1,2,3},
			  {8,4,5,7,2,6,9,3,1}, {1,2,6,4,9,3,8,7,5}, {3,9,7,8,1,5,4,6,2} },
			{ {2,1,8,7,5,3,4,9,6}, {4,3,6,2,9,1,8,5,7}, {9,7,5,4,6,8,3,2,1},
			  {1,9,4,6,3,2,7,8,5}, {8,5,2,1,7,9,6,3,4}, {3,6,7,5,8,4,2,1,9},
			  {5,4,1,8,2,6,9,7,3}, {7,8,3,9,4,5,1,6,2}, {6,2,9,3,1,7,5,4,8} }
		};
    }	

    /**
     *This is to check if it's a completed sudoku.
     */
    private boolean checkWin(){
            for(int i = 0;i < 9;i++){
                    for(int j = 0; j < 9;j++){
                            if(playNumbers[i][j].getText() == "  "){
                                return false;
                            }
                    }
            }//too check if it's full
	    for(int i = 0;i < 9;i++){
            	if(!(checkRow(i)&&checkCol(i))){
			return false;
		}
		
	    }//i
	    for(int i = 0; i < 3; i++){
		for(int j = 0; j < 3; j++){
			if(!(checkSquare(i*3,j*3))){
                        	return false;
                	}
		}
	    }
        return true;
    }
  
    /**
     *This is to check if every number is contained in row r.
     */
    private boolean checkRow(int r){
        boolean hasNum = false;
	for(int num = 1; num < 10; num++){
		for(int c = 0; c < 9; c++){
			if(playNumbers[r][c].getText().equals(Integer.toString(num))){
				hasNum = true;
			}
		}
		if (!hasNum){
			return false;
		}
	}
	return true;
    }

   /**
    * This is to check if every number is contained in col c.
    */
   private boolean checkCol(int c){
        boolean hasNum = false;
        for(int num = 1; num < 10; num++){
                for(int r = 0; r < 9; r++){
                        if(playNumbers[r][c].getText().equals(Integer.toString(num))){
                                hasNum = true;
                        }
                }
                if (!hasNum){
                        return false;
                }
        }
        return true;
    }

    /**
     *This is the check the 3x3 square.
     */		
    private boolean checkSquare(int r, int c){
	boolean hasNum = false;
	for(int num = 1; num < 10; num++){
	    for(int k = r; k < r+3; k++){
         	for(int l = c; l < c+3; l++){
                	if(playNumbers[k][l].getText().equals(Integer.toString(num))){
                                hasNum = true;
                        }
                }
	    }               
            if (!hasNum){           
                   return false;
            }//if

	}//for
	return true;
    }
    /**
     *
     *This method is for set Text to the right place.
     *
     */
    private void setPlayArea(int count, int row, int col){
	numbers[count].setOnAction(e -> {
		int[] rowAndCol = getRowAndCol();
		int row1 = rowAndCol[0];
		int col1 = rowAndCol[1];
		playArea.getChildren().remove(playNumbers[row1][col1]);
		playNumbers[row1][col1].setText(String.valueOf(count+1));
		playArea.add(playNumbers[row1][col1],row1,col1);
		//System.out.println("count= " +count+"row= " +row1 +" col= "+col1);
		if(checkWin()){
			Label win = new Label("Congratulations!!!");
			Scene winScene = new Scene(win, 300, 200);
			Stage winStage = new Stage();
        		winStage.setTitle("win message");
        		winStage.setScene(winScene);
        		winStage.sizeToScene();
        		winStage.show();			
		}
	});
    }    
    /**
     *This is to return row and col.
     */
    public int[] getRowAndCol(){
	int[] rowAndCol = {row,col};
	return rowAndCol;
    }

    public static void main(String[] args) {
	try {
	    Application.launch(args);
	} catch (UnsupportedOperationException e) {
	    System.out.println(e);
	    System.err.println("If this is a DISPLAY problem, then your X server connection");
	    System.err.println("has likely timed out. This can generally be fixed by logging");
	    System.err.println("out and logging back in.");
	    System.exit(1);
	} // try
    } // main

} // ArcadeApp

