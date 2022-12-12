package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import static java.lang.module.ModuleDescriptor.read;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author USER
 */
public class phieunhap extends phieu {
    private String maNhaCungCap;
    
    Pattern pattern_day = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");
    
    Scanner sc = new Scanner (System.in);
    // private BufferedReader reader;

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }
    
    public phieunhap(){
    }

    public phieunhap(String maPhieuNhap,String ngayLapPhieuNhap,String maNhaCungCap,int trangThai) {
        super(maPhieuNhap,ngayLapPhieuNhap,trangThai);
        this.maNhaCungCap = maNhaCungCap;
    }
    
    public void nhapThongTinPhieuNhap(int identity_id,BufferedReader reader,BufferedWriter writer,BufferedWriter writer_ctpn)throws IOException{
        setTrangthai(1);
        
        //ma phieu nhap
        String maPhieuNhap = "PN"+identity_id;
        setMa(maPhieuNhap);
        
        //ngay lap phieu nhap
        System.out.print("ngay lap phieu nhap (dd/mm/yyyy): ");
        String ngayLapPhieuNhap = sc.nextLine();
        Matcher matcher_day = pattern_day.matcher(ngayLapPhieuNhap);
        if(matcher_day.matches() == true){
            setNgay(ngayLapPhieuNhap);
        }
        else{
            while(matcher_day.matches() == false){
                System.out.print("ngay sinh phai theo dang dd/mm/yyyy.\nnhap lai ngay sinh: ");
                ngayLapPhieuNhap = sc.nextLine();
                matcher_day = pattern_day.matcher(ngayLapPhieuNhap);
            }
            setNgay(ngayLapPhieuNhap);
        }
        
        //ma nha cung cap
        System.out.print("ma nha cung cap: ");
        maNhaCungCap = sc.nextLine();
        
        // lay ds ma nha cung cap tu file dsnhacungcap
        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        int count=0;
        while(reader.readLine() != null){
            count+=1;
        }
   
        //tao mang chua ds ma ncc
        nhacungcap[] dsncc = new nhacungcap[count];
        reader.close();
        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        for(int i=0;i<count;i++){
            String[] infor_ncc = reader.readLine().split(";");
            dsncc[i] = new nhacungcap(infor_ncc[0], infor_ncc[1], infor_ncc[2], infor_ncc[3], infor_ncc[4],Integer.parseInt(infor_ncc[5]));
        }
        
        boolean signal = false;
        boolean signal2 = false;
        
        for(int i=0;i<count;i++){
            if(maNhaCungCap.equals(dsncc[i].getMa())==true){
                setMaNhaCungCap(maNhaCungCap);
                signal=true;
            }
        }
        // neu nhap sai ma nha cung cap thi nhap lai
        while(signal==false){
            System.out.print("Ma nha cung cap khong hop le !\nnhap lai ma nha cung cap: ");
            maNhaCungCap = sc.nextLine();
             for(int i=0;i<count;i++){
                if(maNhaCungCap.equals(dsncc[i].getMa())==true){
                    setMaNhaCungCap(maNhaCungCap);
                    signal=true;
                    break;
                }            
            }
        }
        
        //lay ds dien thoai
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        int demdsdt = 0;
        while(reader.readLine() != null){
            demdsdt+=1;
        }
        DienThoai[] dsdt = new DienThoai[demdsdt];
        reader.close();
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        for(int i=0;i<demdsdt;i++){
            String[] infor_dt = reader.readLine().split(";");
            dsdt[i] = new DienThoai(infor_dt[0],infor_dt[1],Double.parseDouble(infor_dt[2]),infor_dt[3],infor_dt[4],infor_dt[5],infor_dt[6],Integer.parseInt(infor_dt[7]),Integer.parseInt(infor_dt[8]));
        }
        
        //nhap dien thoai
        System.out.print("Nhap so luong phan tu dien thoai vao ct phieu: ");
        int soLuongDtNhap=Integer.parseInt(sc.nextLine());
        while(soLuongDtNhap < 0 ){
            System.out.print("So luong dien thoai khong hop le \n moi nhap lai");
            soLuongDtNhap=Integer.parseInt(sc.nextLine());
        }
        String madt;
        int soluongDTThem;
        for(int z=0;z<soLuongDtNhap;z++){
            signal2=false;
            System.out.print("Nhap ma dien thoai: ");
            madt=sc.nextLine();
            for(int j=0;j<demdsdt;j++){
                if(madt.equals(dsdt[j].getMaDienThoai())==true){
                    System.out.print("So luong dien thoai muon them: ");
                    soluongDTThem = Integer.parseInt(sc.nextLine());
                    DanhSachDienThoai.themsoluong(madt,soluongDTThem,reader,writer);
                    writer_ctpn.write(getMa());
                    writer_ctpn.write(";");
                    writer_ctpn.write(madt);
                    writer_ctpn.write(";");
                    writer_ctpn.write(String.valueOf(soluongDTThem));
                    writer_ctpn.newLine();
                    signal2 = true;
                    break;
                }
            }
            while(signal2==false){
            System.out.print("Ma dien thoai khong ton tai !\nnhap lai ma dien thoai: ");
            madt = sc.nextLine();
            for(int j=0;j<demdsdt;j++){
                if(madt.equals(dsdt[j].getMaDienThoai())==true){
                    System.out.print("So luong dien thoai muon them: ");
                    soluongDTThem = Integer.parseInt(sc.nextLine());
                    DanhSachDienThoai.themsoluong(madt,soluongDTThem,reader,writer);
                    writer_ctpn.write(getMa());
                    writer_ctpn.write(";");
                    writer_ctpn.write(madt);
                    writer_ctpn.write(";");
                    writer_ctpn.write(String.valueOf(soluongDTThem));
                    writer_ctpn.newLine();
                    signal2 = true;
                    break;
                }
            }
        }
        }
        writer_ctpn.close();
        
        //lay ds laptop
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        int demdslt = 0;
        while(reader.readLine() != null){
            demdslt+=1;
        }
        Laptop[] dslt = new Laptop[demdslt];
        reader.close();
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        for(int i=0;i<demdslt;i++){
            String[] infor_lt = reader.readLine().split(";");
            dslt[i] = new Laptop(infor_lt[0],infor_lt[1],Double.parseDouble(infor_lt[2]),infor_lt[3],infor_lt[4],infor_lt[5],infor_lt[6],infor_lt[7],Integer.parseInt(infor_lt[8]),Integer.parseInt(infor_lt[9]));
        }
       
        writer_ctpn = new BufferedWriter(new FileWriter("chitietphieunhap.txt",true));
//                    
        //nhap laptop
        System.out.print("Nhap so luong phan tu laptop muon nhap vao ct phieu: ");
        int soLuongLtNhap=Integer.parseInt(sc.nextLine());
        String malt;
        int soluongLTThem;
        for(int z=0;z<soLuongLtNhap;z++){
            signal2=false;
            System.out.print("Nhap ma laptop: ");
            malt=sc.nextLine();
            for(int j=0;j<demdslt;j++){
                if(malt.equals(dslt[j].getMaLaptop())==true){
                    System.out.print("So luong Laptop muon them: ");
                    soluongLTThem = Integer.parseInt(sc.nextLine());
                    DanhSachLaptop.themsoluongLaptop(malt,soluongLTThem,reader,writer);
                    writer_ctpn.write(getMa());
                    writer_ctpn.write(";");
                    writer_ctpn.write(malt);
                    writer_ctpn.write(";");
                    writer_ctpn.write(String.valueOf(soluongLTThem));
                    writer_ctpn.newLine();
                    signal2 = true;
                    break;
                }
            }
            // nhap sai ma laptop thi nhap lai
            while(signal2==false){
            System.out.print("Ma laptop khong ton tai !\nnhap lai ma laptop: ");
            malt = sc.nextLine();
            for(int j=0;j<demdslt;j++){
                if(malt.equals(dslt[j].getMaLaptop())==true){
                    System.out.print("So luong Laptop muon them: ");
                    soluongLTThem = Integer.parseInt(sc.nextLine());
                    DanhSachLaptop.themsoluongLaptop(malt,soluongLTThem,reader,writer);
                    writer_ctpn.write(getMa());
                    writer_ctpn.write(";");
                    writer_ctpn.write(malt);
                    writer_ctpn.write(";");
                    writer_ctpn.write(String.valueOf(soluongLTThem));
                    writer_ctpn.newLine();
                    signal2 = true;
                    break;
                }
            }
        }  
        }
        writer_ctpn.close();  
        }
    
    @Override
    public String toString(){
        return getMa() + ";" + getNgay() + ";"+ getMaNhaCungCap()+";"+getTrangthai();
    }
    
    @Override
    public String xuatThongTin(){
        return "ma phieu nhap: " + getMa() + "\nngay lap phieu nhap: " + getNgay() + "\nma nha cung cap: " + getMaNhaCungCap()+ "\ncon mua hang: " + getTrangthai()+"\n";
    }
}
