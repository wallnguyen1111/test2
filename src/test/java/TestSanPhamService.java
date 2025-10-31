import org.example.SanPham;
import org.example.SanPhamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSanPhamService {
    private SanPhamService sanPhamService;

    @BeforeEach
    public void setUp() {
        sanPhamService = new SanPhamService();
    }

    @Test
    public void testThemSpHopLe() {
        SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, 10, "Danhmuc1");
        sanPhamService.AddSanPham(sanPham);
        assertEquals(10, sanPhamService.sanPham.getSoluong());
    }

    @Test
    public void testThemSpKoHopLeTren() {
        SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, 101, "Danhmuc1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sanPhamService.AddSanPham(sanPham));
        assertEquals("SanPham size must be between 1 and 100", ex.getMessage());
    }

    @Test
    public void testThemSpKoHopLeDuoi() {
        SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, -1, "Danhmuc1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sanPhamService.AddSanPham(sanPham));
        assertEquals("SanPham size must be between 1 and 100", ex.getMessage());
    }

    @Test
    public void testThemSpHopLeBienTren() {
        SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, 100, "Danhmuc1");
        sanPhamService.AddSanPham(sanPham);
        assertEquals(1, sanPhamService.getList().size());
    }

    @Test
    public void testThemSpHopLeBienDuoi() {
        SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, 1, "Danhmuc1");
        sanPhamService.AddSanPham(sanPham);
        assertEquals(1, sanPhamService.getList().size());
    }

    @Test
    public void testThemSpKoHopLeTrung() {
        SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, 100, "Danhmuc1");
        sanPhamService.AddSanPham(sanPham);
        SanPham sanPhammoi = new SanPham("SP1", "Ten1", 2025, 10.6f, 100, "Danhmuc1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> sanPhamService.AddSanPham(sanPhammoi));
        assertEquals("Ma ko duoc trung", ex.getMessage());
    }


}
