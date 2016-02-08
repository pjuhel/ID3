package id3;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by louis on 08/02/2016.
 */
class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();

        try {
            reader.DataSetInfoReader("C:/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataSet dataSet = null;
        try {
            dataSet = reader.DataReader("C:/data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node tree = new Node(null,dataSet,"");
        if(tree.GenerateTree()){
            System.out.print(tree.toString());
        }
    }
}
