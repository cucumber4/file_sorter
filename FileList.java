import java.util.ArrayList;
import java.util.List;

public class FileList {
    private static List<Long> integers = new ArrayList<>();
    private static List<Double> floats = new ArrayList<>();
    private static List<String> strings = new ArrayList<>();


    public static List<Long> getIntegers() {
        return integers;
    }

    public static void setIntegers(List<Long> integers) {
        FileList.integers = integers;
    }

    public static List<Double> getFloats() {
        return floats;
    }

    public static void setFloats(List<Double> floats) {
        FileList.floats = floats;
    }

    public static List<String> getStrings() {
        return strings;
    }

    public static void setStrings(List<String> strings) {
        FileList.strings = strings;
    }
}
