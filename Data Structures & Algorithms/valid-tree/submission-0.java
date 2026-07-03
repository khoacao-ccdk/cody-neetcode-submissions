class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (edges.length > n - 1)
      return false;

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }
    Set<Integer> visited = new HashSet<>();

    if (!dfs(adj, -1, 0, visited))
      return false;

    return visited.size() == n;
  }

  private boolean dfs(List<List<Integer>> adj, int parent, int node, Set<Integer> visited) {
    if (visited.contains(node))
      return false;

    visited.add(node);
    for (int neighbor : adj.get(node)) {
      if (neighbor == parent)
        continue;
      if (!dfs(adj, node, neighbor, visited))
        return false;
    }

    return true;
  }
}
