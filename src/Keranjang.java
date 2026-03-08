import java.util.ArrayList;
import java.util.List;

public class Keranjang {
    private List<Produk> daftarProduk;

    public Keranjang() {
        daftarProduk = new ArrayList<>();
    }

    public void tambahProduk(Produk p) {
        daftarProduk.add(p);
    }

    public List<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}
