package Pattern.facade;

import Pattern.facade.pagemaker.PageMaker;

/**
 * @Description 外观模式 使用者client
 * @Author Heling
 * @Date 2019/8/15 10:57
 **/
public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com","welcome.html");
    }
}
