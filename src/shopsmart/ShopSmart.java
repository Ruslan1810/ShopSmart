package shopsmart;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopSmart {

    ArrayList<String> order;
    ArrayList<String> memory;

    public static void main(String[] args) {
        ShopSmart s = new ShopSmart();
        s.run();
    }

    // поиск различий в двух массивах и добавление их в третий массив
    ArrayList<String> set_difference(ArrayList<String> first, ArrayList<String> second) {

        ArrayList<String> res_ar = new ArrayList<String>();

        for (int i = 0; i < first.size(); i++) {
            if (second.contains(first.get(i)) == false) {
                res_ar.add(first.get(i));
            }
        }

        return res_ar;
    }

    //объединенине массивов
    void unit(ArrayList<String> first, ArrayList<String> second) {

        ArrayList<String> res_ar = new ArrayList<String>();//массив товаров, которых нет в корзмне, но которые ранее заказывали

        for (int i = 0; i < second.size(); i++) {
            if (first.contains(second.get(i)) == false) {
                first.add(second.get(i));
            }
        }
    }
//добавление в корзину
    void enter_order() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите ваш новый заказ");

        
        order = new ArrayList(); //очистка корзины с старым заказом
        while (true) {
            String str = sc.next();
            if (str.equals("STOP")) {
                break;
            }
            order.add(str);
        }
    }
//распечатка корзины
    void print_order() {
        System.out.println("Вы заказали следующее:");
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }

    }

    void run() {
        /* memory = старые заказы;
          order – заново вводит пользователь;
          вывод (memory без order)
          memory = memory + order*/

        order = new ArrayList();
        memory = new ArrayList();
        while (true) {
            enter_order();
            print_order();

            ArrayList<String> res = set_difference(memory, order);
            
            //предложить купить другие товары
            if (res.size() > 0) {
                System.out.println("Раньше вы заказывали и другие товары:");
                for (int i = 0; i < res.size(); i++) {
                    System.out.println(res.get(i));
                }
            }

            unit(memory, order);
            System.out.println("Продолжить покупки:Y/N");
            Scanner sc = new Scanner(System.in);
            if (sc.next().equals("N")) {
                break;
            }

        }
    }
}
