public class Main {

    public static void main(String[] args) {
	// write your code here
        Node root = new Node(1, "root");
        BinaryTree tree = new BinaryTree(root);

        tree.insert(new Node(2, "ironMan"));
        tree.insert(new Node(5, "batman"));
        tree.insert(new Node(6, "superman"));
        tree.insert(new Node(3, "captain America"));
        tree.insert(new Node(4, "hulk"));

        tree.remove(3);
        tree.traverseTreeinOrder(root);
    }
}
