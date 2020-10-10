import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import java.lang.*;


public class GUI extends Application{

	Magic8Ball ball = new Magic8Ball();
	private boolean bgCheck = true;
	private Image button;
	
	public void start(Stage stage){
		stage.setTitle("Magic 8 Ball");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:img/icon.png"));
		
		button = new Image("file:img/button.png", 270, 100, false, false);
		ImageView view = new ImageView();
		BackgroundImage bg1 = new BackgroundImage(new Image("file:img/bg1.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			
		BackgroundImage bg2 = new BackgroundImage(new Image("file:img/bg2.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		BackgroundImage bg3 = new BackgroundImage(new Image("file:img/bg3.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		BackgroundImage bg4 = new BackgroundImage(new Image("file:img/bg4.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		BackgroundImage bg5 = new BackgroundImage(new Image("file:img/bg5.png", 500, 600, false, true), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);	
		
		Pane pane = new Pane(view);
		pane.setBackground(new Background(bg1));
		
		Scene scene = new Scene(pane, 490, 600);
		
		pane.setOnMouseClicked(me -> {
			if (bgCheck) {
				pane.setBackground(new Background(bg2));
				bgCheck = false;
				view.setImage(button);
				view.setX(115);
				view.setY(490);

			}
		});
		
		view.setOnMouseClicked(me -> {
			int result = ball.shake();
			if(!bgCheck){
				switch (result) {
					case 0:
						pane.setBackground(new Background(bg2));
					case 1:
						pane.setBackground(new Background(bg3));
					case 2:
						pane.setBackground(new Background(bg4));
					case 3:
						pane.setBackground(new Background(bg5));
				}
			}
		});
		
	stage.setScene(scene);
	stage.show();
	}
}