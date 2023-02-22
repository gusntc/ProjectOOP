package SyntaxofGrammar;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ExprTokenizerTest {
    @Test
    public void test(){
        try {
            File myObj = new File("src/test/java/Parser/Text.txt");
            Scanner myReader = new Scanner(myObj);
            StringBuilder s = new StringBuilder();
            while (myReader.hasNextLine()) {
                int pos = 0;
                String data = myReader.nextLine();
                s.append(data);
//                //System.out.println(data);
//                //String str = "t = t + 1";
//                String[] arrStr = data.split(" ");
//                ExprTokenizer token = new ExprTokenizer(data);
//                for(int i = 0; i < arrStr.length;i++){
//                    if(token.hasNextToken()){
//                        System.out.print(token.peek()+" ");
//                        token.consume();
//                    }
//                    //assertEquals(arrStr[i],token.consume());
                System.out.println();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}