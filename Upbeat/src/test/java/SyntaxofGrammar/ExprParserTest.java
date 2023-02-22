package SyntaxofGrammar;

import SyntaxofGrammar.Parser.ExprParser;
import SyntaxofGrammar.Tokenizer.ExprTokenizer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ExprParserTest {
    @Test
    void TestParser(){

        try {
            File myObj = new File("/Users/admin/Documents/OOP/Upbeat/src/test/java/SyntaxofGrammar/Text.txt");
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