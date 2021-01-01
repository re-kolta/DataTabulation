package com.kolta;

/**
 * @author lmk
 * @version 0.1
 */
public class TableStyle {
    //下面这些参数用户都可以调用相对应的set方法修改
    //不想做左对齐，右对齐了。。。。。。只整了个居中，还很简陋
    private String tableAbove = "-"; //表格最上面一行
    private String headerCorner = "+";//表头拐角处
    private String headerSide = "|";//表头两边
    private String bodySide = "|";//body的两边
    private String bodyCorner = "+";//body的拐角
    private String bodyBottom = "-";//body的最底部，其实就是表格的最下面，名字忘了统一
    private String rowSeparator = "-";//行与行之间的分隔符
    private String columnSeparator = "|";//列之间的分隔符
    private String headerBottom = "=";//这个其实就是header和body中间的那个部分


    public String getTableAbove() {
        return tableAbove;
    }

    public void setTableAbove(String tableAbove) {
        this.tableAbove = tableAbove;
    }

    public String getHeaderCorner() {
        return headerCorner;
    }

    public void setHeaderCorner(String headerCorner) {
        this.headerCorner = headerCorner;
    }

    public String getHeaderSide() {
        return headerSide;
    }

    public void setHeaderSide(String headerSide) {
        this.headerSide = headerSide;
    }



    public String getHeaderBottom() {
        return headerBottom;
    }

    public void setHeaderBottom(String headerBottom) {
        this.headerBottom = headerBottom;
    }

    public String getBodySide() {
        return bodySide;
    }

    public void setBodySide(String bodySide) {
        this.bodySide = bodySide;
    }

    public String getBodyCorner() {
        return bodyCorner;
    }

    public void setBodyCorner(String bodyCorner) {
        this.bodyCorner = bodyCorner;
    }

    public String getBodyBottom() {
        return bodyBottom;
    }

    public void setBodyBottom(String bodyBottom) {
        this.bodyBottom = bodyBottom;
    }

    public String getRowSeparator() {
        return rowSeparator;
    }

    public void setRowSeparator(String rowSeparator) {
        this.rowSeparator = rowSeparator;
    }

    public String getColumnSeparator() {
        return columnSeparator;
    }

    public void setColumnSeparator(String columnSeparator) {
        this.columnSeparator = columnSeparator;
    }
}
