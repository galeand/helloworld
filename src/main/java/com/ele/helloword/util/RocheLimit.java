package com.ele.helloword.util;

import java.text.DecimalFormat;

/**
 * @name: RocheLimit
 * @author: xiangyf
 * @create: 2019-09-07 22:16
 * @description: 计算刚体洛希极限和流体洛希极限
 */
public class RocheLimit {

    /**
     * 计算刚体洛希极限
     * @param densityML: 中心天体的密度, g/cm^3
     * @param densityMS: 小天体的密度, g/cm^3
     * @param radiusML: 中心天体的半径, cm
     * @return
     */
    public static double rockyLimitOfRigidBody(double densityML, double densityMS, double radiusML){
        if (densityML <=0 || densityMS <=0){
            return Double.NaN;
        }
        double median1 = densityML / densityMS;
        double median2 = RocheLimit.sqrtN(median1, 3.0);
        double res = median2 * 1.26 * radiusML;
        return res;
    }

    /**
     * 计算流体洛希极限
     * @param densityML: 中心天体的密度, g/cm^3
     * @param densityMS: 小天体的密度, g/cm^3
     * @param radiusML: 中心天体的半径, cm
     * @return
     */
    public static double rockyLimitOfFluid(double densityML, double densityMS, double radiusML){
        if (densityML <=0 || densityMS <=0){
            return Double.NaN;
        }
        double median1 = densityML / densityMS;
        double median2 = RocheLimit.sqrtN(median1, 3.0);
        double res = median2 * 2.44 * radiusML;
        return res;
    }

    /**
     * 对d开n次方, n > 0
     *
     * @param d
     * @param i
     * @return
     */
    private static double sqrtN(double d, double i){
        if (d <= 0.0){
            return Double.NaN;
        }
        if (i <= 0.0){
            return Double.NaN;
        }
        i = 1 / i ;
        return Math.pow(d, i);
    }

    public static String formatValue(double rocheLimitEJ){
        if (rocheLimitEJ != 0.0){
            DecimalFormat df = new DecimalFormat("########.00");
            return df.format(rocheLimitEJ);
        }
        return "";
    }

    public static double cmToTenTKm(double val){
        double res = val / 1000000000.0;
        return res;
    }

}
