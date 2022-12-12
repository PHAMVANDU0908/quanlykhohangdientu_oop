package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.WildcardType;
import java.util.Scanner;

import javax.swing.text.html.CSS;

public class quanly implements thuvien {
    public static void menu_thaotacdanhsachkhachhang(){
        System.out.print("====================Thao Tac Voi Danh Sach Khach Hang====================");
        System.out.print("\n\n1:nhap danh sach khach hang lan dau tien ");
        System.out.print("\n2:xuat danh sach khach hang dang ton tai ");
        System.out.print("\n3:them khach hang vao danh sach khach hang ");
        System.out.print("\n4:tim kiem khach hang ");
        System.out.print("\n5:sua thong tin khach hang ");
        System.out.print("\n6:Xoa khach hang");
        System.out.print("\n7:quay lai ");
        System.out.print("\n8:thoat ");
    }


    public static void menu_thaotacdanhsachnhacungcap(){
        System.out.print("====================Thao Tac Voi Danh Sach Nha Cung Cap====================");
        System.out.print("\n\n1:nhap danh sach nha cung cap lan dau tien ");
        System.out.print("\n2:xuat danh sach nha cung cap dang ton tai ");
        System.out.print("\n3:them nha cung cap vao danh sach nha cung cap ");
        System.out.print("\n4:tim kiem nha cung cap ");
        System.out.print("\n5:xoa nha cung cap ");
        System.out.print("\n6:sua nha cung cap ");
        System.out.print("\n7:quay lai ");
        System.out.print("\n8:thoat ");
    }
    
    public static void menu_thaotacdanhsachdienthoai(){
        System.out.print("====================Thao Tac Voi Danh Sach Dien Thoai====================");
        System.out.print("\n\n1:nhap danh sach dien thoai lan dau tien ");
        System.out.print("\n2:xuat danh sach dien thoai dang ton tai ");
        System.out.print("\n3:them dien thoai vao danh sach dien thoai ");
        System.out.print("\n4:tim kiem dien thoai ");
        System.out.print("\n5:xoa dien thoai ");
        System.out.print("\n6:sua thong tin dien thoai ");
        System.out.print("\n7:quay lai ");
        System.out.print("\n8:thoat ");
    }
    
    public static void menu_thaotacdanhsachlaptop(){
        System.out.print("====================Thao Tac Voi Danh Sach laptop====================");
        System.out.print("\n\n1:nhap danh sach laptop lan dau tien ");
        System.out.print("\n2:xuat danh sach laptop dang ton tai ");
        System.out.print("\n3:them laptop vao danh sach laptop ");
        System.out.print("\n4:tim kiem laptop ");
        System.out.print("\n5:xoa laptop ");
        System.out.print("\n6:sua thong tin laptop ");
        System.out.print("\n7:quay lai ");
        System.out.print("\n8:thoat ");
    }

    public static void menu_thaotacdanhsachphieunhap(){
     System.out.println("==================Thao Tac Voi Danh Sach Phieu Nhap==================");
        System.out.println("1:Nhap phieu nhap lan dau");
        System.out.println("2:xuat danh sach phieu ");
        System.out.println("3:tin kiem phieu nhap ");
        System.out.println("4:them phieu nhap");
        System.out.println("5:xoa phieu nhap");
        System.out.println("6:sua phieu nhap");
        System.out.println("7:quay lai");
        System.out.println("8:thoat");
    }
            
    public static void menu_thaotacdanhsachphieuxuat(){
        System.out.println("==================Thao Tac Voi Danh Sach Phieu Xuat==================");
        System.out.println("1:Them phieu xuat");
        System.out.println("2:xuat danh sach phieu xuat");
        System.out.println("3:xem chi tiet phieu xuat ");
        System.out.println("4:xoa phieu xuat");
        System.out.println("5:quay lai");
        System.out.println("6:thoat");
    }
    
    public static void xoamanghinh(){
        //xoa mang hinh
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //
    }
    public static void main(String[] args) throws IOException {
        
        quanly.xoamanghinh();
        
        danhsachkhachhang dskh = new danhsachkhachhang();
        danhsachnhacungcap dsncc = new danhsachnhacungcap();
        FileWriter fw_kh = new FileWriter("danhsachkhachhang.txt", true);
        BufferedWriter writer_kh = new BufferedWriter(fw_kh);
        FileReader fr_kh = new FileReader("danhsachkhachhang.txt");
        BufferedReader reader_kh = new BufferedReader(fr_kh);

        FileWriter fw_ncc = new FileWriter("danhsachnhacungcap.txt", true);
        BufferedWriter writer_ncc = new BufferedWriter(fw_ncc);
        FileReader fr_ncc = new FileReader("danhsachnhacungcap.txt");
        BufferedReader reader_ncc = new BufferedReader(fr_ncc);
        Scanner sc = new Scanner(System.in);

        DanhSachDienThoai dsdt = new DanhSachDienThoai();
        DanhSachLaptop dsLaptop = new DanhSachLaptop();
        FileWriter fw_dt = new FileWriter("danhsachdienthoai.txt", true);
        BufferedWriter writer_dt = new BufferedWriter(fw_dt);
        FileReader fr_dt = new FileReader("danhsachdienthoai.txt");
        BufferedReader reader_dt = new BufferedReader(fr_dt);
        FileWriter fw_laptop = new FileWriter("danhsachlaptop.txt", true);
        BufferedWriter writer_laptop = new BufferedWriter(fw_laptop);
        FileReader fr_laptop = new FileReader("danhsachlaptop.txt");
        BufferedReader reader_laptop = new BufferedReader(fr_laptop);
        
        danhsachphieunhap dspn = new danhsachphieunhap();      
        FileWriter fw_phieunhap = new FileWriter("danhsachphieunhap.txt", true);
        BufferedWriter writer_phieunhap = new BufferedWriter(fw_phieunhap);
        FileReader fr_phieunhap = new FileReader("danhsachphieunhap.txt");
        BufferedReader reader_phieunhap = new BufferedReader(fr_phieunhap);
        FileWriter fwctpn = new FileWriter("chitietphieunhap.txt",true);
	BufferedWriter writer_ctpn = new BufferedWriter(fwctpn);
	FileReader frctpn = new FileReader("chitietphieunhap.txt");
	BufferedReader reader_ctpn = new BufferedReader(frctpn);
        
        FileWriter fw = new FileWriter("danhsachphieuxuat.txt",true);
	BufferedWriter writer_phieu = new BufferedWriter(fw);
	FileReader fr = new FileReader("danhsachphieuxuat.txt");
	BufferedReader reader_phieu = new BufferedReader(fr);
	FileWriter fwct = new FileWriter("chitietphieuxuat.txt",true);
	BufferedWriter writer_ctphieu = new BufferedWriter(fwct);
	FileReader frct = new FileReader("chitietphieuxuat.txt");
	BufferedReader reader_ctphieu = new BufferedReader(frct);
	danhsachphieuxuat e = new danhsachphieuxuat();
        
        back: // lable : link bai viet tham khao:
              // https://shareprogramming.net/java-co-ho-tro-lenh-goto-giong-nhu-c-c/
        while (true) {
            System.out.print("==============================Menu==============================");
            System.out.print("\n\n1:Thao tac voi danh sach khach hang ");
            System.out.print("\n2:thao tac voi danh sach nha cung cap ");
            System.out.print("\n3:thao tac voi danh sach dien thoai ");
            System.out.print("\n4:thao tac voi danh sach laptop ");
            System.out.print("\n5:thao tac voi danh sach phieu nhap");
            System.out.print("\n6:thao tac voi danh sach phieu xuat");
            System.out.print("\n7:thoat");
            System.out.print("\n\n==============================End==============================");
            System.out.print("\n\nNhap vao lua chon cua ban: ");
            int luaChon = sc.nextInt();
            // thao tac voi danh sach khach hang
            if (luaChon == 1) {
                quanly.xoamanghinh();
                quaylailuachon1: while (true) {
                    quanly.menu_thaotacdanhsachkhachhang();
                    System.out.print("\n\nnhap vao lua chon cua ban ");
                    int luaChon1 = sc.nextInt();
                    switch (luaChon1) {
                        case 1:
                            quanly.xoamanghinh();
                            dskh.nhapDanhSachNhachHangLanDau(writer_kh);
                            
                            break;
                        case 2:
                            quanly.xoamanghinh();
                            dskh.xuatDanhKhachHang(reader_kh);
                            break;
                        case 3:
                            quanly.xoamanghinh();
                            dskh.themKH(writer_kh, reader_kh);
                            break;
                        case 4:
                            quanly.xoamanghinh();
                            dskh.timKiemKH(reader_kh);
                            
                            break;
                        case 5:
                            quanly.xoamanghinh();
                            dskh.suaKH(reader_kh, writer_kh);
                            
                            break;
                        case 6:
                            quanly.xoamanghinh();
                            dskh.xoaKH(reader_kh, writer_kh);
                            break;
                        case 7:
                            quanly.xoamanghinh();
                            continue back; // su dung lable voi continue,
                        case 8:
                            System.out.print("\n\n\nKet thuc thao tac \nXin cam on!\n\n");
                            return;
                        default:
                            quanly.xoamanghinh();
                            System.out.print("\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n");
                            continue quaylailuachon1;
                    }
                }
            }

            else if (luaChon == 2) {
                quanly.xoamanghinh();
                quaylailuachon2: while (true) {
                    quanly.menu_thaotacdanhsachnhacungcap();
                    System.out.print("\n\nnhap vao lua chon cua ban ");
                    int luaChon2 = sc.nextInt();
                    switch (luaChon2) {
                        case 1:
                            quanly.xoamanghinh();
                            dsncc.nhapDanhSachNhaCungCapLanDau(writer_ncc);
                            
                            break;
                        case 2:
                            // System.out.println("hihi");
                            quanly.xoamanghinh();
                            dsncc.xuatDanhSachNhaCungCap(reader_ncc);
                            break;
                        case 3:
                            quanly.xoamanghinh();
                            // System.out.println("hihi");
                            dsncc.themNCC(writer_ncc, reader_ncc);
//                            quanly.xoamanghinh();
                            break;
                        case 4:
                            quanly.xoamanghinh();
                            dsncc.timKiemNCC(reader_ncc);
                            // quanly.xoamanghinh();
                            break;
                        case 5:
                            quanly.xoamanghinh();
                            dsncc.xoaNCC(reader_ncc, writer_ncc);
                            // quanly.xoamanghinh();
                            break;
                        case 6:
                            quanly.xoamanghinh();
                            dsncc.suaNCC(reader_ncc, writer_ncc);
//                            quanly.xoamanghinh();
                            break;                     
                        case 7:
                            quanly.xoamanghinh();
                            continue back;
                        case 8:
                            System.out.print("\n\n\nKet thuc theo tac\nXin cam on!\n\n ");
                            return;
                        default:
                            quanly.xoamanghinh();
                            System.out.print("\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n");
                            continue quaylailuachon2;
                    }

                }
            }

            else if (luaChon == 3) {
                quanly.xoamanghinh();
                quaylailuachon3: while (true) {
                    quanly.menu_thaotacdanhsachdienthoai();
                    System.out.print("\n\nnhap vao lua chon cua ban ");
                    int luachon = sc.nextInt();
                    switch (luachon) {
                        case 1:
                            quanly.xoamanghinh();
                            dsdt.nhapDanhSachDienThoaiLanDau(writer_dt);
                            //quanly.xoamanghinh();
                            break;
                        case 2:
                            quanly.xoamanghinh();
                            dsdt.xuatDanhSachDienThoai(reader_dt);
                            //quanly.xoamanghinh();
                            break;
                        case 3:
                            quanly.xoamanghinh();
                            dsdt.themDienThoai(writer_dt, reader_dt);
                            //quanly.xoamanghinh();
                            break;
                        case 4:
                            quanly.xoamanghinh();
                            dsdt.timKiemDienThoai(reader_dt);
                            //quanly.xoamanghinh();
                            break;
                        case 5:
                            quanly.xoamanghinh();
                            dsdt.xoaDienThoai(reader_dt, writer_dt);
                            //quanly.xoamanghinh();
                            break;
                        case 6:
                            quanly.xoamanghinh();
                            dsdt.suaDienThoai(reader_dt, writer_dt);
                            //quanly.xoamanghinh();
                            break;
                        case 7:
                            quanly.xoamanghinh();
                            continue back;
                        case 8:
                            System.out.print("\n\n\nket thuc thao tac\n\n\n ");
                            return;
                        default:
                            quanly.xoamanghinh();
                            System.out.print("\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n");
                            continue quaylailuachon3;
                    }

                }
            }

            else if (luaChon == 4) {
                quanly.xoamanghinh();
                quaylailuachon4: while (true) {
                    quanly.menu_thaotacdanhsachlaptop();
                    System.out.print("\n\nnhap vao lua chon cua ban ");
                    int luachon = sc.nextInt();
                    switch (luachon) {
                        case 1:
                            quanly.xoamanghinh();
                            dsLaptop.nhapDanhSachLaptopLanDau(writer_laptop);
                            //quanly.xoamanghinh();
                            break;
                        case 2:
                            quanly.xoamanghinh();
                            dsLaptop.xuatDanhSachLaptop(reader_laptop);
                            //quanly.xoamanghinh();
                            break;
                        case 3:
                            quanly.xoamanghinh();
                            dsLaptop.themLaptop(writer_laptop, reader_laptop);
                            //quanly.xoamanghinh();
                            break;
                        case 4:
                            quanly.xoamanghinh();
                            dsLaptop.timKiemLaptop(reader_laptop);
                            //quanly.xoamanghinh();
                            break;
                        case 5:
                            quanly.xoamanghinh();
                            dsLaptop.xoaLaptop(reader_laptop, writer_laptop);
                            //quanly.xoamanghinh();
                            break;
                        case 6:
                            quanly.xoamanghinh();
                            dsLaptop.suaLaptop(reader_laptop, writer_laptop);
                            //quanly.xoamanghinh();
                            break;
                        case 7:
                            quanly.xoamanghinh();
                            continue back;
                        case 8:
                            System.out.print("\n\n\nket thuc thao tac\n\n\n ");
                            return;
                        default:
                            quanly.xoamanghinh();
                            System.out.print("\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n");
                            continue quaylailuachon4;
                    }

                }
            }
            
            else if (luaChon == 5) {
                quanly.xoamanghinh();
                quaylailuachon5: while (true) {
                    quanly.menu_thaotacdanhsachphieunhap();
                    System.out.print("\n\nnhap vao lua chon cua ban ");
                    int luachon = sc.nextInt();
                    switch (luachon) {
                        case 1:
                            quanly.xoamanghinh();
                            dspn.nhapDanhSachPhieuNhapLanDau(writer_phieunhap, reader_phieunhap, writer_ctpn);
                            //quanly.xoamanghinh();
                            break;
                        case 2:
                            quanly.xoamanghinh();
                            dspn.xuatDanhSachPhieuNhap(reader_phieunhap);
                            //quanly.xoamanghinh();
                            break;
                        case 3:
                            quanly.xoamanghinh();
                            dspn.timKiemPhieuNhap(reader_phieunhap);
                            // quanly.xoamanghinh();
                            break;
                        case 4:
                            quanly.xoamanghinh();
                            dspn.themPhieuNhap(writer_phieunhap, reader_phieunhap, writer_ctpn);
                            //quanly.xoamanghinh();
                            break;
                        case 5:
                            quanly.xoamanghinh();
                            dspn.xoaPhieuNhap(reader_phieunhap, writer_phieunhap);
                            //quanly.xoamanghinh();
                            break;
                        case 6:
                            quanly.xoamanghinh();
                            dspn.suaPhieuNhap(reader_phieunhap, writer_phieunhap, writer_ctpn);
                            //quanly.xoamanghinh();
                            break;    
                        case 7:
                            quanly.xoamanghinh();
                            continue back;
                        
                        default:
                            quanly.xoamanghinh();
                            System.out.print("\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n");
                            continue quaylailuachon5;
                    }

                }
            }
    
            
             else if (luaChon == 6) {
                quanly.xoamanghinh();
                quaylailuachon6: while (true) {
                    quanly.menu_thaotacdanhsachphieuxuat();
                    System.out.print("\n\nnhap vao lua chon cua ban ");
                    int luachon = sc.nextInt();
                    switch (luachon) {
                        case 1:
                            quanly.xoamanghinh();
                            e.docfile_phieu(reader_phieu);
                            e.docfile_ctphieu(reader_ctphieu);
                            e.themphieuxuat(writer_phieu, writer_ctphieu, reader_kh, reader_dt, reader_laptop);
                            e.docfile_phieu(reader_phieu);
                            e.docfile_ctphieu(reader_ctphieu);
                            e.capnhatsanpham(reader_ctphieu, reader_dt, reader_laptop, writer_dt, writer_laptop);
                           
                            break;
                        case 2:
                            quanly.xoamanghinh();
                            e.docfile_phieu(reader_phieu);
                            e.xuatdanhsachphieu();
                            
                            break;
                        case 3:
                            quanly.xoamanghinh();
                            e.docfile_phieu(reader_phieu);
                            e.docfile_ctphieu(reader_ctphieu);
                            e.xemchitietphieuxuat();
                            
                            break;
                        case 4:
                            quanly.xoamanghinh();
                            e.docfile_phieu(reader_phieu);
                            e.xoaphieuxuat(writer_phieu);
                           
                            break;
                        case 5:
                            quanly.xoamanghinh();
                            continue back;                       
                        default:
                            quanly.xoamanghinh();
                            System.out.print("\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n");
                            continue quaylailuachon6;
                    }

                }
            }
            
            else if (luaChon == 7) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("\n\n\n\n\nKet thuc thao tac \nCam on!\n\n\n\n\n");
                break;
            }

            else {
                quanly.xoamanghinh();
                System.out.print("\n\nlua chon cua ban ngoai danh sach \nthuc hien lai \n\n\n");
                continue back;
            }
        }
    }
}
