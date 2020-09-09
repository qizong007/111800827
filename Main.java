/**
 * 主函数入口
 * 暂时不做arg程序入口，后期加
 */
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AnswerProcessor.process(args[0],args[1],args[2]);
        //AnswerProcessor.process("tests/orig.txt","tests/orig_0.8_add.txt","ans.txt");
        //AnswerProcessor.process("tests/orig_0.8_add.txt","tests/orig.txt","ans.txt");
        //AnswerProcessor.process("org.txt","org_add.txt","ans.txt");
        long end = System.currentTimeMillis();
        System.out.println("用时："+(float)(end-start)/1000+"s");

    }

}