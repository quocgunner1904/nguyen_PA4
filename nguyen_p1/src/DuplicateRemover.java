import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException {
        String words;
        uniqueWords = new HashSet<String>();
        Scanner scan = new Scanner(new File(dataFile));

        while (scan.hasNext()) {
            words = scan.next();
            uniqueWords.add(words);
        }

        scan.close();
    }

    public void write(String outputFile) throws IOException {
        File file = new File(outputFile);

        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file);

            Iterator<String> i = uniqueWords.iterator();
            while (i.hasNext()) {
                fileWriter.write(i.next() + "\n");
            }

            fileWriter.close();
            System.out.println("Data has been written to the file!");
        }
        else {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);

            Iterator<String> i = uniqueWords.iterator();
            while (i.hasNext()) {
                fileWriter.write(i.next() + " ");
            }

            fileWriter.close();
            System.out.println("Data has been written to the file!");
        }
    }
}
