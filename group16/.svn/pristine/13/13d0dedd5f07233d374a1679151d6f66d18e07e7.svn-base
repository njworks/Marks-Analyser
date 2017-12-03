import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.util.Map;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by cgrayc on 02/03/2017.
 * creates pie chart with each module average
 */
public class PieCharts {
    static final JFXPanel fxPie = new JFXPanel();  //FXPanel for running the JavaFx
    public static void window() {
        //PRIMARY METHOD FOR RUNNING THE JAVAFX
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                runFX(fxPie);
            }
        });
    }

    /*
    *SETTING WHAT TO RUN ON JFXPANEL
    */
    private static void runFX(JFXPanel fxPanel) {
        Scene scene = createPieChart();
        scene.getStylesheets().add("chartColor.css");
        fxPanel.setScene(scene);

    }

    /*
    *MAKES THE PIE CHART AND ADD VALUES TO IT
    */
    private static Scene createPieChart() {
        ObservableList<PieChart.Data> pieChartData = observableArrayList();

        for (Map.Entry<Double, String> entry :Modules.sortedAverage.entrySet()) {
            Double key = entry.getKey();
            String value = entry.getValue();
            pieChartData.add(new PieChart.Data(value, key));
        }

        PieChart pie = new PieChart(pieChartData);

        pie.setTitle("Module Average");

        pieChartData.forEach(data -> data.nameProperty().bind(
                Bindings.concat(data.getName(), " : ",data.pieValueProperty(), "%")
                )  );

        Scene scene = new Scene(pie, 775, 480);
        scene.getStylesheets().add("chartColor.css");
        ChartImg.savePieAsPng(pie, "chart6.png");
        return scene;
    }
}