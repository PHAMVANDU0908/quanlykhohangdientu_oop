package quanlykhohangdientu;


//connguoi la mot abstract class 
public abstract class connguoi{
    private String ma;
    private String ten;
    private String diaChi;
    private String dienThoai;
    private int trangThai;

    // public static final String REGEX_NAME = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";
    public static final String REGEX_NAME = "^[A-Z][a-z]*(?:[ ][A-Z][a-z]*)*.*$";
    public static final String REGEX_PHONE ="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getDienThoai() {
        return dienThoai;
    }
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public int getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }


    
    public connguoi(){

    }

    public connguoi(String ma, String ten, String diaChi, String dienThoai,int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.trangThai = trangThai;
    }

    public abstract String toString();

    public abstract void nhapThongTin(int identity_id);

    public abstract String xuatThongTin();

}


