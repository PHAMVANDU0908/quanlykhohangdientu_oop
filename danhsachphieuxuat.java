package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class danhsachphieuxuat {
	private int sophieuxuat;//so phieu hien tai
	private int soctphieu;//so sp trong ct phieu hien tai
	phieuxuat[] dsPhieuxuat = new phieuxuat[1];
	chitietphieuxuat[] dsctPhieu = new chitietphieuxuat[1];
	//mang san pham
	DienThoai[] dsDt = new DienThoai[1];
	Laptop[] dsLap = new Laptop[1];
	Scanner sc = new Scanner(System.in);
	
	public int getSophieuxuat() {
		return sophieuxuat;
	}

	public void setSophieuxuat(int sophieuxuat) {
		this.sophieuxuat = sophieuxuat;
	}
	
	public int getSoctphieu() {
		return soctphieu;
	}

	public void setSoctphieu(int soctphieu) {
		this.soctphieu = soctphieu;
	}

	public void docfile_phieu(BufferedReader reader_phieu) throws IOException {
		// lay so luong
		reader_phieu = new BufferedReader(new FileReader("danhsachphieuxuat.txt"));
		int count = 0;
	    while(reader_phieu.readLine()!=null) {
	    	count++;
	    }
	    reader_phieu.close();
	    setSophieuxuat(count);
	    // ghi vao mang
	    reader_phieu = new BufferedReader(new FileReader("danhsachphieuxuat.txt"));
	    dsPhieuxuat = Arrays.copyOf(dsPhieuxuat, getSophieuxuat());
	    for(int i = 0; i < dsPhieuxuat.length; i++){
            String infor_phieu[] = reader_phieu.readLine().split(";");
            dsPhieuxuat[i] = new phieuxuat(infor_phieu[0],infor_phieu[1],infor_phieu[2],Integer.parseInt(infor_phieu[3]),Integer.parseInt(infor_phieu[4]),Integer.parseInt(infor_phieu[5]));
        }
	    reader_phieu.close();
	    
	}
	
	public void docfile_ctphieu(BufferedReader reader_ctphieu) throws IOException { 
		// lay so luong
		reader_ctphieu = new BufferedReader(new FileReader("chitietphieuxuat.txt"));
	    int count = 0;
	    while (reader_ctphieu.readLine()!=null) {
			count++;
		}
	    reader_ctphieu.close();
	    setSoctphieu(count);
	    // ghi vao mang
	    reader_ctphieu = new BufferedReader(new FileReader("chitietphieuxuat.txt"));
	    dsctPhieu = Arrays.copyOf(dsctPhieu, getSoctphieu());
	    for(int i = 0; i < dsctPhieu.length; i++){
            String infor_ctphieu[] = reader_ctphieu.readLine().split(";");
            dsctPhieu[i] = new chitietphieuxuat(infor_ctphieu[0],Integer.parseInt(infor_ctphieu[1]));
        }
	    reader_ctphieu.close();
	}

	
	public void xuatdanhsachphieu() {
        System.out.print("\nDanh sach phieu ton tai  ");
        System.out.println("\n");
        for (int i = 0; i < dsPhieuxuat.length; i++) {
        	if(dsPhieuxuat[i].getTrangthai() == 1) {
			System.out.println(dsPhieuxuat[i].xuatThongTin());
        	}
		}
	}
	
	public void xemchitietphieuxuat() {
		int signal = 0;
		System.out.print("Nhap ma phieu xuat ban muon xem chi tiet: ");
	    String ma = sc.nextLine();
	    for(int i = 0; i < dsPhieuxuat.length; i++){
	    	if(ma.equals(dsPhieuxuat[i].getMa())) {
	    		System.out.println("\n"+dsPhieuxuat[i].xuatThongTin());
	    		System.out.println("Chi tiet phieu: ");
	    		for(int j = dsPhieuxuat[i].getStt();j<dsPhieuxuat[i].getStt()+dsPhieuxuat[i].getSlSanpham();j++) {
	    			System.out.println(dsctPhieu[j].xuatchitietphieu());

	    		}
	    	signal = 1;
	    	break;
	    	}
	    }
	    if(signal == 0) System.out.println("\nMa phieu hien khong ton tai!!!");
	}
	
	public void themphieuxuat(BufferedWriter writer_phieu, BufferedWriter writer_ctphieu, BufferedReader reader_kh,
			BufferedReader reader_dt, BufferedReader reader_lap) throws IOException {
		writer_phieu = new BufferedWriter(new FileWriter("danhsachphieuxuat.txt",true));
        writer_ctphieu = new BufferedWriter(new FileWriter("chitietphieuxuat.txt",true));
		System.out.println("\nThem phieu xuat: \n");
		for(int i = getSophieuxuat(); i < getSophieuxuat()+1; i++){
			phieuxuat a = new phieuxuat();
			a.nhapThongTin(i, reader_kh);
			a.setStt(getSoctphieu());
			writer_phieu.write(a.toString());
			writer_phieu.newLine();
			System.out.print("\nNhap chi tiet phieu xuat: ");
			System.out.println("\n");
			for(int j = getSoctphieu();j<getSoctphieu()+a.getSlSanpham();j++){
				chitietphieuxuat b = new chitietphieuxuat();
				b.nhapchitietphieu(reader_dt,reader_lap);
				writer_ctphieu.write(b.toString());
				writer_ctphieu.newLine();
			}
			writer_ctphieu.close();
			writer_phieu.close();
		}
	}
 	
	public void xoaphieuxuat(BufferedWriter writer_phieu) throws IOException {
        boolean signal = false;
        writer_phieu = new BufferedWriter(new FileWriter("danhsachphieuxuat.txt"));
        writer_phieu.close();
        writer_phieu = new BufferedWriter(new FileWriter("danhsachphieuxuat.txt",true));
        System.out.print("\nNhap ma phieu ban muon xoa: ");
        String ma = sc.nextLine();
        for(int i = 0; i < dsPhieuxuat.length; i++) {
            if(ma.equals(dsPhieuxuat[i].getMa()) && dsPhieuxuat[i].getTrangthai() == 1) {
            	dsPhieuxuat[i].setTrangthai(0);
            	writer_phieu.write(dsPhieuxuat[i].toString());
                writer_phieu.newLine();
                signal = true;
            }
            else{
            	writer_phieu.write(dsPhieuxuat[i].toString());
                writer_phieu.newLine();
            }
        }
        writer_phieu.close();
        if(signal == false){
            System.out.print("\nMa phieu khong ton tai!!! ");
        }
        else System.out.print("\nPhieu da duoc xoa!!!");
	}
	
	public void capnhatsanpham(BufferedReader reader_ctphieu, BufferedReader reader_dt, BufferedReader reader_lap,
			BufferedWriter writer_dt, BufferedWriter writer_lap) throws IOException{
		//doc file san pham
		reader_dt = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
		reader_lap = new BufferedReader(new FileReader("danhsachlaptop.txt"));
		int count1 = 0, count2 = 0;
		while (reader_dt.readLine() != null) {
			count1++;
		}
		while (reader_lap.readLine() != null) {
			count2++;
		}
		reader_dt.close();
		reader_lap.close();
		
		reader_dt = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
		reader_lap = new BufferedReader(new FileReader("danhsachlaptop.txt"));
		dsDt = Arrays.copyOf(dsDt, count1);
		dsLap = Arrays.copyOf(dsLap, count2);
		for(int i = 0; i < dsDt.length; i++) {
			String infor_dt[] = reader_dt.readLine().split(";");
			dsDt[i] = new DienThoai(infor_dt[0],infor_dt[1],Double.parseDouble(infor_dt[2]),infor_dt[3],infor_dt[4],
					infor_dt[5],infor_dt[6],Integer.parseInt(infor_dt[7]),Integer.parseInt(infor_dt[8]));
		}
		for(int i = 0; i < dsLap.length; i++) {
			String infor_lap[] = reader_lap.readLine().split(";");
			dsLap[i] = new Laptop(infor_lap[0],infor_lap[1],Double.parseDouble(infor_lap[2]),infor_lap[3],infor_lap[4],
					infor_lap[5],infor_lap[6],infor_lap[7],Integer.parseInt(infor_lap[8]),Integer.parseInt(infor_lap[9]));
		}
		reader_dt.close();
		reader_lap.close();
		
		//cap nhat san pham vao mang
		for(int i = getSoctphieu()-1; i > getSoctphieu() - dsctPhieu[getSophieuxuat()].getSoluong()-1; i--) {
			for(int j = 0; j < dsDt.length; j++) {
				if(dsctPhieu[i].getMaSP().equals(dsDt[j].getMaDienThoai())) {
					int sl;
					sl = dsDt[j].getSoLuong() - dsctPhieu[i].getSoluong();
					dsDt[j].setSoLuong(sl);
					break;
				}
			}
		}
		for(int i = getSoctphieu()-1; i > getSoctphieu() - dsctPhieu[getSophieuxuat()].getSoluong()-1; i--) {	
			for(int j = 0; j < dsLap.length; j++) {
				if(dsctPhieu[i].getMaSP().equals(dsLap[j].getMaLaptop())) {
					int sl;
					sl = dsLap[j].getSoLuong() - dsctPhieu[i].getSoluong();
					dsLap[j].setSoLuong(sl);
					break;
				}
			}	
		}
		//ghi vao file
		writer_dt = new BufferedWriter(new FileWriter("danhsachdienthoai.txt"));
		writer_dt.close();
		writer_lap = new BufferedWriter(new FileWriter("danhsachlaptop.txt"));
		writer_lap.close();
		
		writer_dt = new BufferedWriter(new FileWriter("danhsachdienthoai.txt",true));
		for(int i = 0; i < dsDt.length; i++) {
            	writer_dt.write(dsDt[i].toString());
                writer_dt.newLine();
        }
		writer_dt.close();
		
		writer_lap = new BufferedWriter(new FileWriter("danhsachlaptop.txt",true));
		for(int i = 0; i < dsLap.length; i++) {
        	writer_lap.write(dsLap[i].toString());
            writer_lap.newLine();
    }
		writer_lap.close();
	}
}
