class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    int[] indegree = new int[n+1];
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] e : edges) {
      int u = e[0], v = e[1];
      indegree[u]++;
      indegree[v]++;

      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    Queue<Integer> q = new LinkedList<>();
    Set<Integer> nodes = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      nodes.add(i);
      if (indegree[i] == 1)
        q.add(i);
    }

    while (!q.isEmpty()) {
      int node = q.poll();
      nodes.remove(node);

      for (int neighbor : adj.get(node)) {
        indegree[neighbor]--;

        if (indegree[neighbor] == 1) {
          q.add(neighbor);
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      int[] e = edges[i];
      if (nodes.contains(e[0]) && nodes.contains(e[1]))
        return e;
    }

    return null;
  }
}
