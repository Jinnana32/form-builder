package com.itsgmobility.hrbenefits.ui;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * model for viewing of form
 * Created by Tenten Ponce on 9/11/2017.
 */

public class FormAttachmentReview implements Parcelable {

    public static final Creator<FormAttachmentReview> CREATOR = new Creator<FormAttachmentReview>() {
        @Override
        public FormAttachmentReview createFromParcel(Parcel in) {
            return new FormAttachmentReview(in);
        }

        @Override
        public FormAttachmentReview[] newArray(int size) {
            return new FormAttachmentReview[size];
        }
    };
    private String id;
    private String name;
    private Uri uri;
    private String errorMessage;

    public FormAttachmentReview(String id, String name, Uri uri) {
        this(id, name, uri, "");
    }

    public FormAttachmentReview(String name, Uri uri) {
        this(name, name, uri, "");
    }

    public FormAttachmentReview(String id, String name, Uri uri, String errorMessage) {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.errorMessage = errorMessage;
    }

    protected FormAttachmentReview(Parcel in) {
        id = in.readString();
        name = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
        errorMessage = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeParcelable(uri, i);
        parcel.writeString(errorMessage);
    }
}