package Pattern.facade.pagemaker;

import org.junit.runners.model.TestTimedOutException;

import java.io.IOException;
import java.io.Writer;

/**
 * @Description 内部功能模块 提供html
 * @Author Heling
 * @Date 2019/8/15 11:20
 **/
public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }
    public void setTitle(String title) throws IOException{
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }
    public void paragragh(String msg) throws IOException{
        writer.write("<p>" + msg + "</p>\n");
    }
    public void link(String href,String caption) throws IOException{
        paragragh("<a href=\"" + href + "\">" + caption + "</a>");
    }
    public void mailto(String mailaddr,String username) throws IOException{
        link("mailto:" + mailaddr, username);
    }
    public void close() throws IOException{
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }

}
