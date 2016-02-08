package id3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by louis on 03/02/2016.
 */

/**
 * Represent one data.
 */
class Data {
    /**
     * Attributes and their value for the data.
     */
    private final Map<Integer,String> attributes;


    /**
     * Category of the data.
     */
    private Boolean category;

    public Data() {
        this.category = false;
        attributes = new HashMap<>();
    }

    public void put(Integer key, String value) {
        attributes.put(key, value);
    }

    public Boolean getCategory() {
        return category;
    }

    public String getAttribute(Integer integer) {
        return attributes.get(integer);
    }

    public void setCategory(Boolean category) {
        this.category = category;
    }


}
