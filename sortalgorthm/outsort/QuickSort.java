package sortalgorthm.outsort;
//快速排序

public class QuickSort {
    public int data[];

    public static void sort(int data[], int low, int hight) {
        QuickSort qs = new QuickSort();
        qs.data = data;
        qs.sort(low, hight);
    }

    private int partition(int sortArray[], int low, int hight) {
        int key = sortArray[low];
        while (low < hight) {
            while (low < hight && sortArray[hight] >= key) {
                hight--;
            }
            sortArray[low] = sortArray[hight];
            while (low < hight && sortArray[low] <= key) {
                low++;
            }
            sortArray[hight] = sortArray[low];
        }
        sortArray[low] = key;
        return low;
    }

    public void sort(int low, int hight) {
        if (low < hight) {
            int result = partition(data, low, hight);
            sort(low, result - 1);
            sort(result + 1, hight);
        }
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            System.out.print(" ");
        }
    }
}