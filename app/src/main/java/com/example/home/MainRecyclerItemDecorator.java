package com.example.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This class is for setting ItemDecoration for RecyclerView
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
public class MainRecyclerItemDecorator extends RecyclerView.ItemDecoration {

    private final Paint paint;
    private int dividerHeight;
    private int layoutOrientation = -1;

    public MainRecyclerItemDecorator(Context ctx, int dHeight) {
        dividerHeight = dHeight;
        paint = new Paint();
        paint.setColor(ctx.getResources().getColor(R.color.colorBody));
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (layoutOrientation == LinearLayoutManager.HORIZONTAL) {
            outRect.set(0, 0, dividerHeight, 0);
        } else {
            outRect.set(0, 0, 0, dividerHeight);
        }

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        if (layoutOrientation == LinearLayoutManager.HORIZONTAL) {
            horizontalDivider(c, parent);
        } else {
            verticalDivider(c, parent);
        }
    }

    /**
     * Filling a horizontal divider for all RecyclerView items/rows
     *
     * @author Kayis Rahman
     * @since 1.0.0
     * @param c {@link Canvas}
     * @param parent {@link RecyclerView}
     */
    private void horizontalDivider(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int itemCount = parent.getChildCount();
        for (int i = 0; i < itemCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            c.drawLine(left, top, left, bottom, paint);
        }
    }

    /**
     * Filling a vertical divider for all RecyclerView items/rows
     * @param c {@link Canvas}
     * @param parent {@link RecyclerView}
     */
    private void verticalDivider(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            c.drawLine(left, top, right, top, paint);
        }
    }
}
