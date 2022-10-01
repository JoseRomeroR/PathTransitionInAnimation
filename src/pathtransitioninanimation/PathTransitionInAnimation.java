
package pathtransitioninanimation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PathTransitionInAnimation extends Application {
    Circle circle = new Circle();
    Rectangle rectangle = new Rectangle();
    Pane pane = new Pane();
    PathTransition pathTransition = new PathTransition();
    
    @Override
    public void start(Stage primaryStage) {
        //Settings circle
       circle.setCenterX(150);
       circle.setCenterY(150);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(5);
        
        //Settings rectangle
        rectangle.setHeight(50);
        rectangle.setWidth(30);
        rectangle.setFill(Color.ORANGE);
        rectangle.setStroke(Color.BLACK);
        
        //Settins path
        pathTransition.setDuration(Duration.millis(4000)); //Path duration
        pathTransition.setPath(circle); // path animation
        pathTransition.setNode(rectangle); // what is goin to move
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // move orientation
        pathTransition.setCycleCount(Timeline.INDEFINITE); // cycle         
        pathTransition.play();
        
        //Events
        circle.setOnMousePressed(e -> pathTransition.pause());
        circle.setOnMouseReleased(e -> pathTransition.play());
            
        // Add component pane
        pane.getChildren().addAll(circle,rectangle);
        
        
        Scene scene = new Scene(pane, 300, 300);       
        primaryStage.setTitle("Path Transition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
