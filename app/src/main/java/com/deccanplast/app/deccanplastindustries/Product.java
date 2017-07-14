package com.deccanplast.app.deccanplastindustries;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chethan on 14/7/17.
 */


public class Product implements Parcelable {

    private int mProductImageId;
    private String mProductName;

    public Product(String productName, int productImageId) {
        this.mProductName = productName;
        this.mProductImageId = productImageId;
    }

    public Product (Parcel parcel){
        this.mProductName = parcel.readString();
        this.mProductImageId = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mProductName);
        out.writeInt(mProductImageId);
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


    public int getmProductImageId() {
        return mProductImageId;
    }

    public String getmProductName() {
        return mProductName;
    }



}
