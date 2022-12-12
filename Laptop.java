package quanlykhohangdientu;
import java.util.Scanner;
public class Laptop extends SanPham {	
	private String maLaptop;
	private String tenLaptop;
	private double giaLaptop;
	private String thuongHieuLaptop;
	private String heDieuHanhLaptop;
	private String ram;
	private String card;
	private String tenCPU;
	private int soLuong;
	private int trangThai;
	
	public Laptop() {
	}	
	public Laptop(String maLaptop, String tenLaptop, double giaLaptop,
			String thuongHieuLaptop, String heDieuHanhLaptop,String ram, String card, String tenCPU, int soLuong, int trangThai) {
		this.ram = ram;
		this.card = card;
		this.tenCPU = tenCPU;
		this.maLaptop = maLaptop;
		this.tenLaptop = tenLaptop;
		this.giaLaptop = giaLaptop;
		this.thuongHieuLaptop = thuongHieuLaptop;
		this.heDieuHanhLaptop = heDieuHanhLaptop;
		this.soLuong= soLuong;
		this.trangThai= trangThai;
	
	}
	public String getTenLaptop() {
		return tenLaptop;
	}
	public void setTenLaptop(String tenLaptop) {
		this.tenLaptop = tenLaptop;
	}
	public double getGiaLaptop() {
		return giaLaptop;
	}
	public void setGiaLaptop(double giaLaptop) {
		this.giaLaptop = giaLaptop;
	}
	public String getThuongHieuLaptop() {
		return thuongHieuLaptop;
	}
	public void setThuongHieuLaptop(String thuongHieuLaptop) {
		this.thuongHieuLaptop = thuongHieuLaptop;
	}
	public String getHeDieuHanhLaptop() {
		return heDieuHanhLaptop;
	}
	public void setHeDieuHanhLaptop(String heDieuHanhLaptop) {
		this.heDieuHanhLaptop = heDieuHanhLaptop;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getTenCPU() {
		return tenCPU;
	}
	public void setTenCPU(String tenCPU) {
		this.tenCPU = tenCPU;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaLaptop() {
		return maLaptop;
	}
	
	public void setMaLaptop(String maLaptop) {
		// if(maLaptop!=null && maLaptop.substring(0,1).equalsIgnoreCase("5")) {
		// 	this.maLaptop = maLaptop;
		// 	return true;
		// }
		// else {
		// 	System.err.println("nhap lai ma san pham!!!");
		// 	return false;
		// }
		this.maLaptop = maLaptop;		
	}

	Scanner sc=new Scanner(System.in);
	
	@Override
	public void nhapThongTin(int identity_id) {
            setMaLaptop("LT"+identity_id);
		
		System.out.print("Ten Laptop: ");
		tenLaptop=sc.nextLine();		
		System.out.print("Gia: ");
		giaLaptop=Double.parseDouble(sc.nextLine());
		System.out.print("Thuong hieu: ");
		thuongHieuLaptop=sc.nextLine();
		System.out.print("He dieu hanh: ");
	    heDieuHanhLaptop=sc.nextLine();
        System.out.print("Ram: ");
		ram=sc.nextLine();
		System.out.print("Card man hinh: ");
		card=sc.nextLine();
		System.out.print("CPU: ");
		tenCPU=sc.nextLine();
		System.out.print("So luong: ");
		soLuong = Integer.parseInt(sc.nextLine());
		setTrangThai(1);
		
	}
	
	@Override
	public String toString() {
		return   getMaLaptop() 
		        + ";" + getTenLaptop() 
		        + ";" + getGiaLaptop()
		        + ";"+ getThuongHieuLaptop() 
		        + ";" + getHeDieuHanhLaptop()
		        + ";" + getRam() 
		        + ";" + getCard() 
		        + ";"+ getTenCPU() 
		        + ";" + getSoLuong()
		        + ";" + getTrangThai();
		
	}
	
	@Override
	public String xuatThongTin() {
		return  "\nMa Laptop: " + getMaLaptop() 
		        + "\nTen Laptop: " + getTenLaptop() 
		        + "\nGia: " + getGiaLaptop()
		        + "\nThuong hieu: "+ getThuongHieuLaptop() 
		        + "\nHe dieu hanh " + getHeDieuHanhLaptop()
		        + "\nRam: " + getRam() 
		        + "\nCard man hinh: " + getCard() 
		        + "\nCPU: "+ getTenCPU()	
		        + "\nSo luong: "+ getSoLuong();
	}
}
