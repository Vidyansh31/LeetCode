class MyCalendar {

    TreeMap<Integer,Integer> bookings;
    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
       Integer prevBooking = bookings.floorKey(start);
        Integer currBooking = bookings.ceilingKey(start);
        
        if(prevBooking != null && start < bookings.get(prevBooking) && end > prevBooking){
            return false;
        }
        else if(currBooking != null &&  start < bookings.get(currBooking) && end > currBooking){
            return false;
        }
        
        bookings.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */