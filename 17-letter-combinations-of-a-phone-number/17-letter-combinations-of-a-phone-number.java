class Solution {
    public String[] encodes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.length() == 0){
            return ans;
        }
        ans.add("");
        
        for(int i = 0; i < digits.length(); i++){
            int idx = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String permutation = ans.remove();
                for(char c : encodes[idx].toCharArray()){
                    ans.add(permutation+c);
                }
                
            }
        }
        
        
        return ans;
    }
}