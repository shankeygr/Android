package com.gotution.app.auth;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserAttributes implements Parcelable {

    @SerializedName("cart_count")
    private int cartCount;

    @SerializedName("is_first_order_delivered")
    private boolean isFirstOrderDelivered;

    @SerializedName("is_device_id_new")
    private boolean isDeviceIdNew;

    @SerializedName("is_undelivered_order_present")
    private boolean isUndeliveredOrderPresent;

    @SerializedName("is_first_order_placed")
    private boolean isFirstOrderPlaced;

    protected UserAttributes(Parcel in) {
        cartCount = in.readInt();
        isFirstOrderDelivered = in.readByte() != 0;
        isDeviceIdNew = in.readByte() != 0;
        isUndeliveredOrderPresent = in.readByte() != 0;
        isFirstOrderPlaced = in.readByte() != 0;
    }

    public static final Creator<UserAttributes> CREATOR = new Creator<UserAttributes>() {
        @Override
        public UserAttributes createFromParcel(Parcel in) {
            return new UserAttributes(in);
        }

        @Override
        public UserAttributes[] newArray(int size) {
            return new UserAttributes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cartCount);
        dest.writeByte((byte) (isFirstOrderDelivered ? 1 : 0));
        dest.writeByte((byte) (isDeviceIdNew ? 1 : 0));
        dest.writeByte((byte) (isUndeliveredOrderPresent ? 1 : 0));
        dest.writeByte((byte) (isFirstOrderPlaced ? 1 : 0));
    }
}

