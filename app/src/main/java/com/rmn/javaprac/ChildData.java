package com.rmn.javaprac;

import android.os.Parcel;
import android.os.Parcelable;

public class ChildData implements Parcelable{
    int id;
    String value;

    protected ChildData(Parcel in) {
        id = in.readInt();
        value = in.readString();
    }

    public static final Creator<ChildData> CREATOR = new Creator<ChildData>() {
        @Override
        public ChildData createFromParcel(Parcel in) {
            return new ChildData(in);
        }

        @Override
        public ChildData[] newArray(int size) {
            return new ChildData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(value);
    }
}
