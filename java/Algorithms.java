public class Algorithms {

	/**
	 * Sorts a given array of integers
	 * @param values, list of items to be sorted
	 */
	public static void bubbleSort(int[] values){
		
		int temp;
		
		for (int i = 0; i < values.length; i++) {
			for (int j = i+1; j < values.length; j++) {
				if(values[i] > values[j]){
					temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
			}
		}
	}

	/**
	 * Searches list for a given integer and returns its position
	 * @param key, item of interest
	 * @param values, list of integers
	 * @param values
	 * @return i, index of key if found, returns -1 otherwise
	 */
	public static int linearSearch(int key, int[] values){

		for (int i = 0; i < values.length; i++) {
			if(key == values[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static int[] insert(int key, int[] values, int position){
		
		int[] temp = new int[values.length+1];
		if(linearSearch(key, values) == -1){
			
				position--;
				
				
				for (int i = 0; i < position; i++) {
					temp[i] = values[i];
				}
				
				temp[position] = key;
				int j;
				
				for (int i = position + 1; i < temp.length; i++) {
					j = i-1;
					temp[i] = values[j];
				}
			
		}
		else{
			System.out.println("Key already in list");
		}
		return temp;
		
	}

    public static void mergeSort(int array[]) {

        if (array.length > 1) {

            int mid = array.length / 2;
            //Left half sub-array
            int[] left = new int[mid];
            System.arraycopy(array, 0, left, 0, mid);
            mergeSort(left);

            //Right half sub-array
            int[] right = new int[mid];
            System.arraycopy(array, mid, right, 0, mid);
            mergeSort(right);

            merge(left, right, array);
        }
    }

    public static void merge(int[] left, int[] right, int[] temp){

        int leftIndex = 0;
        int rightIndex = 0;
        int tempIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length){

            if(left[leftIndex] < right[rightIndex]){
                temp[tempIndex++] = left[leftIndex++];
            }

            else{
                temp[tempIndex++] = right[rightIndex++];
            }
        }
        //Put the remaining left sub-array items in temp array
        while (leftIndex < left.length){
            temp[tempIndex++] = left[leftIndex++];
        }
        //Put the remaining right sub-array items in temp array
        while (rightIndex < right.length) {
            temp[tempIndex++] = right[rightIndex++];
        }
    }


}