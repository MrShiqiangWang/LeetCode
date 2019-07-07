package package_in_201907;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(new SearchInRotatedSortedArray().search(A, 8));
	}

	public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
		int i = 0;
        boolean reverse=false;
		for (; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
                reverse=true;
				break;
			}
		}
        
        if(!reverse){
            int xleft=0;
            int xright=nums.length-1;
            while(xleft<=xright){
                int xmid=(xleft+xright)/2;
                int xkey=nums[xmid];
                if(xkey==target){
                    return xmid;
                }else if(xkey<target){
                    xleft=xmid+1;
                }else{
                    xright=xmid-1;
                }
            }
            return -1;
        }
        

		int left = 0;
		int right = i;
		if (nums[left] <= target && nums[right] >= target) {
			while (left <= right) {
				int mid = (left + right) / 2;
				int key = nums[mid];
				if (key == target) {
					return mid;
				} else if (key < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

        
		int rleft = i + 1;

		int rright = nums.length-1;
        
        if(nums[rleft]<=target&&nums[rright]>=target){
            while (rleft <= rright) {
                int rmid = (rleft + rright) / 2;
                int rkey = nums[rmid];
                if (rkey == target) {
                    return rmid;
                } else if (rkey < target) {
                    rleft = rmid + 1;
                } else {
                    rright = rmid - 1;
                }
            }
        }
		return -1;
	}
}
