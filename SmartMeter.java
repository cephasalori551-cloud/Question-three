public class SmartMeter {

    // Private fields
    private String meterId;
    private double creditBalance;
    private boolean valveOpen;

    // Constructor
    public SmartMeter(String meterId, double creditBalance) {
        this.meterId = meterId;
        this.creditBalance = creditBalance;
        this.valveOpen = true;
    }

    // Load token
    public double loadToken(double amount) {
        creditBalance += amount;

        if (!valveOpen) {
            valveOpen = true;
        }

        return creditBalance;
    }

    // Record water consumption
    public boolean recordConsumption(double litres) {

        double cost = litres * 50;

        if (!valveOpen || creditBalance <= 0) {
            return false;
        }

        creditBalance -= cost;

        if (creditBalance <= 0) {
            creditBalance = 0;
            valveOpen = false;
        }

        return true;
    }

    // Getters

    public String getMeterId() {
        return meterId;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public boolean isValveOpen() {
        return valveOpen;
    }
}