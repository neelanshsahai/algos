import java.util.*;

public class QuickSort {

  public static long arr[];
	
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Array in the next line");
		String inputString = sc.nextLine();
		String stringArray[] = inputString.split(" ");
		arr = new long[stringArray.length];
		
    for(int i=0; i<stringArray.length; i++)
			arr[i] = Long.parseLong(stringArray[i]);
		
    quick_sort(0, arr.length-1);
		
    for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	private static void quick_sort(int in, int fi) {
		if(in<fi) {
			int pivot = fi;
			
      //sort
			int lo=in, hi=fi-1;
			while(lo<hi) {
				
        if(arr[lo]<=arr[pivot]) {
					lo++;
					continue;
				}
				
        if(arr[hi]>arr[pivot]) {
					hi--;
					continue;
				}
				
        if(arr[lo]>arr[hi]) {
					long tmp = arr[lo];
					arr[lo] = arr[hi];
					arr[hi] = tmp;
					if(lo+1!=hi) {
						lo++;
						hi--;
					}
				}
			}
			if(arr[hi]>arr[pivot]) {
				long tmp = arr[hi];
				arr[hi] = arr[pivot];
				arr[pivot] = tmp;
				pivot = hi;
			}
			else {
				long tmp = arr[hi+1];
				arr[hi+1] = arr[pivot];
				arr[pivot] = tmp;
				pivot = hi+1;				
			}
			
			quick_sort(in, pivot-1);
			quick_sort(pivot+1, fi);
		}
	}
}
