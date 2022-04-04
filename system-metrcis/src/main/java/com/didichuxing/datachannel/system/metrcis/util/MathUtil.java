package com.didichuxing.datachannel.system.metrcis.util;

import com.didichuxing.datachannel.system.metrcis.bean.PeriodStatistics;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

/**
 * 数值计算工具类
 */
public class MathUtil {

    /**
     * @param values 待计算样本值集
     * @return 返回待计算样本值集均值
     */
    public static Double getMean(List<Double> values) {
        int count = values.size();
        if(0 == count) {
            return 0d;
        } else {
            double sum = 0d;
            for (Double value : values) {
                sum += value;
            }
            Double mean = new BigDecimal(sum).divide(new BigDecimal(count), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return mean;
        }
    }

    /**
     * @param values 待计算样本值集
     * @return 返回待计算样本值集标准差
     */
    public static Double getStdDev(List<Double> values) {
        int count = values.size();
        if(0 == count) {
            return 0d;
        }
        double sum = 0;
        for(int i=0; i<count; i++){//求和
            sum += values.get(i);
        }
        double mean = sum / count;//求平均值
        double variance = 0;
        for(int i=0; i<count; i++){//求方差
            variance += (values.get(i) - mean) * (values.get(i) - mean);
        }
        return Math.sqrt(divideWith2Digit(variance, count));
    }

    /**
     * @param values 待计算样本值集
     * @return 返回待计算样本值集 55 分位数
     */
    public static Double getQuantile55(List<Double> values) {
        return percentile(values, 0.55);
    }

    /**
     * @param values 待计算样本值集
     * @return 返回待计算样本值集 75 分位数
     */
    public static Double getQuantile75(List<Double> values) {
        return percentile(values, 0.75);
    }

    /**
     * @param values 待计算样本值集
     * @return 返回待计算样本值集 95 分位数
     */
    public static Double getQuantile95(List<Double> values) {
        return percentile(values, 0.95);
    }

    /**
     * @param values 待计算样本值集
     * @return 返回待计算样本值集 99 分位数
     */
    public static Double getQuantile99(List<Double> values) {
        return percentile(values, 0.99);
    }

    /**
     *
     * @param numerator 分子
     * @param denominator 分母
     * @return 分子 / 分母结果 保留2位小数
     */
    public static Double divideWith2Digit(Double numerator, Double denominator) {
        if(denominator.equals(0d)) {
            return 0d;
        }
        return (double) (Math.round(numerator * 100 / denominator) / 100.0);
    }

    /**
     *
     * @param numerator 分子
     * @param denominator 分母
     * @return 分子 / 分母结果 保留2位小数
     */
    public static Double divideWith2Digit(Double numerator, Integer denominator) {
        if(denominator.equals(0)) {
            return 0d;
        }
        return (double) (Math.round(numerator * 100 / denominator) / 100.0);
    }

    /**
     *
     * @param numerator 分子
     * @param denominator 分母
     * @return 分子 / 分母结果 保留2位小数
     */
    public static Double divideWith2Digit(Long numerator, Long denominator) {
        if(denominator.equals(0l)) {
            return 0d;
        }
        return (double) (Math.round(numerator * 100 / denominator) / 100.0);
    }

    /**
     *
     * @param numerator 分子
     * @param denominator 分母
     * @return 分子 / 分母结果 保留2位小数
     */
    public static Double divideWith2Digit(Integer numerator, Integer denominator) {
        if(denominator.equals(0)) {
            return 0d;
        }
        return (double) (Math.round(numerator * 100 / denominator) / 100.0);
    }

    /**
     * 获取给定数集的p百分位数
     * @param values 待获取百分位数数集
     * @param p 百分位
     * @return 返回获取到的给定数集的p百分位数
     */
    private static Double percentile(List<Double> values,double p){
        int count = values.size();
        if(0 == count) {
            return 0d;
        } else if(1 == count) {
            return values.get(0);
        } else {
            Collections.sort(values);
            double px =  p * (count-1);
            int i = (int) java.lang.Math.floor(px);
            double g = px - i;
            if(g == 0) {
                return values.get(i);
            } else {
                return (1-g) * values.get(i) + g * values.get(i+1);
            }
        }
    }

    /**
     *
     * @param numerator 分子
     * @param denominator 分母
     * @return 分子 / 分母结果 保留2位小数
     */
    public static Double divideWith2Digit(Double numerator, Long denominator) {
        if(denominator.equals(0l)) {
            return 0d;
        }
        return (double) (Math.round(numerator * 100 / denominator) / 100.0);
    }

}
