package io.realm;


public interface PromotionDataRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$beacon_id();
    public void realmSet$beacon_id(String value);
    public String realmGet$promotion_id();
    public void realmSet$promotion_id(String value);
    public String realmGet$created_at();
    public void realmSet$created_at(String value);
    public String realmGet$updated_at();
    public void realmSet$updated_at(String value);
    public com.sumroch.spotme.models.db.Promotion realmGet$promotion();
    public void realmSet$promotion(com.sumroch.spotme.models.db.Promotion value);
}
