public class CurrencyConverter {
    private ExchangeRateAPI exchangeRateAPI;

    public CurrencyConverter(ExchangeRateAPI exchangeRateAPI) {
        this.exchangeRateAPI = exchangeRateAPI;
    }

    public double convertToMXN(String baseCurrency, double amount) {
        double exchangeRate = exchangeRateAPI.getExchangeRate(baseCurrency, "MXN");
        return amount * exchangeRate;
    }

    public double convertToBaseCurrency(String baseCurrency, String targetCurrency, double amount) {
        double exchangeRate = exchangeRateAPI.getExchangeRate(baseCurrency, targetCurrency);
        return amount / exchangeRate;
    }
}
