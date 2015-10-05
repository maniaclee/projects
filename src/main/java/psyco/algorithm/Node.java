package psyco.algorithm;

/**
 * Created by lipeng on 15/9/17.
 */
public class Node {
    public Object value;
    public Node left;
    public Node right;

    public Node(Object value) {
        this.value = value;
    }

    public static Node node(Object value) {
        return new Node(value);
    }

    public Node left(Node n) {
        this.left = n;
        return this;
    }

    public Node right(Node n) {
        this.right = n;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        toString(this, b, "");
        return b.toString();
    }

    private void toString(Node n, StringBuilder b, String offset) {
        b.append(offset).append(n.value).append("\n");
        offset = "\t" + offset;
        if (n.left != null)
            toString(n.left, b, offset);
        if (n.right != null)
            toString(n.right, b, offset);
    }


    public static Node testData() {
        return node(10)
                .left(node(6)
                        .left(node(4))
                        .right(node(8)))
                .right(node(14)
                        .left(node(12))
                        .right(node(18)));
    }

}
