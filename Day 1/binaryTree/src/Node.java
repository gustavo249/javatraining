/**
 * Created by Gustavo on 03/05/2016.
 */
public class Node {
    private int key;
    private String name;
    protected Node leftChild;
    protected Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", key=" + key +
                '}';
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean remove(int key, Node parent) {
        if (key < this.key) {
            if (leftChild != null)
                return leftChild.remove(key, this);
            else
                return false;
        } else if (key > this.key) {
            if (rightChild != null)
                return rightChild.remove(key, this);
            else
                return false;
        } else {
            if (leftChild != null && rightChild != null) {
                this.key = rightChild.minKey(); //replace the value of the node with the minimum one
                rightChild.remove(this.key, this); //because the right subtree contains a duplicate we remove it
            } else if (parent.leftChild == this) {
                parent.leftChild = (leftChild != null) ? leftChild : rightChild;
            } else if (parent.rightChild == this) {
                parent.rightChild = (leftChild != null) ? leftChild : rightChild;
            }
            return true;
        }
    }

    /**
     * finding the minimum value in the right subtree
     * @return
     */
    public int minKey() {
        if (leftChild == null)
            return key;
        else
            return leftChild.minKey();
    }
}
