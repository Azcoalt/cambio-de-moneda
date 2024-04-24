import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el tipo de moneda base (ejemplo: USD, EUR, GBP):");
            String baseCurrency = scanner.next().toUpperCase(); // Convertir a mayúsculas
            System.out.println("Seleccione el tipo de cambio:");
            System.out.println("1. " + baseCurrency + " a MXN");
            System.out.println("2. COP a " + baseCurrency);
            System.out.println("3. MXN a " + baseCurrency);
            System.out.println("4. Salir");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertToMXN(exchangeRateAPI, baseCurrency, scanner);
                    break;
                case 2:
                    convertToBaseCurrency(exchangeRateAPI, baseCurrency, "COP", scanner);
                    break;
                case 3:
                    convertToBaseCurrency(exchangeRateAPI, baseCurrency, "MXN", scanner);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void convertToMXN(ExchangeRateAPI exchangeRateAPI, String baseCurrency, Scanner scanner) {
        CurrencyConverter converter = new CurrencyConverter(exchangeRateAPI);
        System.out.println("Ingrese la cantidad en " + baseCurrency + ":");
        double amount = scanner.nextDouble();
        double convertedAmount = converter.convertToMXN(baseCurrency, amount);
        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " MXN");
    }

    private static void convertToBaseCurrency(ExchangeRateAPI exchangeRateAPI, String baseCurrency, String targetCurrency, Scanner scanner) {
        CurrencyConverter converter = new CurrencyConverter(exchangeRateAPI);
        System.out.println("Ingrese la cantidad en " + targetCurrency + ":");
        double amount = scanner.nextDouble();
        double convertedAmount = converter.convertToBaseCurrency(baseCurrency, targetCurrency, amount);
        System.out.println(amount + " " + targetCurrency + " = " + convertedAmount + " " + baseCurrency);
    }
}
