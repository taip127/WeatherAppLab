import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherReader {
    /*
    Step 1: Method to check if the file exists, if file does not exists it throws and
    will throw a WeatherFileNotFoundException
    */
    public void checkFileExists(File file) throws WeatherFileNotFoundException{
        if(!file.exists()){
            throw new WeatherFileNotFoundException("File does not exist");
        }
    }
    /*
    Step 2: Method to read file using Scanner methods and display the file content
    In this method catch the FileNotFoundException only
    */
    public void readFile(File file) {
// Reading file line by line and display each line
        try {
            Scanner input = new Scanner(file);
            ArrayList<String[]> data = new ArrayList<String[]>();
            while (input.hasNextLine()) {
                String Line = input.nextLine();
                String[] splitedLine = Line.split(" ");
                data.add(splitedLine);
            }
            System.out.println("Reading weather data from files: ");
            for (String[] line : data) {
                System.out.println(line[0] + " " + line[1]);
            }
     }
        catch (FileNotFoundException  e){
            System.out.println("Error Reading Files: " + e.getMessage());
            e.printStackTrace();
        }
    }
    /*
    Step 3: Method to process the file by combining both tasks.
    In this method catch the WeatherFileNotFoundException only
    */
    public void processWeatherFile(String filePath) {
// Step 1: Create File object to assign filePath
// Step 2: Check file existence
// Step 3: Read the file

        File file = new File(filePath);
//        try {
//            checkFileExists(file);
            readFile(file);
//        }
        /*catch (WeatherFileNotFoundException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }*/
    }
    // Method to write data to a file as byte stream

    public void readFileASBytes(String filePath) {
        try(FileInputStream inputStream = new FileInputStream(filePath))
        {
            System.out.println("Reading files as bytes:");
            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error reading file as byte:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeFileAsBytes(String filePath, String content) {
        try (FileOutputStream outputStream = new FileOutputStream(filePath)){
            outputStream.write(content.getBytes());
            System.out.println("Content written to file successfully as bytes.");
        } catch (IOException e) {
            System.err.println("Error writing file as bytes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getFileNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name (with path): ");
        return scanner.nextLine();
    }
}
