import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;


/**
 * Created by tramch 1502020 on 10/03/2017.
 */

public class ChartImg {
    //save image of bar charts to put on pdf file
    public static void saveBarAsPng(BarChart barChart, String path) {
        WritableImage image = barChart.snapshot(new SnapshotParameters(), null);
        File file = new File(path);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //save image of pie charts to put on pdf file
    public static void savePieAsPng(PieChart pie, String path) {
        WritableImage image = pie.snapshot(new SnapshotParameters(), null);
        File file = new File(path);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //save image of tables to put on pdf file
    public static void makePanelImage(Component panel, String path) {

        BufferedImage image = new BufferedImage(750, 275, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        panel.paint(g2);
        File file = new File(path);
        try {
            System.out.println("CALLED " + path);
            ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}