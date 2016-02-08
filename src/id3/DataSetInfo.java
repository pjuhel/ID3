package id3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by louis on 08/02/2016.
 */

/**
 * Standard information about the data set.
 */
public class DataSetInfo {
    /**
     * Map each attribute of the dataset with an unique key.
     */
    public static Map<Integer,Attribute> attributes;

    /**
     * Get all attribute's key.
     * @return All keys of attributes
     */
    public static Set<Integer> keySet() {
        return attributes.keySet();
    }

    public DataSetInfo() {
        attributes = new HashMap<>();
    }
}
