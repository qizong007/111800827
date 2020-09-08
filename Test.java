import org.apache.commons.lang3.StringUtils;

/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        String s = "我真的想把你抓着打";
        String s1 = "你真的抓我想把着打";
        double dis = StringUtils.getJaroWinklerDistance(s,s1);
        System.out.println(dis);

    }
}
