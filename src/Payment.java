public class Payment {
    private int paymentId;
    private Booking booking;
    private double amount;
    private PaymentStatus status;

    public Payment(int paymentId, Booking booking, double amount, PaymentStatus status) {
        this.paymentId = paymentId;
        this.booking = booking;
        this.amount = amount;
        this.status = status;
    }

    public int getPaymentId() { return paymentId; }
    public Booking getBooking() { return booking; }
    public double getAmount() { return amount; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}
