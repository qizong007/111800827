import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 回答处理器
 */
public class AnswerProcessor {

    /**
     * 测试时使用的控制台输出
     * @param ans LCS算法计算结果
     * @param standardLength 原文文件字数
     */
    private static String  mockPrint(int ans,int standardLength){
        float num = (float)ans/standardLength*100;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String result = decimalFormat.format(num);
        System.out.println("查重率为："+result+"%");
        return result+"%";
    }

    /**
     * 输出文件
     * @param outputPath 输出文件路径
     * @param result 字符串形式传入结果
     */
    private static void output(String outputPath,String result){
        File f = new File(outputPath);
        try (FileWriter fr = new FileWriter(f)) {
            String data = result;
            char[] cs = data.toCharArray();
            fr.write(cs);
            System.out.println("结果已写入"+outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理总流程方法
     * @param orgFileName 原文文件路径
     * @param orgAddFileName 抄袭版论文的文件路径
     */
    public static void process(String orgFileName,String orgAddFileName,String outputPath){
        String org = TextProcessor.transferTextToString(orgFileName);
        String orgAdd = TextProcessor.transferTextToString(orgAddFileName);
        int standardLength = org.length();
        int ans = AlgorithmProcessor.LCS(org,orgAdd);
        output(outputPath,mockPrint(ans,standardLength));
    }

}
