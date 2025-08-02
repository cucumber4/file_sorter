public class Classifier {
    public static void classify(String line){
        if (isInteger(line)) {
            FileList.getIntegers().add(Long.parseLong(line));
        } else if (isFloat(line)) {
            FileList.getFloats().add(Double.parseDouble(line));
        } else {
            FileList.getStrings().add(line);
        }
    }

    private static boolean isInteger(String s) {
        try {
            Long.parseLong(s);
            return !s.contains(".") && !s.toLowerCase().contains("e");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        try {
            Double.parseDouble(s);
            return s.contains(".") || s.toLowerCase().contains("e");
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
