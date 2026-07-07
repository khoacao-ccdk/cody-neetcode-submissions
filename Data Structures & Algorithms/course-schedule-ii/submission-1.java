class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    List<List<Integer>> neighbors = new ArrayList<>(numCourses);

    for(int i = 0; i < numCourses; i++) {
      neighbors.add(new ArrayList<>());
    }

    for(int[] pre : prerequisites) {
      int u = pre[0], v = pre[1];

      indegree[u]++;
      neighbors.get(v).add(u);
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
      if(indegree[i] == 0)
        q.add(i);
    }

    int index = 0;
    int[] result = new int[numCourses];
    while(!q.isEmpty()) {
      int curr = q.poll();
      result[index++] = curr;

      for(int neighbor : neighbors.get(curr)) {
        indegree[neighbor]--;

        if(indegree[neighbor] == 0)
          q.add(neighbor);
      }
    }

    return index == numCourses ? result : new int[]{};
  }
}
