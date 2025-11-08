
    // ============================
    // NAMA : EGO WINASIS
    // NIM  : 053062337
    // ============================


public class SortingProgram {

    // ============================
    // MERGE SORT (DESCENDING)
    // ============================
    public static void merge(int[] arr, int left, int mid, int right) {
        // Menentukan ukuran array kiri dan kanan
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Membuat array sementara L (left) dan R (right)
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Memindahkan data ke array L dari arr bagian kiri
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        // Memindahkan data ke array R dari arr bagian kanan
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];

        // Indeks awal dari L, R, dan arr utama
        int i = 0, j = 0, k = left;

        // Menggabungkan dua array sementara kembali ke arr utama
        // Sorting descending (nilai terbesar duluan)
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {   // Jika elemen L lebih besar/sama → descending
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Memasukkan sisa elemen dari L jika masih ada
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Memasukkan sisa elemen dari R jika masih ada
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        // Mengecek apakah array masih bisa dibagi
        if (left < right) {
            // Mencari titik tengah
            int mid = (left + right) / 2;

            // Rekursi sorting pada bagian kiri
            mergeSort(arr, left, mid);

            // Rekursi sorting pada bagian kanan
            mergeSort(arr, mid + 1, right);

            // Menggabungkan bagian kiri dan kanan
            merge(arr, left, mid, right);
        }
    }

    // ============================
    // COUNTING SORT (DESCENDING)
    // ============================
    public static void countingSort(int[] arr) {

        // Mencari nilai maksimum dalam array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        // Membuat array count sesuai range nilai (0 sampai max)
        int[] count = new int[max + 1];

        // Menghitung frekuensi setiap angka
        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        // Menyusun hasil sorting ke array utama (descending)
        int index = 0;
        for (int i = max; i >= 0; i--) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // ============================
    // MAIN PROGRAM
    // ============================
    public static void main(String[] args) {

        // Data untuk merge sort
        int[] dataMergeSort = {55, 23, 88, 12, 99, 43, 67, 5};

        // Data untuk counting sort
        int[] dataCountingSort = {10, 2, 35, 20, 5, 1, 40, 15};

        System.out.println("=== MERGE SORT (DESCENDING) ===");
        System.out.print("Sebelum sorting: ");

        // Menampilkan data sebelum merge sort
        for (int n : dataMergeSort) System.out.print(n + " ");

        // Memanggil merge sort
        mergeSort(dataMergeSort, 0, dataMergeSort.length - 1);

        System.out.print("\nSetelah sorting : ");
        // Menampilkan hasil setelah merge sort
        for (int n : dataMergeSort) System.out.print(n + " ");

        System.out.println("\n\n=== COUNTING SORT (DESCENDING) ===");
        System.out.print("Sebelum sorting: ");

        // Menampilkan data sebelum counting sort
        for (int n : dataCountingSort) System.out.print(n + " ");

        // Memanggil counting sort
        countingSort(dataCountingSort);

        System.out.print("\nSetelah sorting : ");
        // Menampilkan hasil setelah counting sort
        for (int n : dataCountingSort) System.out.print(n + " ");
    }
}
