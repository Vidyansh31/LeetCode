class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5];
        int frogs = 0, maxFrogs = 0;
        for(int i = 0; i < croakOfFrogs.length(); i++){
            char ch = croakOfFrogs.charAt(i);
            int idx = "croak".indexOf(ch);
            ++count[idx];
            
            if(idx == 0){
                frogs++;
                maxFrogs = Math.max(frogs,maxFrogs);
            }
            else if(count[idx-1] < count[idx]){
                return -1;
            }
            else if(idx == 4){
                frogs--;
            }
        }
        maxFrogs = Math.max(frogs,maxFrogs);
        
        return frogs == 0 ? maxFrogs : -1;
    }
}