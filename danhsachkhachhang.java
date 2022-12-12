package quanlykhohangdientu;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class danhsachkhachhang {

    



    private int soLuongKhachHang = 1;
    connguoi[] dsKhachHang = new khachhang[soLuongKhachHang];

    Scanner sc = new Scanner(System.in);

    public int getSoLuongKhachHang() {
        return soLuongKhachHang;
    }
    public void setSoLuongKhachHang(int soLuongKhachHang) {
        this.soLuongKhachHang = soLuongKhachHang;
    }

    public void nhapDanhSachNhachHangLanDau(BufferedWriter writer) throws IOException{
        // --------------------code moi--------------------------
        System.out.print("nhap so luong khach hang muon nhap lan dau: ");
        soLuongKhachHang = sc.nextInt();
        for(int i = 0; i < soLuongKhachHang; i++){
            connguoi a =  new khachhang();
            a.nhapThongTin(i);
            writer.write(a.toString());
            writer.newLine();
        }
        writer.close();
    }

    public void xuatDanhKhachHang(BufferedReader reader) throws IOException{

        // -------------------------------code mới----------------------------------
        reader = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
        String khachhang = "";
        System.out.print("danh sach khach hang danh ton tai trong danh sach \n");
        while((khachhang = reader.readLine())!=null){
            String[] infor_kh = khachhang.split(";");
            if(Integer.parseInt(infor_kh[5]) == 0){
                continue;
            }
            else{
                connguoi a = new  khachhang(infor_kh[0],infor_kh[1],infor_kh[2],infor_kh[3],infor_kh[4],Integer.parseInt(infor_kh[5]));
                System.out.print(a.xuatThongTin()+"\n");
            }
        }
        reader.close();
    }



    public void themKH(BufferedWriter writer,BufferedReader reader) throws IOException{
        // B1:
        reader = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
        writer = new BufferedWriter(new FileWriter("danhsachkhachhang.txt",true));
        int count = 0;//so luong hang trong file
        while(reader.readLine()!=null){
            count++;
        }
        reader.close();
        reader = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
        // B2:vd trong file co 3 hang, minh nhap so luong can them la 2 = > bat dau tu 3
        System.out.print("\nnhap so luong khach hang ban muon them ");
        int soLuongKHThem = sc.nextInt();
        for(int i = count ; i < count + soLuongKHThem;i++){
            connguoi a = new khachhang();
            a.nhapThongTin(i);
            writer.write(a.toString());
            writer.newLine();
        }
        reader.close();
        writer.close();
    }




    public void suaKH(BufferedReader reader,BufferedWriter writer) throws IOException{
        // ý tưởng:
        // B1:lấy danh sách nhà cung cấp từ file xuống mang,sau đó xóa nọi dung trong file đi
        // B2:nhập mã nhà cung cấp muốn sửa và duyệt mãng, nếu object nào có mã giống thì sửa thông tin
        // B3:Ghi lại mãng nhà cung cấp sau khi sửa xong.

        // thực hiện

        // B1:
        // int count = 0;
        boolean signal = false;
        //tạo danh sach nhà cung cấp để luu khi lấy từ file về
        danhsachkhachhang dskh  = new danhsachkhachhang();
        docFileKhachHang(reader, dskh);
        //xoa toan bo thong tin trong file
        writer =  new BufferedWriter(new FileWriter("danhsachkhachhang.txt"));
        writer.close();
        // B2,B3:
        //xoa toan bo thong tin trong file
        writer =  new BufferedWriter(new FileWriter("danhsachkhachhang.txt",true));
        //duyet mang de sua thong tin va ghi lai file
        System.out.print("nhap ma khach hang ban muon sua thong tin: ");
        String ma = sc.nextLine();
        for(int i = 0; i < dskh.dsKhachHang.length; i++){
            if(ma.equals(dskh.dsKhachHang[i].getMa())){
                System.out.println("Khach hang ban muon sua thong tin: \n"+dskh.dsKhachHang[i].xuatThongTin());
                dskh.dsKhachHang[i].nhapThongTin(i);
                do{
                    System.out.print("khach hang con mua hang khong(1 hoac 0): ");
                    dskh.dsKhachHang[i].setTrangThai(sc.nextInt());
                }
                while(dskh.dsKhachHang[i].getTrangThai() != 1 && dskh.dsKhachHang[i].getTrangThai() != 0);
                writer.write(dskh.dsKhachHang[i].toString());
                writer.newLine();
                signal = true;
            }
            else{
                writer.write(dskh.dsKhachHang[i].toString());
                writer.newLine();
            }
        }
        if(signal == false){
            System.out.print("ma khach hang khong co trong danh sach khach hang: \n");
        }
        writer.close();
        reader.close();
        
    }





    public void xoaKH(BufferedReader reader,BufferedWriter writer) throws IOException{
        // int count = 0;
        boolean signal = false;
        danhsachkhachhang dskh = new danhsachkhachhang();
        docFileKhachHang(reader, dskh);
        
        writer =  new BufferedWriter(new FileWriter("danhsachkhachhang.txt"));
        writer.close();
        System.out.print("\nnhap ma khach hang ban muon xoa ");
        // sc.nextLine();
        String ma = sc.nextLine();
        writer =  new BufferedWriter(new FileWriter("danhsachkhachhang.txt",true));
        // System.out.println("hihis");
        for(int i = 0;i < dskh.dsKhachHang.length; i++){
            if(ma.equals(dskh.dsKhachHang[i].getMa())){
                System.out.print("khach hang ban chon de xoa: \n" + dskh.dsKhachHang[i].xuatThongTin());
                dskh.dsKhachHang[i].setTrangThai(0);
                writer.write(dskh.dsKhachHang[i].toString());
                writer.newLine();
                signal = true;
            }
            else{
                writer.write(dskh.dsKhachHang[i].toString());
                writer.newLine();
            }
        }
        if(signal == false){
            System.out.print("ma khach hang khong co trong danh sach khach hang: \n");
        }
        writer.close();
        reader.close();
    }


    public void timKiemKH(BufferedReader reader) throws IOException{
        boolean signal = false;
        System.out.print("nhap ma khach hang ban muon tim kiem ");
        String ma = sc.nextLine();
        reader = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
        // B2:
        String khachhang = "";
        while((khachhang = reader.readLine())!=null){
            String[] infor_kh = khachhang.split(";");
            if(ma.equals(infor_kh[0])){
                System.out.println(infor_kh[0]);
                System.out.print("khach hang ban dang tim \n");
                connguoi a = new khachhang(infor_kh[0], infor_kh[1], infor_kh[2], infor_kh[3], infor_kh[4],Integer.parseInt(infor_kh[5]));
                System.out.print(a.xuatThongTin()+"\n\n");
                signal = true;
                break;
            }
        }
        if(signal == false){
            System.out.print("ma khach hang khong co trong danh sach khach hang: \n");
        }
        reader.close();
    }



    public void docFileKhachHang(BufferedReader reader,danhsachkhachhang dskh) throws IOException{
        int count = 0;
        reader = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
        while(reader.readLine() != null){
            count++;
        }
        reader.close();
        dskh.dsKhachHang = Arrays.copyOf(dskh.dsKhachHang, count);
        dskh.setSoLuongKhachHang(count);
        reader = new BufferedReader(new FileReader("danhsachkhachhang.txt"));
        for(int i = 0; i < dskh.dsKhachHang.length; i++){
            String infor_kh[] = reader.readLine().split(";");
            dskh.dsKhachHang[i] = new khachhang(infor_kh[0], infor_kh[1], infor_kh[2], infor_kh[3], infor_kh[4],Integer.parseInt(infor_kh[5]));
        }
    }
    
}
