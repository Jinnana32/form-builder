package com.unionbankph.hrxmobility.presentation.util.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int mVerticalSpaceHeight;
    private final boolean mSpaceLastItemBelow;

    public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
        this(verticalSpaceHeight, false);
    }

    public VerticalSpaceItemDecoration(int verticalSpaceHeight, boolean spaceLastItemBelow) {
        mVerticalSpaceHeight = verticalSpaceHeight;
        mSpaceLastItemBelow = spaceLastItemBelow;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) != Objects.requireNonNull(parent.getAdapter()).getItemCount() - 1 || mSpaceLastItemBelow) {
            outRect.bottom = mVerticalSpaceHeight;
        }
    }
}