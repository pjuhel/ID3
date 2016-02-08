package id3;

import java.util.ArrayList;

/**
 * Created by louis on 08/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        DataSetInfo dataSetInfo = new DataSetInfo();
        int i=0;
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("Yes");
        tmp.add("No");
        DataSetInfo.attributes.put(i,new Attribute("Furniture",tmp));
        i++;
        tmp = new ArrayList<>();
        tmp.add("Yes");
        tmp.add("No");
        DataSetInfo.attributes.put(i,new Attribute("Kitchen",tmp));
        i++;
        tmp = new ArrayList<>();
        tmp.add("3");
        tmp.add("4");
        DataSetInfo.attributes.put(i,new Attribute("Rooms",tmp));

        DataSet dataSet = new DataSet();

        Data data = new Data(true);
        data.put(0,"No");
        data.put(1,"Yes");
        data.put(2,"3");
        dataSet.add(data);

        data = new Data(false);
        data.put(0,"Yes");
        data.put(1,"No");
        data.put(2,"3");
        dataSet.add(data);

        data = new Data(true);
        data.put(0,"No");
        data.put(1,"No");
        data.put(2,"4");
        dataSet.add(data);

        data = new Data(false);
        data.put(0,"No");
        data.put(1,"No");
        data.put(2,"3");
        dataSet.add(data);

        data = new Data(true);
        data.put(0,"Yes");
        data.put(1,"No");
        data.put(2,"4");
        dataSet.add(data);

        Node tree = new Node(null,dataSet,"");
        if(tree.GenerateTree()){
            System.out.print(tree.toString());
        }
    }
}
