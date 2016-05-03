import java.util.ArrayList;

public class Main {
    private static String[] data = new String[]{"a", "b", "c", "f", "b", "e", "b"};

    public static void main(String[] args) {
        String[] sortedData = quickSort(data);

        for (String str : sortedData) {
            System.out.println(str);
        }
    }

    private static String[] quickSort(String[] data) {
        if (data.length <= 1) {
            return data;
        }

        String[] sortedData = new String[data.length];

        String pivot = data[data.length - 1];

        ArrayList<String> lessThan = new ArrayList<>();
        ArrayList<String> equalTo= new ArrayList<>();
        ArrayList<String> greaterThan = new ArrayList<>();

        for (String str : data) {
            int compareValue = str.compareTo(pivot);

            if (compareValue < 0) {
                lessThan.add(str);
            } else if (compareValue == 0) {
                equalTo.add(str);
            } else {
                greaterThan.add(str);
            }
        }

        String[] lessThanSorted = quickSort(lessThan.toArray(new String[0]));
        String[] greaterThanSorted = quickSort(greaterThan.toArray(new String[0]));

        int length = 0;
        for (String less: lessThanSorted) {
            sortedData[length++] = less;
        }
        for (String equal : equalTo) {
            sortedData[length++] = equal;
        }
        for (String greater : greaterThanSorted) {
            sortedData[length++] = greater;
        }
        return sortedData;
    }
}
