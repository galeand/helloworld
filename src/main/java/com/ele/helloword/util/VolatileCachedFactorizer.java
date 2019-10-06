package com.ele.helloword.util;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @name: VolatileCachedFactorizer
 * @author: xiangyf
 * @create: 2019-09-22 16:43
 * @description:
 */
//@Service
public class VolatileCachedFactorizer {

    class OneValueCache{
        private final BigInteger lastNumber;
        private final Integer[] lastFactors;

        public OneValueCache(BigInteger i, Integer[] factors){
            lastNumber = i;
            lastFactors = Arrays.copyOf(factors, factors.length);
        }

        public Integer[] getFactors(BigInteger i){
            if (lastNumber == null || !lastNumber.equals(i)){
                return null;
            }else {
                return Arrays.copyOf(lastFactors, lastFactors.length);
            }
        }
    }

    private volatile OneValueCache cache = new OneValueCache(null, null);

    public Integer[] doFactorizer(BigInteger i){
        //从缓存中获取
        Integer[] res = cache.getFactors(i);

        Integer num = Integer.valueOf(i.toString());
        if (res == null){
            res = factor(num);
            cache = new OneValueCache(i, res);
        }
        return res;
    }

    /**
     * 分解质因数：质因数就是能够被该正整数整除的质数（除它本身和1外）
     * @param i
     * @return
     */
    private Integer[] factor(Integer i){
        if (i < 4){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for (Integer k = 2; k < Math.sqrt(Double.valueOf(i)); k++){
            if (i % k ==0){
                res.add(k);
                i = i / k;
                k--;
            }
        }
        return res.toArray(new Integer[res.size()]);
    }

}

