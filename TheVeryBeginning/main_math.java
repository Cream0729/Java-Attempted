package TheVeryBeginning;

public class main_math {
    public static void main(String args[]){
        //方法调用
        int end_1 = main_add(10,20,30);
        int end_2 = main_add(20,20,40); 
        int end_3 = main_add(40,10);//方法重载，可同名<类型，个数，顺序不同均可>
        System.out.println("最终输出结果为：" + (end_1 + end_2));
        System.out.println("重载输出结果为：" + end_3);
        }
        public static int main_add(int a,int b,int c){
            //其中的int是返回值类型
            int all = a + b + c;
            return all;
            //结果返回调用处
        }
        public static int main_add(int a,int b){
            int all = a + b;
            return all;
        }
    }
