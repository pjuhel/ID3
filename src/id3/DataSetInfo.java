package id3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by louis on 08/02/2016.
 */

/**
 * Standard information about the data set.
 */
class DataSetInfo {
    /**
     * Map each attribute of the data set with an unique key.
     */
    public static Map<Integer,Attribute> attributes;
    public static String trueString;
    public static String falseString;

    public static void setTrueString(String trueString) {
        DataSetInfo.trueString = trueString;
    }

    public static void setFalseString(String falseString) {
        DataSetInfo.falseString = falseString;
    }

    public static Attribute put(Integer key, Attribute value) {
        return attributes.put(key, value);
    }

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
