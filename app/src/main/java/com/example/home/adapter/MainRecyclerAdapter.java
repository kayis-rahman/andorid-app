package com.example.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.home.R;
import com.example.home.model.Content;
import com.example.home.model.ItemView;
import com.example.home.model.ViewWrapper;
import com.example.home.model.enums.ViewType;
import com.synnapps.carouselview.CarouselView;

import java.util.List;

import lombok.AllArgsConstructor;

/**
 * {@link MainRecyclerAdapter} is used to mapping vertical RecyclerView in {@link com.example.home.activities.MainActivity} nested RecyclerView
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
@AllArgsConstructor
public class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ViewWrapper> viewWrapperList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ViewType.CAROUSEL.getId()) {
            return new CarouselViewHolder(LayoutInflater.from(context).inflate(R.layout.item_carousel, parent, false));
        }
        return new NestedRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_recycler, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return viewWrapperList.get(position).getViewType().getId();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == ViewType.CAROUSEL.getId()) {
            bindCarouselViewHolder((CarouselViewHolder) viewHolder, position);
        } else {
            bindNesterRecyclerView((NestedRecyclerViewHolder) viewHolder, position);
        }
    }

    @Override
    public int getItemCount() {
        return viewWrapperList.size();
    }


    /**
     * Binding carousel view based on view type. Getting content data from viewWrapperList based on position and loading the image to imageView.
     *
     * @param viewHolder {@link CarouselViewHolder}
     * @param pos int
     * @author Kayis Rahman
     * @since 1.0.0
     */
    private void bindCarouselViewHolder(CarouselViewHolder viewHolder, int pos) {
        List<ItemView> data = viewWrapperList.get(pos).getData();
        viewHolder.carouselView.setPageCount(data.size());
        viewHolder.carouselView.setImageListener((position, imageView) -> {
            Content content = data.get(position).getContent();
            Glide.with(context)
                    .load(content.getImageUrl())
                    .into(imageView);
        });
    }

    /**
     * Binding nested recycler view contents. Getting content info from viewWrapperList based on position and setting child RecyclerView items using setItemRecycler method
     *
     * @param viewHolder {@link NestedRecyclerViewHolder}
     * @param position int
     * @author Kayis Rahman
     * @since 1.0.0
     */
    private void bindNesterRecyclerView(@NonNull NestedRecyclerViewHolder viewHolder, int position) {
        viewHolder.titleTextView.setText(viewWrapperList.get(position).getTitle());
        setItemRecycler(viewHolder.itemRecycler, viewWrapperList.get(position).getData(), position);
    }

    /**
     * Initiating recyclerView layout with horizontal RecyclerView.LayoutManager and mapping data with ItemViewRecyclerAdapter.class
     *
     * @param recyclerView {@link RecyclerView}
     * @param imageViewItemList {@link List<ItemView>}
     * @param position int
     */
    private void setItemRecycler(RecyclerView recyclerView, List<ItemView> imageViewItemList, int position) {
        ItemViewRecyclerAdapter itemRecyclerAdapter = new ItemViewRecyclerAdapter(position, context, imageViewItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }


    /**
     *  This class is extending RecyclerView.ViewHolder for binding ViewType.NESTED_RECYCLER xml layout to JAVA instance
     *
     * @author Kayis Rahman
     * @since 1.0.0
     */
    public static final class NestedRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private RecyclerView itemRecycler;

        public NestedRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title_text);
            itemRecycler = itemView.findViewById(R.id.item_recycler);
        }
    }

    /**
     *  This class is extending RecyclerView.ViewHolder for binding ViewType.CAROUSEL xml layout to JAVA instance
     *
     * @author Kayis Rahman
     * @since 1.0.0
     */
    public static final class CarouselViewHolder extends RecyclerView.ViewHolder {
        private CarouselView carouselView;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);

            carouselView = itemView.findViewById(R.id.carouselView);
        }
    }
}
