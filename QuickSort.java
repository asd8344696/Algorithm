import java.util.*;
public class QuickSort{
	static	int[] s=new int[100];
    public static void main(String args[]) {
            int i, n,k;
 			Scanner in=new Scanner(System.in);
 		for (k=1; k<=3; k++) { //�ƤT�^�X
		
 			System.out.print("Round "+k+", Total number of integers n=");
 			
 			n=in.nextInt();
 			
 			System.out.println(n);
 			
 			s[0]=0;
 			
 			for (i=1; i<=n; i++){
 				s[i]=in.nextInt();
 			}
 			
 			//��QuickSort
            quicksort(1,n);
            
            
            System.out.println("The sorted list is:");
            //��X���G
            for (i=1; i<=n;i++){ 
            System.out.print("  "+s[i]);
            }
            
            
            System.out.println();
        }
    }
    
    public static void quicksort(int low, int high) {
    
    	int pivotpoint;
    	//�p�Garray�����ũΥu�Ѥ@�ӭ�
       	if (high>low) {
			//STEP 1 ������I
 			pivotpoint = partition(low,high);
			//STEP 2 �H�����I����� ���ΥX���b���A���ƶi��QuickSort
 			quicksort(low,pivotpoint-1);
			//STEP 3 ���Υk�b���A���ƶi��QuickSort
 			quicksort(pivotpoint+1,high);
   		}	
    }
    //��Divide and Couquer
	//���k�䨫���򩹥��䨫���I���۸I����
	//�������I �N�����I�P�쥻��pivot point ����m
    
    public static int partition(int low, int high){
    	int pivotpoint, left, right, pivotitem,tmp;
    	
    	pivotitem=s[low];
    	left=low;
    	right=high;
    	
    	
    	while(left!=right){
			//�q�̥k�䪺index ��������pivot�p����
    		while(s[right]>=pivotitem&&left<right){
    			right--;
    		}
			//�q�̥��䪺index(pivot)���k���pivot�j����
    		while(s[left]<=pivotitem&&left<right){
    			left++;
    		}
			//�p�G����b�ۼ��e�����i�H�洫���Ȩӥ洫��m
    		if(left<right){
    			tmp=s[left];
    			s[left]=s[right];
    			s[right]=tmp;
    		}
    	}
    	
    	//�p�Gi�Mj�ۼ��F�A�N�N��������I�F
		//�N�����I�P�쥻��pivot point����m
    	pivotpoint=right;
    	tmp=s[low];
    	s[low]=s[pivotpoint];
    	s[pivotpoint]=tmp;
		//�̫�^�Ǥ����I����m
    	return pivotpoint;
    }
}
