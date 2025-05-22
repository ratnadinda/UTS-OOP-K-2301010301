package pencatatannamamahasiswa;
/**
 *
 * @author Ratna Dinda Sari
 * TGL 22-5-2025
 */
import java.util.Scanner;
        
public class PencatatanNamaMahasiswa {
    public class AplikasiPencatatan {
        static String[] data = new String[100]; // Array untuk menyimpan data
        static int jumlahData = 0; // Menyimpan jumlah data yang telah diinput
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU APLIKASI PENCATATAN ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline

            switch (pilihan) {
                case 1:
                    tambahData(scanner);
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    ubahData(scanner);
                    break;
                case 4:
                    hapusData(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }

    static void tambahData(Scanner scanner) {
        if (jumlahData >= data.length) {
            System.out.println("Penyimpanan penuh!");
            return;
        }
        System.out.print("Ratna: ");
        String nama = scanner.nextLine();
        data[jumlahData] = nama;
        jumlahData++;
        System.out.println("Data berhasil ditambahkan.");
    }

    static void tampilkanData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data.");
            return;
        }
        System.out.println("\nData Mahasiswa:");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println((i + 1) + ". " + data[i]);
        }
    }

    static void ubahData(Scanner scanner) {
        tampilkanData();
        if (jumlahData == 0) return;

        System.out.print("Masukkan nomor data yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // membersihkan newline

        if (index >= 0 && index < jumlahData) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            data[index] = namaBaru;
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }

    static void hapusData(Scanner scanner) {
        tampilkanData();
        if (jumlahData == 0) return;

        System.out.print("Masukkan nomor data yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // membersihkan newline

        if (index >= 0 && index < jumlahData) {
            // Menggeser data ke kiri
            for (int i = index; i < jumlahData - 1; i++) {
                data[i] = data[i + 1];
            }
            data[jumlahData - 1] = null;
            jumlahData--;
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }
}

    }
    

