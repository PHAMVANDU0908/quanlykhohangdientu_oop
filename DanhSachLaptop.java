package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;


public class DanhSachLaptop {
	private int soLuongLaptop;
    Laptop[] dsLaptop = new Laptop[100];

    Scanner sc = new Scanner(System.in);

    public int getSoLuongLaptop() {
		return soLuongLaptop;
	}
	public void setSoLuongLaptop(int soLuongLaptop) {
		this.soLuongLaptop = soLuongLaptop;
	}

	public void nhapDanhSachLaptopLanDau(BufferedWriter writer) throws IOException{
        System.out.print("nhap so luong laptop ban muon nhap lan dau: ");
        soLuongLaptop = sc.nextInt();
        dsLaptop = Arrays.copyOf(dsLaptop,soLuongLaptop);
        for(int i = 0; i < dsLaptop.length; i++){        	
        	dsLaptop[i] = new Laptop();
            dsLaptop[i].nhapThongTin(i);
            writer.write(dsLaptop[i].toString());
            writer.newLine();
        }
        writer.close();       
    }
	
    public void xuatDanhSachLaptop(BufferedReader reader) throws IOException{
    	 reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
         String Laptop = "";
         System.out.print("danh sach laptop danh ton tai trong danh sach \n");
         while((Laptop = reader.readLine())!=null){
        	 String[] infor_Laptop = Laptop.split(";");    
             String maLaptop= infor_Laptop[0];
             String tenLaptop= infor_Laptop[1];
             double giaLaptop= Double.parseDouble(infor_Laptop[2]);
             String thuongHieuLaptop= infor_Laptop[3];
             String heDieuHanhLaptop= infor_Laptop[4];
             String ram= infor_Laptop[5];
             String card= infor_Laptop[6]; 
             String tenCPU= infor_Laptop[7];             
             int soLuong= Integer.parseInt(infor_Laptop[8]);
             int trangThai= Integer.parseInt(infor_Laptop[9]);            
             Laptop a = new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong, trangThai);
             if(trangThai==1) {          	 
                System.out.print(a.xuatThongTin()+"\n");
             }         
         }
        reader.close();
    }
         


    public void themLaptop(BufferedWriter writer,BufferedReader reader) throws IOException{
    	 reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
         writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));
         int count = 0;//so luong hang trong file
         while(reader.readLine()!=null){
             count++;
         }
         reader.close();
         reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
         System.out.print("\nnhap so luong laptop ban muon them ");
         int soLuongLaptopThem = sc.nextInt();
         for(int i = count ; i < count + soLuongLaptopThem;i++){
             Laptop a = new Laptop();
             a.nhapThongTin(i);
             writer.write(a.toString());
             writer.newLine();
         }
         reader.close();
         writer.close();
    }
    
    public void suaLaptop(BufferedReader reader,BufferedWriter writer) throws IOException{
        int count = 0;
        DanhSachLaptop dslaptop  = new DanhSachLaptop();
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        while(reader.readLine() != null){
            count++;
        }

        dslaptop.dsLaptop = Arrays.copyOf(dslaptop.dsLaptop, count);
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        dslaptop.setSoLuongLaptop(count);
        for(int i = 0; i < dslaptop.dsLaptop.length; i++){
        	 String[] infor_Laptop = reader.readLine().split(";");    
             String maLaptop= infor_Laptop[0];
             String tenLaptop= infor_Laptop[1];
             double giaLaptop= Double.parseDouble(infor_Laptop[2]);
             String thuongHieuLaptop= infor_Laptop[3];
             String heDieuHanhLaptop= infor_Laptop[4];
             String ram= infor_Laptop[5];
             String card= infor_Laptop[6]; 
             String tenCPU= infor_Laptop[7];             
             int soLuong= Integer.parseInt(infor_Laptop[8]);
             int trangThai= Integer.parseInt(infor_Laptop[9]);            
             dslaptop.dsLaptop[i]= new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong, trangThai);
        }
        writer =  new BufferedWriter(new FileWriter("danhsachlaptop.txt"));
        writer =  new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));
        System.out.print("nhap ma khach hang ban muon sua thong tin: ");
        String ma = sc.nextLine();
        for(int i = 0; i < dslaptop.dsLaptop.length; i++){
            if(ma.equals(dslaptop.dsLaptop[i].getMaLaptop())){
                System.out.println("laptop ban muon sua thong tin: \n"+dslaptop.dsLaptop[i].xuatThongTin());
                dslaptop.dsLaptop[i].nhapThongTin(i);
                writer.write(dslaptop.dsLaptop[i].toString());
                writer.newLine();
            }
            else{
                writer.write(dslaptop.dsLaptop[i].toString());
                writer.newLine();
            }
        }
        writer.close();
        reader.close();       
    }

    public void xoaLaptop(BufferedReader reader,BufferedWriter writer) throws IOException {
    	int count = 0;
        boolean signal = false;
        DanhSachLaptop dslaptop = new DanhSachLaptop();
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        while(reader.readLine() != null){
            count++;
        }

        dslaptop.dsLaptop = Arrays.copyOf(dslaptop.dsLaptop, count);
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        dslaptop.setSoLuongLaptop(count);
        for(int i = 0; i < dslaptop.dsLaptop.length; i++){
        	String[] infor_Laptop = reader.readLine().split(";");    
            String maLaptop= infor_Laptop[0];
            String tenLaptop= infor_Laptop[1];
            double giaLaptop= Double.parseDouble(infor_Laptop[2]);
            String thuongHieuLaptop= infor_Laptop[3];
            String heDieuHanhLaptop= infor_Laptop[4];
            String ram= infor_Laptop[5];
            String card= infor_Laptop[6]; 
            String tenCPU= infor_Laptop[7];             
            int soLuong= Integer.parseInt(infor_Laptop[8]);
            int trangThai= Integer.parseInt(infor_Laptop[9]);            
            dslaptop.dsLaptop[i]= new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong, trangThai);
       }

        
        writer =  new BufferedWriter(new FileWriter("danhsachlaptop.txt"));
        System.out.print("\nnhap ma laptop ban muon xoa ");
        String ma = sc.nextLine();
        writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));     
        for(int i = 0;i < dslaptop.dsLaptop.length; i++){
            if(ma.equals(dslaptop.dsLaptop[i].getMaLaptop())){
                System.out.print("laptop ban chon de xoa: \n" + dslaptop.dsLaptop[i].xuatThongTin());
                dslaptop.dsLaptop[i].setTrangThai(0);
                writer.write(dslaptop.dsLaptop[i].toString());
                writer.newLine();
                signal = true;
            }
            else{   
            	writer.write(dslaptop.dsLaptop[i].toString());
                writer.newLine();
            }
            if(signal == false){
                System.out.println("ma laptop khong co trong danh sach khach hang !!! ");
            }    
            }
        writer.close();
        reader.close();     
    }



    
    public void timKiemLaptop(BufferedReader reader) throws IOException{
    	int count = 0;
    	DanhSachLaptop dslaptop = new DanhSachLaptop();
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        while(reader.readLine() != null){
             count++;
        }
        dslaptop.dsLaptop = Arrays.copyOf(dslaptop.dsLaptop, count);
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        dslaptop.setSoLuongLaptop(count);
        for(int i = 0; i < dslaptop.dsLaptop.length; i++){
        	String[] infor_Laptop = reader.readLine().split(";");    
            String maLaptop= infor_Laptop[0];
            String tenLaptop= infor_Laptop[1];
            double giaLaptop= Double.parseDouble(infor_Laptop[2]);
            String thuongHieuLaptop= infor_Laptop[3];
            String heDieuHanhLaptop= infor_Laptop[4];
            String ram= infor_Laptop[5];
            String card= infor_Laptop[6]; 
            String tenCPU= infor_Laptop[7];             
            int soLuong= Integer.parseInt(infor_Laptop[8]);
            int trangThai= Integer.parseInt(infor_Laptop[9]);            
            dslaptop.dsLaptop[i]= new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong, trangThai);
       }
        
        System.out.print("\n nhap ma laptop ban muon tim kiem ");
        String ma = sc.nextLine();
        for(int i = 0; i < dslaptop.dsLaptop.length; i++){
             if(ma.equals(dslaptop.dsLaptop[i].getMaLaptop())){
                 System.out.println(dslaptop.dsLaptop[i].xuatThongTin());
             }
             reader.close();
        }
    }
    // public void themSoLuongLaptop(int soLuongLaptopThem,BufferedReader reader,BufferedWriter writer) throws IOException{
    //     reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
    //     writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt"));
    //     //duyet file va luu cac san pham xuong mot mang san pham
    //     int count = 0;
    //     //while nay de lay so luong hang trong file
    //     while(reader.readLine() != null){
    //         count++;
    //     }
    //     reader.close();
    //     writer.close();
    //     //tao ra mot danh sach dien thoai voi so luong la count
    //     Laptop[] dsLaptop = new Laptop[count];
    //     reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
    //     System.out.print("\n nhap ma laptop ban muon tim kiem ");
    //     String ma = sc.nextLine();
    //     for(int i = 0; i < dsLaptop.length; i++){
    //     	String[] infor_Laptop = reader.readLine().split(";");    
    //         String maLaptop= infor_Laptop[0];
    //         String tenLaptop= infor_Laptop[1];
    //         double giaLaptop= Double.parseDouble(infor_Laptop[2]);
    //         String thuongHieuLaptop= infor_Laptop[3];
    //         String heDieuHanhLaptop= infor_Laptop[4];
    //         String ram= infor_Laptop[5];
    //         String card= infor_Laptop[6]; 
    //         String tenCPU= infor_Laptop[7];             
    //         int soLuong= Integer.parseInt(infor_Laptop[8]);
    //         int trangThai= Integer.parseInt(infor_Laptop[9]);            
    //         if(ma.equals(dsLaptop[i].getMaLaptop())){
    //         	dsLaptop[i]= new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong+soLuongLaptopThem, trangThai);    
    //         }
    //         else{
    //         	dsLaptop[i]= new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong, trangThai);
    //         }
    //     }
        
    //     //luc nay ta da co mot danh sach dien thoai roi
    //     //ta ghi de danh sach nay lai vao file
    //     writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));
    //     for(int i = 0; i < dsLaptop.length;i++){
    //         writer.write(dsLaptop[i].toString());
    //         writer.newLine();
    //     }
    //     writer.close();
    //     reader.close();
    // }
    public static void themsoluongLaptop(String malt,int soluongLTThem,BufferedReader reader,BufferedWriter writer) throws IOException{
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        //duyet file va luu cac san pham xuong mot mang san pham
        int count = 0;
        //while nay de lay so luong hang trong file
        while(reader.readLine() != null){
            count++;
        }
        reader.close();
        //tao ra mot danh sach dien thoai voi so luong la count
        Laptop[] dslt = new Laptop[count];
        reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
        String dt = "";
        for(int i = 0; i < dslt.length; i++){
            String infor_lt[] = reader.readLine().split(";");
            if(infor_lt[0].equals(malt)){
               dslt[i] = new Laptop(infor_lt[0],infor_lt[1],Double.parseDouble(infor_lt[2]),infor_lt[3],infor_lt[4],infor_lt[5],infor_lt[6],infor_lt[7],Integer.parseInt(infor_lt[8])+soluongLTThem,Integer.parseInt(infor_lt[9]));
            }
            else{
               dslt[i] = new Laptop(infor_lt[0],infor_lt[1],Double.parseDouble(infor_lt[2]),infor_lt[3],infor_lt[4],infor_lt[5],infor_lt[6],infor_lt[7],Integer.parseInt(infor_lt[8]),Integer.parseInt(infor_lt[9]));
            }
        }
        //luc nay ta da co mot danh sach dien thoai roi
        //ta ghi de danh sach nay lai vao file
        writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt"));
        writer.close();
        writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));
        for(int i = 0; i < dslt.length;i++){
            writer.write(dslt[i].toString());
            writer.newLine();
        }
        writer.close();
        reader.close();
    }
    
    // public void giamSoLuongLaptop(int soLuongLaptopGiam,BufferedReader reader,BufferedWriter writer) throws IOException{
    // 	 reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
    //      writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt"));
    //      //duyet file va luu cac san pham xuong mot mang san pham
    //      int count = 0;
    //      //while nay de lay so luong hang trong file
    //      while(reader.readLine() != null){
    //          count++;
    //      }
    //      reader.close();
    //      writer.close();
    //      //tao ra mot danh sach laptop voi so luong la count
    //      Laptop[] dslaptop = new Laptop[count];
    //      reader = new BufferedReader(new FileReader("danhsachlaptop.txt"));
    //      System.out.print("\n nhap ma laptop ban muon tim kiem ");
    //      String ma = sc.nextLine();
    //      for(int i = 0; i < dslaptop.length; i++){
    //     	 String[] infor_Laptop = reader.readLine().split(";");    
    //          String maLaptop= infor_Laptop[0];
    //          String tenLaptop= infor_Laptop[1];
    //          double giaLaptop= Double.parseDouble(infor_Laptop[2]);
    //          String thuongHieuLaptop= infor_Laptop[3];
    //          String heDieuHanhLaptop= infor_Laptop[4];
    //          String ram= infor_Laptop[5];
    //          String card= infor_Laptop[6]; 
    //          String tenCPU= infor_Laptop[7];             
    //          int soLuong= Integer.parseInt(infor_Laptop[8]);
    //          int trangThai= Integer.parseInt(infor_Laptop[9]);            
    //          if(ma.equals(dsLaptop[i].getMaLaptop())){
    //          	dsLaptop[i]= new Laptop(maLaptop, tenLaptop, giaLaptop, thuongHieuLaptop, heDieuHanhLaptop, ram, card, tenCPU, soLuong-soLuongLaptopGiam, trangThai);    
    //          }
    //          else{
    //              System.out.println("khong tim thay laptop can giam so luong !!!");
    //          }
    //      }
    //      //luc nay ta da co mot danh sach laptop roi
    //      //ta ghi de danh sach nay lai vao file
    //      writer = new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));
    //      for(int i = 0; i < dslaptop.length;i++){
    //          writer.write(dslaptop[i].toString());
    //          writer.newLine();
    //      }
    //      writer.close();
    //      reader.close();   	
    // }    
}

 
        
    
