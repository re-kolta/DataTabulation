package com.kolta;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lmk
 * @version 0.1
 */
public class DataTabulation {
    public static void execute(Header header,Body body){
        //这个是本行所有数据的字符总长，一会儿用来打印那些符号用
        int charsumlength = 0;
        //接收Calculate的getMaxCellLength方法的返回值
        List<Integer> maxCellLength = new ArrayList<>();

        TableStyle tableStyle = new TableStyle();

        String headerBottom = tableStyle.getHeaderBottom();

        String tableAbove = tableStyle.getTableAbove();

        String headerCorner = tableStyle.getHeaderCorner();

        String headerSide = tableStyle.getHeaderSide();

        String bodySide = tableStyle.getBodySide();

        String bodyCorner = tableStyle.getBodyCorner();

        String bodyBottom = tableStyle.getBodyBottom();

        String rowSeparator = tableStyle.getRowSeparator();

        String columnSeparator = tableStyle.getColumnSeparator();

        int headerLength = header.getHeaderLength();

        maxCellLength = Calculate.getMaxCellLength(header,body);

        for (int i = 0; i < maxCellLength.size(); i++) {
            charsumlength = charsumlength + maxCellLength.get(i);
        }

        //打印header
        //表格第一行
        System.out.print(headerCorner);
        for (int i = 0; i < headerLength*5+charsumlength-1; i++) {
            System.out.print(tableAbove);
        }
        System.out.println(headerCorner);
        //开始打印一些数据部分了
        System.out.print(headerSide);
        for (int i = 0; i < headerLength; i++) {
            if (i > 0){System.out.print(columnSeparator);}
            //这么长的一串其实就是为了求：有了最大长度，为了让他居中，数据左边得打多少个空格
            for(int j = 0;j < (maxCellLength.get(i) - Calculate.getStrLength(header.getHeaderInfo().get(i)))/2+2;j++){
                System.out.print(" ");
            }
            System.out.print(header.getHeaderInfo().get(i));
            //这个是右边空格
            for(int j = 0;j < maxCellLength.get(i)-((maxCellLength.get(i) - Calculate.getStrLength(header.getHeaderInfo().get(i)))/2)-Calculate.getStrLength(header.getHeaderInfo().get(i))+2;j++){
                System.out.print(" ");
            }
        }
        System.out.println(headerSide);
        //打印表头和body之间的地方
        System.out.print(headerCorner);
        for (int i = 0; i < headerLength*5+charsumlength-1; i++) {
            System.out.print(headerBottom);
        }
        System.out.println(headerCorner);

        //打印body
        //下面用了一堆i，j，k，m，n。。。。。写的很拉跨。。能力有限，，只会这么写了
        for (int i = 0; i < body.getBodyLength(); i++) {
            System.out.print(bodySide);
            //j不能小于body.getBodyInfo().get(i).get(j).length()，因为后面这个j会加到3，但是边界取不到3，用个get(0).get(0)就行了，或者headerlength
            for (int j = 0; j < headerLength; j++) {

                if (j > 0){System.out.print(columnSeparator);}
                //这个和上面一样，都是为了求数据两边的空格
                for(int k = 0;k < (maxCellLength.get(j) - Calculate.getStrLength(body.getBodyInfo().get(i).get(j)))/2+2;k++){
                    System.out.print(" ");
                }
                System.out.print(body.getBodyInfo().get(i).get(j));
                for(int l = 0;l < maxCellLength.get(j)-((maxCellLength.get(j) - Calculate.getStrLength(body.getBodyInfo().get(i).get(j)))/2)-Calculate.getStrLength(body.getBodyInfo().get(i).get(j))+2;l++){
                    System.out.print(" ");
                }
            }
            System.out.println(bodySide);
            System.out.print(bodyCorner);
            for (int m = 0; m < headerLength*5+charsumlength-1; m++) {
                System.out.print(rowSeparator);
            }
            System.out.println(bodyCorner);
            //最后一行，单独拉出来讨论，然后打印就行了
            if(i == body.getBodyLength()){
                System.out.print(bodyCorner);
                for (int m = 0; m < headerLength*5+charsumlength-1; m++) {
                    System.out.print(bodyBottom);
                }
                System.out.println(bodyCorner);
            }
        }
    }
    /*//下面就是测试数据，把注释删了可以自己运行一下，看看效果
    public static void main(String[] args) {
        List headerdata = new ArrayList();
        headerdata.add("userid");
        headerdata.add("name");
        headerdata.add("password");
        Header header = new Header();
        header.headerFill(headerdata);

        List bodydata1 = new ArrayList();
        bodydata1.add("143732779848849");
        bodydata1.add("lmk");
        bodydata1.add("passwordgdfgdfgfdg");

        List bodydata2 = new ArrayList();
        bodydata2.add("1651fs1df2sf");
        bodydata2.add("lmkfsdf");
        bodydata2.add("fdsffffffdsfdfdfdffdsffd");

        List<List> bodydata = new ArrayList<>();
        bodydata.add(bodydata1);
        bodydata.add(bodydata2);
        Body body = new Body();
        body.bodyFill(bodydata);

        DataTabulation.execute(header,body);
    }*/

    
}
