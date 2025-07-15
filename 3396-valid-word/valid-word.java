class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3)
            return false;
        Set<Character>set=Set.of('a','e','i','o','u','A','E','I','O','U');
        boolean isVowel = false, isConsonent = false;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!(Character.isDigit(ch) || Character.isLetter(ch))) {
                return false;
            }
            if (!isVowel && set.contains(ch)) {
                isVowel=true;
            }
            if (!isConsonent &&  !set.contains(ch) && !Character.isDigit(ch)) {
                isConsonent=true;
            }
        }
        return isVowel && isConsonent;
    }
}