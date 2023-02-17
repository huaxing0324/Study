package com.example.demo.study.design;

/**
 * 简单工厂：解耦，分工明确/耦合性高（增加类型需要修改工厂方法）
 */
public class SimpleFactory {

    public static Operation createOperation(String type){
        //jdk 使用的简单工厂
        // DateFormat dateInstance = SimpleDateFormat.getDateInstance();
        Operation o = null;
        switch (type){
            case "+":
                o = new OperationAdd();
                break;
            case "-":
                o = new OperationSub();
                break;
        }
        return o;
    }

    public static void main(String[] args) {
        Operation operation = SimpleFactory.createOperation("+");
        int r = operation.operation(3, 2);
        System.out.println(r);
        Operation operation1 = SimpleFactory.createOperation("-");
        int r1 = operation1.operation(3, 2);
        System.out.println(r1);
    }

    interface Operation{
        int operation(int x,int y);
    }
    static class OperationAdd implements Operation{

        @Override
        public int operation(int x, int y) {
            return x + y;
        }
    }
    static class OperationSub implements Operation{

        @Override
        public int operation(int x, int y) {
            return x - y;
        }
    }

}
