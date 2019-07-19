package lambdasinaction.chap3;

import java.io.*;


/**
 * 环绕执行： 准备/初始化--->任务--> 清理/结束
 * 将前后逻辑抽取成模板.
 *
 * 1.行为参数化： (BufferedReader b) -> b.readLine()
 * 2.使用函数接口传递行为：接口参数，返回值对应 1. 然后将接口作为方法的一个参数
 * 3.执行行为，实现上个方法的内容（处理接口的参数。。）
 * 4.传递 Lambda
 */
public class ExecuteAround {

	public static void main(String ...args) throws IOException{

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile(b -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("lambdasinaction//chap3//data.txt"))) {
            // 在这个方法中就是 环绕执行(execute around)
            return br.readLine();
        }
    }


    /**
     * 行为参数化---> lambda
     * @param p
     * @return
     * @throws IOException
     */
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))){
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		String process(BufferedReader b) throws IOException;
	}
}
