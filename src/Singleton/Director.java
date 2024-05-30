package Singleton;

import java.util.List;

public class Director implements Observer{


    @Override
    public void event(List<String> mass) {
        System.out.println("Элемент" + mass);
    }
}
