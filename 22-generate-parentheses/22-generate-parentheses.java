class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list,n,n,"");
        return list;
    }
    
    public void helper(List<String> list, int open, int closed, String s){
        if(open < 0 || closed < 0){
            return;
        }
        if(open == 0 && closed == 0){
            list.add(s);
        }
        
        if(open == closed){
            helper(list,open-1,closed,s+"(");
        }
        else{
            helper(list,open-1,closed,s+"(");
            helper(list,open,closed-1,s+")");
        }
    }
}