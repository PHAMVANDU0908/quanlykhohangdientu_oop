package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class danhsachphieunhap {
    private int soLuongPhieuNhap = 1;
    
    phieunhap[] dsPhieuNhap = new phieunhap[soLuongPhieuNhap];
    
    Scanner sc = new Scanner (System.in);

    public int getSoLuongPhieuNhap() {
        return soLuongPhieuNhap;
    }

    public void setSoLuongPhieuNhap(int soLuongPhieuNhap) {
        this.soLuongPhieuNhap = soLuongPhieuNhap;
    }
    
    public void nhapDanhSachPhieuNhapLanDau(BufferedWriter writer,BufferedReader reader,BufferedWriter writer_ctpn) throws IOException{
        System.out.print("nhap so luong phieu nhap lan dau: ");
        soLuongPhieuNhap = sc.nextInt();
        for(int i = 0; i < soLuongPhieuNhap; i++){
            phieunhap pn =  new phieunhap();
            pn.nhapThongTinPhieuNhap(i,reader,writer,writer_ctpn);
            writer.write(pn.toString());
            writer.newLine();
        }
        writer.close();
    }
    
    public void xuatDanhSachPhieuNhap(BufferedReader reader) throws IOException{
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        String phieunhap = "";
        System.out.println("danh sach phieu nhap dang ton tai trong danh sach ");
        while((phieunhap = reader.readLine())!=null){
            String[] infor_pn = phieunhap.split(";");
            phieu pn = new  phieunhap(infor_pn[0],infor_pn[1],infor_pn[2],Integer.parseInt(infor_pn[3])); // ma phieu, ngay lap phieu, ma nha cung cap
            System.out.print(pn.xuatThongTin()+"\n");
        }
        reader.close();
    }
    
     public void themPhieuNhap(BufferedWriter writer,BufferedReader reader,BufferedWriter writer_ctpn) throws IOException{
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        writer = new BufferedWriter(new FileWriter("danhsachphieunhap.txt",true));
        int count = 0;//so luong hang trong file
        while(reader.readLine()!=null){
            count++;
        }
        System.out.print("nhap so luong phieu nhap muon them: ");
        int soLuongPhieuNhapThem = sc.nextInt();
        for(int i = count ; i < count + soLuongPhieuNhapThem;i++){
            phieunhap pn = new phieunhap();
            pn.nhapThongTinPhieuNhap(i,reader,writer,writer_ctpn);
            writer.write(pn.toString());
            writer.newLine();
        }
        reader.close();
        writer.close();
     }
     
     public void suaPhieuNhap(BufferedReader reader,BufferedWriter writer,BufferedWriter writer_ctpn) throws IOException{
        // ý tưởng:
        // B1:lấy danh sách nhà cung cấp từ file xuống mãng,sau đó xóa nọi dung trong file đi
        // B2:nhập mã nhà cung cấp muốn sửa và duyệt mãng, nếu object nào có mã giống thì sửa thông tin
        // B3:Ghi lại mãng nhà cung cấp sau khi sửa xong.

        // thực hiện

        // B1:
        int count = 0;
        // boolean signal = false;
        //tạo danh sach nhà cung cấp để luu khi lấy từ file về
        danhsachphieunhap dspn  = new danhsachphieunhap();
        //vì lúc này độ dai của mảngx là bằng 1(trogn phần khai báo danh sách nhà cung câp),
        //nên cần fix lại độ dài,ta lấy từ file luôn
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        while(reader.readLine() != null){
            count++;
        }

        dspn.dsPhieuNhap = Arrays.copyOf(dspn.dsPhieuNhap, count);
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        dspn.setSoLuongPhieuNhap(count);
        //ghi toàn bộ dữ liệu từ file vào mãng mình vừa tạo
        for(int i = 0; i < dspn.dsPhieuNhap.length; i++){
            String infor_pn[] = reader.readLine().split(";");
            dspn.dsPhieuNhap[i] = new phieunhap(infor_pn[0], infor_pn[1], infor_pn[2],Integer.parseInt(infor_pn[3]));
        }
        
        //xoa toan bo thong tin trong file
        writer =  new BufferedWriter(new FileWriter("danhsachphieunhap.txt"));

        // B2,B3:
        //xoa toan bo thong tin trong file
        boolean signal = false;
        writer =  new BufferedWriter(new FileWriter("danhsachphieunhap.txt",true));
        //duyet mang de sua thong tin va ghi lai file
        System.out.print("nhap ma phieu nhap ban muon sua: ");
        String maPhieu = sc.nextLine();
        for(int i = 0; i < dspn.dsPhieuNhap.length; i++){
            if(maPhieu.equals(dspn.dsPhieuNhap[i].getMa())){
                System.out.println("Phieu nhap ban muon sua thong tin: \n"+dspn.dsPhieuNhap[i].xuatThongTin());
                dspn.dsPhieuNhap[i].nhapThongTinPhieuNhap(i,reader,writer,writer_ctpn);
                do{
                    System.out.print("trang thai (1 hoac 0): ");
                    dspn.dsPhieuNhap[i].setTrangthai(sc.nextInt());
                }
                while(dspn.dsPhieuNhap[i].getTrangthai() != 1 && dspn.dsPhieuNhap[i].getTrangthai() != 0);
                writer.write(dspn.dsPhieuNhap[i].toString());
                writer.newLine();
                signal = true;
            }
            else{
                writer.write(dspn.dsPhieuNhap[i].toString());
                writer.newLine();
            }
        }
        if(signal == false){
            System.out.print("ma phieu khong co trong danh sach phieu \n");
        }
writer.close();
        reader.close();
     }
     
     public void xoaPhieuNhap(BufferedReader reader,BufferedWriter writer) throws IOException{
        int count = 0;
        boolean signal = false;
        danhsachphieunhap dspn = new danhsachphieunhap();
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        while(reader.readLine() != null){
            count++;
        }

        reader.close();
        dspn.dsPhieuNhap = Arrays.copyOf(dspn.dsPhieuNhap, count);
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        dspn.setSoLuongPhieuNhap(count);
        for(int i = 0; i < dspn.dsPhieuNhap.length; i++){
            String infor_pn[] = reader.readLine().split(";");
            dspn.dsPhieuNhap[i] = new phieunhap(infor_pn[0], infor_pn[1], infor_pn[2],Integer.parseInt(infor_pn[3]));
        }

        
        writer =  new BufferedWriter(new FileWriter("danhsachphieunhap.txt"));
        writer.close();
        System.out.print("nhap ma phieu nhap ban muon xoa ");
        // sc.nextLine();
        String maPhieu = sc.nextLine();
        writer =  new BufferedWriter(new FileWriter("danhsachphieunhap.txt",true));
        // System.out.println("hihis");
        for(int i = 0;i < dspn.dsPhieuNhap.length; i++){
            if(maPhieu.equals(dspn.dsPhieuNhap[i].getMa())){
                System.out.print("phieu nhap chon de xoa: \n" + dspn.dsPhieuNhap[i].xuatThongTin());
                dspn.dsPhieuNhap[i].setTrangthai(0);
                writer.write(dspn.dsPhieuNhap[i].toString());
                writer.newLine();
                signal = true;
            }
            else{
                writer.write(dspn.dsPhieuNhap[i].toString());
                writer.newLine();
                }
            }
            if(signal==false){
                    System.out.println("ma phieu nhap khong co trong danh sach phieu nhap \n");
            }
        writer.close();
        reader.close();
    }
     
    public void timKiemPhieuNhap(BufferedReader reader) throws IOException{
        System.out.print("nhap ma phieu nhap muon tim kiem ");
        String maPhieu = sc.nextLine();
        System.out.println("phieu nhap ban dang tim");
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        // B2:
        String phieunhap = "";
        while((phieunhap = reader.readLine())!=null){
            String[] infor_pn = phieunhap.split(";");
            // System.out.println(infor_ncc[0]);
            if(maPhieu.equals(infor_pn[0])){
                // System.out.println("hihi");
                phieu pn = new phieunhap(infor_pn[0], infor_pn[1], infor_pn[2],Integer.parseInt(infor_pn[3]));
                System.out.print(pn.xuatThongTin()+"\n\n");
                break;
            }
        }
        reader.close();
    }
    
}
