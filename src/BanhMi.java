import Entity.BanhMiKhong;
import Entity.Topping;

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
        Scanner sc = new Scanner();

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
