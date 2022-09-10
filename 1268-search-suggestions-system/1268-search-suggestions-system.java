class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>();
        if(searchWord.length() == 0 || products.length == 0){
            return list;
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < searchWord.length(); i++){
            String str = searchWord.substring(0,i+1);
            List<String> suggestion = new ArrayList<>();
            
            for(String prod : products){
                if(prod.startsWith(str)){
                    pq.add(prod);
                    
                    if(pq.size() > 3){
                        pq.remove();
                    }
                }
            }
            
            while(pq.size() > 0){
                suggestion.add(0,pq.remove());
            }
            
            list.add(suggestion);
            
        }
        
        return list;
    }
    
}