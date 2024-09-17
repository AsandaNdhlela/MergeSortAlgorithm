
public class MergeSortAlgorithm {

	public static void main(String[] args) {
		
		int[] array = new int[1000000];
		
		for (int i = 0; i< array.length; i++) {
			array[i] = (int) (Math.random() * array.length);
		}
//		System.out.println(array.length + "random numbers generated");
		mergeSort(array);
		
		for(int i = 0; i< array.length; i++) {
			System.out.print(array[i]+", ");
		}
	}

	private static void mergeSort(int[] array) {
		
		int length = array.length;
		
		if(length <= 1) {
			return; // base case
		}
		
		int middle = length / 2;
		
		int leftArray[] = new int[middle];
		int rightArray[] = new int[length - middle];
		
		int i = 0;
		int j = 0;
		
		for(; i< length; i++) {
			
			if (i < middle) {
				leftArray[i] = array[i];
				
			}else {
				rightArray[j] = array[i];
				j++;
			}
		}
		
		mergeSort(leftArray);
		mergeSort(rightArray);
		
		merge(leftArray, rightArray, array);
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		
		int i = 0;
		int left = 0;
		int right = 0;
		
		while( left < leftSize && right < rightSize) {
			
			if(leftArray[left] < rightArray[right]) {
				
				array[i] = leftArray[left];
				i++;
				left++;

			}else {
				
				array[i] = rightArray[right];
				i++;
				right++;

			}
		}
		
		while(left < leftSize) {
			array[i] = leftArray[left];
			i++;
			left++;

		}
		
		while(right < rightSize) {
			array[i] = rightArray[right];
			i++;
			right++;

		}
	}

}
