package com.deccanplast.app.deccanplastindustries;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chethan on 14/7/17.
 */


public class Product implements Parcelable {

    private int mProductCode;
    private int mProductImageId;
    private String mProductName;
    private int mProductCost;
    private String mProductFeatures;
    private String mProductDimensions;
    private String mProductRecommendations;

    public Product(){

    }

    public Product(int productCode,String productName, int productImageId) {
        this.mProductCode = productCode;
        this.mProductName = productName;
        this.mProductImageId = productImageId;
    }

    public Product(int productCode,String productName, int productImageId, int productCost) {
        this.mProductCode = productCode;
        this.mProductName = productName;
        this.mProductImageId = productImageId;
        this.mProductCost = productCost;
    }

    public Product (Parcel parcel){
        this.mProductCode = parcel.readInt();
        this.mProductName = parcel.readString();
        this.mProductImageId = parcel.readInt();
        this.mProductCost = parcel.readInt();
        this.mProductFeatures = parcel.readString();
        this.mProductDimensions = parcel.readString();
        this.mProductRecommendations = parcel.readString();
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


    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getmProductCode() {
        return mProductCode;
    }

    public int getmProductImageId() {
        return mProductImageId;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductCode(int mProductCode) {
        this.mProductCode = mProductCode;
    }

    public void setmProductImageId(int mProductImageId) {
        this.mProductImageId = mProductImageId;
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
}
