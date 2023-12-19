package uz.jasurbekruzimov.deliveryapp.Domain;

public class Time {
    private int Id;
    private String Value;

    public Time() {
    }

    @Override
    public String toString() {
        return Value;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
