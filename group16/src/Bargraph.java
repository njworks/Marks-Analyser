import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Map;

/**
 * Created by njosepa on 26/02/2017.
 * Contributor tramch 1502020
 * Creates the bar chart
 */

public class Bargraph{

    static final JFXPanel fxPanel = new JFXPanel();

    public static void window() {
        //PRIMARY METHOD FOR RUNNING THE JAVAFX
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                runFX(fxPanel);
            }
        });
    }

    /*
    *SETTING WHAT TO RUN ON JFXPANEL
    */
    private static void runFX(JFXPanel fxPanel){
        Scene scene = create();
        scene.getStylesheets().add("chartColor.css");
        fxPanel.setScene(scene);
    }

    /*
    *CREATES THE BAR CHART AND ADD EACH VALUES TO IT
    */
    private static Scene create(){
        final CategoryAxis xA = new CategoryAxis();
        final NumberAxis yA = new NumberAxis();
        final BarChart<String, Number> barChart = new BarChart<String, Number>(xA,yA);
        barChart.setTitle("Module Average for first class");
        barChart.setLegendVisible(false);
        xA.setLabel("Module Name");
        yA.setLabel("Module Average");
        barChart.setAnimated(false);

        XYChart.Series series = new XYChart.Series();
        series.setName("Modules");
        for (Map.Entry<Double, String> entry : Modules.firstAverage.entrySet()) {
            Double key = entry.getKey();
            String value = entry.getValue();
            if (Double.isNaN(key)) {
                key = 0.0;
            }
            series.getData().add(new XYChart.Data(value, key));
        }
        barChart.getData().add(series);
        Scene scene = new Scene(barChart,775,480);
        scene.getStylesheets().add("chartColor.css");
        ChartImg.saveBarAsPng(barChart, "chart.png");
        return (scene);
    }
}