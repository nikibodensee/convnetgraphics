package main.java.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Main extends Application {

    private Cnngraphics cnngraphics;
    private Stage primaryStage;
    private String filepath = "test.txt";
    private int xAmountNodes = 4;
    private int yAmountNodes = 5;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.getIcons().add(new Image("iconprint.png"));
        primaryStage.setTitle("Nensys Layerview");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);

        cnngraphics = new Cnngraphics();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cnngraphics.fxml")); // file loaden
        AnchorPane pane = loader.load();


        this.cnngraphics = loader.getController();

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();

        cnngraphics.drawOutput(filepath,xAmountNodes,yAmountNodes);
    }


    public static void main(String[] args) {
        try
        {
            launch(args);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            try
            {
                PrintWriter pw = new PrintWriter(new File("errorprotocoll.txt"));
                e.printStackTrace(pw);
                pw.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }

}

