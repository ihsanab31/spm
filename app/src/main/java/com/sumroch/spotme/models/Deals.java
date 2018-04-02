package com.sumroch.spotme.models;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class Deals extends RealmObject {
    @PrimaryKey
    @SerializedName("id")
    private int id;
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("picture")
    private String picture;
    @SerializedName("price")
    private double price;
    @SerializedName("discount")
    private double discount;
    @SerializedName("stock")
    private int stock;
    @SerializedName("viewer")
    private int viewer;
    @SerializedName("likers_count")
    private int likersCount;
    @SerializedName("category")
    @Ignore
    private Category category;
    @SerializedName("merchant")
    @Ignore
    private Merchant merchant;

    public Deals(int id, String name, double discount) {
        this.name = name;
        this.id = id;
        this.discount = discount;
    }

    public Deals() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getViewer() {
        return viewer;
    }

    public void setViewer(int viewer) {
        this.viewer = viewer;
    }

    public int getLikersCount() {
        return likersCount;
    }

    public void setLikersCount(int likersCount) {
        this.likersCount = likersCount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return String of formatted price
     */
    public String getFormattedPrice() {
        return formatPrice(price);
    }

    public String formatPrice(double value) {
        NumberFormat format = new DecimalFormat("#,###,###");
        return "IDR. " + format.format(value).replaceAll(",", ".");
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getDummyImage() {
        String[] dummyImage = {
                "https://id-live-03.slatic.net/p/7/erds-jaket-parasut-bolak-balik-maroon-dark-grey-1479698431-11139611-0c5e290b7be65b287d5b6f72615a1f58-webp-zoom_850x850.jpg",
                "https://id-live-01.slatic.net/p/7/vm-jaket-zipper-korean-hoodie-black-outdoor-jacket-ariel-1490971303-98068611-eb1670b903c940d324276893113811c3-webp-zoom_850x850.jpg",
                "https://id-live-01.slatic.net/p/7/givta-blazer-pria-slim-black-1501084931-90018043-8639e785a67707e0ca0cbd09669b2788-webp-zoom_850x850.jpg",
                "https://id-live-02.slatic.net/p/7/dozn-celana-panjang-blackhawk-tactical-outdoor-crm-1491969930-65477251-3170e38fb8da38a2d9db760f9d53961d-webp-zoom_850x850.jpg",
                "https://id-live-01.slatic.net/p/7/nhs-celana-chino-panjang-slim-fit-cream-1503384077-2541708-dda1ecf5089ba08604f2ba8205c768b6-webp-zoom_850x850.jpg"
        };
        return dummyImage[new Random().nextInt(4)];
    }

    public static class Request {
        public static final String DEFAULT_TYPE = "default";
        public static final String DEALS_TYPE = "deals";
        public static final String RECOMMENDATIONS_TYPE = "recommendations";
        public static final String POPULAR_TYPE = "popular";
        public static final String FLASH_SALE_TYPE = "flash_sale";
        public static final String EXCLUSIVE = "exclusive";

        private int offset;
        private int limit = 10;
        private Integer categoryId;
        private String type;
        private String subFilter;
        private String showMerchant = "yes";

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            if (type.equalsIgnoreCase(DEFAULT_TYPE)) {
                type = null;
            }
            this.type = type;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getSubFilter() {
            return subFilter;
        }

        public void setSubFilter(String subFilter) {
            this.subFilter = subFilter;
        }

        public String getShowMerchant() {
            return showMerchant;
        }

        public void setShowMerchant(String showMerchant) {
            this.showMerchant = showMerchant;
        }
    }
}
