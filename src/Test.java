import java.security.InvalidParameterException;

/**
 * Created by matao on 7/20/16.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(recursionGcd(-1, 5));
    }

    /**
     * 计算两个非负整数p和q的最大公约数: 若q是0, 则最大公约数为p
     * 否则将p除以q得到余数r, p和q的最大公约数即q和r的最大公约数
     *
     * @param p     入参p
     * @param q     入参q
     * @return      最大公约数
     */
    public static int recursionGcd(int p, int q) {
        if (p < 0 || q < 0) {
            throw new InvalidParameterException("参数不能为负数");
        }

        if (q == 0) {
            return p;
        }
        int r = p % q;
        return recursionGcd(q, r);
    }
}
