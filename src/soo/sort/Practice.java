package soo.sort;

public class Practice {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5};

    //sort(arr);
    quickSort(arr, 0, arr.length - 1);

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  public static void sort(int[] arr) {
    int arrLength = arr.length;
    int i, j, temp;

    for (i = 1; i < arrLength; i++) {
      temp = arr[i];

      for (j = i - 1; j > 0 && temp < arr[j]; j--) {
        arr[j + 1] = arr[j];
      }

      arr[j + 1] = temp;
    }
  }

  public static void quickSort(int[] data, int l, int r) {
    int left = l;
    int right = r;
    int pivot = data[(l + r) / 2];

    do {
      while (data[left] < pivot) left++;
      while (data[right] > pivot) right++;

      if (left <= right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        left++;
        right--;
      }
    } while (left <= right);

    if (l < right) quickSort(data, l, right);
    if (left < r) quickSort(data, left, r);
  }
}
