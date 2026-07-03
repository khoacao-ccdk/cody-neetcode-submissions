class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    int[] degree = new int[n+1];
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] e : edges) {
      int u = e[0], v = e[1];
      degree[u]++;
      degree[v]++;

      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (degree[i] == 1)
        q.add(i);
    }

    while (!q.isEmpty()) {
      int node = q.poll();
      degree[node]--;

      for (int neighbor : adj.get(node)) {
        degree[neighbor]--;

        if (degree[neighbor] == 1) {
          q.add(neighbor);
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      int[] e = edges[i];
      if (degree[e[0]] > 0 && degree[e[1]] > 0)
        return e;
    }

    return null;
  }
}
