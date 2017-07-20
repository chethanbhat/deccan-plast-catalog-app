package com.deccanplast.app.deccanplastindustries;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chethan on 15/7/17.
 */

public class ProductPage implements Parcelable {
    private String mProductName;
    private int mProductImageId;

    public ProductPage() {
    }


    public ProductPage(String ProductName, int ProductImageId) {
        this.mProductName = ProductName;
        this.mProductImageId = ProductImageId;
    }

    public ProductPage (Parcel parcel){
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
    public static final Parcelable.Creator<ProductPage> CREATOR = new Parcelable.Creator<ProductPage>() {
        public ProductPage createFromParcel(Parcel in) {
            return new ProductPage(in);
        }

        public ProductPage[] newArray(int size) {
            return new ProductPage[size];
        }
    };


    public String getmProductName() {
        return mProductName;
    }

    public int getmProductImageId() {
        return mProductImageId;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public void setmProductImageId(int mProductImageId) {
        this.mProductImageId = mProductImageId;
    }
}
