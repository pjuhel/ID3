package id3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louis on 03/02/2016.
 */

/**
 * Represent a node of the tree.
 */
public class Node {
    /**
     * Parent node. If null, then the node is the root.
     */
    private Node parent;
    /**
     * Children of the current node.
     */
    private List<Node> children;
    /**
     * id3.Data set of the node.
     */
    private DataSet dataSet;
    /**
     * Label of the node.
     */
    private String label;
    /**
     * Depth of the node.
     */
    private int level;

    public int getLevel() {
        return level;
    }

    public Node(Node node, DataSet data,String value) {
        children = new ArrayList<>();
        parent=node;
        level=0;
        if(parent!=null)
            level=parent.getLevel()+1;
        dataSet=data;
        label=value;
    }

    /**
     * Recursive function generating the tree.
     * @return true if all good, but well it's useless because it never return false.
     */
    public boolean GenerateTree() {
        if(dataSet.isEmpty())
        {
            manageLabel();
            label+="None";
            return true;
        }
        if (dataSet.OnlyTrue()) {
            manageLabel();
            label+="True";
            return true;
        }
        if (dataSet.OnlyFalse()) {
            manageLabel();
            label+="False";
            return true;
        }
        return continueTree();
    }

    /**
     * If the current node is not a leaf, then generating the children.
     * @return
     */
    private boolean continueTree() {
        Integer id = dataSet.findBestAttribute();
        Attribute attribute = DataSetInfo.attributes.get(id);
        manageLabel();
        label+=attribute.getLabel();
        for (String value: attribute.getValues()
             ) {
            Node node = new Node(this,dataSet.getData(id,value),value);
            children.add(node);
        }
        boolean status = true;
        for (Node node: children
             ) {
            status=(node.GenerateTree()&&status);
        }
        return status;
    }

    /**
     * Self-explanatory
     * @return Self-explanatory.
     */
    @Override
    public String toString() {
        String toReturn="";
        toReturn+=label+"\n";
        for (Node node: children
             ) {
            toReturn+=node.toString();
        }
        return toReturn;
    }

    private void manageLabel() {
        String tmp="";
        for (int i = 0; i < level; i++) {
            tmp+="-";
        }
        label=tmp+label;
        if(level!=0)
            label+=":";
    }
}
