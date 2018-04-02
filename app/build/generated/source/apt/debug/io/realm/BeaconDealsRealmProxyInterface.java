package io.realm;


public interface BeaconDealsRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public com.sumroch.spotme.models.BeaconSubscription realmGet$beaconSubscription();
    public void realmSet$beaconSubscription(com.sumroch.spotme.models.BeaconSubscription value);
    public com.sumroch.spotme.models.Deals realmGet$deals();
    public void realmSet$deals(com.sumroch.spotme.models.Deals value);
    public long realmGet$detectedTime();
    public void realmSet$detectedTime(long value);
    public boolean realmGet$read();
    public void realmSet$read(boolean value);
}
