import org.example.KtraTinhTong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;
import static org.junit.jupiter.api.Assertions.*;
public class TestKtraTinhTong {
    private KtraTinhTong ktraTinhTong;

    @BeforeEach
    public void setUp() {
        ktraTinhTong = new KtraTinhTong();
    }

    @Test
    public void testKtraTinhTongHopLe() {
        int num = 5;
        assertEquals(9, ktraTinhTong.tinhTong(num));
    }

    @Test
    public void testKtraTinhTongKoHopLeTren() {
        int num = 101;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ktraTinhTong.tinhTong(num));
        assertEquals("Number phai be hon hoac bang 10 va lon hon 100", ex.getMessage());
    }

    @Test
    public void testKtraTinhTongKoHopLeDuoi() {
        int num = -1;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> ktraTinhTong.tinhTong(num));
        assertEquals("Number phai be hon hoac bang 10 va lon hon 100", ex.getMessage());
    }

    @Test
    public void testKtraTinhTongHopLeBienDuoi() {
        int num = 1;
        assertEquals(1, ktraTinhTong.tinhTong(num));
    }

    @Test
    public void testKtraTinhTongHopLeBienTren() {
        int num = 99;
        assertEquals(2500, ktraTinhTong.tinhTong(num));
    }
}
