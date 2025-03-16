package EasyMethodLib;

@SuppressWarnings("ALL")
public class OperatorsTest {
    /**
     * 基础运算符测试
     */
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Arithmetic (算术运算符)");
        System.out.println("Add : 184 + 137 = " + (184 + 137));
        System.out.println("Subtract : 184 - 137 = " + (184 - 137));
        System.out.println("Multiply : 184 * 137 = " + (184 * 137));
        System.out.println("Divide : 184 / 137 = " + (184 / 137));
        System.out.println("Mod : 184 % 137 = " + (184 % 137));
        System.out.println();

        System.out.println("Assignment (赋值运算符)");
        int example = 0;
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("After: example = 10 -> " + (example = 10));
        System.out.println("Before: example = 10 -> " + example);
        System.out.println();

        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("After: example += 10 -> " + (example += 10));
        System.out.println("Before: example += 10 -> " + example);
        System.out.println();

        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("After: example -= 10 -> " + (example -= 10));
        System.out.println("Before: example -= 10 -> " + example);
        System.out.println();

        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("After: example *= 10 -> " + (example *= 10));
        System.out.println("Before: example *= 10 -> " + example);
        System.out.println();

        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("After: example /= 10 -> " + (example /= 10));
        System.out.println("Before: example /= 10 -> " + example);
        System.out.println();

        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("After: example %= 10 -> " + (example %= 10));
        System.out.println("Before: example %= 10 -> " + example);
        System.out.println();

        System.out.println("Relational (关系运算符)");
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("example > 10 -> " + (example > 10));
        System.out.println("example < 10 -> " + (example < 10));
        System.out.println("example >= 10 -> " + (example >= 10));
        System.out.println("example <= 10 -> " + (example <= 10));
        System.out.println("example != 10 -> " + (example != 10));
        System.out.println("example == 10 -> " + (example == 10));
        System.out.println();

        System.out.println("Logical (逻辑运算符)");
        System.out.println("true && true -> " + (true && true));
        System.out.println("true && false -> " + (true && false));
        System.out.println("false && true -> " + (false && true));
        System.out.println("false && false -> " + (false && false));
        System.out.println();
        System.out.println("true || true -> " + (true || true));
        System.out.println("true || false -> " + (true || false));
        System.out.println("false || true -> " + (false || true));
        System.out.println("false || false -> " + (false || false));
        System.out.println();
        System.out.println("!true -> " + (!true));
        System.out.println("!false -> " + (!false));

        System.out.println("Bitwise (位运算符)");
        System.out.println("true & true -> " + (true & true));
        System.out.println("true & false -> " + (true & false));
        System.out.println("false & true -> " + (false & true));
        System.out.println("false & false -> " + (false & false));
        System.out.println();

        System.out.println("true | true -> " + (true | true));
        System.out.println("true | false -> " + (true | false));
        System.out.println("false | true -> " + (false | true));
        System.out.println("false | false -> " + (false | false));
        System.out.println();

        System.out.println("true ^ true -> " + (true ^ true));
        System.out.println("true ^ false -> " + (true ^ false));
        System.out.println("false ^ true -> " + (false ^ true));
        System.out.println("false ^ false -> " + (false ^ false));
        System.out.println("127 ^ 45 -> " + (127 ^ 45) + " >>> 1111111 ^ 101101 -> 1010010");
        System.out.println();

        example = 1000;
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println();
        System.out.println("example << 1 -> " + (example << 1));
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println();
        System.out.println("example << 2 -> " + (example << 2));
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println();
        System.out.println("example >> 1 -> " + (example >> 1));
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println();
        System.out.println("example >> 2 -> " + (example >> 2));
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println();

        System.out.println("Conditional (条件运算符)");
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("true | false ? example++ : example-- -> " + (true | false ? example++ : example--));
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println();
        System.out.println(">>> ThisTime : example = " + example);
        System.out.println("true & false ? ++example : --example -> " + (true & false ? ++example : --example));
        System.out.println(">>> ThisTime : example = " + example);
    }
}