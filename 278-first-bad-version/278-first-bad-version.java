/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // If nth version is not a bad version, then all versions are good.
        if (n <= 0 || !isBadVersion(n)) {
            return -1;
        }
        // If first version is a bad version, then all versions are bad.
        if (isBadVersion(1)) {
            return 1;
        }
        int low = 1;
        int high = n;
        int rv = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(isBadVersion(mid)){
                rv = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return rv;
    }
}