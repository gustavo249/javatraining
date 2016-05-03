/**
 * Created by Gustavo on 03/05/2016.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void insert(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode;

                //if the key value is less than the current node we place the new node on the left
                if (newNode.getKey() < currentNode.getKey()) {
                    currentNode = currentNode.getLeftChild();

                    if (currentNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();

                    if (currentNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void traverseTreeinOrder(Node currentNode) {
        if (currentNode != null) {
            traverseTreeinOrder(currentNode.getLeftChild());
            System.out.println(currentNode);
            traverseTreeinOrder(currentNode.getRightChild());
        }
    }
}
