class Solution {
  public int countComponents(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }

    int components = 0;
    Set<Integer> visited = new HashSet<>();

    for (int i = 0; i < n; i++) {
      if (visited.contains(i))
        continue;

      components++;
      dfs(adj, i, visited);
    }

    return components;
  }

  private void dfs(List<List<Integer>> adj, int node, Set<Integer> visited) {
    if (visited.contains(node))
      return;

    visited.add(node);

    for (int neighbor : adj.get(node)) {
      dfs(adj, neighbor, visited);
    }
  }
}
