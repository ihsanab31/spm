package io.realm;


public interface BeaconDataRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$uuid();
    public void realmSet$uuid(String value);
    public String realmGet$major();
    public void realmSet$major(String value);
    public String realmGet$minor();
    public void realmSet$minor(String value);
    public String realmGet$x_position();
    public void realmSet$x_position(String value);
    public String realmGet$y_position();
    public void realmSet$y_position(String value);
    public String realmGet$position();
    public void realmSet$position(String value);
    public String realmGet$created_at();
    public void realmSet$created_at(String value);
    public String realmGet$updated_at();
    public void realmSet$updated_at(String value);
    public RealmList<com.sumroch.spotme.models.db.PromotionData> realmGet$promotionData();
    public void realmSet$promotionData(RealmList<com.sumroch.spotme.models.db.PromotionData> value);
}
