class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length; // Since we now have n edges to form a cyclical graph

    List<List<Integer>> adj = new ArrayList<>(n);

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] e : edges) {
      int u = e[0], v = e[1];
      adj.get(u).add(v);
      adj.get(v).add(u);

      if (!dfs(adj, -1, u, new HashSet<>()))
        return e;
    }

    return null;
  }

  private boolean dfs(List<List<Integer>> adj, int parent, int node, Set<Integer> visited) {
    if (visited.contains(node)) {
      return false;
    }

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
