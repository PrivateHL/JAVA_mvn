package Pattern.composite;

/**
 * @Description 对文件调用add事件时抛出的异常，文件不能作为容器对象
 * @Author Heling
 * @Date 2019/8/9 18:41
 **/
public class FileThreatmentException  extends RuntimeException{
    public FileThreatmentException() {
    }

    public FileThreatmentException(String message) {
        super(message);
    }
}
