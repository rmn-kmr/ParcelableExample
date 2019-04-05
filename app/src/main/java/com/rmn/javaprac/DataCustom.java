package com.rmn.javaprac;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

public class DataCustom implements Parcelable {

    int id;
    String data;
    float value;
    List<String> childList;
    ChildData childData;
    List<ChildData> childDataList;

    final Parcelable.Creator<DataCustom> CREATOR = new Creator<DataCustom>() {
        @Override
        public DataCustom createFromParcel(Parcel source) {
            return new DataCustom(source);
        }

        @Override
        public DataCustom[] newArray(int size) {
            return new DataCustom[size];
        }
    };

    private DataCustom(Parcel in) {
        this.id = in.readInt();
        this.data = in.readString();
        this.value = in.readFloat();
        in.readStringList(childList);
        childData = in.readParcelable(ChildData.class.getClassLoader());
        childDataList = Arrays.asList((ChildData[]) in.readParcelableArray(ChildData.class.getClassLoader()));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.data);
        dest.writeFloat(this.value);
        dest.writeStringList(childList);
        dest.writeParcelable(childData, flags);
    }
}
