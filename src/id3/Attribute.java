package id3;

import java.util.ArrayList;

/**
 * Created by louis on 08/02/2016.
 */

/**
 * Represent an attribute.
 */
class Attribute {
    /**
     * List of possible value for this attribute.
     */
    private final ArrayList<String> values;
    /**
     * Name of the attribute.
     */
    private final String label;

    public Attribute(String label, ArrayList<String> values) {
        this.label = label;
        this.values = values;
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<String> getValues() {
        return values;
    }
}
