package io.realm;


public interface DealsRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$code();
    public void realmSet$code(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$description();
    public void realmSet$description(String value);
    public String realmGet$picture();
    public void realmSet$picture(String value);
    public double realmGet$price();
    public void realmSet$price(double value);
    public double realmGet$discount();
    public void realmSet$discount(double value);
    public int realmGet$stock();
    public void realmSet$stock(int value);
    public int realmGet$viewer();
    public void realmSet$viewer(int value);
    public int realmGet$likersCount();
    public void realmSet$likersCount(int value);
}
