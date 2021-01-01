# DataTabulation
这个工具可以给数据加个表格外框，让数据看起来美观点，然后控制台打印出来
首先感谢一下给我思路的一个人的链接，我的功能比他少一点
https://blog.csdn.net/CL_YD/article/details/85006808

然后就是用法：
实例化header，body两个对象，调用他们的fill方法（代码里看看具体叫啥吧），header接受数组或者列表，body的话你得传二维列表
然后  DataTabulation.execute(header,body) 就可以进行打印了，只支持居中显示

注意事项：想中英文混合打印出来的话，控制台的字体得中英文都支持等宽输出，不然就错位了。


