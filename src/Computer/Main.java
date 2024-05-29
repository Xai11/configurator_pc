package Computer;

import Connection.Link;
import Read_File.ReadFileBlockPower;
import Read_File.ReadFileVideoCard;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       Link link = new Link();
       link.Conn();
       Computer computer = new Computer();
       computer.createComputer();
    }
}
