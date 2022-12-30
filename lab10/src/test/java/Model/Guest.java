package Model;

public class Guest {
    private String Direction;
    private String TripType;
    private String Currency;

    public Guest(String direction,String triptype, String currency) {
        this.Direction = direction;
        this.TripType = triptype;
        this.Currency = currency;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        this.Direction = direction;
    }

    public String getTripType() {
        return TripType;
    }

    public void setTripType(String tripType) {
        this.TripType = tripType;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

}
