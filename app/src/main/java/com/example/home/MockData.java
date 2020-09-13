package com.example.home;

import com.example.home.model.Content;
import com.example.home.model.ItemView;
import com.example.home.model.ViewWrapper;
import com.example.home.model.enums.ContentType;
import com.example.home.model.enums.ViewType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * A simple Data Repository for this application
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
public class MockData {

    public static final List<ViewWrapper> ALL_DATA = new ArrayList<>();
    private static final String TITLE = "Multi line demo texts";
    private static final String WRAPPER_HEIGHT = "200px";
    private static final String WRAPPER_WIDTH = "360px";
    private static final String BODY = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don\\'t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn\\'t anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";

    private final static String IMAGE_URL_HEIGHT_PREFIX = "&h=";
    private final static String IMAGE_URL_WIDTH_PREFIX = "&w=";
    private static final String[] vegetablesArray = new String[]{
            "https://images.pexels.com/photos/2255935/pexels-photo-2255935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2255935/pexels-photo-2255935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2255935/pexels-photo-2255935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2255935/pexels-photo-2255935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2255935/pexels-photo-2255935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    };
    public static final List<ItemView> VEGETABLES = buildWrapperViews(vegetablesArray);
    private static final String[] foodsArray = new String[]{
            "https://images.pexels.com/photos/1633578/pexels-photo-1633578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1633578/pexels-photo-1633578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1633578/pexels-photo-1633578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1633578/pexels-photo-1633578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1633578/pexels-photo-1633578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    };
    public static final List<ItemView> FOODS = buildWrapperViews(foodsArray);
    private static final String[] juiceArray = new String[]{
            "https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/338713/pexels-photo-338713.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    };
    public static final List<ItemView> JUICE = buildWrapperViews(juiceArray);
    private static final String[] hotBeverageArray = new String[]{
            "https://images.pexels.com/photos/302896/pexels-photo-302896.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/302896/pexels-photo-302896.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/302896/pexels-photo-302896.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/302896/pexels-photo-302896.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/302896/pexels-photo-302896.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    };
    public static final List<ItemView> HOT_BEVERAGE = buildWrapperViews(hotBeverageArray);
    private static final String[] fruitsArray = new String[]{
            "https://images.pexels.com/photos/429807/pexels-photo-429807.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/429807/pexels-photo-429807.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/429807/pexels-photo-429807.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/429807/pexels-photo-429807.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/429807/pexels-photo-429807.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    };
    public static final List<ItemView> FRUITS = buildWrapperViews(fruitsArray);
    private static final String[] hotBeverageHorizontalArray = new String[]{
            "https://images.pexels.com/photos/705869/pexels-photo-705869.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/705869/pexels-photo-705869.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/705869/pexels-photo-705869.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/705869/pexels-photo-705869.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/705869/pexels-photo-705869.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
    };
    public static final List<ItemView> HOT_BEVERAGE_HORIZONTAL = buildWrapperViews(hotBeverageHorizontalArray);
    private static final String[] foodsHorizontalArray = new String[]{
            "https://images.pexels.com/photos/1351238/pexels-photo-1351238.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/1351238/pexels-photo-1351238.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/1351238/pexels-photo-1351238.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/1351238/pexels-photo-1351238.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
            "https://images.pexels.com/photos/1351238/pexels-photo-1351238.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=2",
    };
    public static final List<ItemView> FOODS_HORIZONTAL = buildWrapperViews(foodsHorizontalArray);

    static {
        ALL_DATA.add(new ViewWrapper("", MockData.HOT_BEVERAGE_HORIZONTAL, ViewType.CAROUSEL));
        ALL_DATA.add(new ViewWrapper("Fruits", MockData.FRUITS, ViewType.NESTED_RECYCLER));
        ALL_DATA.add(new ViewWrapper("Vegetables", MockData.VEGETABLES, ViewType.NESTED_RECYCLER));
        ALL_DATA.add(new ViewWrapper("Foods", MockData.FOODS, ViewType.NESTED_RECYCLER));
        ALL_DATA.add(new ViewWrapper("Juice", MockData.JUICE, ViewType.NESTED_RECYCLER));
        ALL_DATA.add(new ViewWrapper("", MockData.FOODS_HORIZONTAL, ViewType.CAROUSEL));
        ALL_DATA.add(new ViewWrapper("Hot Beverage", MockData.HOT_BEVERAGE, ViewType.NESTED_RECYCLER));
        ALL_DATA.add(new ViewWrapper("Foods", MockData.FOODS, ViewType.NESTED_RECYCLER));
    }


    /**
     * Building wrapper views and mapping to {@link Content} objects using mapToContent method
     *
     * @author Kayis Rahman
     * @since 1.0.0
     * @param valueArray {@link String[]}
     * @return ArrayList<ItemView>
     */
    private static ArrayList<ItemView> buildWrapperViews(String[] valueArray) {
        return IntStream.range(0, valueArray.length)
                .mapToObj(i -> mapToContent(i, valueArray))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Mapping url string and creating a mock content object.
     *
     * @author Kayis Rahman
     * @since 1.0.0
     * @param i
     * @param valueArray {@link String[]}
     * @return ItemView
     */
    private static ItemView mapToContent(int i, String[] valueArray) {
        Content content = new Content(i, TITLE, boxImageUrl(valueArray[i]), LocalDateTime.now(), BODY, false, ContentType.NEWS);
        return new ItemView(content);
    }

    /**
     * Appending height(IMAGE_URL_HEIGHT_PREFIX) and width(IMAGE_URL_WIDTH_PREFIX) params to url
     * @param s {@link String}
     * @return String
     */
    private static String boxImageUrl(String s) {
        return new StringBuilder(s).append(IMAGE_URL_HEIGHT_PREFIX)
                .append(WRAPPER_HEIGHT).append(IMAGE_URL_WIDTH_PREFIX)
                .append(WRAPPER_WIDTH).toString();
    }
}
