package Basic;

import java.io.BufferedReader;
import java.io.IOException;

public class FileUtils {
    public static String getFullContent(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        String readedLine = null;
        try {
            while ((readedLine = reader.readLine()) != null) {
                sb.append(readedLine);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String content = sb.toString();
        return content.toString();
    }
}
