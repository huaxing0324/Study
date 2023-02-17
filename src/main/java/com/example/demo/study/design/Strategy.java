package com.example.demo.study.design;

/**
 * 策略模式：它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户
 */
public class Strategy {
    public static void main(String[] args) {
        //策略模式与简单模式结合，客户端只需要认识CashContext的类
        //spring DispatcherServlet -> initStrategies -> handlermapping -> afterpropertiesset -> Controller/RequestMapping
        //在《阿里巴巴Java开发手册》中有提到当超过 3 层的 if-else 的逻辑判断代码可以使用策略模式来实现。
        //https://blog.csdn.net/qq_27276045/article/details/113533404
        CashContext cs = new CashContext("normal");
        int result = cs.getResult(3);
        System.out.println(result);
    }
    interface CashSuper{
        int getResult(int money);
    }
    static class CashNormal implements CashSuper{

        @Override
        public int getResult(int money) {
            return money -1;
        }
    }
    static class CashContext{
        private CashSuper cs;
        public CashContext(String type){
            switch (type){
                case "normal":
                    cs = new CashNormal();
                    break;
            }
        }
        public int getResult(int x){
            return cs.getResult(x);
        }
    }
}
