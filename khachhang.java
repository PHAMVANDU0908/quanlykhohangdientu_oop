package quanlykhohangdientu;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import quanlykhohang.dienthoai;

//phieu nhap bat dau tu 0
//phieu xuat bat dau tu 1
//khach hang bat dau tu 2
//nha cung cap bat dau tu 3
//dien thoai bat dau 4
//lap top 5




//hoi co de xac dinh so do class, 
public class khachhang extends connguoi {
    private String ngaySinh;


    Pattern pattern_name = Pattern.compile(connguoi.REGEX_NAME);
    Pattern pattern_age = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");
    Pattern pattern_phone = Pattern.compile(connguoi.REGEX_PHONE);
    Scanner sc = new Scanner(System.in);
    
    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }


    public khachhang(){

    }

    public khachhang(String maKH,String tenKH,String ngaySinhKH,String diaChiKH,String dienThoaiKH,int conmuahang){
        super(maKH,tenKH,diaChiKH,dienThoaiKH,conmuahang);
        this.ngaySinh = ngaySinhKH;
    }

    

    @Override
    public void nhapThongTin(int identity_id){
        setTrangThai(1);
        String maKH = "KH"+identity_id;
        setMa(maKH);
        System.out.print("ten khach hang(example:Pham Van Du): ");
        String tenKH = sc.nextLine();
        Matcher matcher_name = pattern_name.matcher(tenKH);
        if(matcher_name.matches() == true){
            setTen(tenKH);
        }
        else{
            while(matcher_name.matches() == false){
                System.out.println("Ten khach hang viet hoa chu cai dau va khong dau. \nmoi nhap lai: ");
                tenKH = sc.nextLine();
                matcher_name = pattern_name.matcher(tenKH);
            }
            setTen(tenKH);
        }

        System.out.print("ngay sinh khach hang(dd/mm/yyyy): ");
        String ngaySinh = sc.nextLine();
        Matcher matcher_age = pattern_age.matcher(ngaySinh);
        if(matcher_age.matches() == true){
            setNgaySinh(ngaySinh);
        }
        else{
            while(matcher_age.matches() == false){
                System.out.print("ngay sinh phai theo dang dd/mm/yyyy.\nnhap lai ngay sinh: ");
                ngaySinh = sc.nextLine();
                matcher_age = pattern_age.matcher(ngaySinh);
            }
            setNgaySinh(ngaySinh);
        }
        System.out.print("dia chi khach hang: ");
        String diaChiKH = sc.nextLine();
        setDiaChi(diaChiKH);
        System.out.print("dien thoai khach hang(0xxxxxxxxx hoac +84xxxxxxxxx): ");
        String dienThoaiKH = sc.nextLine();
        Matcher matcher_phone = pattern_phone.matcher(dienThoaiKH);
        if(matcher_phone.matches() == true){
            setDienThoai(dienThoaiKH);
        }
        else{
            while(matcher_phone.matches() == false){
                System.out.print("So dien thoai nhap sai.\nmoi nhap lai theo cu phap(0xxxxxxxxx hoac +84xxxxxxxxx): ");
                dienThoaiKH = sc.nextLine();
                matcher_phone = pattern_phone.matcher(dienThoaiKH);
            }
            setDienThoai(dienThoaiKH);
        }
    }


    @Override
    public String toString(){
        return getMa() + ";" + getTen() + ";"+ getNgaySinh() + ";" + getDiaChi() + ";" + getDienThoai() +";"+getTrangThai();
    }

    @Override
    public String xuatThongTin(){
        return "ma khach hang: " + getMa() + "\nten khach hang: " + getTen() + "\nngay sinh khach hang: "+ getNgaySinh() + "\ndia chi khach hang: " + getDiaChi() + "\ndien thoai khach hang: " + getDienThoai() + "\nkhach hang con mua hang khong: " + getTrangThai()+"\n";
    }

    
}

