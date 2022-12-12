package quanlykhohangdientu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class phieuxuat extends phieu{
	private String maKhachhang;
	private  int slSanpham;
	private int stt;
    Pattern pattern_date = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");
	Scanner sc = new Scanner(System.in);
	connguoi[] dskh = new khachhang[1];

	
	 public String getMaKhachhang() {
		return maKhachhang;
	}

	public void setMaKhachhang(String maKhachhang) {
		this.maKhachhang = maKhachhang;
	}

	
	public int getSlSanpham() {
		return slSanpham;
	}

	public void setSlSanpham(int slSanpham) {
		this.slSanpham = slSanpham;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}


	public phieuxuat() {
	}
	
	public phieuxuat(String ma, String ngay, String maKhachhang, int slSanpham, int stt, int trangthai ) {
		super(ma, ngay, trangthai);
		this.slSanpham=slSanpham;
		this.stt = stt;
		this.maKhachhang = maKhachhang;
	}
	
	 public void nhapThongTin(int identity_id,BufferedReader reader_kh) throws IOException {
		//doc file kh
		reader_kh = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
		
		int count = 0;
	    while(reader_kh.readLine()!=null) {
	    	count++;
	    }
	    reader_kh.close();
	    
	    reader_kh = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
	    dskh = Arrays.copyOf(dskh, count);
	    for(int i = 0; i < dskh.length; i++){
            String infor_kh[] = reader_kh.readLine().split(";");
            dskh[i] = new khachhang(infor_kh[0],infor_kh[1],infor_kh[2],infor_kh[3],infor_kh[4],Integer.parseInt(infor_kh[5]));
        }
	    reader_kh.close();
	    
		setTrangthai(1);
		String ma = "PX"+identity_id;
        setMa(ma);
        System.out.println("Ma phieu: " + getMa());
	    System.out.print("ngay sinh khach hang(dd/mm/yyyy): ");
        String ngay = sc.nextLine();
        Matcher matcher_date = pattern_date.matcher(ngay);
        if(matcher_date.matches() == true){
            setNgay(ngay);
        }
        else{
            while(matcher_date.matches() == false){
                System.out.print("ngay sinh phai theo dang dd/mm/yyyy.\nnhap lai ngay sinh: ");
                ngay = sc.nextLine();
                matcher_date = pattern_date.matcher(ngay);
            }
            setNgay(ngay);
        }
	    System.out.print("Ma khach hang: ");
	    String khachhang = sc.nextLine();
	    int o = 1;
	    while (o < 2) {
			for(int i = 0; i < dskh.length; i++) {
				if(khachhang.equals(dskh[i].getMa())) {
					setMaKhachhang(khachhang);
					o ++;
					break;
				}
			}
			if(o < 2) {
				System.out.println("Moi nhap lai ma khach hang: ");
				khachhang = sc.nextLine();
			}
			
		}    
	    System.out.print("So loai san pham: ");
	    int slSanpham = sc.nextInt();
	    setSlSanpham(slSanpham);
		}
	
	@Override
	public String xuatThongTin() {
		return "Ma phieu: " + getMa() + "\nNgay lap: " + getNgay()  + "\nMa khach hang: " + getMaKhachhang() + "\nSo loai san pham: " + getSlSanpham() + "\n";
	}
	 
	@Override
	public String toString() {
		return getMa() + ";" + getNgay() + ";" + getMaKhachhang() + ";" + getSlSanpham() + ";" + getStt() + ";" + getTrangthai();
	}
	
}
