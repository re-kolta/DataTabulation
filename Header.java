package com.kolta;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lmk
 * @version 0.1
 */
public class Header {
    //表头的话就是定义了一个简单的列表
    private List<String> headerInfo = new ArrayList();
    public  List<String> getHeaderInfo() {
        return headerInfo;
    }
    //同body的操作，传入表头数据
    public void headerFill(String[] args){
        for(String arg:args){
            this.headerInfo.add(arg);
        }
    }
    //重载了一个方法，传数组也行，传列表也行
    public void headerFill(List args){
        for(int i = 0;i < args.size();i++){
            String.valueOf(args.get(i));
        }
        this.headerInfo.addAll(args);
    }
    //这个其实就是根据size方法看看有几列
    public int getHeaderLength(){
        return headerInfo.size();
    }

}
