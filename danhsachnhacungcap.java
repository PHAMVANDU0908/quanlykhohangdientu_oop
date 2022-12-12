package quanlykhohangdientu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
public class danhsachnhacungcap implements Serializable {
    private int soLuongNhaCungCap;
    connguoi[] dsNhaCungCap = new nhacungcap[1];

    
    public int getSoLuongNhaCungCap() {
        return soLuongNhaCungCap;
    }
    public void setSoLuongNhaCungCap(int soLuongNhaCungCap) {
        this.soLuongNhaCungCap = soLuongNhaCungCap;
    }

    Scanner sc = new Scanner(System.in);

    public void nhapDanhSachNhaCungCapLanDau(BufferedWriter writer) throws IOException{
        System.out.print("nhap so luong nha cung cap muon nhap lan dau: ");
        soLuongNhaCungCap = sc.nextInt();
        // dsNhaCungCap = Arrays.copyOf(dsNhaCungCap, soLuongNhaCungCap);
        for(int i = 0; i < soLuongNhaCungCap; i++){
            // dsNhaCungCap[i] = new nhacungcap();
            // dsNhaCungCap[i].nhapThongTin(i);
            connguoi a =  new nhacungcap();
            a.nhapThongTin(i);
            writer.write(a.toString());
            writer.newLine();
        }
        writer.close();
    }


    
    public void xuatDanhSachNhaCungCap(BufferedReader reader) throws IOException{
        // ý tưởng:
        // duyệt file rồi xuất từng hàng
        //-nếu tình trạng hợp tác == 0(nhà cung cấp đã bị xóa) thì không in ra màng hình
        //-nếu tình trang hơp tác == 1(nhà cung cấp vẫn còn ) thì in ra màng hình

        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        String ncc = "";
        System.out.print("danh sach nha cung cap danh ton tai trong danh sach \n");
        while((ncc = reader.readLine())!=null){
            String[] infor_ncc = ncc.split(";");
            if(Integer.parseInt(infor_ncc[5]) == 0){
                continue;
            }
            else{
                connguoi a = new  nhacungcap(infor_ncc[0],infor_ncc[1],infor_ncc[2],infor_ncc[3],infor_ncc[4],Integer.parseInt(infor_ncc[5]));
                System.out.print(a.xuatThongTin()+"\n");
            }
            
        }
        reader.close();
    }



    public void themNCC(BufferedWriter writer,BufferedReader reader) throws IOException{
        // ý tưởng:
        // B1:tính số lượng hàng trong file để tăng mã.
        // B2:thêm object mới vào file
        // B1:
        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        writer = new BufferedWriter(new FileWriter("danhsachnhacungcap.txt",true));
        int count = 0;//so luong hang trong file
        while(reader.readLine()!=null){
            count++;
        }
        reader.close();
        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        // B2:vd trong file co 3 hang, minh nhap so luong can them la 2 = > bat dau tu 3
        System.out.print("\nnhap so luong nha cung cap ban muon them ");
        int soLuongNCCThem = sc.nextInt();
        for(int i = count ; i < count + soLuongNCCThem;i++){
            connguoi a = new nhacungcap();
            a.nhapThongTin(i);
            writer.write(a.toString());
            writer.newLine();
        }
        reader.close();
        writer.close();
    }





    public void suaNCC(BufferedReader reader,BufferedWriter writer) throws IOException{
        // ý tưởng:
        // B1:lấy danh sách nhà cung cấp từ file xuống mãng,sau đó xóa nọi dung trong file đi
        // B2:nhập mã nhà cung cấp muốn sửa và duyệt mãng, nếu object nào có mã giống thì sửa thông tin
        // B3:Ghi lại mãng nhà cung cấp sau khi sửa xong.

        // thực hiện

        // B1:
        boolean signal = false;//dùng để làm cờ để kiểm tra xem mã nhà cung cấp nhập vào có tồn tại trong danh sách không
        //tạo danh sach nhà cung cấp để luu khi lấy từ file về
        danhsachnhacungcap dsncc  = new danhsachnhacungcap();
        docFileNhaCungCap(reader, dsncc);//đọc file danh sách nhà cung cấp và bỏ vào mảng 
        //thực hiện việc xóa toàn bộ thông tin trong file danh sách nhà cung cấp nhờ đặc tính của constructor
        writer =  new BufferedWriter(new FileWriter("danhsachnhacungcap.txt"));
        writer.close();

        writer =  new BufferedWriter(new FileWriter("danhsachnhacungcap.txt",true));
        //duyet mang de sua thong tin va ghi lai file
        System.out.print("nhap ma nha cung cap ban muon sua thong tin: ");
        String ma = sc.nextLine();
        for(int i = 0; i < dsncc.dsNhaCungCap.length; i++){
            if(ma.equals(dsncc.dsNhaCungCap[i].getMa())){
                System.out.println("nha cung cap ban muon sua: \n"+dsncc.dsNhaCungCap[i].xuatThongTin());
                dsncc.dsNhaCungCap[i].nhapThongTin(i);
                do{
                    System.out.print("trang thai hop tac(1 hoac 0): ");
                    dsncc.dsNhaCungCap[i].setTrangThai(sc.nextInt());
                }
                while(dsncc.dsNhaCungCap[i].getTrangThai() != 1 && dsncc.dsNhaCungCap[i].getTrangThai() != 0);
                writer.write(dsncc.dsNhaCungCap[i].toString());
                writer.newLine();
                signal = true;
            }
            else{
                writer.write(dsncc.dsNhaCungCap[i].toString());
                writer.newLine();
            }
        }
        if(signal == false){
            System.out.print("ma nha cung cap khong co trong danh sach nha cung cap \n");
        }
        writer.close();
        reader.close();
        
    }


    public void xoaNCC(BufferedReader reader,BufferedWriter writer) throws IOException{
        boolean signal = false;//dung de lam co kiem tra xem ma nha cung cap nhap vao co trong danh sách không
        danhsachnhacungcap dsncc  = new danhsachnhacungcap();
        docFileNhaCungCap(reader,dsncc);
        writer =  new BufferedWriter(new FileWriter("danhsachnhacungcap.txt"));
        writer.close();
        System.out.print("\nnhap ma nha cung cap ban muon xoa ");
        String ma = sc.nextLine();
        writer =  new BufferedWriter(new FileWriter("danhsachnhacungcap.txt",true));
        for(int i = 0;i < dsncc.dsNhaCungCap.length; i++){
            if(ma.equals(dsncc.dsNhaCungCap[i].getMa())){
                System.out.print("nha cung cap ban chon de xoa: \n" + dsncc.dsNhaCungCap[i].xuatThongTin());
                dsncc.dsNhaCungCap[i].setTrangThai(0);
                writer.write(dsncc.dsNhaCungCap[i].toString());
                writer.newLine();
                signal = true;
            }
            else{
                writer.write(dsncc.dsNhaCungCap[i].toString());
                writer.newLine();
            }
        }
        if(signal == false){
            System.out.print("ma nha cung cap khong co trong danh sach nha cung cap \n");
        }
        writer.close();
        reader.close();
    }



    public void timKiemNCC(BufferedReader reader) throws IOException{
        // ý tưởng: 
        // B1: nhập mã ncc muốn tìm kiếm.
        // B2:duyệt file, nếu trùng mã thì xuất ra maàng hình
        // B1:
        System.out.print("nhap ma nha cung cap ban muon tim kiem ");
        String ma = sc.nextLine();
        boolean signal = false;
       reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        // B2:
        String ncc = "";
        while((ncc = reader.readLine())!=null){
            String[] infor_ncc = ncc.split(";");
            // System.out.println(infor_ncc[0]);
            if(ma.equals(infor_ncc[0])){
                // System.out.println("hihi");
                System.out.print("nha cung cap ban dang tim \n");
                connguoi a = new nhacungcap(infor_ncc[0], infor_ncc[1], infor_ncc[2], infor_ncc[3], infor_ncc[4],Integer.parseInt(infor_ncc[5]));
                System.out.print(a.xuatThongTin()+"\n\n");
                signal = true;
                break;
            }
        }
        if(signal == false){
            System.out.print("nha cung cap khong co trong danh sach nha cung cap \n");
        }
        reader.close();
    }


    //method duyet file ncc va dua toan bo thong tin vao mang 
    public void docFileNhaCungCap(BufferedReader reader,danhsachnhacungcap dsncc) throws IOException{
        int count = 0;
        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        while(reader.readLine() != null){
            count++;
        }
        reader.close();
        dsncc.dsNhaCungCap = Arrays.copyOf(dsncc.dsNhaCungCap, count);
        dsncc.setSoLuongNhaCungCap(count);
        reader = new BufferedReader(new FileReader("danhsachnhacungcap.txt"));
        for(int i = 0; i < dsncc.dsNhaCungCap.length; i++){
            String infor_ncc[] = reader.readLine().split(";");
            dsncc.dsNhaCungCap[i] = new nhacungcap(infor_ncc[0], infor_ncc[1], infor_ncc[2], infor_ncc[3], infor_ncc[4],Integer.parseInt(infor_ncc[5]));
        }
    }
}
