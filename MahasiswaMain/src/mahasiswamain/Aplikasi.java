/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mahasiswamain;

import java.util.Scanner;
/**
 *
 * @author User
 */
public class Aplikasi {
    private Mahasiswa[] data = new Mahasiswa[100];
    private int count = 0;
    private Scanner input = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\n=== MENU APLIKASI MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Ubah Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // konsumsi enter

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilMahasiswa();
                    break;
                case 3:
                    ubahMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private void tambahMahasiswa() {
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        data[count] = new Mahasiswa(nama, nim);
        count++;
        System.out.println("Data berhasil ditambahkan.");
    }

    private void tampilMahasiswa() {
        System.out.println("\n=== DAFTAR MAHASISWA ===");
        if (count == 0) {
            System.out.println("Belum ada data.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + data[i]);
            }
        }
    }

    private void ubahMahasiswa() {
        tampilMahasiswa();
        System.out.print("Pilih nomor mahasiswa yang ingin diubah: ");
        int index = input.nextInt() - 1;
        input.nextLine(); // konsumsi enter
        if (index >= 0 && index < count) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = input.nextLine();
            System.out.print("Masukkan NIM baru: ");
            String nimBaru = input.nextLine();
            data[index].setNama(namaBaru);
            data[index].setNim(nimBaru);
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private void hapusMahasiswa() {
        tampilMahasiswa();
        System.out.print("Pilih nomor mahasiswa yang ingin dihapus: ");
        int index = input.nextInt() - 1;
        if (index >= 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                data[i] = data[i + 1];
            }
            count--;
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }
}