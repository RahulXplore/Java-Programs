import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextCounter {

    public static void main(String[] args) {
        // Specify the path to the text file you want to analyze
        String filePath = "sample.txt"; 

        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        // Using try-with-resources to ensure the reader closes automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read the file line by line until the end is reached
            while ((line = reader.readLine()) != null) {
                lineCount++; // Increment line count for each line read
                
                // Add the number of characters in the current line
                // Note: readLine() strips the newline character (\n), so this counts only the text
                charCount += line.length();

                // Remove leading/trailing spaces to ensure accurate word splitting
                String trimmedLine = line.trim();
                
                if (!trimmedLine.isEmpty()) {
                    // Split the line into words using regular expression for whitespace ("\\s+")
                    String[] words = trimmedLine.split("\\s+");
                    wordCount += words.length;
                }
            }

            // Display the results
            System.out.println("--- Text Analysis Results ---");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error: Could not read the file. Please make sure '" + filePath + "' exists.");
        }
    }
}
