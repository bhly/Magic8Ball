import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.ImageCursor;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
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
	
	
	public void start(Stage stage){
		stage.setTitle("Magic 8 Ball");
		
		stage.getIcons().add(new Image("file:icon.png"));
		
		sparkle = new Image("cursor.png");
		ImageCursor cursor = new ImageCursor(sparkle);
		
		button = new Image("file:button.png");
		ImageView view = new ImageView();	
		
		BackgroundImage bg1 = new BackgroundImage(new Image("file:bg1.png", 600, 700, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			
		BackgroundImage bg2 = new BackgroundImage(new Image("file:bg2.png", 600, 700, false, true), BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		Pane pane = new Pane(view);
		pane.setBackground(new Background(bg1));
		
		Scene scene = new Scene(pane, 600, 700);
		scene.setCursor(cursor);
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent me){
				if(bgCheck){
					pane.setBackground(new Background(bg2));
					bgCheck = false;
					view.setImage(button);
					view.setX(130);
					view.setY(570);
				}
			}
			
	});
		
		view.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent me){
				
				if(!bgCheck){
					random = Math.random() * 10;
					
					pane.setBackground(new Background(bg1));
					
				}
			}
		});
		
	stage.setScene(scene);
	stage.show();

	}
}