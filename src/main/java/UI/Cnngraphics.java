package main.java.UI;

import javafx.concurrent.Task;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.AIGraphics.Layer;
import main.java.Stringhandle.Stringextracter;
import main.java.handleexe.CRexe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cnngraphics {

    CRexe exe;
    private Thread supplier;
    public ImageView cnnview;
    private Stage primaryStage;
    private GraphicsContext gc;
    private String exepath;

    public void drawOutput(String filepath, int xAmountNodes, int yAmountNodes) throws IOException {

        List<Integer> result = new ArrayList<>();

        Task task = new Task<Void>() {
            @Override
            public Void call() throws IOException {


                BufferedReader br = new BufferedReader(new FileReader(filepath));

                String buffer;

                while ((buffer = br.readLine()) != null) {
//                    System.out.println(buffer);
                    result.add((int)(Float.parseFloat(buffer)*255));

            }

                setInputimage(result.stream().mapToInt(Integer::intValue).toArray(),xAmountNodes,yAmountNodes);

                return null;
            }
        };
        supplier = new Thread(task);
        supplier.start();

    }

    private void setInputimage(int[] val,int xamo, int yamo){

        int width = (int)cnnview.getFitWidth();
        int height = (int)cnnview.getFitHeight();
        WritableImage wImage = new WritableImage(width, height);
        PixelWriter writer = wImage.getPixelWriter();

        Layer l = new Layer(100,xamo,width,yamo,height);
        Color[][] screen = new Color[width][height];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                screen[x][y] = Color.grayRgb(255);
            }
        }
        screen = l.drawNet(screen,val);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                writer.setColor(x, y,screen[x][y]);
            }
        }
        cnnview.setImage(wImage);
    }
}
