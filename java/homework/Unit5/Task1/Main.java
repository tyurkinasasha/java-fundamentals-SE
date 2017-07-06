package homework.Unit5.Task1;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.Iterator;

public class Main extends Application {
    private static FileChooser fileChooser = new FileChooser();
    private static FileNameExtensionFilter filter = new FileNameExtensionFilter("Only txt filter", "txt");
    private static Font labelFont = new Font("Times New Roman", 20);
    private static Font buttonFont = new Font("Times New Roman", 16);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Layout
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        //Creating nodes
        Label startLabel = new Label("Choose action");
        Button buttonView = new Button("View files");
        Button buttonCreate = new Button("Create new file");
        //Setting up nodes
        startLabel.setFont(labelFont);
        buttonView.setMaxWidth(200);
        buttonCreate.setMaxWidth(200);
        buttonView.setFont(buttonFont);
        buttonCreate.setFont(buttonFont);

        buttonView.setOnAction(event -> viewFiles(primaryStage));
        buttonCreate.setOnAction(event -> displayText("", null));
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 500, 500);
        vBox.getChildren().addAll(startLabel, buttonCreate, buttonView);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void viewFiles(Stage stage) {
        String text;
        JOptionPane.showMessageDialog(null, "To display russian symbols correctly, choose UTF-8 encoded files"
                + "\nAlso feel free to delete any files using 'del' button :)");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) try {
            if (filter.accept(file)) {
                text = new String(Files.readAllBytes(file.toPath()), "UTF-8");
                displayText(text, file.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you can view only .txt files");
                viewFiles(stage);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Reading failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayText(String text, String filePath) {
        Stage viewingStage = new Stage();
        TextArea textArea = new TextArea();
        textArea.setText(text);

        HBox hBox = new HBox(10);
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            //(???)using this because textArea.getText() was giving text without newlines
            ObservableList<CharSequence> pars = textArea.getParagraphs();
            Iterator<CharSequence> iter = pars.iterator();
            StringBuilder sb = new StringBuilder();
            while (iter.hasNext()) {
                sb.append(iter.next());
                sb.append(System.lineSeparator());
            }

//            String textToSave=textArea.getText();
            String textToSave = sb.toString();

            saveFile(filePath, viewingStage, textToSave);
        });
        HBox.setHgrow(textArea, Priority.ALWAYS);
        saveButton.setFont(buttonFont);

        hBox.getChildren().addAll(textArea, saveButton);
        Scene scene = new Scene(hBox, 600, 400);

        viewingStage.setScene(scene);
        viewingStage.show();
    }

    private void saveFile(String filePath, Stage stage, String textToSave) {
        if (filePath == null) {
            File file = fileChooser.showSaveDialog(stage);
            if (file != null)
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
                    bw.write(textToSave);
                    JOptionPane.showMessageDialog(null, "Saved at " + file.getAbsolutePath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Saving failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } else {
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                fileOutputStream.write(textToSave.getBytes());
                JOptionPane.showMessageDialog(null, "Edited file was successfully saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Saving failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        stage.close();
    }
}
