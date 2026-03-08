import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Produk>   daftarBarang = new ArrayList<>();

        daftarBarang.add(new Produk(1, "Samsung Galaxy S23", 12000000, 100));
        daftarBarang.add(new Produk(2, "iPhone 14", 15000000, 90));
        daftarBarang.add(new Produk(3, "Xiaomi Redmi Note 12", 3000000, 29));
        daftarBarang.add(new Produk(4, "Oppo A78", 3500000, 45));
        daftarBarang.add(new Produk(5, "Vivo V29", 4500000, 87));
        daftarBarang.add(new Produk(6, "Power Bank 10000mAh", 150000, 15));
        daftarBarang.add(new Produk(7, "Charger Fast Charging", 100000, 20));
        daftarBarang.add(new Produk(8, "Headset Bluetooth", 250000, 12));
        daftarBarang.add(new Produk(9, "Tempered Glass", 50000, 30));
        daftarBarang.add(new Produk(10, "Softcase HP", 40000, 25));

        System.out.println("=== DAFTAR BARANG TOKO HP ===");
        for (Produk p : daftarBarang) {
            System.out.printf("%d. %s | Rp%,.0f | Stok: %d\n",
        p.getId(),
        p.getNama(),
        p.getHarga(),
        p.getStok());

        }

        Pesanan pesanan = new Pesanan(101);

        String lanjut;
        do {
            System.out.print("\nPilih ID barang: ");
            int idPilih = input.nextInt();

            System.out.print("Jumlah beli: ");
            int jumlah = input.nextInt();

            Produk produkDipilih = null;
            for (Produk p : daftarBarang) {
                if (p.getId() == idPilih) {
                    produkDipilih = p;
                    break;
                }
            }

            if (produkDipilih != null) {
                if (jumlah <= produkDipilih.getStok()) {
                    pesanan.tambahItem(produkDipilih, jumlah);
                    produkDipilih.setStok(produkDipilih.getStok() - jumlah);
                    System.out.println("Barang berhasil ditambahkan!");
                } else {
                    System.out.println("Stok tidak cukup!");
                }
            } else {
                System.out.println("ID tidak ditemukan!");
            }

            System.out.print("Tambah barang lagi? (y/n): ");
            lanjut = input.next();

        } while (lanjut.equalsIgnoreCase("y"));

        System.out.println("\n=== TOTAL PESANAN ===");
        System.out.printf("Total bayar: Rp%.0f\n", pesanan.hitungTotal());


        input.close();
    }
}
