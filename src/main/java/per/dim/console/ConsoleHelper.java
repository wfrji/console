package per.dim.console;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 控制台助手，包装了输入、输出、交互、清屏
 * @author ray 2024/7/28 7:38
 */
public class ConsoleHelper {
    private final Scanner scanner;
    private final PrintWriter writer;

    /**
     * 构造基本控制台。它会创建一个输入器和一个输出器。
     */
    public ConsoleHelper() {
        scanner = new Scanner(System.in);
        writer = new PrintWriter(System.out, true);
    }

    /**
     * 输出一行。文本中带回车符其实也可以多行。
     * @param line 一行文本
     */
    public void outLn(String line) {
        writer.println(line);
    }

    /**
     * 输出文本，不换行。但文本中可以带回车符来换行。
     * @param text 多行文本
     */
    public void out(String text) {
        writer.print(text);
        writer.flush();
    }

    /**
     * 输入（一行）
     * @return 一行字符串
     */
    public String in() {
        return scanner.nextLine();
    }

    /**
     * 多行输入
     * @param stipulation 约定的（输入结束字符串）
     * @return 多行文本
     */
    public String inMulti(String stipulation) {
        StringBuilder builder = new StringBuilder();
        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (stipulation.equals(line)) {
                break;
            }
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

    /**
     * 关闭输入输出
     */
    public void close() {
        scanner.close();
        writer.close();
    }

    /**
     * 控制台交互，输出消息，询问用户输入(Y/N)，确定程序走向
     * @param msg 控制台的提示消息
     * @return 【true】用户输入了 Y，【false】用户输入了 Y 以外的字符
     */
    public boolean interact(String msg) {
        //此处使用 PrintWriter::print 会卡死
        System.out.print(msg + "（Y/N）？");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    /**
     * 清屏
     */
    public static void clearScreen() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                //Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                //Unix
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println("清屏异常");
        }
    }
}
