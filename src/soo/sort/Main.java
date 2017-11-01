package soo.sort;

public class Main {

  public static void main(String[] args) {
    int[] sortArray = new int[]{5, 8, 1, 2, 6, 9};

    long start = System.currentTimeMillis(); //시작하는 시점 계산
    //new BubbleÎ().sort(sortArray);
    //new Selection().sort(sortArray);
    ///new Insertion().sort(sortArray);
    new Quick().sort(sortArray, 0, sortArray.length - 1);
    long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    System.out.println("실행 시간 : " + (end - start) / 1000.0 + "초"); //실행 시간 계산 및 출력

    for (int i : sortArray) {
      System.out.print(i + " ");
    }
  }
}

class Bubble {

  public void sort(int[] array) {
    int arrayLength = array.length;
    int i, j, tempValue;
    int cnt = 0;

    for (i = 0; i < arrayLength - 1; i++) {
      for (j = 0; j < arrayLength - 1; j++) {
        if (array[j] > array[j + 1]) {
          tempValue = array[j + 1];
          array[j + 1] = array[j];
          array[j] = tempValue;
          cnt++;
        }
      }
    }

    System.out.println(String.format("카운트 %d", cnt));
  }
}

class Selection {

  public void sort(int[] arr) {
    int arrLength = arr.length;
    int min; //최소값을 가진 데이터의 인덱스 저장 변수
    int temp;

    for (int i = 0; i < arrLength - 1; i++) { // size-1 : 마지막 요소는 자연스럽게 정렬됨
      min = i;

      for (int j = i + 1; j < arrLength; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }

      temp = arr[min];
      arr[min] = arr[i];
      arr[i] = temp;
    }
  }
}

class Insertion {

  public void sort(int[] arr) {
    int arrLength = arr.length;
    int temp;
    int i, j;

    for (i = 1; i < arrLength; i++) {
      temp = arr[i];

      for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
        arr[j + 1] = arr[j];
      }

      arr[j + 1] = temp;
    }
  }
}

class Quick {

  public void sort(int[] data, int l, int r) {
    int left = l;
    int right = r;
    int pivot = data[(l + r) / 2];

    do {
      while (data[left] < pivot) left++;
      while (data[right] > pivot) right--;
      if (left <= right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
        left++;
        right--;
      }
    } while (left <= right);

    if (l < right) sort(data, l, right);
    if (r > left) sort(data, left, r);
  }
}



//Shell, Radix, Quick, Merge
//이진 탐색
//http://jaewoos.tistory.com/15

