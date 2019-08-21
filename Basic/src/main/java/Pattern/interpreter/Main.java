package Pattern.interpreter;

import java.util.ArrayList;

/**
 * @Description 使用者 使用解释器解释迷你语言
 * @Author Heling
 * @Date 2019/8/21 17:31
 **/
public class Main {
    public static void main(String[] args) {
        ArrayList<String> altString = new ArrayList();
        altString.add("program end");
        altString.add("program go end");
        altString.add("program go right go right go right end");
        altString.add("program repeat 4 go right end end");
        altString.add("program repeat 4 repeat 3 go right go left end right end end");
        try {
            for (int i = 0; i < altString.size(); i++) {
                System.out.println("TEXT " + altString.get(i));
                Node node = new ProgramNode();
                node.parse(new Context(altString.get(i)));
                System.out.println("node = " + node);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
