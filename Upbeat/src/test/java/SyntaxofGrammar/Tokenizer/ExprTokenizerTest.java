package SyntaxofGrammar.Tokenizer;

import SyntaxofGrammar.Parser.ExprParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ExprTokenizerTest {
    @Test
    void test(){
        System.out.println(Math.pow(3,2));
    }

    @Test
    void TestParser(){
        try {
            File myObj = new File("C:\\Users\\Stealth15\\Desktop\\UPBEAT TEST\\MARVEN\\src\\test\\java\\SyntaxofGrammar\\Tokenizer\\Text.txt");
            Scanner myReader = new Scanner(myObj);
            StringBuilder s = new StringBuilder();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s.append(data + " ");
//                int pos = 0;
//                String data = myReader.nextLine();
//                String[] arrStr = data.split(" ");
//                ExprTokenizer token = new ExprTokenizer(data);
//                ExprParser p = new ExprParser(token);
//                p.parse();
            }
            String str = s.toString();
            ExprTokenizer token = new ExprTokenizer(str);
            ExprParser p = new ExprParser(token);
            p.parse();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}