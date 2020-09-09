import java.io.File;

public class TestForAll {

    static void testAllFiles(){
        File f = new File("tests");
        String[] files = f.list();
        int cnt = 1;
        for(String file : files){
            if(!file.equals("orig.txt")){
                System.out.println("开始处理"+file);
                AnswerProcessor.process("tests/orig.txt","tests/"+file,"result/ans"+cnt+".txt");
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        testAllFiles();
    }
}
