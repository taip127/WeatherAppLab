import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){
        WeatherReader weatherReader = new WeatherReader();

        /*String filePath = "weather.txt";
        weatherReader.processWeatherFile(filePath);

        // reading and writing as bytes
        String content =    "Saturday: Foggy\n" +
                            "Sunday: Rainy";
        String newFilePath = weatherReader.getFileNameFromUser();

        weatherReader.readFileASBytes(filePath);
        weatherReader.writeFileAsBytes(newFilePath,content);
        weatherReader.readFileASBytes(newFilePath);*/

        String filePath = weatherReader.getFileNameFromUser();
        weatherReader.processWeatherFile(filePath);

        String content =    "Saturday: Foggy\n" +
                            "Sunday: Rainy";
        weatherReader.readFileASBytes(filePath);
        weatherReader.writeFileAsBytes(filePath, content);

        weatherReader.readFileASBytes(filePath);


    }
}
