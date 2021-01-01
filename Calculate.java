package com.kolta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lmk
 * @version 0.1
 */
public class Calculate {
    //这个方法算是关键方法，计算每串数据一共占几个字符位
    public static int getStrLength(String str){
        //一个中文占两个字符位置
        //中文字符数量
        int count = 0;
        //整个正则表达式把中文的个数求出来
        String regExp = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        int sum = str.length() + count;
        //sum就是总的的数
        return sum;
    }
    //这个是最关键的方法，把每一列的最长的那一串数据比出来，根据它来确定这一列的宽度
    public static List<Integer> getMaxCellLength(Header header, Body body){
        //每一列最大的那个数存到列表里，列表真他妈好用，可能也因为我是初学者知道的少
        List<Integer> maxCellLength = new ArrayList<>();
        //求有多少列
        int headerLength = header.getHeaderLength();
        //把每个字符串的长度求出来再放到这个二维数组里，这个100.。就当最大100行吧，必须得初始化一下。。
        int[][] everyCellLength = new int[headerLength][100];

        for (int i = 0; i < body.getBodyLength() + 1; i++) {
            for (int j = 0;j < headerLength;j++){
                 if(i == 0){
                     //i==0的时候是在求表头
                     //这个everyCellLength[j][i] j,i就是把同一列的长度，现在给他放到同一行，方便一会儿sort取最大的
                     everyCellLength[j][i] = Calculate.getStrLength(header.getHeaderInfo().get(j));
                     continue;
                 }else {
                     //body部分
                     everyCellLength[j][i] = Calculate.getStrLength(body.getBodyInfo().get(i - 1).get(j));
                 }
            }
        }
        for(int i = 0;i < headerLength;i++){
            //取出那个最大值，放到开局声明的那个列表里
            Arrays.sort(everyCellLength[i]);
            maxCellLength.add(everyCellLength[i][everyCellLength[i].length - 1]);
        }
        return maxCellLength;
    };

}
    /*为了求字符宽度走过的弯路，因为现在好多都是等宽字体，所以这个方法不能用了
      public int[] getStringWidth(String str){
        JLabel label = new JLabel();
        FontMetrics metrics;
        int textH = 0;
        int textW = 0;
        label.setText(str);
        metrics = label.getFontMetrics(label.getFont());
        textH = metrics.getHeight();//字符串的高,   只和字体有关
        textW = metrics.stringWidth(label.getText());//字符串的宽
        int[] num = new int[2];
        num[0] = textH;
        num[1] = textW;
        return num;
    }*/
