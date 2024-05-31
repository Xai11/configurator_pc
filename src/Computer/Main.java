package Computer;

import Factory.Creator;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Creator creator = new Creator();
        creator.setRequest();
        creator.createComputer();


    }
}

