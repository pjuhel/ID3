package id3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by louis on 03/02/2016.
 */

/**
 * Represent a set of data.
 */
public class DataSet {
    /**
     * All data of the data set.
     */
    private ArrayList<Data> data;
    /**
     * All the attributes key of the data set.
     */
    private ArrayList<Integer> attributes;

    public DataSet() {
        data = new ArrayList<>();
        attributes = new ArrayList<>(DataSetInfo.keySet());
    }

    /**
     * Add a data to the data set.
     * @param data
     * @return
     */
    public boolean add(Data data) {
        return this.data.add(data);
    }

    /**
     * Check if one data of the data set is not of the requested value.
     * @param input : requested value.
     * @return true if all data are of the category gave in inpuyt, false otherwise.
     */
    private boolean Only(boolean input) {
        for (Data data: this.data
             ) {
            if(data.getCategory()!=input)
                return false;
        }
        return true;
    }

    /**
     * Check if all data are from true category.
     * @return self-explanatory.
     */
    public boolean OnlyTrue() {
        return Only(true);
    }

    /**
     * Check if all data are from false category.
     * @return self-explanatory.
     */
    public boolean OnlyFalse() {
        return Only(false);
    }

    /**
     * Check if the data set is empty.
     * @return self-explanatory.
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * Find the best attribute of the data set.
     * @return the key of the best attribute
     */
    public Integer findBestAttribute() {
        double minEntropy=0.0f;
        Integer bestAttribute = -1;
        for (Integer attribute : attributes
                ) {
            double tmp= computeGain(attribute);
            if(tmp>minEntropy)
            {
                bestAttribute=attribute;
                minEntropy=tmp;
            }
        }
        return bestAttribute;
    }

    /**
     * Compute the gain of the attribute
     * @param key : attribute key, as defined in datasetinfo during dataset preparation.
     * @return gain of the attribute
     */
    private double computeGain(Integer key) {
        int dataCount = data.size();
        float entropy = 0.0f;
        int positiveTotal=0;
        int negativeTotal=0;

        Attribute attribute = DataSetInfo.attributes.get(key);
        Map<String,ArrayList<Data>> attributeCount = new HashMap<>();
        for (String value : attribute.getValues()
                ) {
            attributeCount.put(value,new ArrayList<>());
        }
        for (Data data: this.data
             ) {
            String attributeValue = data.getAttribute(key);
            attributeCount.get(attributeValue).add(data);
        }
        for (ArrayList<Data> attributesDatas: attributeCount.values()
             ) {
            int positive=0;
            int negative=0;
            for (Data data: attributesDatas
                 ) {
                if(data.getCategory()){
                    positive++;
                }
                else {
                    negative++;
                }
            }
            entropy-=((double)(positive+negative)/(double)dataCount)*computeInfo(positive,negative);
            positiveTotal+=positive;
            negativeTotal+=negative;
        }
        return entropy+computeInfo(positiveTotal,negativeTotal);
    }

    /**
     * Compute the information from the number of positive/negative data.
     * @param positive : Number of positive data
     * @param negative : Number of negative data.
     * @return Information.
     */
    private double computeInfo(int positive, int negative)
    {
        double positiveRate = (double) positive/(double)(positive+negative);
        double negativeRate = (double) negative/(double)(positive+negative);
        if(positiveRate==0 ||negativeRate==0)
            return 0;
        return (-1/Math.log10(2))*(positiveRate*Math.log10(positiveRate)+negativeRate*Math.log10(negativeRate));
    }

    /**
     * Return all data where the value of the attributes are "value"
     * @param id of the attributes
     * @param value requested attributes value
     * @return data set where all data have {value} for attribute{id}
     */
    public DataSet getData(Integer id, String value) {
        DataSet toReturn = new DataSet();

        for (Data data: this.data
             ) {
            if(data.getAttribute(id) == value) {
                toReturn.add(data);
            }
        }
        return toReturn;
    }
}
