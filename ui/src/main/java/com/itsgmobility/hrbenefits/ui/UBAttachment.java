package com.itsgmobility.hrbenefits.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import org.jetbrains.annotations.Nullable;

public class UBAttachment extends RelativeLayout {

    private static final String ERROR_MESSAGE_COLOR = "#FF4336";

    private RelativeLayout relativeLayout;
    private ProgressBar progressBar;
    private AppCompatImageView ivAttachment;
    private AppCompatTextView tvAttachment;

    private String mLabel;

    public UBAttachment(Context context) {
        super(context);
        init(context, null);
    }

    public UBAttachment(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public UBAttachment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.ub_attachment, this);

        relativeLayout = findViewById(R.id.rl_attachment);
        progressBar = findViewById(R.id.progress);
        ivAttachment = findViewById(R.id.iv_attachment);
        tvAttachment = findViewById(R.id.tv_attachment);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UBAttachment);

        try {
            String label = a.getString(R.styleable.UBAttachment_attachmentLabel);
            setAttachmentLabel(label);
        } finally {
            a.recycle();
        }
    }

    @SuppressWarnings("unused")
    public void setErrorMessage(String errorMessage) {
        if (errorMessage != null && !errorMessage.isEmpty()) {
            tvAttachment.setText(Html.fromHtml(
                    mLabel + "<br/><small><font color='" + ERROR_MESSAGE_COLOR + "'>" + errorMessage + "</font><small>"));
        } else {
            tvAttachment.setText(mLabel);
        }
    }

    public void setLayoutLength(int length) {
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();

        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = length;
    }

    @SuppressWarnings("unused")
    public void setAttachmentLabel(String label) {
        mLabel = label;
        tvAttachment.setText(label);
    }

    @SuppressWarnings("unused")
    public AppCompatImageView getAttachmentImageView() {
        return ivAttachment;
    }

    @SuppressWarnings("unused")
    public AppCompatTextView getAttachmentLabel() {
        return tvAttachment;
    }

    public void setAttachment(Object o) {
        if (o == null) {
            ivAttachment.setImageResource(R.drawable.ic_note_add_grey_500_48dp);

            tvAttachment.setBackgroundDrawable(null);
            tvAttachment.setTextColor(Color.DKGRAY);
        } else {
            progressBar.setVisibility(VISIBLE);

            Glide.with(getContext())
                    .asBitmap()
                    .apply(new RequestOptions()
                            .centerCrop()
                            .error(R.drawable.ic_note_add_grey_500_48dp)
                            .diskCacheStrategy(DiskCacheStrategy.NONE))
                    .transition(new BitmapTransitionOptions()
                            .crossFade())
                    .load(o)
                    .listener(new RequestListener<Bitmap>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                            setErrorMessage("Uploading error");
                            tvAttachment.setBackgroundDrawable(null);
                            tvAttachment.setTextColor(Color.DKGRAY);

                            progressBar.setVisibility(GONE);

                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                            tvAttachment.setText(mLabel); // remove error text
                            tvAttachment.setBackgroundResource(R.color.tint);
                            tvAttachment.setTextColor(Color.WHITE);

                            progressBar.setVisibility(GONE);
                            return false;
                        }
                    })
                    .into(ivAttachment);
        }
    }
}
