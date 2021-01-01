package com.kolta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lmk
 * @version 0.1
 * @date 2021/1/1 22:08
 */

public class Body {
    //定义了一个装body数据的二维列表
    private List<List<String>> bodyInfo = new ArrayList<>();
    public List<List<String>> getBodyInfo() {
        return bodyInfo;
    }
    //调用bodyFill把body部分的数据传进来，后面打印的时候要用到body这个对象
    public void bodyFill(List<List> args){
        for (int i = 0;i < args.size();i++){
            for(int j = 0;j < args.get(i).size();j++){
                String.valueOf(args.get(i).get(j));
            }
            this.bodyInfo.add(args.get(i));
        }
    }
    //其实就是获取一下body的行数
    public int getBodyLength(){
        return this.bodyInfo.size();

    }
}
