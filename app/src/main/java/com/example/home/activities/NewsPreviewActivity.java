package com.example.home.activities;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.home.MockData;
import com.example.home.R;
import com.example.home.adapter.ItemViewRecyclerAdapter;
import com.example.home.model.Content;
import com.skyhope.showmoretextview.ShowMoreTextView;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * {@link MainActivity} This is the preview activity for all content.
 * It's binding R.layout.activity_news_preview xml layout.
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
public class NewsPreviewActivity extends AppCompatActivity {
    private int contentId;
    private int viewId;

    private ImageView newsImage;
    private TextView newsTitle;
    private TextView newsTime;
    private ShowMoreTextView newsBody;
    private RecyclerView recommendedRecycler;
    private ImageView isFavImage;
    private Content content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_preview);

        contentId = getIntent().getIntExtra("CONTENT_ID", contentId);
        viewId = getIntent().getIntExtra("VIEW_ID", viewId);

        newsImage = findViewById(R.id.newsImage);
        newsTitle = findViewById(R.id.newsTitle);
        newsTime = findViewById(R.id.newsTime);
        newsBody = findViewById(R.id.newsBody);

        // Getting content object based on parent(viewId) and index(contentId) position
        content = MockData.ALL_DATA.get(viewId).getData().get(contentId).getContent();

        newsTitle.setText(content.getTitle());
        newsTime.setText(getFormattedTime(content.getCreatedTime()));
        newsBody.setText(content.getBody());
        newsBody.setShowingLine(4);


        isFavImage = findViewById(R.id.favImageView);
        setFavImageView();

        isFavImage.setOnClickListener(view -> {
            content.setFavourites(!content.isFavourites());
            setFavImageView();
        });

        // Glide will fetch image resource from internet and set as newsImage ImageView resource
        Glide.with(this)
                .load(content.getImageUrl())
                .into(newsImage);

        recommendedRecycler = findViewById(R.id.recommendedRecycler);

        setMainRecycler();
    }


    /**
     * Setting isFavImage ImageView resource. It will toggle fav images based on value in content.isFavourites
     *
     * @author Kayis Rahman
     * @since 1.0.0
     */
    private void setFavImageView() {
        int drawableId = content.isFavourites() ? R.drawable.ic_baseline_favorite_24 : R.drawable.ic_baseline_favorite_border_24;
        isFavImage.setImageResource(drawableId);
    }


    /**
     * Formatting LocalDate object to human readable string
     *
     * @param createdTime {@link LocalDateTime}
     * @return CharSequence
     * @author Kayis Rahman
     * @since 1.0.0
     */
    private CharSequence getFormattedTime(LocalDateTime createdTime) {
        long createdTimeMills = createdTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = System.currentTimeMillis();
        return DateUtils.getRelativeTimeSpanString(createdTimeMills, now, DateUtils.MINUTE_IN_MILLIS);
    }

    /**
     * Initiating recommendedRecycler layout with RecyclerView.LayoutManager and mapping data with ItemViewRecyclerAdapter.class
     *
     * @author Kayis Rahman
     * @since 1.0.0
     */
    private void setMainRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recommendedRecycler.setLayoutManager(layoutManager);

        ItemViewRecyclerAdapter itemRecyclerAdapter = new ItemViewRecyclerAdapter(viewId, this, MockData.VEGETABLES);
        recommendedRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recommendedRecycler.setAdapter(itemRecyclerAdapter);
    }
}