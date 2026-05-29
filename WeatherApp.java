import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class WeatherApp {

    private static final String API_KEY = "eb4c544edd1a56992046eae0b96e8ed8";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + API_KEY + "&units=metric";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HTTP Error Code: " + responseCode);
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Parse JSON
            JSONObject json = new JSONObject(response.toString());

            JSONObject main = json.getJSONObject("main");
            double temp = main.getDouble("temp");
            int humidity = main.getInt("humidity");

            String weather = json.getJSONArray("weather")
                                 .getJSONObject(0)
                                 .getString("description");

            // Display Output
            System.out.println("\n----- Weather Report -----");
            System.out.println("City: " + city);
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Weather: " + weather);
            System.out.println("Humidity: " + humidity + "%");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}