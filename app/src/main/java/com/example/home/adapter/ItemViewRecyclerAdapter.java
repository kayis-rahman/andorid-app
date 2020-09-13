package com.example.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.home.R;
import com.example.home.activities.NewsPreviewActivity;
import com.example.home.model.Content;
import com.example.home.model.ItemView;

import java.util.List;

import lombok.AllArgsConstructor;


/**
 * {@link ItemViewRecyclerAdapter} is used to mapping horizontal RecyclerView in {@link com.example.home.fragment.HomeFragment} RecyclerView
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
@AllArgsConstructor
public class ItemViewRecyclerAdapter extends RecyclerView.Adapter<ItemViewRecyclerAdapter.ItemViewHolder> {

    private int viewId;
    private Context context;
    private List<ItemView> itemViewList;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.contentId = position;
        holder.viewId = viewId;
        Content content = itemViewList.get(position).getContent();
        Glide.with(context)
                .load(content.getImageUrl())
                .into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return itemViewList.size();
    }

    /**
     *  This class is extending RecyclerView.ViewHolder for binding xml layout to JAVA instance
     *
     * @author Kayis Rahman
     * @since 1.0.0
     */
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        int contentId;
        int viewId;
        ImageView itemImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemImage.setOnClickListener(view -> {
                // passing viewId and contentId for getting content object in NewsPreviewActivity.
                Intent intent = new Intent(itemImage.getContext(), NewsPreviewActivity.class);
                intent.putExtra("VIEW_ID", viewId);
                intent.putExtra("CONTENT_ID", contentId);
                itemImage.getContext().startActivity(intent);
            });
        }
    }

}
