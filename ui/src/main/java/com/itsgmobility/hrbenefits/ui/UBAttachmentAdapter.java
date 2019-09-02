package com.itsgmobility.hrbenefits.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class UBAttachmentAdapter extends BaseAdapter {

    private Context mContext;
    private List<FormAttachmentReview> mAttachments;
    private OnAttachmentClickListener mOnClickListener;

    public UBAttachmentAdapter(Context context, List<FormAttachmentReview> attachments) {
        mContext = context;
        mAttachments = attachments;
    }

    @SuppressWarnings("unused")
    public UBAttachmentAdapter withOnClickListener(OnAttachmentClickListener onClickListener) {
        mOnClickListener = onClickListener;

        return this;
    }

    @Override
    public int getCount() {
        return mAttachments.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final FormAttachmentReview formAttachmentReview = mAttachments.get(position);

        final UBAttachment ubAttachment;
        if (convertView == null) {
            ubAttachment = new UBAttachment(mContext);
        } else if (position == mAttachments.size() - 1) {
            ubAttachment = new UBAttachment(mContext);
        } else {
            ubAttachment = (UBAttachment) convertView;
        }

        ubAttachment.setAttachmentLabel(formAttachmentReview.getName());
        ubAttachment.setAttachment(formAttachmentReview.getUri());
        ubAttachment.setErrorMessage(formAttachmentReview.getErrorMessage());

        if (mOnClickListener != null) {
            ubAttachment.setOnClickListener(v ->
                    mOnClickListener.onClick(v, ubAttachment, formAttachmentReview));
        }

        return ubAttachment;
    }

    public interface OnAttachmentClickListener {
        void onClick(View v, UBAttachment ubAttachment, FormAttachmentReview formAttachmentReview);
    }
}