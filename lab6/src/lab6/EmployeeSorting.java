

package lab6;

import java.util.Arrays;


public class EmployeeSorting {
    
    public static void bubbleSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && arr[j].compareTo(arr[j + 1]) > 0) || (!ascending && arr[j].compareTo(arr[j + 1]) < 0)) {
                    Employee temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if ((ascending && arr[j].compareTo(arr[minIdx]) < 0) || (!ascending && arr[j].compareTo(arr[minIdx]) > 0)) {
                    minIdx = j;
                }
            }
            Employee temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Employee key = arr[i];
            int j = i - 1;
            while (j >= 0 && ((ascending && arr[j].compareTo(key) > 0) || (!ascending && arr[j].compareTo(key) < 0))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
     public static void quickSort(Employee[] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(arr, low, high, ascending);
            quickSort(arr, low, pi - 1, ascending);
            quickSort(arr, pi + 1, high, ascending);
        }
    }

    private static int partition(Employee[] arr, int low, int high, boolean ascending) {
        Employee pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if ((ascending && arr[j].compareTo(pivot) <= 0) || (!ascending && arr[j].compareTo(pivot) >= 0)) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void mergeSort(Employee[] arr, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, ascending);
            mergeSort(arr, mid + 1, right, ascending);
            merge(arr, left, mid, right, ascending);
        }
    }

    private static void merge(Employee[] arr, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Employee[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        Employee[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if ((ascending && leftArr[i].compareTo(rightArr[j]) <= 0) || (!ascending && leftArr[i].compareTo(rightArr[j]) >= 0)) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void heapSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i, ascending);
        for (int i = n - 1; i > 0; i--) {
            Employee temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0, ascending);
        }
    }

    private static void heapify(Employee[] arr, int n, int i, boolean ascending) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && ((ascending && arr[left].compareTo(arr[largest]) > 0) || (!ascending && arr[left].compareTo(arr[largest]) < 0))) largest = left;
        if (right < n && ((ascending && arr[right].compareTo(arr[largest]) > 0) || (!ascending && arr[right].compareTo(arr[largest]) < 0))) largest = right;
        if (largest != i) {
            Employee swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest, ascending);
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("A05", "Tran Quang", 7),
            new Employee("A03", "Nguyen An", 7),
            new Employee("A01", "Truong Phung", 5),
            new Employee("A04", "Pham Thi Lam", 2),
            new Employee("A02", "Do Trung Ton", 5)
        };

        System.out.println("Original List:");
        System.out.println(Arrays.toString(employees));

        // Bubble Sort (Ascending and Descending)
        bubbleSort(employees, true);
        System.out.println("\nBubble Sort (Ascending):");
        System.out.println(Arrays.toString(employees));

        bubbleSort(employees, false);
        System.out.println("\nBubble Sort (Descending):");
        System.out.println(Arrays.toString(employees));

        // Selection Sort (Ascending and Descending)
        selectionSort(employees, true);
        System.out.println("\nSelection Sort (Ascending):");
        System.out.println(Arrays.toString(employees));

        selectionSort(employees, false);
        System.out.println("\nSelection Sort (Descending):");
        System.out.println(Arrays.toString(employees));

        // Insertion Sort (Ascending and Descending)
        insertionSort(employees, true);
        System.out.println("\nInsertion Sort (Ascending):");
        System.out.println(Arrays.toString(employees));

        insertionSort(employees, false);
        System.out.println("\nInsertion Sort (Descending):");
        System.out.println(Arrays.toString(employees));
        
        System.out.println("Original List:");
        System.out.println(Arrays.toString(employees));

        mergeSort(employees, 0, employees.length - 1, true);
        System.out.println("\nMerge Sort (Ascending):");
        System.out.println(Arrays.toString(employees));

        heapSort(employees, false);
        System.out.println("\nHeap Sort (Descending):");
        System.out.println(Arrays.toString(employees));
    }
    
}
