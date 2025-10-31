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

    Các bước CI/CD trên GitHub

    B1: khởi tạo git
    git init
    git add .
    git commit -m "Initial commit of project"
    git branch -M main
    git remote add origin <<link github>>
    git push -u origin main

    B2: Tạo CI
    mkdir -p .github/workflows

    B3: tao notepad
    notepad .github/workflows/ci.yml

    B4 : them cyml
    name: Java CI

    on:
      push:
        branches: [ "main" ]
      pull_request:
        branches: [ "main" ]
      workflow_dispatch:

    jobs:
      build:
        runs-on: ubuntu-latest

        steps:
          - uses: actions/checkout@v4
          - name: Set up JDK 17
            uses: actions/setup-java@v4
            with:
              java-version: '17'
              distribution: 'temurin'
          - name: Build with Maven
            run: mvn -B package --file pom.xml
     B5 : commit
    git add .
    git commit -m"feat: Add Github Actions CI workflow for Java"
    git push origin main



}
