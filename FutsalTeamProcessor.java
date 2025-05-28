import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FutsalTeamProcessor {
    public static void main(String[] args) {
        // ================== MENGGUNAKAN ARRAY BIASA ==================
        System.out.println("================== NO 1 ==================");

        // Data awal dalam bentuk array biasa
        int[][] timA = {
                { 1, 168, 50 }, { 2, 170, 60 }, { 3, 165, 56 }, { 4, 168, 55 }, { 5, 172, 60 },
                { 6, 170, 70 }, { 7, 169, 66 }, { 8, 165, 56 }, { 9, 171, 72 }, { 10, 166, 56 }
        };

        int[][] timB = {
                { 1, 170, 66 }, { 2, 167, 60 }, { 3, 165, 59 }, { 4, 166, 58 }, { 5, 168, 58 },
                { 6, 175, 71 }, { 7, 172, 68 }, { 8, 171, 68 }, { 9, 168, 65 }, { 10, 169, 60 }
        };

        // 1a. Urutkan berdasarkan tinggi badan (ascending & descending)
        System.out.println("\n1a. Urutan berdasarkan tinggi badan:");

        // Urutkan Tim A ascending (tinggi badan)
        Arrays.sort(timA, Comparator.comparingInt(a -> a[1]));
        System.out.println("\nTim A - Ascending:");
        printArray(timA);

        // Urutkan Tim A descending (tinggi badan)
        Arrays.sort(timA, (a, b) -> b[1] - a[1]);
        System.out.println("\nTim A - Descending:");
        printArray(timA);

        // Urutkan Tim B ascending (tinggi badan)
        Arrays.sort(timB, Comparator.comparingInt(a -> a[1]));
        System.out.println("\nTim B - Ascending:");
        printArray(timB);

        // Urutkan Tim B descending (tinggi badan)
        Arrays.sort(timB, (a, b) -> b[1] - a[1]);
        System.out.println("\nTim B - Descending:");
        printArray(timB);

        // 1b. Urutkan berdasarkan berat badan (ascending & descending)
        System.out.println("\n1b. Urutan berdasarkan berat badan:");

        // Urutkan Tim A ascending (berat badan)
        Arrays.sort(timA, Comparator.comparingInt(a -> a[2]));
        System.out.println("\nTim A - Ascending:");
        printArray(timA);

        // Urutkan Tim A descending (berat badan)
        Arrays.sort(timA, (a, b) -> b[2] - a[2]);
        System.out.println("\nTim A - Descending:");
        printArray(timA);

        // Urutkan Tim B ascending (berat badan)
        Arrays.sort(timB, Comparator.comparingInt(a -> a[2]));
        System.out.println("\nTim B - Ascending:");
        printArray(timB);

        // Urutkan Tim B descending (berat badan)
        Arrays.sort(timB, (a, b) -> b[2] - a[2]);
        System.out.println("\nTim B - Descending:");
        printArray(timB);

        // 1c. Mencari nilai maksimum dan minimum
        System.out.println("\n1c. Nilai maksimum dan minimum:");

        // Untuk Tim A
        int[] maxMinA = getMaxMin(timA);
        System.out.println("Tim A - Tinggi: Max=" + maxMinA[0] + " cm, Min=" + maxMinA[1] + " cm");
        System.out.println("Tim A - Berat: Max=" + maxMinA[2] + " kg, Min=" + maxMinA[3] + " kg");

        // Untuk Tim B
        int[] maxMinB = getMaxMin(timB);
        System.out.println("Tim B - Tinggi: Max=" + maxMinB[0] + " cm, Min=" + maxMinB[1] + " cm");
        System.out.println("Tim B - Berat: Max=" + maxMinB[2] + " kg, Min=" + maxMinB[3] + " kg");

        // 1d. Copy Tim B ke Tim C
        int[][] timC = Arrays.copyOf(timB, timB.length);
        System.out.println("\n1d. Tim C (copy dari Tim B):");
        printArray(timC);

        // ================== MENGGUNAKAN ARRAYLIST ==================
        System.out.println("\n================== NO 2 ==================");

        // 2a. Implementasi ArrayList terpisah
        ArrayList<Pemain> arrayListTimA = new ArrayList<>();
        ArrayList<Pemain> arrayListTimB = new ArrayList<>();

        // Inisialisasi data ArrayList Tim A
        for (int[] data : timA) {
            arrayListTimA.add(new Pemain("A", data[0], data[1], data[2]));
        }

        // Inisialisasi data ArrayList Tim B
        for (int[] data : timB) {
            arrayListTimB.add(new Pemain("B", data[0], data[1], data[2]));
        }

        System.out.println("\n2a. Implementasi ArrayList:");
        System.out.println("Data Tim A:");
        arrayListTimA.forEach(System.out::println);
        System.out.println("\nData Tim B:");
        arrayListTimB.forEach(System.out::println);

        // 2b. Binary Search untuk Tim B (tinggi badan)
        Collections.sort(arrayListTimB, Comparator.comparingInt(p -> p.tinggiBadan));
        int tinggiCari1 = 168;
        int tinggiCari2 = 160;

        int count168 = binarySearchCount(arrayListTimB, tinggiCari1, true);
        int count160 = binarySearchCount(arrayListTimB, tinggiCari2, true);

        System.out.println("\n2b. Jumlah pemain Tim B dengan tinggi:");
        System.out.println("168 cm: " + count168);
        System.out.println("160 cm: " + count160);

        // 2c. Binary Search untuk Tim A (berat badan)
        Collections.sort(arrayListTimA, Comparator.comparingInt(p -> p.beratBadan));
        int beratCari1 = 56;
        int beratCari2 = 53;

        int count56 = binarySearchCount(arrayListTimA, beratCari1, false);
        int count53 = binarySearchCount(arrayListTimA, beratCari2, false);

        System.out.println("\n2c. Jumlah pemain Tim A dengan berat:");
        System.out.println("56 kg: " + count56);
        System.out.println("53 kg: " + count53);

        // 2d. Cek kesamaan data antara Tim A dan B
        boolean adaTinggiSama = checkSameValue(arrayListTimA, arrayListTimB, true);
        boolean adaBeratSama = checkSameValue(arrayListTimA, arrayListTimB, false);

        System.out.println("\n2d. Apakah ada pemain dengan tinggi/berat yang sama di Tim A dan B?");
        System.out.println("Tinggi badan sama: " + (adaTinggiSama ? "Ya" : "Tidak"));
        System.out.println("Berat badan sama: " + (adaBeratSama ? "Ya" : "Tidak"));
    }

    // Metode untuk mencetak array 2D
    private static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.printf("No: %2d, Tinggi: %3d cm, Berat: %2d kg\n", row[0], row[1], row[2]);
        }
    }

    // Metode untuk mendapatkan nilai max dan min
    private static int[] getMaxMin(int[][] tim) {
        int maxTinggi = Integer.MIN_VALUE;
        int minTinggi = Integer.MAX_VALUE;
        int maxBerat = Integer.MIN_VALUE;
        int minBerat = Integer.MAX_VALUE;

        for (int[] pemain : tim) {
            if (pemain[1] > maxTinggi)
                maxTinggi = pemain[1];
            if (pemain[1] < minTinggi)
                minTinggi = pemain[1];
            if (pemain[2] > maxBerat)
                maxBerat = pemain[2];
            if (pemain[2] < minBerat)
                minBerat = pemain[2];
        }

        return new int[] { maxTinggi, minTinggi, maxBerat, minBerat };
    }

    // Metode untuk binary search count
    private static int binarySearchCount(ArrayList<Pemain> list, int value, boolean isTinggi) {
        Collections.sort(list,
                isTinggi ? Comparator.comparingInt(p -> p.tinggiBadan) : Comparator.comparingInt(p -> p.beratBadan));

        int index = Collections.binarySearch(list,
                new Pemain("", 0, isTinggi ? value : 0, isTinggi ? 0 : value),
                isTinggi ? Comparator.comparingInt(p -> p.tinggiBadan) : Comparator.comparingInt(p -> p.beratBadan));

        if (index < 0)
            return 0;

        int count = 1;
        // Cari ke kiri
        int left = index - 1;
        while (left >= 0 &&
                (isTinggi ? list.get(left).tinggiBadan : list.get(left).beratBadan) == value) {
            count++;
            left--;
        }

        // Cari ke kanan
        int right = index + 1;
        while (right < list.size() &&
                (isTinggi ? list.get(right).tinggiBadan : list.get(right).beratBadan) == value) {
            count++;
            right++;
        }

        return count;
    }

    // Metode untuk mengecek apakah ada nilai yang sama
    private static boolean checkSameValue(ArrayList<Pemain> tim1, ArrayList<Pemain> tim2, boolean isTinggi) {
        ArrayList<Integer> values1 = new ArrayList<>();
        ArrayList<Integer> values2 = new ArrayList<>();

        for (Pemain p : tim1) {
            int val = isTinggi ? p.tinggiBadan : p.beratBadan;
            if (!values1.contains(val))
                values1.add(val);
        }

        for (Pemain p : tim2) {
            int val = isTinggi ? p.tinggiBadan : p.beratBadan;
            if (values1.contains(val))
                return true;
            if (!values2.contains(val))
                values2.add(val);
        }

        return false;
    }
}
