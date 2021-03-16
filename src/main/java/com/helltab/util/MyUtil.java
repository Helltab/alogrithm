package com.helltab.util;


import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class MyUtil {
    public static void test(Consumer<Long> consumer) {
        long start = System.nanoTime();
        consumer.accept(start);
        long end = System.nanoTime() - start;
        System.out.println(end + "ns : " + end / 1000000 + "ms : " + end / 1000000000 + "s");
    }

    public static Consumer<Object> visit = data -> {
        System.out.print(ColorUtil.colorFontB(data + "\t", ColorCons.F_BLUE_H));
    };

    public static void test(Predicate<Long> predicate, String testTitle) {
        long start = System.nanoTime();
        System.out.println(ColorUtil.colorFont("\n开始测试: " + testTitle, ColorCons.F_G));
        System.out.println(ColorUtil.colorFont("------------------------------------", ColorCons.F_B_H));
        boolean result = predicate.test(start);
        System.out.println(ColorUtil.colorFont("\n------------------------------------", ColorCons.F_B_H));
        System.out.print(ColorUtil.colorFont("结束测试, 结果: ", ColorCons.F_G));
        System.out.print(ColorUtil.colorFont(result + "", ColorCons.F_Y));
        System.out.print(ColorUtil.colorFont(" 耗时: ", ColorCons.F_G));
        System.out.println(ColorUtil.colorFont((System.nanoTime() - start) + "ns", ColorCons.F_R));
    }
}