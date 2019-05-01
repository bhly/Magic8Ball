import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.ImageCursor;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.media.AudioClip;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.text.*;
import java.lang.*;


public class Magic extends Application{

	private boolean bgCheck = true;
	private Image sparkle;
	private Image button;
	private double random;
	private AudioClip audio;
	
	
	public void start(Stage stage){
		stage.setTitle("Magic 8 Ball");
		stage.setResizable(false);
		
		stage.getIcons().add(new Image("file:icon.png"));
		
		sparkle = new Image("cursor.png");
		ImageCursor cursor = new ImageCursor(sparkle);
		
		button = new Image("file:button.png", 270, 100, false, false);
		ImageView view = new ImageView();	
		
		audio = new AudioClip("file:audio.mp3");
		
		BackgroundImage bg1 = new BackgroundImage(new Image("file:bg1.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			
		BackgroundImage bg2 = new BackgroundImage(new Image("file:bg2.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		BackgroundImage bg3 = new BackgroundImage(new Image("file:bg3.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		BackgroundImage bg4 = new BackgroundImage(new Image("file:bg4.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		BackgroundImage bg5 = new BackgroundImage(new Image("file:bg5.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		Pane pane = new Pane(view);
		pane.setBackground(new Background(bg1));
		
		Scene scene = new Scene(pane, 490, 600);
		scene.setCursor(cursor);
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent me){
				if(bgCheck){
					pane.setBackground(new Background(bg2));
					audio.play();
					bgCheck = false;
					view.setImage(button);
					view.setX(115);
					view.setY(490);
					
				}
			}
			
	});
		
		view.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent me){
				
				if(!bgCheck){
					random = Math.random() * 10;
					if(random <=2.24)
						pane.setBackground(new Background(bg2));
					else if(random >= 2.25 && random <= 4.99)
						pane.setBackground(new Background(bg3));
					else if(random >=5 && random <= 7.24)
						pane.setBackground(new Background(bg4));
					else
						pane.setBackground(new Background(bg5));
					audio.play();
					System.out.println(random);
					
				}
			}
		});
		
	stage.setScene(scene);
	stage.show();

	}
}