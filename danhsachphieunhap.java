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
        // ?? t?????ng:
        // B1:l???y danh s??ch nh?? cung c???p t??? file xu???ng m??ng,sau ???? x??a n???i dung trong file ??i
        // B2:nh???p m?? nh?? cung c???p mu???n s???a v?? duy???t m??ng, n???u object n??o c?? m?? gi???ng th?? s???a th??ng tin
        // B3:Ghi l???i m??ng nh?? cung c???p sau khi s???a xong.

        // th???c hi???n

        // B1:
        int count = 0;
        // boolean signal = false;
        //t???o danh sach nh?? cung c???p ????? luu khi l???y t??? file v???
        danhsachphieunhap dspn  = new danhsachphieunhap();
        //v?? l??c n??y ????? dai c???a m???ngx l?? b???ng 1(trogn ph???n khai b??o danh s??ch nh?? cung c??p),
        //n??n c???n fix l???i ????? d??i,ta l???y t??? file lu??n
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        while(reader.readLine() != null){
            count++;
        }

        dspn.dsPhieuNhap = Arrays.copyOf(dspn.dsPhieuNhap, count);
        reader = new BufferedReader(new FileReader("danhsachphieunhap.txt"));
        dspn.setSoLuongPhieuNhap(count);
        //ghi to??n b??? d??? li???u t??? file v??o m??ng m??nh v???a t???o
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
