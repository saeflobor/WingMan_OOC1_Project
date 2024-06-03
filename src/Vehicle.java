public class Vehicle {
    private String vehicleId;
    private String brandName;
    private String model;
    private int enginceCC;
    private int rentPerDay;
    private String client;
    private String availability;

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Vehicle(String vehicleId, String brandName, String model, int enginceCC, int rentPerDay, String client, String availability) {
        this.vehicleId = vehicleId;
        this.brandName = brandName;
        this.availability=availability;
        this.model = model;
        this.enginceCC = enginceCC;
        this.rentPerDay = rentPerDay;
        this.client = client;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEnginceCC() {
        return enginceCC;
    }

    public void setEnginceCC(int enginceCC) {
        this.enginceCC = enginceCC;
    }

    public int getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(int rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
