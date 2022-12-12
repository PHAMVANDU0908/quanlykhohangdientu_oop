package quanlykhohangdientu;
import java.util.Scanner;
import java.util.regex.Matcher;
public class DienThoai extends SanPham {	
	private String maDienThoai;
	private String tenDienThoai;
	private double giaDienThoai;
	private String thuongHieuDienThoai;
	private String heDieuHanhDienThoai;
	private String dungLuong;
	private String mauDienThoai;
	private int soLuong;
	private int trangThai;

		
	public DienThoai() {
	}
	public DienThoai(String maDienThoai, String tenDienThoai, double giaDienThoai,
			String thuongHieuDienThoai, String heDieuHanhDienThoai, String dungLuong, String mauDienThoai, int soLuong, int trangThai) {
		this.dungLuong = dungLuong;
		this.mauDienThoai = mauDienThoai;
		this.maDienThoai = maDienThoai;
		this.tenDienThoai = tenDienThoai;
		this.giaDienThoai = giaDienThoai;
		this.thuongHieuDienThoai = thuongHieuDienThoai;
		this.heDieuHanhDienThoai = heDieuHanhDienThoai;
		this.soLuong= soLuong;
		this.trangThai= trangThai;
		
	}
	public String getTenDienThoai() {
		return tenDienThoai;
	}

	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	public double getGiaDienThoai() {
		return giaDienThoai;
	}

	public void setGiaDienThoai(double giaDienThoai) {
		this.giaDienThoai = giaDienThoai;
	}

	public String getThuongHieuDienThoai() {
		return thuongHieuDienThoai;
	}

	public void setThuongHieuDienThoai(String thuongHieuDienThoai) {
		this.thuongHieuDienThoai = thuongHieuDienThoai;
	}

	public String getHeDieuHanhDienThoai() {
		return heDieuHanhDienThoai;
	}

	public void setHeDieuHanhDienThoai(String heDieuHanhDienThoai) {
		this.heDieuHanhDienThoai = heDieuHanhDienThoai;
	}
	public String getDungLuong() {
		return dungLuong;
	}
	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}
	public String getMauDienThoai() {
		return mauDienThoai;
	}
	public void setMauDienThoai(String mauDienThoai) {
		this.mauDienThoai = mauDienThoai;
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
	public String getMaDienThoai() {
		return maDienThoai;
	}

        public void setMaDienThoai(String maDienThoai) {
            this.maDienThoai = maDienThoai;
        }
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void nhapThongTin(int identity_id) {		
                setMaDienThoai("DT"+identity_id);
		System.out.print("Ten dien thoai: ");
		tenDienThoai=sc.nextLine();
		System.out.print("Gia: ");
		giaDienThoai=Double.parseDouble(sc.nextLine());	
		System.out.print("Thuong hieu: ");
		thuongHieuDienThoai=sc.nextLine();	
		System.out.print("He dieu hanh: ");
		heDieuHanhDienThoai=sc.nextLine();				
		System.out.print("Mau dien thoai: ");
		mauDienThoai=sc.nextLine();	
		System.out.print("Dung luong(GB): ");
		dungLuong=sc.nextLine();
		System.out.print("So luong: ");
		soLuong= Integer.parseInt(sc.nextLine());
		setTrangThai(1);
	}
	
	
	@Override
	public String toString() {
		return getMaDienThoai() 
		        + ";" + getTenDienThoai()
				+ ";" + getGiaDienThoai() 
				+ ";" + getThuongHieuDienThoai() 
				+ ";"+ getHeDieuHanhDienThoai() 
				+ ";" + getMauDienThoai()
				+ ";" + getDungLuong()
				+ ";" + getSoLuong()
				+ ";" + getTrangThai();		
	}
	
	@Override
	public String xuatThongTin() {
		return "\nMa dien thoai: " + getMaDienThoai() 
		        + "\nTen dien thoai: " + getTenDienThoai()
				+ "\nGia: " + getGiaDienThoai() 
				+ "\nThuong hieu: " + getThuongHieuDienThoai() 
				+ "\nHe dieu hanh: "+ getHeDieuHanhDienThoai() 
				+ "\nMau dien thoai: " + getMauDienThoai()
				+ "\nDung luong(GB): " + getDungLuong()
		        + "\nSo luong: " + getSoLuong()
		        + "\n";
		        
	}
	
	
}
