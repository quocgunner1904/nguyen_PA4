import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public void count(String dataFile) throws IOException {
        wordCounter = new HashMap<String, Integer>();
        Scanner scan = new Scanner(new File(dataFile));

        while (scan.hasNext()) {
            String word = scan.next();
            Integer noOfWord = wordCounter.get(word);

            if (noOfWord != null)
                noOfWord++;
            else
                noOfWord = 1;

            wordCounter.put(word, noOfWord);
        }
    }
    public void write(String outputFile) throws IOException {
        File file = new File(outputFile);

        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file);

            for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                fileWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
            }

            fileWriter.close();
            System.out.println("Data has been written to the file!");
        }
        else {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);

            for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
                fileWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
            }

            fileWriter.close();
            System.out.println("Data has been written to the file!");
        }
    }
}
