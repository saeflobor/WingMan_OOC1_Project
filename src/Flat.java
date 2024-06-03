public class Flat {

    private String FlatID;
    private int numberOfRooms;
    private String location;
    private int rentPerMonth;
    private String client;

    private String availability;

    public String getFlatID() {
        return FlatID;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Flat(String flatID, int numberOfRooms, String location, int rentPerMonth, String client, String availability) {
        FlatID = flatID;
        this.numberOfRooms = numberOfRooms;
        this.location = location;
        this.rentPerMonth = rentPerMonth;
        this.client = client;
        this.availability = availability;
    }
    public Flat(){

    }

    public void setFlatID(String flatID) {
        FlatID = flatID;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRentPerMonth() {
        return rentPerMonth;
    }

    public void setRentPerMonth(int rentPerMonth) {
        this.rentPerMonth = rentPerMonth;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
