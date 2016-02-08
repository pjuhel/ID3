package id3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by louis on 03/02/2016.
 */

/**
 * Represent one data.
 */
public class Data {
    /**
     * Attributes and their value for the data.
     */
    private Map<Integer,String> attributes;
    /**
     * Category of the data.
     */
    private Boolean category;

    public Data(Boolean category) {
        this.category = category;
        attributes = new HashMap<>();
    }

    public String put(Integer key, String value) {
        return attributes.put(key, value);
    }

    public Boolean getCategory() {
        return category;
    }

    public String getAttribute(Integer integer) {
        return attributes.get(integer);
    }
}
