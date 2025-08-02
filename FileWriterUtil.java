import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileWriterUtil {
    public static void writeResults(String outputPath, String prefix, boolean append) {
        try {
            writeListToFile(FileList.getIntegers(), outputPath, prefix + "integers.txt", append);
            writeListToFile(FileList.getFloats(), outputPath, prefix + "floats.txt", append);
            writeListToFile(FileList.getStrings(), outputPath, prefix + "strings.txt", append);
        } catch (IOException e) {
            System.out.println("Error while writing result files: " + e.getMessage());
        }
    }

    private static <T> void writeListToFile(List<T> data, String dir, String fileName, boolean append) throws IOException {
        if (data == null || data.isEmpty()) {
            return;
        }

        Path outputFile = Paths.get(dir, fileName);

        Files.createDirectories(outputFile.getParent());

        OpenOption[] options = append
                ? new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND}
                : new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};

        try (BufferedWriter writer = Files.newBufferedWriter(outputFile, options)) {
            for (T value : data) {
                writer.write(value.toString());
                writer.newLine();
            }
        }
    }
}
