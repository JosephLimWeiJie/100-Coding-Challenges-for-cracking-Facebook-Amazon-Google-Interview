import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    
    public static String mostCommonWord(String paragraph, String[] banned) {
        // Ignore a-z & A-Z & '+' to mean one or more occurrence of that element
        String[] arrOfWords = paragraph.split("[^a-zA-Z]+"); 
        Map<String, Integer> hashMap = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        
        int count = 0;
        String ans = "";
        
        for (String word : banned) {
            bannedSet.add(word);
        }
        
        for (String word : arrOfWords) {
            // Remove unwanted characters
            word =  word.toLowerCase().replaceAll("[!?',;.]+", "");
            
            if (!bannedSet.contains(word)) {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
                
                if (hashMap.get(word) > count) {
                    count = hashMap.get(word);
                    ans = word;
                }
            }
        }        
        return ans;
    }
   
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
    
    /*
     * Learning points:
     *
     * For HashSet: (Unordered)
     * Default initial capacity is 16 and load factor is 0.75
     * Load factor = number of stored elements / size of hashTable
     * If current load factor exceeds 0.75, the whole hashTable will rehash again
     * Since HashSet works like a HashMap, 
     * its key is the object you passed in
     * its value is a constant variable
     * so key-value pair becomes {yourObject, "PRESENT"); 
     * 
     * Hashed based set functions(add, remove, contains, size) are in constant time 
     * for average case, assuming elements are well distributed among the buckets 
     * 
     * For HashMap:
     * HashMap uses chaining to resolve collision
     * It uses a linkedlist of nodes (which contains hashValue, key, value, Node (next()))
     * 
     */
}
