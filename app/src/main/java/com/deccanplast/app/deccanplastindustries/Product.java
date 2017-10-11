package com.deccanplast.app.deccanplastindustries;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Product Class represents various products under Furniture and MHS
 * categories.
 * <p>
 * Each Product has Unique Code, Product Name, Product Cost, Product Image or Product Image Sliders,
 * Product Features, Product Dimensions, Product Recommendations, Product Colors (Optional)
 */


public class Product implements Parcelable {

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    private int mProductCode;
    private int mProductImageId;
    private String mProductName;
    private int mProductCost;
    private String mProductFeatures;
    private String mProductDimensions;
    private String mProductRecommendations;
    private int[] mProductSlider;
    private String[] mProductColors;

    public Product() {

    }

    public Product(int productCode, String productName, int productImageId) {
        this.mProductCode = productCode;
        this.mProductName = productName;
        this.mProductImageId = productImageId;
    }

    public Product(Parcel parcel) {
        this.mProductCode = parcel.readInt();
        this.mProductName = parcel.readString();
        this.mProductImageId = parcel.readInt();
        this.mProductCost = parcel.readInt();
        this.mProductFeatures = parcel.readString();
        this.mProductDimensions = parcel.readString();
        this.mProductRecommendations = parcel.readString();
        this.mProductSlider = parcel.createIntArray();
        this.mProductColors = parcel.createStringArray();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mProductCode);
        out.writeString(mProductName);
        out.writeInt(mProductImageId);
        out.writeInt(mProductCost);
        out.writeString(mProductFeatures);
        out.writeString(mProductDimensions);
        out.writeString(mProductRecommendations);
        out.writeIntArray(mProductSlider);
        out.writeStringArray(mProductColors);
    }

    public int getmProductCode() {
        return mProductCode;
    }

    public void setmProductCode(int mProductCode) {
        this.mProductCode = mProductCode;
    }

    public int getmProductImageId() {
        return mProductImageId;
    }

    public void setmProductImageId(int mProductImageId) {
        this.mProductImageId = mProductImageId;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public int getmProductCost() {
        return mProductCost;
    }

    public void setmProductCost(int mProductCost) {
        this.mProductCost = mProductCost;
    }

    public String getmProductFeatures() {
        return mProductFeatures;
    }

    public void setmProductFeatures(String mProductFeatures) {
        this.mProductFeatures = mProductFeatures;
    }

    public String getmProductDimensions() {
        return mProductDimensions;
    }

    public void setmProductDimensions(String mProductDimensions) {
        this.mProductDimensions = mProductDimensions;
    }

    public String getmProductRecommendations() {
        return mProductRecommendations;
    }

    public void setmProductRecommendations(String mProductRecommendations) {
        this.mProductRecommendations = mProductRecommendations;
    }

    public int[] getmProductSlider() {
        return mProductSlider;
    }

    public void setmProductSlider(int[] mProductSlider) {
        this.mProductSlider = mProductSlider;
    }

    public String[] getmProductColors() {
        return mProductColors;
    }

    public void setmProductColors(String[] mProductColors) {
        this.mProductColors = mProductColors;
    }

    public boolean hasSlider() {
        return mProductSlider != null;
    }

    public boolean hasColors() {
        return mProductColors != null;
    }
}
