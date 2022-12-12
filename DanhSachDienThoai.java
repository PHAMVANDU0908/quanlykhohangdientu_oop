package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachDienThoai {
	private int soLuongDienThoai;
    DienThoai[] dsDienThoai = new DienThoai[100];

    Scanner sc = new Scanner(System.in);

    public int getSoLuongDienThoai() {
		return soLuongDienThoai;
	}
	public void setSoLuongDienThoai(int soLuongDienThoai) {
		this.soLuongDienThoai = soLuongDienThoai;
	}

	public void nhapDanhSachDienThoaiLanDau(BufferedWriter writer) throws IOException{
        System.out.print("nhap so luong dien thoai ban muon nhap lan dau: ");
        soLuongDienThoai = sc.nextInt();
        dsDienThoai = Arrays.copyOf(dsDienThoai, soLuongDienThoai);
        for(int i = 0; i < dsDienThoai.length; i++){
            dsDienThoai[i] = new DienThoai();
            dsDienThoai[i].nhapThongTin(i);
            writer.write(dsDienThoai[i].toString());
                 writer.newLine();
             }
             writer.close();
        
    }
	
    public void xuatDanhSachDienThoai(BufferedReader reader) throws IOException{
    	 reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
         String DienThoai = "";
         System.out.print("danh sach dien thoai danh ton tai trong danh sach \n");
         while((DienThoai = reader.readLine())!=null){
             String[] infor_DienThoai = DienThoai.split(";");    
             String maDienThoai= infor_DienThoai[0];
             String tenDienThoai= infor_DienThoai[1];
             double giaDienThoai= Double.parseDouble(infor_DienThoai[2]);
             String thuongHieuDienThoai= infor_DienThoai[3];
             String heDieuHanhDienThoai= infor_DienThoai[4];
             String dungLuong= infor_DienThoai[5];
             String mauDienThoai= infor_DienThoai[6]; 
             int soLuong= Integer.parseInt(infor_DienThoai[7]);
             int trangThai= Integer.parseInt(infor_DienThoai[8]);            
             DienThoai a = new DienThoai(maDienThoai, tenDienThoai, giaDienThoai, thuongHieuDienThoai, heDieuHanhDienThoai, dungLuong, mauDienThoai, soLuong, trangThai);
             if(trangThai==1) {
             System.out.print(a.xuatThongTin()+"\n");
             }
        }
         reader.close();
    }

    public void themDienThoai(BufferedWriter writer,BufferedReader reader) throws IOException{
    	 reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
         writer = new BufferedWriter(new FileWriter("danhsachdienthoai.txt",true));
         int count = 0;//so luong hang trong file
         while(reader.readLine()!=null){
             count++;
         }
         reader.close();
         reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
         System.out.print("\nnhap so luong dien thoai ban muon them ");
         int soLuongDienThoaiThem = sc.nextInt();
         for(int i = count ; i < count + soLuongDienThoaiThem;i++){
             DienThoai a = new DienThoai();
             a.nhapThongTin(i);
             writer.write(a.toString());
             writer.newLine();
         }
         reader.close();
         writer.close();
    }
    
    public void suaDienThoai(BufferedReader reader,BufferedWriter writer) throws IOException{
        int count = 0;
        DanhSachDienThoai dsdt  = new DanhSachDienThoai();
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        while(reader.readLine() != null){
            count++;
        }
        reader.close();
        dsdt.dsDienThoai = Arrays.copyOf(dsdt.dsDienThoai, count);
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        dsdt.setSoLuongDienThoai(count);
        for(int i = 0; i < dsdt.dsDienThoai.length; i++){
            String[] infor_DienThoai = reader.readLine().split(";");
            String maDienThoai= infor_DienThoai[0];
            String tenDienThoai= infor_DienThoai[1];
            double giaDienThoai= Double.parseDouble(infor_DienThoai[2]);
            String thuongHieuDienThoai= infor_DienThoai[3];
            String heDieuHanhDienThoai= infor_DienThoai[4];
            String dungLuong= infor_DienThoai[5];
            String mauDienThoai= infor_DienThoai[6]; 
            int soLuong= Integer.parseInt(infor_DienThoai[7]);
            int trangThai= Integer.parseInt(infor_DienThoai[8]);            
            dsdt.dsDienThoai[i] = new DienThoai(maDienThoai, tenDienThoai, giaDienThoai, thuongHieuDienThoai, heDieuHanhDienThoai, dungLuong, mauDienThoai, soLuong, trangThai);


        }
        writer =  new BufferedWriter(new FileWriter("danhsachdienthoai.txt"));
        writer.close();
        writer =  new BufferedWriter(new FileWriter("danhsachdienthoai.txt",true));
        System.out.print("nhap ma khach hang ban muon sua thong tin: ");
        String ma = sc.nextLine();
        for(int i = 0; i < dsdt.dsDienThoai.length; i++){
            if(ma.equals(dsdt.dsDienThoai[i].getMaDienThoai())){
                System.out.println("Dien thoai ban muon sua thong tin: \n"+dsdt.dsDienThoai[i].xuatThongTin());
                dsdt.dsDienThoai[i].nhapThongTin(i);
                writer.write(dsdt.dsDienThoai[i].toString());
                writer.newLine();
            }
            else{
                writer.write(dsdt.dsDienThoai[i].toString());
                writer.newLine();
            }
        }
        writer.close();
        reader.close();       
    }

    public void xoaDienThoai(BufferedReader reader,BufferedWriter writer) throws IOException {
    	int count = 0;
        boolean signal = false;
        DanhSachDienThoai dsdt = new DanhSachDienThoai();
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        while(reader.readLine() != null){
            count++;
        }
        dsdt.dsDienThoai = Arrays.copyOf(dsdt.dsDienThoai, count);
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        dsdt.setSoLuongDienThoai(count);
        for(int i = 0; i < dsdt.dsDienThoai.length; i++){
        	String[] infor_DienThoai = reader.readLine().split(";");
            String maDienThoai= infor_DienThoai[0];
            String tenDienThoai= infor_DienThoai[1];
            double giaDienThoai= Double.parseDouble(infor_DienThoai[2]);
            String thuongHieuDienThoai= infor_DienThoai[3];
            String heDieuHanhDienThoai= infor_DienThoai[4];
            String dungLuong= infor_DienThoai[5];
            String mauDienThoai= infor_DienThoai[6]; 
            int soLuong= Integer.parseInt(infor_DienThoai[7]);
            int trangThai= Integer.parseInt(infor_DienThoai[8]);            
            dsdt.dsDienThoai[i] = new DienThoai(maDienThoai, tenDienThoai, giaDienThoai, thuongHieuDienThoai, heDieuHanhDienThoai, dungLuong, mauDienThoai, soLuong, trangThai);
        }       
        writer =  new BufferedWriter(new FileWriter("danhsachdienthoai.txt"));
        System.out.print("\nnhap ma dien thoai ban muon xoa ");
        String ma = sc.nextLine();
        writer = new BufferedWriter(new FileWriter("danhsachdienthoai.txt",true));     
        for(int i = 0;i < dsdt.dsDienThoai.length; i++){
            if(ma.equals(dsdt.dsDienThoai[i].getMaDienThoai())){
                System.out.print("dien thoai ban chon de xoa: \n" + dsdt.dsDienThoai[i].xuatThongTin());
                dsdt.dsDienThoai[i].setTrangThai(0);
                writer.write(dsdt.dsDienThoai[i].toString());
                writer.newLine();
                signal = true;
            }
            else{              
                 writer.write(dsdt.dsDienThoai[i].toString());
                 writer.newLine();
                }       
        }
        if(signal == false){
            System.out.println("ma dien thoai khong co trong danh sach khach hang !!! ");
        } 
        writer.close();
        reader.close();
        
    }
    public void timKiemDienThoai(BufferedReader reader) throws IOException{
    	int count = 0;
    	DanhSachDienThoai dsdt = new DanhSachDienThoai();
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        while(reader.readLine() != null){
             count++;
        }
        dsdt.dsDienThoai = Arrays.copyOf(dsdt.dsDienThoai, count);
        reader = new BufferedReader(new FileReader("danhsachdienThoai.txt"));
        dsdt.setSoLuongDienThoai(count);
        for(int i = 0; i < dsdt.dsDienThoai.length; i++){
        	String[] infor_DienThoai = reader.readLine().split(";");
            String maDienThoai= infor_DienThoai[0];
            String tenDienThoai= infor_DienThoai[1];
            double giaDienThoai= Double.parseDouble(infor_DienThoai[2]);
            String thuongHieuDienThoai= infor_DienThoai[3];
            String heDieuHanhDienThoai= infor_DienThoai[4];
            String dungLuong= infor_DienThoai[5];
            String mauDienThoai= infor_DienThoai[6]; 
            int soLuong= Integer.parseInt(infor_DienThoai[7]);
            int trangThai= Integer.parseInt(infor_DienThoai[8]);            
            dsdt.dsDienThoai[i] = new DienThoai(maDienThoai, tenDienThoai, giaDienThoai, thuongHieuDienThoai, heDieuHanhDienThoai, dungLuong, mauDienThoai, soLuong, trangThai);

        }        
        System.out.print("\n nhap ma dien thoai ban muon tim kiem ");
        String ma = sc.nextLine();
        for(int i = 0; i < dsdt.dsDienThoai.length; i++){
             if(ma.equals(dsdt.dsDienThoai[i].getMaDienThoai())){
                 System.out.println(dsdt.dsDienThoai[i].xuatThongTin());
             }
             reader.close();
        }
    }
    
    public static void themsoluong(String madt,int soluongDTThem,BufferedReader reader,BufferedWriter writer) throws IOException{
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        //duyet file va luu cac san pham xuong mot mang san pham
        int count = 0;
        //while nay de lay so luong hang trong file
        while(reader.readLine() != null){
            count++;
        }
        reader.close();
        //tao ra mot danh sach dien thoai voi so luong la count
        DienThoai[] dsdt = new DienThoai[count];
        reader = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
        String dt = "";
        for(int i = 0; i < dsdt.length; i++){
            String infor_DienThoai[] = reader.readLine().split(";");
            if(infor_DienThoai[0].equals(madt)){
                //cho nay ong xem cau infor_DienThoai[?] la so luong thi cong them cai so luong san pham them vao
                
                //vd: infor_DienThoai[7] la thuoc tinh so luong cua san pham do thi ta lam nhu sau
               //dsdt[i] = new DienThoai(infor_DienThoai[0],infor_DienThoai[1],infor_DienThoai[2],infor_DienThoai[3],infor_DienThoai[4],infor_DienThoai[5],infor_DienThoai[6],infor_DienThoai[7]+soluongDTThem);
               dsdt[i] = new DienThoai(infor_DienThoai[0],infor_DienThoai[1],Double.parseDouble(infor_DienThoai[2]),infor_DienThoai[3],infor_DienThoai[4],infor_DienThoai[5],infor_DienThoai[6],Integer.parseInt(infor_DienThoai[7])+soluongDTThem,Integer.parseInt(infor_DienThoai[8]));
            }
            else{
               dsdt[i] = new DienThoai(infor_DienThoai[0],infor_DienThoai[1],Double.parseDouble(infor_DienThoai[2]),infor_DienThoai[3],infor_DienThoai[4],infor_DienThoai[5],infor_DienThoai[6],Integer.parseInt(infor_DienThoai[7]),Integer.parseInt(infor_DienThoai[8]));
            }
        }
        //luc nay ta da co mot danh sach dien thoai roi
        //ta ghi de danh sach nay lai vao file
        writer = new BufferedWriter(new FileWriter("danhsachdienthoai.txt"));
        writer.close();
        writer = new BufferedWriter(new FileWriter("danhsachdienthoai.txt",true));
        for(int i = 0; i < dsdt.length;i++){
            writer.write(dsdt[i].toString());
            writer.newLine();
        }
        writer.close();
        reader.close();
    }
}
        
    
