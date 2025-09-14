class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Exact match set
        Set<String> exactWords = new HashSet<>();
        
        // 2. Case-insensitive map
        Map<String, String> caseInsensitive = new HashMap<>();
        
        // 3. Vowel-error map
        Map<String, String> vowelInsensitive = new HashMap<>();
        
        // Fill the structures
        for (String word : wordlist) {
            exactWords.add(word);
            
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            
            String devoweled = devowel(lower);
            vowelInsensitive.putIfAbsent(devoweled, word);
        }
        
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (exactWords.contains(query)) {
                ans[i] = query;  // exact match
                continue;
            }
            
            String lowerQuery = query.toLowerCase();
            if (caseInsensitive.containsKey(lowerQuery)) {
                ans[i] = caseInsensitive.get(lowerQuery);
                continue;
            }
            
            String devoweledQuery = devowel(lowerQuery);
            if (vowelInsensitive.containsKey(devoweledQuery)) {
                ans[i] = vowelInsensitive.get(devoweledQuery);
                continue;
            }
            
            ans[i] = ""; // no match
        }
        
        return ans;
    }
     private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}