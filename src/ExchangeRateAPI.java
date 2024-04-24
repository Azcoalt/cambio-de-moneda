import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/ce1245af0fb83adb306cbfb5/latest/";

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        double exchangeRate = 0.0;

        try {
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();

                // Parse JSON response to get exchange rate
                // (You can use a JSON parsing library like Jackson or Gson for this)
                // For simplicity, I'm just assuming a fixed exchange rate here.
                exchangeRate = 20.0; // For demonstration purposes, assuming 1 USD = 20 MXN
            } else {
                System.out.println("Error en la conexión a la API. Código de respuesta: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exchangeRate;
    }
}

