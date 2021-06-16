import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Praveenkumar on 12/17/2020.
 */
public class SortingArray {

    public static void main(String[] args) {
        int arr[]={1,3,5,7};
        int arr1[] = {2,4,6,8};
        sorting(merge(arr,arr1));

        // Results : 1,2,3,4,5,6,7,8
    }

    public static int[] merge(int arr[], int arr1[]){
        // Find the size of both
        int l1 = arr.length;
        int l2 = arr1.length;

        int array[] = new int[l1+l2];
        int i = 0;
        for ( ; i < arr.length ; i++){
            array[i] = arr[i];
        }
        i = 0;
        for ( ; i < arr1.length ; i++){
            array[arr.length + i] = arr1[i];
        }
    return array;
    }

    public  static void sorting(int arr[]){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


    }


}
