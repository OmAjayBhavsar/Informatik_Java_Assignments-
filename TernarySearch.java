public class TernarySearch {
    static final int UNDEF = -1;
    static int count = 0;

    // to initiate ternary search
    public static int find(int[] a, int x) {
        return _find(a, 0, a.length - 1, x);
    }

    private static int _find(int[] a, int l, int r, int x) {
        count++;
        if (l > r) return UNDEF;

        // mid point
        int m = (l + r) / 2;
        // check if at middle
        if (x == a[m]) return m;
        // if less than middle search left third
        else if (x < a[m]) return _find(a, l, m - 1, x);
        // if more than middle search right third
        else return _find(a, m + 1, r, x);
    }

    public static int ternaryRec(int a[], int x) {
        return _ternaryRec(a, 0, a.length - 1, x);
    }

    public static int _ternaryRec(int a[], int l, int r, int x) {
        count++;
        if (l > r) return UNDEF;
        else {
            // calculation of midpoints dividing the range into three parts
            int thirdPart = (r - l)/ 3;
            int mid1 = l + thirdPart;
            int mid2 = r - thirdPart;
            // check if at middle 1
            if (x == a[mid1]) return mid1;
            // check if at middle 2
            else if (x == a[mid2]) return mid2;
            // if less than middle 1 then search in 1st part
            else if (x < a[mid1]) return _ternaryRec(a, l, mid1 - 1, x);
            // if greater than middle 2 then search in 3rd part
            else if (x > a[mid2]) return _ternaryRec(a, mid2 + 1, r, x);
            // else search in middle part
            return _ternaryRec(a, mid1, mid2, x);
        }
    }


    public static void main(String[] args) {
        int[] array = {2, 4, 6, 13, 10, 12};
        System.out.println(ternaryRec(array, 4));
        System.out.println(count);
        count = 0;
        System.out.println(find(array, 4));
        System.out.println(count);

    }
}