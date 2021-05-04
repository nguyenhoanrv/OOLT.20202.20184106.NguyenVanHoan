package hust.soict.hedspi.gui.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXHello extends Application {
	private Button btnHello; // Declare a "Button" control
 @Override
 	public void start(Stage primaryStage) {
	 	// Construct the "Button" and attach an "EventHandler"
		 btnHello = new Button();
		 btnHello.setText("Say Hello");
		 // Using JDK 8 Lambda Expression to construct an EventHandler<ActionEvent>
		 btnHello.setOnAction(evt -> System.out.println("Hello World!"));
		 // Construct a scene graph of nodes
		 StackPane root = new StackPane(); // The root of scene graph is a layout node
		 root.getChildren().add(btnHello); // The root node adds Button as a child
		 Scene scene = new Scene(root, 300, 100); // Construct a scene given the root of scen
		 primaryStage.setScene(scene); // The stage sets scene
		 primaryStage.setTitle("Hello"); // Set window's title
		 primaryStage.show(); // Set visible (show it)
	 }
 
	 public static void main(String[] args) {
		 launch(args);
	 }
}
