import java.util.Collections;
import java.util.List;

public class FullStat {
    public void getFullStat(){
        System.out.println("\n    FULL STATISTICS \n");
        getFullIntegerStat();
        getFullFloatStat();
        getFullStringStat();
    }

    public void getFullIntegerStat(){
        System.out.println("===== Integers statistic ===== \n");

        List<Long> integers = FileList.getIntegers();

        if (integers.isEmpty()) {
            System.out.println("Integers list is empty. \n");
            return;
        }

        long sum = integers.stream().mapToLong(Long::longValue).sum();
        long min = Collections.min(integers);
        long max = Collections.max(integers);
        double avg = (double) sum / integers.size();

        System.out.println("Integers count: " + integers.size());
        System.out.println("Minimal integer value: " + min);
        System.out.println("Maximal integer value: " + max);
        System.out.println("Sum of all integers: " + sum);
        System.out.println("Average of all integers: " + avg);
    }

    public void getFullFloatStat() {
        System.out.println("===== Floats statistic ===== \n");
        List<Double> floats = FileList.getFloats();

        if (floats.isEmpty()) {
            System.out.println("Floats list is empty. \n");
            return;
        }

        double sum = floats.stream().mapToDouble(Double::doubleValue).sum();
        double min = Collections.min(floats);
        double max = Collections.max(floats);
        double avg = sum / floats.size();

        System.out.println("Floats count: " + floats.size());
        System.out.println("Minimal float value: " + min);
        System.out.println("Maximal float value: " + max);
        System.out.println("Sum of all floats: " + sum);
        System.out.println("Average of all floats: " + avg);

    }

    public void getFullStringStat() {
        System.out.println("===== Strings statistic ===== \n");
        List<String> strings = FileList.getStrings();

        if (strings.isEmpty()) {
            System.out.println("Strings list is empty. \n");
            return;
        }

        int minLength = strings.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        int maxLength = strings.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        System.out.println("String count : " + FileList.getStrings().size());
        System.out.println("Shortest string length: " + minLength);
        System.out.println("Longest string length: " + maxLength);
    }
}
