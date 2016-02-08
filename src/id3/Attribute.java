package id3;

import java.util.ArrayList;

/**
 * Created by louis on 08/02/2016.
 */

/**
 * Represent an attribute.
 */
public class Attribute {
    /**
     * List of possible value for this attribute.
     */
    private ArrayList<String> values;
    /**
     * Name of the attribute.
     */
    private String label;

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
