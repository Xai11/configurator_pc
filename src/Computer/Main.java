package Computer;

import Factory.Creator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws FileNotFoundException {
        Creator creator = new Creator();
        creator.createComputer();
    }
}
