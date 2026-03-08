import java.util.ArrayList;
import java.util.List;

public class Pesanan {
    private int nomorPesanan;
    private List<ItemPesanan> daftarItem;

    public Pesanan(int nomorPesanan) {
        this.nomorPesanan = nomorPesanan;
        this.daftarItem = new ArrayList<>();
    }

    public void tambahItem(Produk p, int jumlah) {

    if (jumlah > p.getStok()) {
        System.out.println("Pembelian melebihi stok! Stok tersedia: " + p.getStok());
        return;
    }

    if (jumlah <= 0) {
        System.out.println("Jumlah pembelian tidak valid!");
        return;
    }

    ItemPesanan item = new ItemPesanan(p, jumlah);
    daftarItem.add(item);

    p.setStok(p.getStok() - jumlah);

    System.out.println("Produk berhasil ditambahkan ke pesanan.");
}


    public double hitungTotal() {
        double total = 0;
        for (ItemPesanan item : daftarItem) {
            total += item.getSubtotal();
        }
        return total;
    }

    private class ItemPesanan {
        private Produk produk;
        private int jumlah;

        public ItemPesanan(Produk produk, int jumlah) {
            this.produk = produk;
            this.jumlah = jumlah;
        }

        public double getSubtotal() {
            return produk.getHarga() * jumlah;
        }
    }
}
