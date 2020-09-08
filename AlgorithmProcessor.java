/**
 * 算法处理器
 */
public class AlgorithmProcessor {

    /**
     * 最长公共子串处理算法
     * @param word_a org.txt文件
     * @param word_b org_add.txt文件
     * @return
     */
    public static int LCS(String word_a,String word_b){
        int[][] cell = new int[word_a.length()+1][word_b.length()+1];
        int lena = word_a.length();
        int lenb = word_b.length();
        for(int i=0;i<lena;i++){
            for(int j=0;j<lenb;j++){
                if(word_a.charAt(i) == word_b.charAt(j)){
                    cell[i+1][j+1] = cell[i][j] + 1;
                }else{
                    cell[i+1][j+1] = Math.max(cell[i][j+1],cell[i+1][j]);
                }
            }
        }
        return cell[lena][lenb];
    }

}
