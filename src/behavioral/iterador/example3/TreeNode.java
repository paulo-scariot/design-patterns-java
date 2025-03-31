package behavioral.iterador.example3;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T value;
    List<TreeNode<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }
}