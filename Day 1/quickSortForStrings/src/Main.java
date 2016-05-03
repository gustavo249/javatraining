public class Main {

    public static void main(String[] args) {
        String[] list = {"a", "f", "c", "b"};
        quickSort(list, 0, list.length - 1);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void quickSort(String[] list, int start, int end) {
        if (start < end) {
            int pIndex = partition(list, start, end);
            quickSort(list, start, pIndex - 1);
            quickSort(list, pIndex + 1, end);
        }
    }

    private static int partition(String[] list, int start, int end) {
        String pivot = list[end];

        int leftCounter = start;
        int rightCounter = end;

        while (leftCounter < rightCounter) {
            while (list[leftCounter].compareTo(pivot) <= 0 && leftCounter < end && rightCounter > leftCounter) {
                leftCounter++;
            }
            while (list[rightCounter].compareTo(pivot) >= 0 && rightCounter > start && rightCounter >= leftCounter) {
                rightCounter--;
            }
            if (leftCounter < rightCounter) {
                swap(list, leftCounter, rightCounter);
                leftCounter++;
                rightCounter--;
            }
        }
        if(start < rightCounter) swap(list, start, rightCounter);
        if(end > leftCounter) swap(list, leftCounter, end);
        return end;
    }

    private static void swap(String[] list, int start, int end) {
        String aux = list[start];
        list[start] = list[end];
        list[end] = aux;
    }
}
