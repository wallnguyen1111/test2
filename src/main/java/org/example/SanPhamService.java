package org.example;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    public List<SanPham> list = new ArrayList<SanPham>();
    public List<SanPham> getList() {
        return list;
    }
    public SanPham sanPham = new SanPham("SP1", "Ten1", 2025, 10.6f, 10, "Danhmuc1");

    public void AddSanPham(SanPham sanPham) {
        if (sanPham.getSoluong() < 1 || sanPham.getSoluong() > 100) {
            throw new IllegalArgumentException("SanPham size must be between 1 and 100");
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa() == sanPham.getMa()) {
                throw new IllegalArgumentException("Ma ko duoc trung");
            }
        }

        list.add(sanPham);
    }
}
