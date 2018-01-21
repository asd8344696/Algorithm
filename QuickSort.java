import java.util.*;
public class QuickSort{
	static	int[] s=new int[100];
    public static void main(String args[]) {
            int i, n,k;
 			Scanner in=new Scanner(System.in);
 		for (k=1; k<=3; k++) { //排三回合
		
 			System.out.print("Round "+k+", Total number of integers n=");
 			
 			n=in.nextInt();
 			
 			System.out.println(n);
 			
 			s[0]=0;
 			
 			for (i=1; i<=n; i++){
 				s[i]=in.nextInt();
 			}
 			
 			//做QuickSort
            quicksort(1,n);
            
            
            System.out.println("The sorted list is:");
            //輸出結果
            for (i=1; i<=n;i++){ 
            System.out.print("  "+s[i]);
            }
            
            
            System.out.println();
        }
    }
    
    public static void quicksort(int low, int high) {
    
    	int pivotpoint;
    	//如果array不為空或只剩一個值
       	if (high>low) {
			//STEP 1 找切割點
 			pivotpoint = partition(low,high);
			//STEP 2 以切割點為基準 切割出左半部再重複進行QuickSort
 			quicksort(low,pivotpoint-1);
			//STEP 3 切割右半部再重複進行QuickSort
 			quicksort(pivotpoint+1,high);
   		}	
    }
    //做Divide and Couquer
	//當往右邊走的跟往左邊走的點互相碰撞後
	//找到切割點 將切割點與原本的pivot point 換位置
    
    public static int partition(int low, int high){
    	int pivotpoint, left, right, pivotitem,tmp;
    	
    	pivotitem=s[low];
    	left=low;
    	right=high;
    	
    	
    	while(left!=right){
			//從最右邊的index 往左邊找比pivot小的值
    		while(s[right]>=pivotitem&&left<right){
    			right--;
    		}
			//從最左邊的index(pivot)往右找比pivot大的值
    		while(s[left]<=pivotitem&&left<right){
    			left++;
    		}
			//如果兩邊在相撞前有找到可以交換的值來交換位置
    		if(left<right){
    			tmp=s[left];
    			s[left]=s[right];
    			s[right]=tmp;
    		}
    	}
    	
    	//如果i和j相撞了，就代表找到切割點了
		//將切割點與原本的pivot point換位置
    	pivotpoint=right;
    	tmp=s[low];
    	s[low]=s[pivotpoint];
    	s[pivotpoint]=tmp;
		//最後回傳切割點的位置
    	return pivotpoint;
    }
}
