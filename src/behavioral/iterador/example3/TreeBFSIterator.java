package behavioral.iterador.example3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Breadth-First
public class TreeBFSIterator<T> implements Iterator<TreeNode<T>> {
    private Queue<TreeNode<T>> queue = new LinkedList<>();

    public TreeBFSIterator(TreeNode<T> root) {
        if (root != null) {
            queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public TreeNode<T> next() {
        TreeNode<T> current = queue.poll();

        queue.addAll(current.children);

        return current;
    }
}
