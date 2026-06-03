/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
    if(node == null) return null;
    
    Map<Node, Node> cloneMap = new HashMap<>();

    cloneHelper(node, cloneMap);

    return cloneMap.get(node);
  }

  private Node cloneHelper(Node node, Map<Node, Node> cloneMap) {
    if(cloneMap.containsKey(node)) {
        return cloneMap.get(node);
    }

    Node clone = new Node(node.val, new ArrayList<>());
    cloneMap.put(node, clone);
    List<Node> clonedNeighbors = clone.neighbors;

    for(Node nb : node.neighbors) {
        Node clonedNb = cloneHelper(nb, cloneMap);
        clonedNeighbors.add(clonedNb);
    }

    return clone;
  }
}