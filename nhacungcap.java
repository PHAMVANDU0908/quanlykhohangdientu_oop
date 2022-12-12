package quanlykhohangdientu;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nhacungcap extends connguoi {
    private String maSoThue;
    Pattern pattern_taxcode = Pattern.compile("[0-9]*");
    Scanner sc = new Scanner(System.in);
    Pattern pattern_phone = Pattern.compile(connguoi.REGEX_PHONE);

    public String getMaSoThue() {
        return maSoThue;
    }


    public void setmaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public nhacungcap(){

    }

    public nhacungcap(String maNCC, String tenNCC,String diaChiNCC,String dienThoaiNCC,String maSoThue,int conhoptac){
        super(maNCC,tenNCC,diaChiNCC,dienThoaiNCC,conhoptac);
        this.maSoThue = maSoThue;
    }

    @Override
    public void nhapThongTin(int identity_id){
        setTrangThai(1);
        String maNCC = "NCC" + identity_id;
        setMa(maNCC);
        System.out.print("ten nha cung cap: ");
        String tenNCC = sc.nextLine();
        setTen(tenNCC);
        System.out.print("dia chi nha cung cap: ");
        String diaChiNCC = sc.nextLine();
        setDiaChi(diaChiNCC);
        System.out.print("dien thoai nha cung cap(0xxxxxxxxx hoac +84xxxxxxxxx): ");
        String dienThoaiNCC = sc.nextLine();
        Matcher matcher_phone = pattern_phone.matcher(dienThoaiNCC);
        if(matcher_phone.matches() == true){
            setDienThoai(dienThoaiNCC);
        }
        else{
            while(matcher_phone.matches() == false){
                System.out.print("So dien thoai nhap sai.\nmoi nhap lai theo cu phap(0xxxxxxxxx hoac +84xxxxxxxxx): ");
                dienThoaiNCC = sc.nextLine();
                matcher_phone = pattern_phone.matcher(dienThoaiNCC);
            }
            setDienThoai(dienThoaiNCC);
        }
        setDienThoai(dienThoaiNCC);
        System.out.print("ma so thue(13 ki tu so): ");
        maSoThue = sc.nextLine();
        Matcher matcher_taxcode = pattern_taxcode.matcher(maSoThue);
        if(matcher_taxcode.matches() == true){
            setmaSoThue(maSoThue);
        }
        else{
            while(matcher_taxcode.matches() == false || maSoThue.length() != 13){
                System.out.println("ma so thue nhap sai(13 ki tu so). \nmoi nhap lai: ");
                maSoThue = sc.nextLine();
                matcher_taxcode= pattern_taxcode.matcher(maSoThue);
            }
            setmaSoThue(maSoThue);
        }
    }


    @Override
    public String toString(){
        return getMa() + ";"+ getTen() + ";"+ getDiaChi() + ";" + getDienThoai() + ";"+ getMaSoThue() +";"+getTrangThai();
    }


    @Override
    public String xuatThongTin(){
        return "ma ncc: " + getMa() + "\nten ncc: "+getTen()+"\ndiachi ncc: "+getDiaChi()+"\ndienthoai ncc: "+getDienThoai()+"\nma so thue: "+getMaSoThue()+"\ntinh trang hop tac: "+getTrangThai()+"\n";
    }
}
