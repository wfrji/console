import per.dim.console.ConsoleHelper;

public class TestConsoleHelper {
    public static void main(String[] args) {
        ConsoleHelper helper = new ConsoleHelper();
        String input;
        while (true) {
            helper.outLn("测试 outLn 和 in 方法，请输入：");
            input = helper.in();
            helper.outLn("您输入的是：" + input);
            helper.outLn("测试 inMulti 和 out 方法，请用一行 EXIT 结束输入：");
            helper.out(helper.inMulti("EXIT"));
            helper.outLn("测试 interact 和 clearScreen 方法：");
            if (helper.interact("再测试一次 ")) {
                ConsoleHelper.clearScreen();
                continue;
            }
            break;
        }
        helper.close();
    }
}
