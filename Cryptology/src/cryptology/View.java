package cryptology;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class View {
	
	private Stage primaryStage;
	private Controller controller;
	
	private TextArea clearTextTextArea;
	private TextArea cipherTextTextArea; 
	
	public View(Stage primaryStage, Controller controller) {
		
		this.primaryStage = primaryStage;
		this.controller = controller;
		
		VBox contentVBox = new VBox();
		contentVBox.setPadding(new Insets(3));
		contentVBox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(contentVBox);
		scene.getStylesheets().add(this.getClass().getResource("/CSS/cryptology.css").toExternalForm());
		//scene.getStylesheets().add(this.getClass().getResource("/CSS/metro-bootstrap.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cryptology");
		
		// Create the Menu Bar
		MenuBar menuBar = new MenuBar();
		Menu settingsMenu = new Menu("Settings");
		menuBar.getMenus().add(settingsMenu);
		
		MenuItem prefrencesMenuItem = new MenuItem("Preferences");
		prefrencesMenuItem.addEventHandler(ActionEvent.ACTION, new PreferencesEventHandler());
		settingsMenu.getItems().add(prefrencesMenuItem);
		
		contentVBox.getChildren().add(menuBar);
		
		// <Common Control Pane
		HBox commonControlsHBox = new HBox();
		
		// <Clear Text Controls
		VBox clearTextVBox = new VBox();
		clearTextTextArea = new TextArea();
		Label clearTextLabel = new Label("Clear Text:");
		
		clearTextVBox.getChildren().addAll(clearTextLabel, clearTextTextArea);
		// End of Clear Text Controls>
		
		// <Cipher Buttons
		VBox cipherButtonVBox = new VBox();
		
		Button encipherButton = new Button("Encipher");
		encipherButton.addEventHandler(ActionEvent.ACTION, new EncipherButtonEventHandler());
		encipherButton.setMinWidth(65);
		
		Button decipherButton = new Button("Decipher");
		decipherButton.addEventHandler(ActionEvent.ACTION, new DecipherButtonEventHandler());
		decipherButton.setMinWidth(65);
		
		cipherButtonVBox.getChildren().addAll(encipherButton, decipherButton);
		cipherButtonVBox.setSpacing(3);
		cipherButtonVBox.setPadding(new Insets(20, 0, 0, 0));
		// End of Cipher Buttons>
		
		// <Cipher Text Controls
		VBox cipherTextVBox = new VBox();
		cipherTextTextArea = new TextArea();
		Label cipherTextLabel = new Label("Cipher Text:");
		
		cipherTextVBox.getChildren().addAll(cipherTextLabel, cipherTextTextArea);
		// End of Cipher Text Controls>
		
		// <Cipher Controls
		ChoiceBox<String> cipherChoiceBox = new ChoiceBox<String>();
		cipherChoiceBox.setItems(FXCollections.observableArrayList("Select a Cipher", "Caesar", "Single Columnar", "Double Columnar", "Vigenere"));
		cipherChoiceBox.setPrefSize(150, 20);
		cipherChoiceBox.getSelectionModel().selectFirst();

		// End of Cipher controls>
		
		commonControlsHBox.getChildren().addAll(clearTextVBox, cipherButtonVBox, cipherTextVBox);
		// End of Common Control Pane>
		
		contentVBox.getChildren().addAll(commonControlsHBox, cipherChoiceBox);
		
		primaryStage.show();
	}
	
	private class PreferencesEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			PreferencesView preferencesView = new PreferencesView(controller);
		}
	}
	
	private class EncipherButtonEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
		}
	}
	
	private class DecipherButtonEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
		}
	}
}
