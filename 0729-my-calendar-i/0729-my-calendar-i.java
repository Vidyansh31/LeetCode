class MyCalendar {

    TreeMap<Integer,Integer> bookings;
    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
       Integer prevBooking = bookings.floorKey(start); // return the just less than start key
        Integer nextBooking = bookings.ceilingKey(start); // return the just greater than start key
        
        //check for overlap
       if((prevBooking == null || bookings.get(prevBooking) <= start) && (nextBooking == null || end <= nextBooking)){
           bookings.put(start,end);
           return true;
       }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */