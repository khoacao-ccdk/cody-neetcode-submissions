class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>(numCourses);
    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      indegree[pre[0]]++;
      adj.get(pre[1]).add(pre[0]);
    }

    Queue<Integer> q = new LinkedList<>();
    int[] result = new int[numCourses];
    int finished = 0;

    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0)
        q.add(i);
    }

    while (!q.isEmpty()) {
      int node = q.poll();
      result[finished] = node;
      finished++;

      for (int neighbor : adj.get(node)) {
        indegree[neighbor]--;
        
        if(indegree[neighbor] == 0) {
            q.add(neighbor);
        }
      }
    }

    return finished == numCourses ? result : new int[0];
  }
}
