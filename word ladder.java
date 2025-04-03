import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; 
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1; 

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                for (int j = 0; j < word.length(); j++) {
                    char[] wordArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        if (newWord.equals(endWord)) {
                            return level + 1; 
                        }

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }
                }
            }
            level++; 
        }

        return 0; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(solution.ladderLength("hit", "cog", wordList)); 
    }
}
