package recursion.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private List<TreeNode> children;
    private String call;
    private String returned;

    public TreeNode() {
        children = new ArrayList<>();
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public void append(TreeNode node){
        this.children.add(node);
    }
    public TreeNode getChild(int index){
        return this.children.get(index);
    }
}
