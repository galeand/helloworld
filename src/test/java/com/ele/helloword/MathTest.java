package com.ele.helloword;

import com.ele.helloword.util.RocheLimit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;

/**
 * @name: MathTest
 * @author: xiangyf
 * @create: 2019-09-07 22:36
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MathTest {

    @Test
    public void test01(){
        // 计算地球和木星之间的刚体洛希极限
        double radiusJ = 7.15 * 10000 * 1000 * 100; //木星的半径，7.15万公里
        double rocheLimitEJ = RocheLimit.rockyLimitOfRigidBody(1.33, 5.51, radiusJ);
        System.out.println("地球和木星之间的刚体洛希极限:" + RocheLimit.formatValue(rocheLimitEJ) + "厘米");
        System.out.println("也就是:" + RocheLimit.formatValue(RocheLimit.cmToTenTKm(rocheLimitEJ)) + "万公里");

        double rocheLimitEJ2 = RocheLimit.rockyLimitOfFluid(1.33, 5.51, radiusJ);
        System.out.println("地球和木星之间的流体洛希极限:" + RocheLimit.formatValue(rocheLimitEJ2) + "厘米");
        System.out.println("也就是:" + RocheLimit.formatValue(RocheLimit.cmToTenTKm(rocheLimitEJ2)) + "万公里");

        System.out.println("=========================");
        double radiuSUN = 6.955 * 100000 * 1000 * 100;
        double denJ = 1.33;
        double denSun = 1.409;
        double rlJSun = RocheLimit.rockyLimitOfRigidBody(denSun, denJ, radiuSUN);
        System.out.println("木星和太阳之间的刚体洛希极限:" + RocheLimit.formatValue(RocheLimit.cmToTenTKm(rlJSun)) + "万公里");
        double rlSun2 = RocheLimit.rockyLimitOfFluid(denSun, denJ, radiuSUN);
        System.out.println("木星和太阳之间的流体洛希极限:" + RocheLimit.formatValue(RocheLimit.cmToTenTKm(rlSun2)) + "万公里");
    }


    /**
     * java浮点数运算中有两个特殊的情况：NAN、INFINITY。
     * INFINITY：无穷大； NAN: 非数字。
     * float是单精度类型,精度是8位有效数字，取值范围是10的-38次方到10的38次方，float占用4个字节的存储空间
     * double是双精度类型，精度是17位有效数字，取值范围是10的-308次方到10的308次方，double占用8个字节的存储空间
     */
    @Test
    public void test02(){
        System.out.println(Double.POSITIVE_INFINITY);

        System.out.println(Float.NaN == Float.NaN);

        System.out.println(Double.isNaN(Float.NaN));
    }
}
