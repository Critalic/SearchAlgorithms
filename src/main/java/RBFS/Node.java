package RBFS;

public class Node implements Comparable<Node> {
    private final int[][] state;
    private int numberOfConacts;

    public Node(int[][] state, int value) {
        this.state = state;
        this.numberOfConacts = value;
    }

    public void setNumberOfConacts(int numberOfConacts) {
        this.numberOfConacts = numberOfConacts;
    }

    public int[][] getState() {
        return state;
    }

    public int getNumberOfContacts() {
        return numberOfConacts;
    }

    @Override
    public int compareTo(Node o) {
        return this.getNumberOfContacts() - o.getNumberOfContacts();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + numberOfConacts +
                '}';
    }
}
