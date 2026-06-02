class Solution {
  private Map<String, Boolean> resultMap = new HashMap<>();

  public boolean wordBreak(String s, List<String> wordDict) {
    if(s.equals("")) return true;

    if(resultMap.containsKey(s)) 
        return resultMap.get(s);

    for(String word : wordDict) {
        if(s.indexOf(word) != 0) continue;
        String leftover = s.substring(word.length());
        boolean leftoverResult = wordBreak(leftover, wordDict);
        resultMap.put(leftover, leftoverResult);

        if(leftoverResult == true)
            return true;
    }

    return false;
  }
}
