import java.util.*;

/**
 * Created by cgrayc on 10/03/2017.
 * contributed by tramch 1502020
 */
public class Weight {

    public static TreeMap<Integer, String> firstWeighting = new TreeMap
            <Integer, String>(Collections.reverseOrder());
    public static TreeMap<Integer, String> twoOneWeighting = new TreeMap
            <Integer, String>(Collections.reverseOrder());
    public static TreeMap<Integer, String> twoTwoWeighting = new TreeMap
            <Integer, String>(Collections.reverseOrder());
    public static TreeMap<Integer, String> passWeighting = new TreeMap
            <Integer, String>(Collections.reverseOrder());
    public static TreeMap<Integer, String> failWeighting = new TreeMap
            <Integer, String>(Collections.reverseOrder());
    public static TreeMap<String, Integer> finalWeighting = new TreeMap
            <String, Integer>(Collections.reverseOrder());
    public static TreeMap<String, Integer> finalW = new TreeMap
            <String, Integer>();
    public static TreeMap<String, Integer> firstSecWeight = new TreeMap<String, Integer>();
    public static TreeMap<String, Integer> finalFirstSecWeighting = new TreeMap
            <String, Integer>(Collections.reverseOrder());
    public static TreeMap<String, Integer> weakWeight = new TreeMap<String, Integer>();
    public static TreeMap<String, Integer> finalWeakWeight = new TreeMap
            <String, Integer>(Collections.reverseOrder());

    public static void weighting() {
        int weigh = 1;
        int weighTO = 2;
        int weighTT = 3;
        int weighP = 4;
        int weighF = 15;

        for (Map.Entry<Double, String> entry : Modules.firstAverage.entrySet()) {
            String value = entry.getValue();
            firstWeighting.put(weigh, value);
            weigh++;
        }
        for (Map.Entry<Double, String> entry : Modules.secondAverage.entrySet()) {
            String value = entry.getValue();
            twoOneWeighting.put(weighTO, value);
            weighTO++;
        }
        for (Map.Entry<Double, String> entry : Modules.secondTwoAverage.entrySet()) {
            String value = entry.getValue();
            twoTwoWeighting.put(weighTT, value);
            weighTT++;
        }
        for (Map.Entry<Double, String> entry : Modules.passAverage.entrySet()) {
            String value = entry.getValue();
            passWeighting.put(weighP, value);
            weighP++;
        }
        for (Map.Entry<Double, String> entry : Modules.failAverage.entrySet()) {
            String value = entry.getValue();
            failWeighting.put(weighF, value);
            weighF--;
        }

        int weight = 0;

        for (int i = 0; i < Modules.moduleNames.length; i++){
            String name = Modules.moduleNames[i];

            if (firstWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(firstWeighting, name);
                weight += keys.get(0);
            }
            if (twoOneWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(twoOneWeighting, name);
                weight += keys.get(0);
            }
            if (twoTwoWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(twoTwoWeighting, name);
                weight += keys.get(0);
            }
            if (passWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(passWeighting, name);
                weight += keys.get(0);
            }
            if (failWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(failWeighting, name);
                weight += keys.get(0);
            }
            finalW.put(name, weight);
            weight = 0;
        }

        for (int i = 0; i < Modules.moduleNames.length; i++) {
            String name = Modules.moduleNames[i];

            if (firstWeighting.containsValue(name)) {
                List<Integer> keys = getKeysFromValue(firstWeighting, name);
                weight += keys.get(0);
            }
            if (twoOneWeighting.containsValue(name)) {
                List<Integer> keys = getKeysFromValue(twoOneWeighting, name);
                weight += keys.get(0);
            }
            firstSecWeight.put(name, weight);
            weight = 0;
        }

        for (int i = 0; i < Modules.moduleNames.length; i++) {
            String name = Modules.moduleNames[i];

            if (twoTwoWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(twoTwoWeighting, name);
                weight += keys.get(0);
            }
            if (passWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(passWeighting, name);
                weight += keys.get(0);
            }
            if (failWeighting.containsValue(name)){
                List<Integer> keys  = getKeysFromValue(failWeighting, name);
                weight += keys.get(0);
            }
            weakWeight.put(name, weight);
            weight = 0;
        }

        Comparator<String> valueComparator =  new Comparator<String>() {
            public int compare(String k1, String k2) {
                int compare = finalW.get(k2).compareTo(finalW.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        finalWeighting = new TreeMap<String, Integer>(valueComparator);
        finalWeighting.putAll(finalW);

        Comparator<String> valueComparator1 =  new Comparator<String>() {
            public int compare(String k1, String k2) {
                int compareTwo = firstSecWeight.get(k2).compareTo(firstSecWeight.get(k1));
                if (compareTwo == 0) return 1;
                else return compareTwo;
            }
        };
        finalFirstSecWeighting = new TreeMap<String, Integer>(valueComparator1);
        finalFirstSecWeighting.putAll(firstSecWeight);

        Comparator<String> valueComparator2 =  new Comparator<String>() {
            public int compare(String k1, String k2) {
                int compareTwo = weakWeight.get(k2).compareTo(weakWeight.get(k1));
                if (compareTwo == 0) return 1;
                else return compareTwo;
            }
        };
        finalWeakWeight = new TreeMap<String, Integer>(valueComparator2);
        finalWeakWeight.putAll(weakWeight);

    }

    private static <A,B> List<A> getKeysFromValue(Map<A, B> hm, B value){
        List <A>list = new ArrayList<>();
        for(A o:hm.keySet()){
            if(hm.get(o).equals(value)) {
                list.add(o);
            }
        }
        return list;
    }
}