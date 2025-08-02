import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> inputFiles = new ArrayList<>();

        String prefixName = "";
        String outputPath = "";
        boolean appendToExist = false;
        boolean shortStats = false;
        boolean fullStats = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        outputPath = args[++i];
                    } else {
                        System.out.println("Флаг -o требует путь");
                    }
                    break;
                case "-p":
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        prefixName = args[++i];
                    } else {
                        System.out.println("Флаг -p требует префикс");
                    }
                    break;
                case "-a":
                    appendToExist = true;
                    break;
                case "-s":
                    shortStats = true;
                    break;
                case "-f":
                    fullStats = true;
                    break;
                default:
                    if (args[i].startsWith("-")) {
                        System.out.println("Неизвестный флаг: " + args[i]);
                    } else {
                        inputFiles.add(args[i]);
                    }
            }
        }

        for(String file: inputFiles){
            try(BufferedReader reader = Files.newBufferedReader(Paths.get(file))){
                String line;
                while ((line = reader.readLine()) != null){
                    line = line.trim();
                    if (line.isEmpty()){
                        continue;
                    }
                    Classifier.classify(line);
                }
            }
            catch (IOException e){
                System.out.println("Error ocured during reading the file: " + file + " — " + e.getMessage());
            }
        }

        FileWriterUtil.writeResults(outputPath, prefixName, appendToExist);

        if(shortStats){
            ShortStat shortStat = new ShortStat();
            shortStat.getShortStat();
        }

        if(fullStats){
            FullStat fullStat = new FullStat();
            fullStat.getFullStat();
        }
    }
}
