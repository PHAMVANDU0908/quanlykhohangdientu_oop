package quanlykhohangdientu;
public abstract class phieu {
	private String ma;
	private String ngay;
	private int trangthai;
	
	public phieu() {
	}
	public phieu(String ma, String ngay,int trangthai) {
		this.ma = ma;
		this.ngay = ngay;
		this.trangthai = trangthai;
	}
	
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	
	public abstract String toString();
	public abstract String xuatThongTin();
	
}