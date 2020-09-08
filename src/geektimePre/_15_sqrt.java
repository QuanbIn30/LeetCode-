package geektimePre;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 求一个数的平方根，并保留指定精度
 * @author MHLEVEL
 * @date 2020-09-08 10:14
 */
public class _15_sqrt {
    public static double sqrt(double n, int precision) {
        if (n < 0) return Double.NaN;

        double low = 0;
        double high = n;
        double ret = 0;

        // 保留 precision 位小数
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 0; i < precision; i++) sb.append("0");
        DecimalFormat df = new DecimalFormat(sb.toString());

        // 计算整数位和小数位，并考虑到四舍五入
        for (int i = 0; i < precision + 2; i++) {
            if (i > 0) {
                low = 1;
                high = 9;
            }
            while (low <= high) {
                double mid = (low + high) / 2;
                // Math.pow(i, 3); --> 这个语句的作用是求i的立方
                double tmp = BigDecimal.valueOf(ret).add(BigDecimal.valueOf(mid * Math.pow(10, -i))).doubleValue();
                if (Math.pow(tmp, 2) == n) {
                    return Double.parseDouble(df.format(tmp));
                } else if (Math.pow(tmp, 2) < n) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ret += high * Math.pow(10, -i);
        }

        return Double.parseDouble(df.format(ret));
    }

    public static void main(String[] args) {
        double num = 19;
        double res = sqrt(num, 4);
        System.out.println(res);
    }
}
