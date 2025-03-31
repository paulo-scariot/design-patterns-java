package behavioral.iterador.example3;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Depth-First
public class TreeDFSIterator<T> implements Iterator<TreeNode<T>> {
    private Stack<TreeNode<T>> stack = new Stack<>();

    public TreeDFSIterator(TreeNode<T> root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode<T> next() {
        TreeNode<T> current = stack.pop();

        List<TreeNode<T>> children = current.children;
        for (int i = children.size() - 1; i >= 0; i--) {
            stack.push(children.get(i));
        }

        return current;
    }
}
