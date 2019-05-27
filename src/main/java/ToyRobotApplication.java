import utils.FileUtils;

import java.io.File;
import java.util.Scanner;

public class ToyRobotApplication {
    static String fileName = "input.txt";

    public static void main(String[] args) throws Exception {

        //Step1: Setup
        SquareTable squareTable = new SquareTable(0, 5);
        Game game = new Game(squareTable);

        //Step2: Get File
        File file = FileUtils.getFileFromResources(fileName);

        //Step3: Read File
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            //Step4: Process Command
            game.play(line);
        }
    }
}