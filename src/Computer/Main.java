package Computer;

import Factory.Creator;
import Singleton.Characteristics;
import Singleton.NameComponents;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Creator creator = new Creator();
        Characteristics ch = Characteristics.getInstance();
        NameComponents nc = NameComponents.getInstance();
        while(true) {

            creator.setRequest();
            creator.createComputer();
            ch.reset();
            nc.reset();

        }

    }
}

