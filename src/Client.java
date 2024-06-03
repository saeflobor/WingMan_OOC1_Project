public class Client extends User{
    private int FlatPaymentPending=0;
    private int VehiclePayemntPending=0;

    private String CardNumber;

    public void calculateFlatPayment(int numberOfDays,int rentPerMonth){
        FlatPaymentPending+=numberOfDays*rentPerMonth;

    }
    public void calculateVehiclePayment(int numberOfDays,int rentPerDay){
        VehiclePayemntPending+=numberOfDays*rentPerDay;


    }

    public int getFlatPaymentPending() {
        return FlatPaymentPending;
    }

    public void setFlatPaymentPending(int flatPaymentPending) {
        FlatPaymentPending = flatPaymentPending;
    }

    public int getVehiclePayemntPending() {
        return VehiclePayemntPending;
    }

    public void setVehiclePayemntPending(int vehiclePayemntPending) {
        VehiclePayemntPending = vehiclePayemntPending;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }
}
