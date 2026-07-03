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
    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 1)
        q.add(i);
    }

    while (!q.isEmpty()) {
      int node = q.poll();
      indegree[node]--;

      for (int neighbor : adj.get(node)) {
        indegree[neighbor]--;

        if (indegree[neighbor] == 1) {
          q.add(neighbor);
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      int[] e = edges[i];
      if (indegree[e[0]] > 0 && indegree[e[1]] > 0)
        return e;
    }

    return null;
  }
}
