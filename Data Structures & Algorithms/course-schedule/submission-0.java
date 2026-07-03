class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    int[] inDegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      adj.get(pre[0]).add(pre[1]);
      inDegree[pre[1]]++;
    }

    Queue<Integer> courseQ = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0)
        courseQ.add(i);
    }

    int finished = 0;
    while (!courseQ.isEmpty()) {
      int node = courseQ.poll();
      finished++;

      for (int neighbor : adj.get(node)) {
        inDegree[neighbor]--;

        if (inDegree[neighbor] == 0) {
          courseQ.add(neighbor);
        }
      }
    }

    return finished == numCourses;
  }
}
