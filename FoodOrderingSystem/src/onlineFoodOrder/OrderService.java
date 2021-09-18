package onlineFoodOrder;

import java.util.List;

public class OrderService {
    private static OrderService instance = null;
    private OrderService(){

    }
    public static OrderService getInstance(){
        if(instance==null){
            instance=new OrderService();
        }
        return instance;
    }
    UserDao userDao=UserDao.getInstance();

    public Orders placeOrder(String name, Integer quantity){
        if(quantity<=0){
            System.out.println("Invalid value for mandatory fields");
            return null;
        }
        return userDao.placeOrder(name,quantity);
    }

    public List<Orders> listOrders(){
        return userDao.listOrders();
    }
}
