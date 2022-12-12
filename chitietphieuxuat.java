package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class chitietphieuxuat {
	private String maSP;
	private int soluong;
	Scanner sc = new Scanner(System.in);
	DienThoai[] dsdt = new DienThoai[1];
	Laptop[] dslap = new Laptop[1];
	
	
	
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	public chitietphieuxuat() {
	}
	
	public chitietphieuxuat(String maSP, int soluong) {
		super();
		this.maSP = maSP;
		this.soluong = soluong;
	}

	
	public void nhapchitietphieu(BufferedReader reader_dt, BufferedReader reader_lap) throws IOException {
		reader_dt = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
		reader_lap = new BufferedReader(new FileReader("danhsachlaptop.txt"));
		int count1 = 0, count2 = 0;
		while(reader_dt.readLine() != null) {
			count1 ++;
		}
		while(reader_lap.readLine() != null) {
			count2 ++;
		}
		reader_dt.close();
		reader_lap.close();
		
		reader_dt = new BufferedReader(new FileReader("danhsachdienthoai.txt"));
		dsdt = Arrays.copyOf(dsdt, count1);
		for(int i=0; i<dsdt.length; i++) {
			String infor_dt[] = reader_dt.readLine().split(";");
			dsdt[i] = new DienThoai(infor_dt[0],infor_dt[1],Double.parseDouble(infor_dt[2]),infor_dt[3],infor_dt[4],
					infor_dt[5],infor_dt[6],Integer.parseInt(infor_dt[7]),Integer.parseInt(infor_dt[8]));
		}
		reader_dt.close();
		
		reader_lap = new BufferedReader(new FileReader("danhsachlaptop.txt"));
		dslap = Arrays.copyOf(dslap, count2);
		for(int i=0; i<dslap.length; i++) {
			String infor_lap[] = reader_lap.readLine().split(";");
			dslap[i] = new Laptop(infor_lap[0],infor_lap[1],Double.parseDouble(infor_lap[2]),infor_lap[3],infor_lap[4],
					infor_lap[5],infor_lap[6],infor_lap[7],Integer.parseInt(infor_lap[8]),Integer.parseInt(infor_lap[9]));
		}
		reader_dt.close();
		
		
		System.out.print("Ma san pham: ");
		String maSP = sc.nextLine();
		int o = 1;
		while (o < 2) {
			// so sanh ma voi ma dt
			for(int i = 0; i < dsdt.length; i++) {
				if(maSP.equals(dsdt[i].getMaDienThoai())) {
					setMaSP(maSP);
					System.out.print("So luong: ");
					int soluong = sc.nextInt();
					while (o < 2) {
						if(soluong <= dsdt[i].getSoLuong() && soluong >= 0) {
						setSoluong(soluong);
						o ++;
						break;
						}
						else {
							System.out.print("So luong khong hop le");
							System.out.print("Nhap lai so luong: ");
							soluong = sc.nextInt();
						}
					}
					
				}
			}
			// so sanh ma voi ma lap
		if(o < 2) {	
			for(int i = 0; i < dslap.length; i++) {
				if(maSP.equals(dslap[i].getMaLaptop())) {
					setMaSP(maSP);
					System.out.print("So luong: ");
					int soluong = sc.nextInt();
					while (o < 2) {
						if(soluong <= dslap[i].getSoLuong() && soluong >= 0) {
						setSoluong(soluong);
						o ++;
						break;
						}
						else {
							System.out.print("So luong khong hop le");
							System.out.print("Nhap lai so luong: ");
							soluong = sc.nextInt();
						}
					}
				}
			}
		}
		
			if(o < 2) {
				System.out.print("Ma san pham khong ton tai!!! ");
				System.out.print("Nhap lai ma san pham");
				maSP = sc.nextLine();
			}
		}    
	}

	public String xuatchitietphieu( ) {
		return "Ma san pham: " + getMaSP() + "\nSo luong: " + getSoluong();
	}
	
	public String toString() {
		return getMaSP() + ";" + getSoluong();
		}
}
