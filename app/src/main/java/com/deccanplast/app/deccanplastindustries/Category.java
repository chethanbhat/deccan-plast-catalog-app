package com.deccanplast.app.deccanplastindustries;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class to represent various categories of Furnitures
 * Every Category consists of a Category Code, Category Image and Category Bame
 */

public class Category implements Parcelable {

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
    private int mCategoryCode;
    private int mCategoryImageId;
    private String mCategoryName;

    public Category(int categoryCode, String categoryName, int categoryImageId) {
        this.mCategoryCode = categoryCode;
        this.mCategoryName = categoryName;
        this.mCategoryImageId = categoryImageId;
    }

    public Category(Parcel parcel) {
        this.mCategoryCode = parcel.readInt();
        this.mCategoryName = parcel.readString();
        this.mCategoryImageId = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mCategoryCode);
        out.writeString(mCategoryName);
        out.writeInt(mCategoryImageId);
    }

    public int getmCategoryCode() {
        return mCategoryCode;
    }

    public int getmCategoryImageId() {
        return mCategoryImageId;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }
}
