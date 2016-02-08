package id3;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by juhel on 08/02/2016.
 */
public class Reader {
    public Reader() {
    }

    public DataSetInfo DataSetInfoReader(String path)throws IOException{
        String line;
        DataSetInfo datasetInfo = new DataSetInfo();
        int key = 0;
        try (
                InputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                String[] input = line.split(",");
                if(input[0].equals("Class")) {
                    datasetInfo.setTrueString(input[1]);
                    datasetInfo.setFalseString(input[2]);
                }
                else{
                    ArrayList<String> values = new ArrayList<String>();
                    for(int j = 1; j < input.length; j++){
                        values.add(input[j]);
                    }
                    Attribute attribute = new Attribute(input[0], values);
                    datasetInfo.put(key, attribute);
                    key++;
                }
            }
        }
        return datasetInfo;
    }

    public DataSet DataReader(String path) throws IOException{
        String line;
        DataSet dataset = new DataSet();
        int key = 0;
        try (
                InputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                String[] input = line.split(",");
                Data data = new Data();
                if(input[input.length-1].equals("B")) {
                    data.setCategory(true);
                }
                for(int j = 0; j < input.length-1; j++){
                        data.put(j, input[j]);
                }
                dataset.add(data);
            }
            return dataset;
        }
    }
}
