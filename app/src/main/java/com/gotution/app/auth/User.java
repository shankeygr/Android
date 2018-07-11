package com.gotution.app.auth;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    private String email;
    private long id;
    private String image;
    private String name;
    private String phone;
    private boolean verified;
    @SerializedName("wallet_id")
    private long walletId;
    @SerializedName("is_baba")
    private boolean isBaba;

    public String getEmail() {
        if(this.email == null)
            return "";
        return this.email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeLong(this.id);
        dest.writeString(this.image);
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeByte(verified ? (byte) 1 : (byte) 0);
        dest.writeLong(this.walletId);
        dest.writeByte((byte) (isBaba ? 1 : 0));
    }

    public User(User user) {
        this.email = user.email;
        this.name = user.name;
        this.id = user.id;
        this.image = user.image;
        this.phone = user.phone;
        this.verified = user.verified;
        this.walletId = user.walletId;
        this.isBaba = user.isBaba;
    }

    private User(Parcel in) {
        this.email = in.readString();
        this.id = in.readLong();
        this.image = in.readString();
        this.name = in.readString();
        this.phone = in.readString();
        this.verified = in.readByte() != 0;
        this.walletId = in.readLong();
        this.isBaba = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

}

