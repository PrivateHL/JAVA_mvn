package Pattern.interpreter;

import java.util.StringTokenizer;

/**
 * @Description 迷你语言的上下文环境
 * @Author Heling
 * @Date 2019/8/21 17:32
 **/
public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken(){
        if( tokenizer.hasMoreTokens()){
            currentToken = tokenizer.nextToken();
        }else{
            currentToken = null;
        }
        return currentToken;
    }
    public String currentToken(){
        return currentToken;
    }
    public  void skipToken(String token) throws ParseException{
        if(!token.equals(currentToken)){
            throw new ParseException("warning:" + token + " is expected,but" + currentToken + " is found.");
        }
        nextToken();
    }
    public int currentNumber() throws ParseException{
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        }catch (NumberFormatException e){
            throw new ParseException("warning : " + e);
        }
        return number;
    }
}
