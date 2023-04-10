import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BanhMi implements  DoAnNhanh{
    private final ArrayList<Topping> toppings = new ArrayList<>(5);

    public BanhMi() {
        Topping banhMiKhong = new BanhMiKhong();
        toppings.add(banhMiKhong);
    }

    public Integer addTopping(Topping topping){
        //check max size of topping
        if(toppings.size() ==5){
            return -1;
        }


        toppings.add(topping);

        if(validation()){
            return 1;
        }
        //case BanhMi topping not valid
        toppings.remove(topping);
        return -1;
    }
    public Integer removeTopping(Topping topping){
            //case topping removed is Entity.BanhMiKhong
            if(topping instanceof BanhMiKhong){
                return  -1;
            }

            if( toppings.remove(topping)){
                return 1;
            }
            return -1;
    }
    public static BanhMi write(){
        BanhMi banhMi = new BanhMi();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option!=15){

            System.out.println("Trạng thái bánh mì hiện tại: " + banhMi);
            System.out.println("Vui lòng chọn topping cho bánh mì");


            Class<?>[] toppingChild = Topping.class.getDeclaredClasses();

            for (Class<?> topping:toppingChild){
                System.out.println(topping.toString());
            }
/*            System.out.println("\n1. " + BoKho.toString());
            System.out.println("\n2. " + CaHoi.toString());
            System.out.println("\n3. " + ChaBo.toString());
            System.out.println("\n4. " + ChaBong.toString());
            System.out.println("\n5. " + ChaCa.toString());
            System.out.println("\n6. " + ChaLua.toString());
            System.out.println("\n7. " + HeoQuay.toString());
            System.out.println("\n8. " + Jambon.toString());
            System.out.println("\n9. " + Nem.toString());
            System.out.println("\n10. " + Thit.toString());
            System.out.println("\n11. " + ThitNuong.toString());
            System.out.println("\n12. " + TrungChien.toString());
            System.out.println("\n13. " + XiuMai.toString());*/
            System.out.println("\n14. Xóa topping gần nhất.") ;
            System.out.println("\n15. Kết thúc nhập.") ;
                System.out.print("\n ===============\n Lựa chọn: ");
            option = sc.nextInt();
        }
        return banhMi;
    }
    @Override
    public Boolean validation() {
    //check valid topping
        return true;
    }
    @Override
    public Double getPrice(){
        return toppings.stream()
                .map(Topping::getPrice)
                .reduce(0.0, Double::sum);
    }

    public String getName(){
        if(toppings.size() ==1)
            return "Bánh mì không.";
        StringBuilder result = new StringBuilder("Bánh mì ");
        // template Bánh mì trứng, trứng, thịt, thịt.
        for(int i = 0 ; i < toppings.size(); i++){
            String toppingName = toppings.get(i).getName();
            if(i> 0 )
                result.append(",");
            result.append(" ")
                    .append(toppingName);
        }
        result.append(".");
        return result.toString();
    }

}
