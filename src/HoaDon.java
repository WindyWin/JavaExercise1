import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoaDon {
    private ArrayList<DoAnNhanh> items;
    private LocalDateTime ngayTao ;
    //tong tien thanh toan
    private Double tongCong;

    private HoaDon(ArrayList<DoAnNhanh> items){
        this.items = items;
        this.ngayTao = LocalDateTime.now();
        this.tongCong = items.stream().map(DoAnNhanh::getPrice).reduce(0.0,Double::sum);
    }

    public ArrayList<DoAnNhanh> getItems() {
        return items;
    }

    public void setItems(ArrayList<DoAnNhanh> items) {
        this.items = items;
        this.tongCong = items.stream().map(DoAnNhanh::getPrice).reduce(0.0,Double::sum);
    }
    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getTongCong() {
        return tongCong;
    }


}
