package Pattern.bridge;

public class CharDisplayImpl extends DisplayImpl {
    char start = '<';
    char end = '>';
    String content;

    public CharDisplayImpl(char start, char end, String content) {
        this.start = start;
        this.end = end;
        this.content = content;
    }

    public CharDisplayImpl(String content) {
        this.content = content;
    }

    public void rawOpen() {
        System.out.print(start);
    }

    public void rawPrint() {
        System.out.print(content);
    }

    public void rawClose() {
        System.out.println(end);
    }
}
