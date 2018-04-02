package io.realm;


public interface BeaconSubscriptionRealmProxyInterface {
    public String realmGet$beaconId();
    public void realmSet$beaconId(String value);
    public String realmGet$uuid();
    public void realmSet$uuid(String value);
    public int realmGet$major();
    public void realmSet$major(int value);
    public int realmGet$minor();
    public void realmSet$minor(int value);
}
