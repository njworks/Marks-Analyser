import java.util.*;
/**
 * Created by njosepa on 11/02/2017.
 * contributed by tramch 1502020
 * The csv data is used to get each module average
 * The stored marks is used to split it further to get each degree class, e.g. first
 * second, 2:2, pass and fail for further use
 */
public class Modules {
    //stores csv values in string
    public static ArrayList store = new ArrayList();
    //stores module names
    public static String[] moduleNames = new String[15];
    //stores module averages
    public static TreeMap<Double, String> sortedAverage = new TreeMap<Double,String>
            (Collections.reverseOrder());
    //stores marks in Double
    private static Double[][] fullMarksStore = new Double[129][17];
    //contains modules of students with 70+ TC marks
    private static Double[][] firstStore = new Double[50][15];
    //contains modules of students with 60-69 TC marks
    private static Double[][] secondStore = new Double[50][15];
    //contains modules of students with 50-59 TC marks
    private static Double[][] secTwoStore = new Double[50][15];
    //contains modules of students with 40-49 TC marks
    private static Double[][] passStore = new Double[50][15];
    //contains modules of students with <40 TC marks
    private static Double[][] failStore = new Double[50][15];
    //stores module averages for First class students
    public static TreeMap<Double, String> firstAverage = new TreeMap
            <Double,String>(Collections.reverseOrder());
    //stores module averages for upper second class students
    public static TreeMap<Double, String> secondAverage = new TreeMap
            <Double,String>(Collections.reverseOrder());
    //stores module averages for lower second class students
    public static TreeMap<Double, String> secondTwoAverage = new TreeMap
            <Double,String>(Collections.reverseOrder());
    //stores module averages for third class students
    public static TreeMap<Double, String> passAverage = new TreeMap
            <Double,String>(Collections.reverseOrder());
    //stores module averages for fail class students
    public static TreeMap<Double, String> failAverage = new TreeMap
            <Double,String>(Collections.reverseOrder());

    /*
    *ADDS MODULE NAMES TO ARRAY
    */
    private static void moduleName(){
        Object row = store.get(0);
        String convert = row.toString();
        String[] eachName = convert.split(",");
        int counter = 0;
        for (int i =3; i <18; i++){
            moduleNames[counter] = eachName[i].replaceAll("\\s+","");
            counter++;
        }
    }

    /*
    *CONVERTS THE STRING STORED MARKS TO DOUBLES AND STORES INTO NEW TWO
    *DIMENSIONAL ARRAY
    */
    private static void fullSlice(int rowPosition, int rowNumber){
        String row = (store.get(rowPosition)).toString();
        String[] split = row.split(",");
        int counter = 0;
        try {
            for (int x = 3; x < 20; x++) {
                String word = split[x].replaceAll("\\s+", "0");
                String each = word.replaceAll("]", "");
                double mark = Integer.parseInt(each);
                fullMarksStore[rowNumber][counter] = mark;
                counter++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
    *WORKS OUT AVERAGE FOR EACH MODULES
    */
    private static Double eachModuleAverage(Double[][] entryStore, int value){
        int counter = 0;
        double average;
        float finalMark = 0;
        try{
            for (int i = 0; i <entryStore.length; i++){
                double mark = entryStore[i][value];
                if(mark != 0){
                    counter++;
                }
                if (Double.isNaN(mark)) {
                    break;
                }
                finalMark += mark;
            }}
        catch (Exception e){
            //   System.out.println(e);
        }
        average = finalMark/counter;
        String temp = String.format( "%.2f", average );
        Double convert = Double.parseDouble(temp);

        return convert;
    }

    /*
    *Splits the marks into sub categories: 1st, 2nd, 2:2, pass, fail
    */
    private static void pieData(){
        int firstCounter = 0;
        int secondCounter = 0;
        int secondtwoCounter = 0;
        int passCounter = 0;
        int failCounter = 0;
        try{
            for (int i = 0; i < fullMarksStore.length; i++) {
                double value = fullMarksStore[i][16];
                if (value >= 70.0) {
                    for (int a = 0; a < moduleNames.length; a++) {
                        double temp = fullMarksStore[i][a];
                        firstStore[firstCounter][a] = temp;
                    }
                    firstCounter++;
                    continue;
                }
                else if (value >= 60.0 && value <= 69.0) {
                    for (int b = 0; b < moduleNames.length; b++) {
                        double tempB = fullMarksStore[i][b];
                        secondStore[secondCounter][b] = tempB;
                    }
                    secondCounter++;
                    continue;
                } else if (value >= 50.0 && value <= 59.0) {
                    for (int c = 0; c < moduleNames.length; c++) {
                        double tempC = fullMarksStore[i][c];
                        secTwoStore[secondtwoCounter][c] = tempC;
                    }
                    secondtwoCounter++;
                    continue;
                } else if (value >= 40.0 && value <= 49.0) {
                    for (int d = 0; d < moduleNames.length; d++) {
                        double tempD = fullMarksStore[i][d];
                        passStore[passCounter][d] = tempD;
                    }
                    passCounter++;
                    continue;
                } else if (value <= 39.0) {
                    for (int a = 0; a < moduleNames.length; a++) {
                        double tempE = fullMarksStore[i][a];
                        failStore[failCounter][a] = tempE;
                    }
                    failCounter++;
                    continue;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /*
    *ADDS THE AVERAGES FOR MODULES AND MODULE NAMES TO TREEMAP
    */
    private static void averageAdd(){
        for (int u =0; u< moduleNames.length; u++){
            sortedAverage.put(eachModuleAverage(fullMarksStore, u), moduleNames[u]);

            if (!eachModuleAverage(firstStore, u).isNaN()) {
                firstAverage.put(eachModuleAverage(firstStore, u), moduleNames[u]);
            }

            if (!eachModuleAverage(secondStore, u).isNaN()) {
                secondAverage.put(eachModuleAverage(secondStore, u), moduleNames[u]);
            }

            if (!eachModuleAverage(secTwoStore, u).isNaN()) {
                secondTwoAverage.put(eachModuleAverage(secTwoStore, u), moduleNames[u]);
            }

            if (!eachModuleAverage(passStore, u).isNaN()) {
                passAverage.put(eachModuleAverage(passStore, u), moduleNames[u]);
            }

            if (!eachModuleAverage(failStore, u).isNaN()) {
                failAverage.put(eachModuleAverage(failStore, u), moduleNames[u]);
            }
        }
    }

    /*
    *READIES ALL THE METHODS TO BE RUN IN MAIN
    */
    public static void runAllMethods(){
        moduleName();
        for (int a = 1; a < store.size(); a++){
            fullSlice(a, a-1);
        }
        pieData();
        averageAdd();
    }
}