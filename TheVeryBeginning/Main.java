package TheVeryBeginning;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Non-Resizable Window without Maximize Button");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 禁用调整大小和隐藏最大化按钮
        frame.setResizable(false);

        frame.setVisible(true);
    }
}