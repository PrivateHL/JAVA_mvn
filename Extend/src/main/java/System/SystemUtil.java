package System;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Basic.ValueWidget;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/***
 *
 * @author huangwei
 *
 */
public final class SystemUtil {
    public static final String OSNAME = System.getProperty("os.name");
    public static final String OSARCH = System.getProperty("os.arch");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String USER_DIR = System.getProperty("user.dir");
    /***
     * ����ϵͳ��ʱĿ¼:C:\Users\huangwei\AppData\Local\Temp\
     */
    public static final String SYSTEM_TEMP_FOLDER = System
            .getProperty("java.io.tmpdir");
    public static final String CURR_ENCODING = System
            .getProperty("file.encoding");
    public static final String LINE_SEPARATOR = System
            .getProperty("line.separator");
    public static final String CRLF = LINE_SEPARATOR; // Carriage Return/Line
    // Feed
    public static final String CRLF_LINUX = "\n";
    public static final String CRLF_WINDOW = "\r\n";
    public static final String CHARSET_UTF = "UTF-8";
    public static final String CHARSET_GBK = "GBK";
    public static final String CHARSET_GB2312 = "GB2312";
    public static final String CHARSET_GB18030 = "GB18030";
    public static final String CHARSET_UNICODE = "UNICODE";
    public static final String CHARSET_ISO88591 = "ISO-8859-1";
    public static final String[] CHARSET_ARRAY = new String[] { CHARSET_UTF,
            CHARSET_GBK, CHARSET_GB2312 };

    public static boolean isWindows = false;
    public static boolean isHP_UX = false;
    public static boolean isSolaris = false;
    public static boolean isOS32bit = true;
    public static final int BUFF_SIZE = 4096;
    public static final int BUFF_SIZE_1024 = 1024;
    public static final int SIZE_K=BUFF_SIZE_1024;
    /***
     * MB ���ֽڸ���
     */
    public static final int SIZE_M=BUFF_SIZE_1024*BUFF_SIZE_1024;
    public static final String KEY_ALGORITHM_RSA = "RSA";
    public final static String KEY_ALGORITHM_DES = "DES";
    public static final String KEY_ALGORITHM_SHA1withRSA = "SHA1withRSA";
    public static final String KEY_SHA = "SHA";
    public static final String KEY_SHA1 = "SHA-1";
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_HMAC_SHA256 = "HMACSHA256";
    public static final String KEY_HMAC_SHA1 = "HmacSHA1";
    public static final String CERTIFICATEFACTORY_X509 = "X.509";
    public static final char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    public static BigInteger BIGINT1 = BigInteger.valueOf(1l);
    public static final String CONTENTTYPE_HTML = "text/html";
    public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CONTENTTYPE_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public static final String CONTENTTYPE_OCTET_STREAM = "application/octet-stream";
    /***
     * Ӧ��(response)�е�Content-Type:��ҳ
     */
    public static final String RESPONSE_CONTENTTYPE_HTML="text/html";
    /**
     * Ӧ��(response)�е�Content-Type:��ͨ�ı�
     */
    public static final String RESPONSE_CONTENTTYPE_PLAIN="text/plain";
    /***
     * Ӧ��(response)�е�Content-Type:json,UTF-8����
     */
    public static final String RESPONSE_CONTENTTYPE_JSON_UTF="application/json;charset=UTF-8";
    /***
     * Ӧ��(response)�е�Content-Type:json,GBK����
     */
    public static final String RESPONSE_CONTENTTYPE_JSON_GBK="application/json;charset=GBK";
    /***
     * Ӧ��(response)�е�Content-Type:�������ļ�,����
     */
    public static final String RESPONSE_CONTENTTYPE_BINARY="application/octet-stream";
    public static final String RESPONSE_CONTENTTYPE_JAVASCRIPT="application/javascript";
    /***
     * �����Ա�����ĸ���
     */
    public static final String RESPONSE_CONTENTTYPE_JAVASCRIPT2="text/javascript";
    /***
     * JPGͼƬ
     */
    public static final String RESPONSE_CONTENTTYPE_JPEG="image/jpeg";
    /***
     * pngͼƬ
     */
    public static final String RESPONSE_CONTENTTYPE_PNG="image/png";
    public static final String RESPONSE_CONTENTTYPE_SWF="application/x-shockwave-flash";
    public static final String PROCOTOL_HTTP = "http";
    public static final String PROCOTOL_HTTPS = "https";
    public static final String COLON = ":";
    /**
     * �ַ����ո�
     */
    public static final String BLANK = " ";
    /***
     * Ӣ�ľ��
     */
    public static final String ENGLISH_PERIOD = ".";
    /***
     * "0"
     */
    public static final String ZERO_STRING = "0";
    public static final String DIVIDING_LINE = "---------------------------------------";
    /***
     * -1
     */
    public static final int NEGATIVE_ONE = -1;
    /***
     * ���ַ���:""
     */
    public static final String EMPTY = "";
    /***
     * ����
     */
    public static final String ENGLISH_COMMA = ",";
    public static final String SWING_DIALOG_RED = "<font color=\"red\"  style=\"font-weight:bold;\">%s</font>";
    public static final String SWING_DIALOG_BLUE = "<font color=\"blue\"  style=\"font-weight:bold;\">%s</font>";
    public static final String BR_HTML = "<br />";
    public static final String LABEL_BROWSE = "���";
    public static final String LABEL_PASTE = "ճ��";
    public static final String LABEL_CLEANUP = "���";
    /***
     * �»���
     */
    public static final String UNDERLINE = "_";
    /***
     * �л���
     */
    public static final String MIDDLE_LINE = "-";
    /***
     * 100
     */
    public static final int NUMBER_100 = 100;
    /***
     * the ascci of blank space
     */
    public static final byte BLANK_BYTE = (byte) 32;
    public static final String  KEY_HEADER_COOLIE="Set-Cookie";
    static {
        if (SystemUtil.OSNAME.toLowerCase().contains("window")) {
            isWindows = true;
        }
        if (SystemUtil.OSNAME.toLowerCase().contains("hp-ux")) {
            isHP_UX = true;
        }
        if (SystemUtil.OSNAME.toLowerCase().contains("Solaris")) {
            isSolaris = true;
        }
        if (SystemUtil.OSARCH.contains("64")) {
            isOS32bit = false;
        }
    }

    /***
     * the unit of file size
     */
    public static final String[] UNIT_SIZE = { "B", "KB", "MB", "GB", "TB",
            "KTB" };
    public static final String[] FILE_SIZE_ARR = UNIT_SIZE;
    public static final String CMD_SHORT="cmd /c ";
    private SystemUtil() {
        throw new Error("Don't let anyone instantiate this class.");
    }

    public static void copyFile(String resourceFileName, String targetFileName)
            throws IOException {
        File resourceFile = new File(resourceFileName);
        File targetFile = new File(targetFileName);
        if (!resourceFile.exists()) {
            System.out.println("[copyFile ]: resource file has not been found:"
                    + resourceFileName);
        }
        if (!resourceFile.isFile()) {
            System.out.println("[copyFile ]: directory can not be copyed:"
                    + resourceFileName);
        }

        if (targetFile.isDirectory()) {
            targetFile = new File(targetFile, resourceFile.getName());
        }

        FileInputStream resource = null;
        FileOutputStream target = null;
        try {
            resource = new FileInputStream(resourceFile);
            target = new FileOutputStream(targetFile);
            copyFile(resourceFile, targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resource != null) {
                resource.close();
            }
            if (target != null) {
                target.close();
            }
        }
    }

    /**
     *
     * @param srcFile
     *            :must be regular file,can not be folder;
     * @param targetFile
     *            :must be regular file,can not be folder;
     * @throws IOException
     */
    public static void copyFile(File srcFile, File targetFile)
            throws IOException {
        FileInputStream in = new FileInputStream(srcFile);

        FileOutputStream out = new FileOutputStream(targetFile);
        copyFile(in, out);

    }

    public static void copyFile(InputStream in, FileOutputStream target)
            throws IOException {
        // File targetFile = new File(targetFileName);
        // FileOutputStream target = null;
        // if (targetFile.isDirectory())
        // {
        // targetFile = new File(targetFile, simpleName);
        // }
        try {
            // target = new FileOutputStream(targetFile);
            byte[] buffer = new byte[BUFF_SIZE];
            int byteNum;

            while ((byteNum = in.read(buffer)) != NEGATIVE_ONE) {
                target.write(buffer, 0, byteNum);

            }
            System.out.println("[SystemUtil:copyFile]:file copy successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
                in = null;
            }
            if (target != null) {
                target.close();
                target = null;
            }
        }
    }

    /**
     *
     * @param fullpath
     *            :/a/b/c/d
     * @return /a/b/c/
     */
    public static String getParentDir(File fullpath) {
        // String parentDir = null;
        if (ValueWidget.isNullOrEmpty(fullpath)) {
            System.out.println("The first argument can not be null");
            return null;
        }

        // if (fullpath.contains("/")) {
        // int index=fullpath.lastIndexOf("/") ;
        // parentDir = fullpath.substring(0, index+ 1);
        // }
        return fullpath.getParent();
    }
    /***
     * ��ȡ��Ŀ¼
     * @param fullpath
     * @return
     */
    public static String getParentDir(String fullpath) {
        return getParentDir(new File(fullpath));
    }
    /***
     * ����Ŀ¼������,����������
     * @param file
     */
    public static File createParentFolder(File file){
        String parentStr=file.getParent();
        File parentFolder=new File(parentStr);
        if(!parentFolder.exists()){
            parentFolder.mkdirs();
        }
        return parentFolder;
    }
    /***
     * �������ļ�,���ļ��Ѵ���,�򷽷�����
     * @param file
     * @throws IOException
     */
    public static void createEmptyFile(File file) throws IOException{
        if(!file.exists()){//����ļ�������
            createParentFolder(file);
            file.createNewFile();
        }
    }
    /***
     * �������ļ�,���ļ��Ѵ���,�򷽷�����
     * @param file
     * @throws IOException
     */
    public static void createEmptyFile(String file) throws IOException{
        createEmptyFile(new File(file));
    }
    /***
     * ����Ŀ¼������,����������
     * @param file
     */
    public static void createParentFolder(String file){
        createParentFolder(new File(file));
    }

    /**
     *
     * @param fullpath
     *            :/a/b/c/d
     * @return d
     */
    public static String getFileSimpleName(String fullpath) {
        // String parentDir = null;
        if (null == fullpath) {
            System.out.println("The first argument can not be null");
            return null;
        }
        // if (fullpath.contains("/")) {
        // parentDir = fullpath.substring(fullpath.lastIndexOf("/") + 1);
        // }
        return new File(fullpath).getName();
    }

    // public static void main(String[] args) throws IOException
    // {
    // copyFile("/home/whuang2/study/linux/study/c/main.exe", "/home/whuang2");
    // }
    public static String convertUTF2ISO(String oldName) {
        if (oldName == null) {
            return oldName;
        }
        try {
            return new String(oldName.getBytes(CHARSET_UTF), CHARSET_ISO88591);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertGBK2ISO(String input) {
        if (input == null) {
            return input;
        }
        try {
            return new String(input.getBytes(CHARSET_GBK), CHARSET_ISO88591);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * convert GBK to UTF-8
     *
     * @param input
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] convertGBK2UTF(byte[] input)
            throws UnsupportedEncodingException {
        return new String(input, SystemUtil.CHARSET_GBK)
                .getBytes(SystemUtil.CHARSET_UTF);
    }

    /***
     * convert from GBK to UTF-8
     *
     * @param input
     * @return
     */
    public static String convertGBK2UTF(String input) {
        if (input == null) {
            return input;
        }
        try {
            return new String(input.getBytes(CHARSET_GBK), CHARSET_UTF);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] convertFromeGBK(byte[] input, String toCharset)
            throws UnsupportedEncodingException {
        return new String(input, SystemUtil.CHARSET_GBK).getBytes(toCharset);
    }

    /***
     * convert utf-8 to gbk
     *
     * @param input
     * @return
     */
    public static String convertUTF2GBK(String input) {
        if (input == null) {
            return input;
        }
        try {
            return new String(input.getBytes(CHARSET_UTF), CHARSET_GBK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertISO2Specified(String oldName, String newEncoding) {
        if (oldName == null) {
            return oldName;
        }
        try {
            return new String(oldName.getBytes(CHARSET_ISO88591), newEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertISO2GBK(String input) {
        return convertISO2Specified(input, CHARSET_GBK);
    }

    public static String convertISO2UTF(String oldName) {
        return convertISO2Specified(oldName, CHARSET_UTF);
    }

    public static void printFilesSimpleName(File[] files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public static void printFilesFilePath(File[] files) {
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static void printFilesFilePath(List<File> files) {
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    /***
     *
     * @param srcfile
     *            : source file
     * @param targfile
     *            : target file
     * @param inputCharset
     *            : from charset
     * @param outputCharset
     *            : to charset
     */
    public static void convertEncoding(File srcfile, File targfile,
                                       String inputCharset, String outputCharset) {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        char[] cbuf = new char[BUFF_SIZE];
        int size_char;
        try {
            fin = new FileInputStream(srcfile);
            fout = new FileOutputStream(targfile);
            InputStreamReader isr = null;
            OutputStreamWriter osw = null;
            try {
                isr = new InputStreamReader(fin, inputCharset);
                osw = new OutputStreamWriter(fout, outputCharset);
                while ((size_char = isr.read(cbuf)) != NEGATIVE_ONE) {
                    osw.write(cbuf, 0, size_char);
                }
                //
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    isr.close();
                    osw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static byte[] convertEncoding(byte[] oldContent, String oldCharset,
                                         String newCharset) {
        if (ValueWidget.isNullOrEmpty(oldContent)
                || ValueWidget.isNullOrEmpty(oldCharset)
                || ValueWidget.isNullOrEmpty(newCharset)) {
            return null;
        }
        try {
            return new String(oldContent,oldCharset).getBytes(newCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * delete the same one
     *
     * @param list
     * @return
     */
    public static List<String> guolv(List<String> list) {
        List<String> newlist = new ArrayList<String>();
        if (list != null && list.size() > 0) {
            newlist.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (!newlist.contains(list.get(i))) {
                    newlist.add(list.get(i));
                }
            }
        }
        return newlist;
    }

    /***
     * delete CRLF; delete empty line ;delete blank lines
     *
     * @param input
     * @return
     */
    private static String deleteCRLFOnce(String input) {
        if (ValueWidget.isHasValue(input)) {
            return input.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1")
                    .replaceAll("^((\r\n)|\n)", "");
        } else {
            return null;
        }
    }

    /***
     * Delete all spaces
     *
     * @param input
     * @return
     */
    public static String deleteAllCRLF(String input) {
        return input.replaceAll("((\r\n)|\n)[\\s\t ]*", "").replaceAll(
                "^((\r\n)|\n)", "");
    }

    /**
     * delete CRLF; delete empty line ;delete blank lines
     *
     * @param input
     * @return
     */
    public static String deleteCRLF(String input) {
        input = SystemUtil.deleteCRLFOnce(input);
        return SystemUtil.deleteCRLFOnce(input);
    }

    /***
     * Use uniqueness of collection
     *
     * @param list
     * @return
     */
    public static List<String> guolv2(List<String> list) {
        Set<String> set = new HashSet<String>(list);
        return new ArrayList<String>(set);
    }

    /**
     * delete the same one
     *
     * @param list
     * @return
     */
    public static List<Integer> guolvInteger(List<Integer> list) {
        List<Integer> newlist = new ArrayList<Integer>();
        if (list != null && list.size() > 0) {
            newlist.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (!newlist.contains(list.get(i))) {
                    newlist.add(list.get(i));
                }
            }
        }
        return newlist;
    }

    public static List<Integer> guolvInteger2(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>(list);
        return new ArrayList<Integer>(set);
    }

    /**
     * �ֽ�������1���򷵻�true
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        return String.valueOf(c).getBytes().length > 1;
    }

    /**
     * �ж�str �е������ַ��Ƿ�ȫ���������ַ����������ĵı����ţ�
     *
     * @param str
     * @return
     */
    public static boolean isAllChinese(String str) {
        char[] cs = null;
        if (str.length() == 1) {
            cs = new char[1];
            cs[0] = str.charAt(0);
        } else {
            cs = str.toCharArray();
        }
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHasChinses(String str) {
        String encodeName = "UTF-8";
        for (int i = 0; i < str.length(); i++) {
            try {
                String singleStr = str.substring(i, i + 1);
                int leng = getEncodeLength(singleStr, encodeName);
                // System.out.println(singleStr + "\t" + leng);
                if (leng == 9)// ��ʾ�������ַ�
                {
                    // System.out.println("������");
                    return true;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isHasChinses2(String str) {
        String encodeName = "UTF-8";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            try {
                char c = chars[i];
                int leng = getEncodeLength(c, encodeName);
                // System.out.println(singleStr + "\t" + leng);
                if (leng == 9)// ��ʾ�������ַ�
                {
                    // System.out.println("������");
                    return true;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int getEncodeLength(String str, String encodeName)
            throws Exception, UnsupportedEncodingException {// ����ֵΪ9 �Ļ�����˵�������ġ�
        if (str.length() != 1) {
            throw new Exception("����һ���ַ�");
        }
        String encod = URLEncoder.encode(str, "UTF-8");
        return encod.length();
    }

    public static int getEncodeLength(char c, String encodeName)
            throws Exception, UnsupportedEncodingException {// ����ֵΪ9
        // �Ļ�����˵�������ġ�
        String encod = URLEncoder.encode(String.valueOf(c), "UTF-8");
        return encod.length();
    }

    /**
     * ɾ��input�ַ����е�html��ʽ
     *
     * @param input
     * @param length
     *            ��ʾ���ַ��ĸ���
     * @return
     */
    public static String splitAndFilterString(String input, int length) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        // ȥ������htmlԪ��,
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
                "<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        int len = str.length();
        if (len <= length) {
            return str;
        } else {
            str = str.substring(0, length);
            str += "......";
        }
        return str;
    }

    /**
     * ���ش��ı�,ȥ��html�����б�ǩ,����ȥ������
     *
     * @param input
     * @return
     */
    public static String splitAndFilterString(String input) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        // ȥ������htmlԪ��,
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
                "<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        return SystemUtil.deleteCRLF(str);
    }

    public static boolean contains(List<Object> list, Object value) {
        if (list == null || list.size() == 0) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                String valueStr;
                if (value instanceof File) {
                    valueStr = ((File) value).getName();
                } else {
                    valueStr = value.toString();
                }
                Object obj = list.get(i);
                if (obj instanceof File) {
                    if (list.contains(valueStr)
                            || ((File) obj).getName().toString()
                            .equals(valueStr)) {
                        return true;
                    }
                } else {
                    if (list.contains(valueStr)
                            || list.get(i).toString().equals(valueStr)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * minus Set
     *
     * @param oldList
     * @param list
     * @return
     */
    public static List<Object> getMinusSet(List oldList, List list) {
        List selectedList = null;
        if (oldList != null) {
            selectedList = new ArrayList<Object>();
            int leng = oldList.size();
            if (leng != 0) {
                for (int i = 0; i < leng; i++) {
                    Object obj = oldList.get(i);
                    if (!contains(list, obj)) {
                        selectedList.add(obj);
                    }
                }
            }
        }
        return selectedList;
    }

    public static List<File> getMinusSetFile(List oldList, List list) {
        List selectedList = null;
        if (oldList != null) {
            selectedList = new ArrayList<File>();
            int leng = oldList.size();
            if (leng != 0) {
                for (int i = 0; i < leng; i++) {
                    Object obj = oldList.get(i);
                    if (!contains(list, obj)) {
                        selectedList.add(obj);
                    }
                }
            }
        }
        return selectedList;
    }

    public static List<String> getMinusSetStr(List oldList, List list) {
        List selectedList = null;
        if (oldList != null) {
            selectedList = new ArrayList<Object>();
            int leng = oldList.size();
            if (leng != 0) {
                for (int i = 0; i < leng; i++) {
                    Object obj = oldList.get(i);
                    if (!contains(list, obj)) {
                        selectedList.add(obj);
                    }
                }
            }
        }
        return selectedList;
    }

    /***
     * У��MD5 ֵ
     * @param file
     * @param comparedMD5
     * @return
     */
    public static boolean getFileMD5(File file,String comparedMD5) {
        String md5=getFileMD5(file);
        return (md5.equalsIgnoreCase(comparedMD5)&&comparedMD5!=null);
    }
    /**
     * Get MD5 of one file:hex string,test OK!
     *
     * @param file
     * @return : hex string
     */
    public static String getFileMD5(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != NEGATIVE_ONE) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    public static byte[] digest(byte srcBytes[], String algorithm)
            throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(srcBytes);
        byte digestBytes[] = digest.digest();
        return digestBytes;
    }
    public static String getMD5(String source) throws NoSuchAlgorithmException {
        return getMD5(source.getBytes());
    }
    public static String getMD5(byte[] source) throws NoSuchAlgorithmException {
        byte bytes[] = digest(source, "MD5");
        return SystemUtil.toHexString(bytes);
    }
    public static byte[] getMD5Bytes(byte[] source) throws NoSuchAlgorithmException {
        byte bytes[] = digest(source, "MD5");
        return bytes;
    }
    public static boolean getMD5(String source,String comparedMD5) throws NoSuchAlgorithmException {
        String md5=getMD5(source);
        return (md5.equalsIgnoreCase(comparedMD5)&&comparedMD5!=null);
    }
    /***
     * Get MD5 of one file��test ok!
     *
     * @param filepath
     * @return
     */
    public static String getFileMD5(String filepath) {
        File file = new File(filepath);
        return getFileMD5(file);
    }

    /***
     * У��MD5 ֵ
     * @param filepath
     * @param comparedMD5
     * @return
     */
    public static boolean getFileMD5(String filepath,String comparedMD5) {
        String md5=getFileMD5(filepath);
        return (md5.equalsIgnoreCase(comparedMD5)&&comparedMD5!=null);
    }
    /**
     * MD5 encrypt,test ok
     *
     * @param data
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance(SystemUtil.KEY_MD5);
        md5.update(data);
        return md5.digest();
    }

    public static byte[] encryptMD5(String data) throws Exception {
        return encryptMD5(data.getBytes(SystemUtil.CHARSET_ISO88591));
    }

    /***
     * compare two file by Md5
     *
     * @param file1
     * @param file2
     * @return
     */
    public static boolean isSameMd5(File file1, File file2) {
        String md5_1 = SystemUtil.getFileMD5(file1);
        String md5_2 = SystemUtil.getFileMD5(file2);
        return md5_1.equals(md5_2);
    }

    /***
     * compare two file by Md5
     *
     * @param filepath1
     * @param filepath2
     * @return
     */
    public static boolean isSameMd5(String filepath1, String filepath2) {
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);
        return isSameMd5(file1, file2);
    }

    /***
     * the times target occur in <code>int[] ints</code>
     *
     * @param ints
     * @param target
     * @return
     */
    public static int count(int[] ints, int target) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == target) {
                count++;
            }
        }
        return count;
    }

    /***
     * Ignore Case
     *
     * @param strs
     * @param target
     * @return
     */
    public static int count(String[] strs, String target) {
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equalsIgnoreCase(target)) {
                count++;
            }
        }
        return count;
    }

    /***
     * Ignore Case
     *
     * @param list
     * @param target
     * @return
     */
    public static int count(List<String> list, String target) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(target)) {
                count++;
            }
        }
        return count;
    }

    // public static void printSet(Set<Integer>set ){
    // for(Iterator<Integer> it=set.iterator();it.hasNext();){
    // Integer age=it.next();
    // System.out.println(age);
    // }
    // }

    /***
     *
     * @param list
     */
    public static void printList(List<?> list, boolean isNewline,
                                 String delimiter) {
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (isNewline) {
                System.out.println(obj);
            } else {
                System.out.print(obj + delimiter);
            }
        }
    }

    public static void printList(List<?> list, String delimiter) {
        printList(list, true, delimiter);
    }


    public static void printStrList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void printSet(Set<Object> set) {
        for (Iterator<Object> it = set.iterator(); it.hasNext();) {
            Object age = it.next();
            System.out.println(age);
        }
    }

    public static <T extends Serializable> T clone2(T obj) {
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(
                    baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (T) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clonedObj;
    }

    /***
     * convert byte array to public key algorithm : RSA
     *
     * @param keyBytes
     *            byte[]
     * @return RSAPublicKey
     * @throws Exception
     */
    public static PublicKey convert2PublicKey(byte[] keyBytes) throws Exception {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory
                .getInstance(SystemUtil.KEY_ALGORITHM_RSA);// RSA
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        return publicKey;
    }

    /***
     *
     * @param keyHexStr
     *            : hex(16) string
     * @return PublicKey
     * @throws Exception
     */
    public static PublicKey convert2PublicKey(String keyHexStr)
            throws Exception {
        byte[] keyBytes = hexStrToBytes(keyHexStr);
        return convert2PublicKey(keyBytes);
    }

    /**
     * convert public key to hex(16) bit string
     *
     * @param publicKey
     * @return hex(16) bit string
     */
    public static String convert4PublicKey(PublicKey publicKey) {
        return toHexString(publicKey.getEncoded());
    }

    public static PublicKey getPublicKey(InputStream in)
            throws CertificateException {
        CertificateFactory cf = CertificateFactory
                .getInstance(SystemUtil.CERTIFICATEFACTORY_X509);
        X509Certificate oCertServer = (X509Certificate) cf
                .generateCertificate(in);
        PublicKey pubKey = oCertServer.getPublicKey();
        return pubKey;
    }

    /***
     *
     * @param file
     * @return
     * @throws CertificateException
     * @throws FileNotFoundException
     */
    public static PublicKey getPublicKey(File file)
            throws CertificateException, FileNotFoundException {
        InputStream in = new FileInputStream(file);
        return getPublicKey(in);
    }

    /***
     *
     * @param modulus
     *            :N
     * @param publicExponent
     *            :E
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String modulus, String publicExponent)
            throws Exception {
        BigInteger m = new BigInteger(modulus);

        BigInteger e = new BigInteger(publicExponent);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        KeyFactory keyFactory = KeyFactory
                .getInstance(SystemUtil.KEY_ALGORITHM_RSA);

        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    // public static PublicKey getPublicKey(BigInteger m, BigInteger e){
    // RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
    // KeyFactory keyFactory = KeyFactory
    // .getInstance(SystemUtil.KEY_ALGORITHM_RSA);
    //
    // PublicKey publicKey = keyFactory.generatePublic(keySpec);
    // return publicKey;
    // }
    /***
     *
     * @param modulus
     * @param ePublicExponent
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(BigInteger modulus,
                                         BigInteger ePublicExponent) throws Exception {
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus,
                ePublicExponent);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        return publicKey;

    }

    /***
     *
     * @param m
     * @param publicExponent
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(BigInteger m, byte[] publicExponent)
            throws Exception {
        BigInteger e = new BigInteger(publicExponent);
        return getPublicKey(m, e);
    }

    /**
     * convert byte array to private key algorithm : RSA
     *
     * @param keyBytes
     *            byte[]
     * @return RSAPrivateKey
     * @throws Exception
     */
    public static PrivateKey convert2PrivateKey(byte[] keyBytes,
                                                String algorithm) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        return privateKey;
    }

    /***
     *
     * @param keyString
     *            : hex(16) string
     * @return
     * @throws Exception
     */
    public static PrivateKey convert2PrivateKey(String keyString,
                                                String algorithm) throws Exception {
        byte[] keyBytes = hexStrToBytes(keyString);
        return convert2PrivateKey(keyBytes, algorithm);
    }

    /***
     * convert private key to hex bit string
     *
     * @param privateKey
     * @return keyString : hex(16) string
     */
    public static String convert4PrivateKey(PrivateKey privateKey) {
        return toHexString(privateKey.getEncoded());
    }

    /**
     * decrypt,key can be a public key�� can also be a private key algorithm :
     * RSA
     *
     * @param message
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(SystemUtil.KEY_ALGORITHM_RSA);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(message);
    }

    /**
     * decrypt,key can be a public key�� can also be a private key
     *
     * @param message
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(String message, Key key) throws Exception {
        return SystemUtil.decrypt(SystemUtil.hexStrToBytes(message), key);
    }

    /**
     * ����<br>
     * ��˽Կ����
     *
     * @param data
     * @param publicKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String publicKeyStr,
                                            String algorithm,boolean isHext) throws Exception {
        // ����Կ����
        byte[] keyBytes = SystemUtil.hexStrToBytes(publicKeyStr);

        // ȡ�ù�Կ
        PublicKey publicKey = SystemUtil.convert2PublicKey(keyBytes);

        return SystemUtil.decrypt(data, publicKey);
    }

    /**
     * decrypt use private key to decrypt http://www.5a520.cn
     * http://www.feng123.com
     *
     * @param data
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String privateKeyStr,
                                             String algorithm) throws Exception {
        byte[] keyBytes = SystemUtil.hexStrToBytes(privateKeyStr);
        return decryptByPrivateKey(data, keyBytes, algorithm);
    }

    public static byte[] decryptByPrivateKey(byte[] data, byte[] keyBytes,
                                             String algorithm) throws Exception {
        PrivateKey privateKey = SystemUtil.convert2PrivateKey(keyBytes,
                algorithm);
        return SystemUtil.decrypt(data, privateKey);
    }

    /***
     *
     * @param data
     * @param N
     *            :modulus
     * @param D
     *            :private exponent
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] N, byte[] D)
            throws Exception {
        PrivateKey privateKey = getPrivateKey(N, D);
        return decrypt(data, privateKey);
    }

    /***
     *
     * @param dataHex
     *            :hex bit string
     * @param privateKeyStr
     * @return
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(String dataHex,
                                             String privateKeyStr, String algorithm)
            throws UnsupportedEncodingException, Exception {
        return decryptByPrivateKey(SystemUtil.hexStrToBytes(dataHex),
                privateKeyStr, algorithm);
    }

    /**
     * DES
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptDES(byte[] data, byte[] key) throws Exception {
        if(ValueWidget.isNullOrEmpty(data)){
            return data;
        }
        // Generate a random number generator which can be trusted
        SecureRandom sr = new SecureRandom();

        DESKeySpec dks = new DESKeySpec(key);

        // Create a key factory, and then use it to convert DESKeySpec to
        // SecretKey
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(SystemUtil.KEY_ALGORITHM_DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(SystemUtil.KEY_ALGORITHM_DES);

        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * DES
     *
     * @param data
     * @param key
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decryptDES(String data, String key)
            throws IOException, Exception {
        if (data == null)
            return null;
        byte[] buf = SystemUtil.decodeBase64(data);
        byte[] bt = SystemUtil.decryptDES(buf,
                key.getBytes(SystemUtil.CHARSET_UTF));
        if(bt==null){//data ��������
            return data;
        }
        return new String(bt, SystemUtil.CHARSET_UTF);
    }

    /**
     * encrypt,key can be a public key��can also be a private key algorithm : RSA
     *
     * @param message
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(SystemUtil.KEY_ALGORITHM_RSA);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(message);
    }

    /**
     * encrypt,key can be a public key��can also be a private key
     *
     * @param message
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String message, Key key) throws Exception {
        return SystemUtil.encrypt(
                message.getBytes(SystemUtil.CHARSET_ISO88591), key);
    }

    /**
     * encrypt use public key
     *
     * @param data
     * @param publicKeyStr
     *            : hex bit string
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKeyStr)
            throws Exception {
        byte[] keyBytes = hexStrToBytes(publicKeyStr);
        // get public key
        PublicKey publicKey = SystemUtil.convert2PublicKey(keyBytes);
        return SystemUtil.encrypt(data, publicKey);
    }

    /***
     *
     * @param data
     * @param publicKeyStr
     *            : hex bit string
     * @param charSet
     * @return
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(String data, String publicKeyStr,
                                            String charSet) throws UnsupportedEncodingException, Exception {
        return encryptByPublicKey(data.getBytes(charSet), publicKeyStr);
    }

    /**
     * encrypt use private key
     *
     * @param data
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKeyStr,
                                             String algorithm) throws Exception {
        byte[] keyBytes = hexStrToBytes(privateKeyStr);
        // get private key
        Key privateKey = SystemUtil.convert2PrivateKey(keyBytes, algorithm);
        return SystemUtil.encrypt(data, privateKey);
    }

    /***
     *
     * @param data
     * @param privateKeyStr
     *            : hex bit string
     * @param charSet
     * @return
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(String data, String privateKeyStr,
                                             String charSet, String algorithm)
            throws UnsupportedEncodingException, Exception {
        return encryptByPrivateKey(data.getBytes(charSet), privateKeyStr,
                algorithm);
    }

    /**
     * DES
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptDES(byte[] data, byte[] key) throws Exception {
        // Generate a random number generator which can be trusted
        SecureRandom sr = new SecureRandom();

        DESKeySpec dks = new DESKeySpec(key);
        // Create a key factory, and then use it to convert DESKeySpec to
        // SecretKey
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(SystemUtil.KEY_ALGORITHM_DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance(SystemUtil.KEY_ALGORITHM_DES);
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * DES
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptDES(String data, String key) throws Exception {
        byte[] bt = SystemUtil.encryptDES(
                data.getBytes(SystemUtil.CHARSET_UTF),
                key.getBytes(SystemUtil.CHARSET_UTF));
        String strs = SystemUtil.encodeBase64(bt);
        return strs;
    }

    /***
     * convert hex(16) bit string to byte array
     *
     * @param sHex
     *            : hex(16) bit string
     * @return byte[]
     */
    public static final byte[] hexStrToBytes(String sHex) {
        int length = sHex.length();
        if (length % 2 != 0) {
            String message = "Hex  bit string length must be even";
            System.err.println(message);
            throw new RuntimeException(message);
        }
        byte[] bytes;
        bytes = new byte[sHex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(
                    sHex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    /***
     * convert byte array to hex(16) bit string
     *
     * @param
     * @return hex(16) bit string
     */
    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
            sb.append(HEXCHAR[b[i] & 0x0f]);
        }
        return sb.toString();
    }
    /***
     * convert byte array to hex(16) bit string
     * @param bytes
     * @return
     */
    public static String bytes2HexString(byte[]bytes){
        return toHexString(bytes);
    }

    /**
     *
     * @param
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String toString(byte[] b) throws UnsupportedEncodingException {
        return new String(b, CHARSET_ISO88591);
    }

    /**
     * SHA encrypt
     *
     * @param data
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {

        MessageDigest sha = MessageDigest.getInstance(SystemUtil.KEY_SHA);
        sha.update(data);
        return sha.digest();

    }

    /***
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(String data) throws Exception {
        return encryptSHA(data.getBytes(SystemUtil.CHARSET_ISO88591));
    }

    /***
     * sha-1
     *
     * @param data
     *            byte[]
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA1(byte[] data) throws Exception {

        MessageDigest sha = MessageDigest.getInstance(SystemUtil.KEY_SHA1);
        sha.update(data);
        return sha.digest();

    }

    /***
     * sha-1
     *
     * @param data
     *            :String
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA1(String data) throws Exception {
        return encryptSHA1(data.getBytes(SystemUtil.CHARSET_ISO88591));
    }

    /***
     *
     * @param secretKey
     * @param input
     * @param algorithm
     * @return byte[]
     * @throws Exception
     */
    public static byte[] getHMAC(byte[] secretKey, byte[] input,
                                 String algorithm) throws Exception {
        Mac mac = Mac.getInstance(algorithm);
        // get the bytes of the hmac key and data string
        SecretKey secret = new SecretKeySpec(secretKey, algorithm);
        mac.init(secret);
        // ��input ����HMAC ����
        byte[] bytesF1 = mac.doFinal(input);
        return bytesF1;
    }

    /***
     * HMACSHA256
     *
     * @param secretKey
     * @param input
     * @return
     * @throws Exception
     */
    public static byte[] getHMAC_SHA256(byte[] secretKey, byte[] input)
            throws Exception {
        return getHMAC(secretKey, input, SystemUtil.KEY_HMAC_SHA256);
    }

    /***
     * HmacSHA1
     *
     * @param secretKey
     * @param input
     * @return
     * @throws Exception
     */
    public static byte[] getHMAC_SHA1(byte[] secretKey, byte[] input)
            throws Exception {
        return getHMAC(secretKey, input, SystemUtil.KEY_HMAC_SHA1);
    }

    /***
     *
     * @param secretKey
     *            : hex bit string
     * @param input
     *            : hex bit string
     * @return byte array
     * @throws Exception
     */
    public static byte[] getHMAC_SHA1(String secretKey, String input)
            throws Exception {
        return getHMAC_SHA1(SystemUtil.hexStrToBytes(secretKey),
                SystemUtil.hexStrToBytes(input));
    }

    /***
     *
     * @param keyInfo
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static KeyPair getKeyPair(String keyInfo, String algorithm)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return getKeyPair(keyInfo.getBytes(SystemUtil.CHARSET_ISO88591),
                algorithm);
    }

    /***
     *
     * @param keyInfo
     * @param algorithm
     *            :�㷨����RSA
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static KeyPair getKeyPair(byte[] keyInfo, String algorithm)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance(algorithm);
        SecureRandom random = new SecureRandom();
        random.setSeed(keyInfo);
        // ��ʼ���ܣ�����Ϊ512�������Ǵ���512�ſ��Ե�
        keygen.initialize(512, random);
        // ȡ����Կ��
        KeyPair kp = keygen.generateKeyPair();
        return kp;
    }

    /***
     * RSA .
     *
     * @param keyInfo
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static KeyPair getRSAKeyPair(byte[] keyInfo)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return getKeyPair(keyInfo, SystemUtil.KEY_ALGORITHM_RSA);
    }

    /***
     *
     * @param modulus
     *            :N
     * @param privateExponent
     *            :D
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String modulus,
                                           String privateExponent) throws Exception {

        BigInteger m = new BigInteger(modulus);

        BigInteger D = new BigInteger(privateExponent);

        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, D);

        KeyFactory keyFactory = KeyFactory
                .getInstance(SystemUtil.KEY_ALGORITHM_RSA);

        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        return privateKey;

    }

    /***
     *
     * @param m
     *            : modulus
     * @param d
     *            :private exponent
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(BigInteger m, BigInteger d)
            throws Exception {
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, d);

        KeyFactory keyFactory = KeyFactory
                .getInstance(SystemUtil.KEY_ALGORITHM_RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        return privateKey;

    }

    // public static PrivateKey getPrivateKey(byte[] N_hex, byte[] D_hex){
    // return SystemUtil.getPrivateKey(new BigInteger(N_hex), new
    // BigInteger(D_hex));
    // }
    /***
     *
     * @param m
     * @param privateExponent
     *            :D
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(BigInteger m, byte[] privateExponent)// TODO
            throws Exception {
        BigInteger d = new BigInteger(privateExponent);
        return getPrivateKey(m, d.negate());
    }

    public static PrivateKey getPrivateKey(byte[] m, byte[] privateExponent)
            throws Exception {
        return getPrivateKey(SystemUtil.getBigIntegerByByteArr(m),
                SystemUtil.getBigIntegerByByteArr(privateExponent));
    }

    /***
     * OK
     *
     * @param publicKey
     * @param priKey
     * @return
     * @throws Exception
     */
    public static boolean verifyPrivPubKey(PublicKey publicKey,
                                           PrivateKey priKey) throws Exception {
        String message = "32";
        RSAPublicKey rsaPublKey = (RSAPublicKey) publicKey;
        RSAPrivateKey rsaPriKey = (RSAPrivateKey) priKey;
        byte[] encryptBytes = SystemUtil.encrypt(message, publicKey);
        byte[] decryptBytes = SystemUtil.decrypt(encryptBytes, priKey);
        return new String(decryptBytes, SystemUtil.CHARSET_ISO88591)
                .equals(message)
                && rsaPriKey.getModulus().equals(rsaPublKey.getModulus());
    }

    /***
     * convert byte array to BigInteger
     *
     * @param bytes
     * @return
     */
    public static BigInteger getBigIntegerByByteArr(byte[] bytes) {
        return new BigInteger(SystemUtil.toHexString(bytes), 16);
    }

    /***
     * convert BigInteger to byte array
     *
     * @param bi
     * @return
     */
    public static byte[] getBytesByBigInteger(BigInteger bi) {
        String hexString = bi.toString(16);
        return SystemUtil.hexStrToBytes(hexString);
    }

    /***
     * get prime number
     *
     * @param base
     * @return
     */
    // public static int generatePrime(int base) {
    // for (int i = base;; i++) {
    // if (isPrime(i)) {
    // return i;
    // }
    // }
    // }
    /***
     * get prime number which >=base,result>=base
     *
     * @param base
     * @return
     */
    public static BigInteger generatePrime(int base) {
        return generatePrime(BigInteger.valueOf(base));
    }

    /***
     * convert decemal string to BigInteger. radix:10
     *
     * @param dicemalBase
     * @return
     */
    public static BigInteger generatePrime(String dicemalBase) {
        return generatePrime(new BigInteger(dicemalBase, 10));
    }

    /***
     * get prime number which >=base
     *
     * @param base
     * @return BigInteger
     */
    public static BigInteger generatePrime(BigInteger base) {
        for (BigInteger i = base;; i = i.add(BIGINT1)) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    /***
     * whether is a prime number
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        return isPrime(BigInteger.valueOf(num));
        // boolean isPrime = true;
        // for (int i = 2; i <= num / 2; i++) {
        // if (num % i == 0) {
        // isPrime = false;
        // break;
        // }
        // }
        // return isPrime;
    }

    /***
     * whether is a prime number
     *
     * @param num
     * @return
     */
    public static boolean isPrime(BigInteger num) {
        boolean isPrime = true;
        BigInteger bigIntTwo = BigInteger.valueOf(2l);
        BigInteger bigIntOne = BIGINT1;
        for (BigInteger i = bigIntTwo; num.divide(bigIntTwo).compareTo(i) >= 0; i = i
                .add(bigIntOne)) {
            if (num.mod(i).intValue() == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /***
     *
     * @param ta
     * @param isAdd
     */
    public static void addSubduction(JTextArea ta, boolean isAdd) {
        String argument1 = ta.getText();
        BigInteger bigIntArg1 = new BigInteger(argument1);
        if (isAdd) {
            ta.setText(bigIntArg1.add(BIGINT1).toString());
        } else {
            ta.setText(bigIntArg1.subtract(BIGINT1).toString());
        }
    }

    /***
     *
     * @param tf
     * @param isAdd
     */
    public static void addSubduction(JTextField tf, boolean isAdd) {
        String argument1 = tf.getText();
        BigInteger bigIntArg1 = new BigInteger(argument1);
        if (isAdd) {
            tf.setText(bigIntArg1.add(BIGINT1).toString());
        } else {
            tf.setText(bigIntArg1.subtract(BIGINT1).toString());
        }
    }

    /***
     *
     * @param ta
     * @return
     */
    public static BigInteger getBigInteger(JTextArea ta) {
        String data = ta.getText();
        return new BigInteger(data);
    }

    /***
     *
     * @param arg1
     * @param arg2
     * @return
     */
    public static BigInteger mod(BigInteger arg1, BigInteger arg2) {
        return arg1.mod(arg2);
    }

    /***
     *
     * @param ta1
     * @param ta2
     * @return
     */
    public static BigInteger mod(JTextArea ta1, JTextArea ta2) {
        BigInteger arg1 = new BigInteger(ta1.getText());
        BigInteger arg2 = new BigInteger(ta2.getText());
        return mod(arg1, arg2);
    }

    /***
     *
     * @param ta1
     * @param ta2
     * @return
     */
    public static BigInteger mod(JTextField ta1, JTextField ta2) {
        BigInteger arg1 = new BigInteger(ta1.getText());
        BigInteger arg2 = new BigInteger(ta2.getText());
        return mod(arg1, arg2);
    }

    /***
     * convert int to hex string
     *
     * @param bigInt
     * @return
     */
    public static String toHexString(BigInteger bigInt) {
        return bigInt.toString(16);
    }

    /***
     *
     * @param ta
     * @return
     */
    public static String toHexString(JTextArea ta) {
        BigInteger arg1 = new BigInteger(ta.getText());
        return toHexString(arg1);

    }

    /***
     * encode by Base64
     */
    public static String encodeBase64(byte[] input) throws Exception {
        Class clazz = Class
                .forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod = clazz.getMethod("encode", byte[].class);
        mainMethod.setAccessible(true);
        Object retObj = mainMethod.invoke(null, new Object[] { input });
        return (String) retObj;
    }

    /***
     * decode by Base64
     */
    public static byte[] decodeBase64(String input) throws Exception {
        Class clazz = Class
                .forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod = clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj = mainMethod.invoke(null, input);
        return (byte[]) retObj;
    }

    /**
     * ����
     *
     * @param bstr
     * @return String
     */
    public static String encode(byte[] bstr) {
        return new sun.misc.BASE64Encoder().encode(bstr);
    }

    /**
     * ����
     *
     * @param str
     * @return string
     */
    public static byte[] decode(String str) {
        byte[] bt = null;
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bt;
    }

    /***
     * ��ȡʵ�ʵ������class
     *
     * @param clz
     * @return
     */
    public static <T> Class<T> getGenricClassType(
            @SuppressWarnings("rawtypes") Class clz) {
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] types = pt.getActualTypeArguments();
            if (types.length > 0 && types[0] instanceof Class) {
                // System.out.println("class:"+types[0]);
                return (Class) types[0];
            }
        }

        return (Class) Object.class;
    }

    // public static byte[] decodeBufferBASE64Decoder(String data) {
    //
    // try {
    // Class clazz = Class.forName("sun.misc.BASE64Decoder");
    // Method mainMethod;
    // mainMethod = clazz.getMethod("decodeBuffer", String.class);
    // mainMethod.setAccessible(true);
    // Object retObj = mainMethod.invoke(clazz.newInstance(), data);
    // return (byte[]) retObj;
    // } catch (SecurityException e) {
    // e.printStackTrace();
    // } catch (NoSuchMethodException e) {
    // e.printStackTrace();
    // } catch (IllegalArgumentException e) {
    // e.printStackTrace();
    // } catch (IllegalAccessException e) {
    // e.printStackTrace();
    // } catch (InvocationTargetException e) {
    // e.printStackTrace();
    // } catch (InstantiationException e) {
    // e.printStackTrace();
    // } catch (ClassNotFoundException e) {
    // e.printStackTrace();
    // }
    // return null;
    //
    // }
    //
    // public static String encodeBASE64Encoder(byte[] bt) {
    //
    // try {
    // Class clazz = Class.forName("sun.misc.BASE64Decoder");
    // Method mainMethod;
    // mainMethod = clazz.getMethod("encode", byte[].class);
    // mainMethod.setAccessible(true);
    // Object retObj = mainMethod.invoke(clazz.newInstance(), bt);
    // return (String) retObj;
    // } catch (SecurityException e) {
    // e.printStackTrace();
    // } catch (NoSuchMethodException e) {
    // e.printStackTrace();
    // } catch (IllegalArgumentException e) {
    // e.printStackTrace();
    // } catch (IllegalAccessException e) {
    // e.printStackTrace();
    // } catch (InvocationTargetException e) {
    // e.printStackTrace();
    // } catch (InstantiationException e) {
    // e.printStackTrace();
    // } catch (ClassNotFoundException e) {
    // e.printStackTrace();
    // }
    // return null;
    //
    // }
    /***
     * print byte array
     *
     * @param bytes
     * @param isNeedPlus
     *            : Whether to add a plus sign
     * @return such as
     *         "[ 52, 116, -18, 34, 70, -43,  56, -60, 17, -67, -52, -97 ] ;length:16"
     */
    public static String printBytes(byte[] bytes, boolean isNeedPlus) {
        StringBuffer sb = new StringBuffer("[ ");
        for (int i = 0; i < bytes.length; i++) {

            if (bytes[i] > 0 && isNeedPlus) {
                sb.append("+" + String.valueOf(bytes[i]));
            } else {
                sb.append(bytes[i]);
            }
            if (i < bytes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]").append(" ;length:" + bytes.length);
        return sb.toString();
    }

    /***
     * Format a byte array
     *
     * @param bytes
     * @return
     */
    public static String formatBytes(byte[] bytes) {
        return printBytes(bytes, false);
    }
    /***
     * convert Set to String[]
     * @param set
     * @since 2014-07-17
     * @return
     */
    public static String[]formatSet(Set set){
        if(ValueWidget.isNullOrEmpty(set)){
            return null;
        }
        String[]strs=new String[set.size()];
        int count=0;
        for (Iterator<?> it = set.iterator(); it.hasNext();) {
            String childType22 = (String) it.next();
            strs[count++]=childType22;
        }
        return strs;
    }
    /***
     * ������ת��ΪSet
     * @param strs
     * @return
     */
    public static Set convert2Set(String[]strs){
        if(ValueWidget.isNullOrEmpty(strs)){
            return null;
        }
        Set set=new HashSet();
        for(int i=0;i<strs.length;i++){
            set.add(strs[i]);
        }
        return set;
    }

    /***
     * Format a byte array
     *
     * @param hex
     * @return
     */
    public static String formatBytes(String hex) {
        return formatBytes(SystemUtil.hexStrToBytes(hex));
    }

    /***
     *
     * @param bytes
     */
    public static void printBytes(byte[] bytes) {
        System.out.println(formatBytes(bytes));
    }

    /***
     *
     * @param hex
     */
    public static void printBytes(String hex) {
        System.out.println(formatBytes(hex));
    }

    /***
     * �ϲ��ֽ�����
     *
     * @param a
     * @return
     */
    public static byte[] mergeArray(byte[]... a) {
        // �ϲ���֮��������ܳ���
        int index = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i].length;
        }
        byte[] result = new byte[sum];
        for (int i = 0; i < a.length; i++) {
            int lengthOne = a[i].length;
            if (lengthOne == 0) {
                continue;
            }
            // ��������
            System.arraycopy(a[i], 0, result, index, lengthOne);
            index = index + lengthOne;
        }
        return result;
    }

    /***
     * ���ϳ�Ϊ·��
     * @param parent
     * @param child
     * @return
     */
    public static String mergeTwoPath(String parent,String child){
        String fullPath;
        if (!child.startsWith("\\") && !parent.endsWith("\\")) {
            fullPath = parent + "\\" + child;
        } else {
            fullPath = parent + child;
        }
        return fullPath;
    }
    /***
     * merge two array
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] mergeArray2(String[]arr1,String[]arr2){
        int length1=arr1.length;
        int length2=arr2.length;
        int totalLength=length1+length2;
        String[]totalArr=new String[totalLength];
        for(int i=0;i<length1;i++){
            totalArr[i]=arr1[i];
        }
        for(int i=0;i<length2;i++){
            totalArr[i+length1]=arr2[i];
        }
        return totalArr;
    }
    /***
     * �ϲ��ַ�����
     *
     * @param a
     * @return
     */
    public static char[] mergeArray(char[]... a) {
        // �ϲ���֮��������ܳ���
        int index = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i].length;
        }
        char[] result = new char[sum];
        for (int i = 0; i < a.length; i++) {
            int lengthOne = a[i].length;
            if (lengthOne == 0) {
                continue;
            }
            // ��������
            System.arraycopy(a[i], 0, result, index, lengthOne);
            index = index + lengthOne;
        }
        return result;
    }

    /***
     * append a byte.
     *
     * @param a
     * @param b
     * @return
     */
    public static byte[] appandByte(byte[] a, byte b) {
        int length = a.length;
        byte[] resultBytes = new byte[length + 1];
        System.arraycopy(a, 0, resultBytes, 0, length);
        resultBytes[length] = b;
        return resultBytes;
    }

    /***
     * merge two int array to a string
     *
     * @param a
     * @param b
     * @return
     */
    public static String merge(int[] a, int[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            sb.append(",");
        }
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
            sb.append(",");
        }
        int leng_str = sb.toString().length();
        return sb.substring(0, leng_str - 1);
    }

    /***
     * Get top <code>frontNum</code> bytes
     *
     * @param source
     * @param frontNum
     * @return
     */
    public static byte[] getFrontBytes(byte[] source, int frontNum) {
        byte[] frontBytes = new byte[frontNum];
        System.arraycopy(source, 0, frontBytes, 0, frontNum);
        return frontBytes;
    }

    public static byte[] getAfterBytes(byte[] source, int afterNum) {
        int length = source.length;
        byte[] afterBytes = new byte[afterNum];
        System.arraycopy(source, length - afterNum, afterBytes, 0, afterNum);
        return afterBytes;
    }

    /***
     *
     * @param frontNum
     * @param source
     * @return
     */
    public static byte[] filterFrontBytes(int frontNum, byte[] source) {
        return copyByte(frontNum, source.length - frontNum, source);
    }

    public static byte[] copyByte(int start, int length, byte[] source) {
        byte[] des = new byte[length];
        System.arraycopy(source, start, des, 0, length);
        return des;
    }

    /***
     * Compare two byte arrays whether are the same.
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean arrayIsEqual(byte[] a, byte[] b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null) {
            if (a.length != b.length) {
                return false;
            } else {
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[i]) {
                        return false;
                    }
                }
            }
        } else {// one is null, the other is not null
            return false;
        }
        return true;
    }

    /***
     * Compare two int arrays whether are the same.
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean arrayIsEqual(int[] a, int[] b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null) {
            if (a.length != b.length) {
                return false;
            } else {
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[i]) {
                        return false;
                    }
                }
            }
        } else {// one is null, the other is not null
            return false;
        }
        return true;
    }

    /***
     * Delete the slash which is in front of input
     * <br /><code>input.replaceAll("^/", "")</code>
     *
     * @param input
     * @return
     */
    public static String deleteFrontSlash(String input) {
        String result = input.replaceAll("^/", "");
        return result;
    }
    /***
     * Delete the slash which is in end of input
     * <br /><code>String result = input.replaceAll("/$", "");</code>
     * @param input
     * @return
     */
    public static String deleteAfterSlash(String input) {
        String result = input.replaceAll("/$", "");
        return result;
    }

    /***
     * Delete the brackets
     *
     * @param input
     * @return
     */
    public static String deletebrackets(String input) {
        input = input.replaceAll("\\[?(.*)\\]?", "$1");
        return input;
    }

    /***
     * delete ( and )
     * @param input
     * @return
     */
    public static String deleteSmallBrackets(String input) {
        input = input.replaceAll("\\(?(.*)\\)", "$1");
        return input;
    }
    /***
     * Delete the curly braces ({ })
     *
     * @param input
     * @return
     */
    public static String deleteCurlyBraces(String input) {
        input = input.replaceAll("\\{?(.*)\\}", "$1");
        return input;
    }

    public static String deleteSingleQuotes(String input) {
        input = input.replaceAll("'?(.*)'", "$1");
        return input;
    }

    /***
     * ��б�ܺ�?�ָ��ȡ���һ�� / ? input
     * :http://localhost:8081/SSLServer/addUser.security?a=b
     * result:addUser.security
     */
    public static String getSerlvetNameByQuestionMark(String url) {
        String input = null;
        input = url.replaceAll(".*/([\\w\\.]*)(\\?.*)?$", "$1");
        return input;
    }

    /***
     * input :http://localhost:8081/SSLServer/addUser.security?a=b
     * result:addUser
     */
    public static String getSerlvetName(String url) {
        String input = null;
        input = url.replaceAll(".*/([\\w\\.]*)(\\..*)$", "$1");
        if (input.contains("?")) {
            input = getSerlvetNameByQuestionMark(input);
        }
        return input;
    }

    /***
     * get port
     *
     * @param url
     *            such as http://localhost:8081/SSLServer/addUser.A?a=b
     * @return 8081
     *
     */
    public static String getHttpPort(String url) {
        String input = url.replaceAll("^.+:([\\d]+)/.*$", "$1");
        return input;
    }

    /***
     *
     *
     * @param url
     *            such as localhost/SSLServer/addUser.A?a=b
     * @return SSLServer
     */
    public static String getProjectName(String url) {
        String input = url.replaceAll("^.+(:[\\d]+)?/(.*)/.*$", "$2");
        return input;
    }

    /***
     * get Http request ip
     *
     * @param url
     * @return
     */
    public static String getHttpIp(String url) {
        String input = url.replaceAll("^(.*://)?([^/:]*)(:[\\d]+)?/.*$", "$2");
        return input;
    }

    /***
     * be similar to grep in linux os
     *
     * @param keyWord
     * @param input
     *            :List
     * @return
     */
    public static List<String> grepStr(String keyWord, String input) {
        String regex = ".*" + keyWord + ".*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        List<String> grepResult = new ArrayList<String>();
        if (m.find()) {
            grepResult.add(m.group());
        }
        return grepResult;
    }

    /****
     * old:java.lang.String ; result: String
     *
     * @param input
     * @return
     */
    public static String getLastNameByPeriod(String input) {
        input = input.replaceAll("^.*\\.([\\w]+)", "$1");
        return input;
    }

    /***
     * ɾ���ַ������ߵ�˫����<br />
     * "abc"-->abc
     * @param input
     * @return
     */
    public static String delDoubleQuotation(String input){
        input = input.replaceAll("\"?([^\"]*)\"?", "$1");
        return input;
    }
    /***
     * ��ȡ�ļ��ĺ�׺�������������.
     *
     * @param fileSimpleName
     * @return
     */
    public static String getFileSuffixName(String fileSimpleName) {
        return getLastNameByPeriod(fileSimpleName);
    }

    /***
     *
     * @param input
     *            :2013-06-15
     * @return
     */
    public static boolean isDate(String input) {
        String regex = "[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    public static String grepSimple(String keyWord, String input) {
        List<String> grepResult = grepStr(keyWord, input);
        if (grepResult.size() > 0) {
            return grepResult.get(0);
        } else {
            return null;
        }
    }

    /***
     * times byte occure int byte[]
     *
     * @param hexStr
     * @param keyWord
     * @return
     */
    public static int indexOf(String hexStr, String keyWord) {
        return hexStr.indexOf(keyWord.toLowerCase()) / 2;
    }

    public static int indexOf(byte[] bytes, String keyWord) {
        return indexOf(SystemUtil.toHexString(bytes), keyWord.toLowerCase());
    }

    public static int indexOf(byte[] bytes, byte[] keyWord) {
        return indexOf(SystemUtil.toHexString(bytes), SystemUtil
                .toHexString(keyWord).toLowerCase());
    }

    /***
     * ��ȡkeyword ��srcText���ֵĴ���
     *
     * @param srcText
     * @param keyword
     * @return
     */
    public static int count(String srcText, String keyword) {
        return findStr1(srcText, keyword);
    }

    /**
     *
     * The number of occurrences of find keyword in srcText
     *
     * @param srcText
     * @param keyword
     * @return
     */
    public static int findStr1(String srcText, String keyword) {
        int count = 0;
        int leng = srcText.length();
        int j = 0;
        for (int i = 0; i < leng; i++) {
            if (srcText.charAt(i) == keyword.charAt(j)) {
                j++;
                if (j == keyword.length()) {
                    count++;
                    j = 0;
                }
            } else {
                i = i - j;// should rollback when not match
                j = 0;
            }
        }

        return count;
    }

    /***
     * NOTE:length of both is same. �ӵڼ����ַ���ʼ��ͬ��
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int compareText(String text1, String text2) {
        if (ValueWidget.isNullOrEmpty(text1)
                || ValueWidget.isNullOrEmpty(text2)) {
            return SystemUtil.NEGATIVE_ONE;
        }
        int count = 0;
        int length = text1.length();
        for (int i = 0; i < length; i++) {
            if (text1.charAt(i) == text2.charAt(i)) {
                count++;
            } else {
                return count;
            }
        }
        return SystemUtil.NEGATIVE_ONE;
    }

    /***
     * The number of occurrences of find keyword in srcText
     *
     * @param srcText
     * @param keyword
     * @return
     */
    public static int findStr2(String srcText, String keyword) {
        int count = 0;
        Pattern p = Pattern.compile(keyword);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static int findStr3(String srcText, String keyword) {
        return findStr(srcText, keyword, 0);
    }

    public static int findStr(String srcText, String keyWord, int pos) {
        return findStr(srcText, keyWord, pos, srcText.length());
    }
    /***
     * The number of occurrences of find keyword in srcText
     *
     * @param srcText
     * @param keyWord
     * @param pos  :  start position
     * @return
     */
    public static int findStr(String srcText, String keyWord, int pos,int endPos) {
        int i, j, k = 0;
        i = pos;
        j = 0;
        while (i < srcText.length() &&i<endPos && j < keyWord.length()) {
            if (srcText.charAt(i) == keyWord.charAt(j)) {
                ++i;
                ++j;
                if (j == keyWord.length()) {
                    k = k + 1;// k++
                    j = 0;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return k;
    }
    /***
     * �������һ��keyWord,���඼�滻Ϊreplacement<br>
     * "com.common.jn.img.path.png" -->com/common/jn/img/path.png
     * @param srcText
     * @param keyWord : Ҫ���滻���ַ���,����"."
     * @param replacement : �滻��Ϊ,����"/"
     * @return
     */
    public static String replaceStrExceptLast(String srcText, String keyWord, String replacement)
    {
        int lastIndex=srcText.lastIndexOf(keyWord);//���һ��"."��λ��,�������".",������"."���滻Ϊ"/"
        return replaceStr(srcText, keyWord, lastIndex, replacement);
    }
    /***
     * "com.common.jn.img.path.png" -->com/common/jn/img/path/png
     * @param srcText
     * @param keyWord : Ҫ���滻���ַ���,����"."
     * @param endPos : ����λ��
     * @param replacement : �滻��Ϊ,����"/"
     * @return
     */
    public static String replaceStr(String srcText, String keyWord, int endPos,String replacement)
    {
        return replaceStr(srcText, keyWord, 0, endPos, replacement);
    }
    /***
     * "com.common.jn.img.path.png" -->com/common/jn/img/path/png
     * @param srcText : ԭ�ı�
     * @param keyWord : Ҫ���滻���ַ���,����"."
     * @param pos : ��ʼλ��
     * @param endPos : ����λ��
     * @param replacement : �滻��Ϊ,����"/"
     * @return
     */
    public static String replaceStr(String srcText, String keyWord, int pos,int endPos,String replacement) {
        if(ValueWidget.isNullOrEmpty(srcText)||ValueWidget.isNullOrEmpty(keyWord)){
            return null;
        }
        if(keyWord.length()>srcText.length()){
            return srcText;
        }
        int i, j/*, k = 0*/;
        i = pos;
        j = 0;
        while (i < srcText.length() &&i<endPos && j < keyWord.length()) {
            if (srcText.charAt(i) == keyWord.charAt(j)) {
                ++i;
                ++j;
                if (j == keyWord.length()) {
                    String fragment=srcText.substring(0, i-j)+replacement+srcText.substring(i);
                    srcText=fragment;
                    fragment=null;
                    i=i-j+replacement.length();
//					k = k + 1;// k++
                    j = 0;

                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return srcText;
    }

    /***
     * ������keyWord��ʱ�������index,<br>���û�з���,��ʼ�շ���-1
     * @param srcText
     * @param keyWord
     * @param pos
     * @return
     */
    public static int findReadLength(String srcText, String keyWord, int pos) {
        int i, j/*, k = 0*/;
        i = pos;
        j = 0;
        while (i < srcText.length() && j < keyWord.length()) {
            if (srcText.charAt(i) == keyWord.charAt(j)) {
                ++i;
                ++j;
                if (j == keyWord.length()) {
//					k = k + 1;// k++
//					j = 0;
                    return i;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return SystemUtil.NEGATIVE_ONE;
    }

    /***
     *
     * @param srcText
     * @param keyWord
     * @param pos
     * @return
     */
    public static int findReadLength2(String srcText, String keyWord, int pos) {
        int i, j/*, k = 0*/;
        i = pos;
        j = 0;
        while (i < srcText.length() && j < keyWord.length()) {
            if(ValueWidget.isBlank(srcText.charAt(i))){
                i++;
                continue;
            }
            if (srcText.charAt(i) == keyWord.charAt(j)) {
                ++i;
                ++j;
                if (j == keyWord.length()) {
//					k = k + 1;// k++
//					j = 0;
                    return i;
                }
            } else {
                return SystemUtil.NEGATIVE_ONE;
//				i = i - j + 1;
//				j = 0;
            }
        }
        return SystemUtil.NEGATIVE_ONE;
    }


    /***
     *
     * @param source
     * @param findTarget
     *            :key word
     * @param pos
     *            :where start from
     * @return index
     */
    public static int findBytes(byte[] source, byte[] findTarget, int pos) {
        int i, j, k = 0;
        i = pos;
        j = 0;
        while (i < source.length && j < findTarget.length) {
            if (source[i] == findTarget[j]) {
                ++i;
                ++j;
                if (j == findTarget.length) {
                    k = k + 1;// k++
                    break;
                    // j = 0;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return k == 0 ? -1 : i - j;
    }

    /***
     * start from 0
     *
     * @param source
     * @param findTarget
     * @return
     */
    public static int findBytes(byte[] source, byte[] findTarget) {
        return findBytes(source, findTarget, 0);
    }

    // / <summary>
    // / �ж�����byte[]������ֵ�Ƿ����
    // / </summary>
    // / <param name="bytes1">byte[] 1</param>
    // / <param name="bytes2">byte[] 2</param>
    // / <returns>��ȷ���True,��֮False</returns>
    public static boolean isEqualBytes(byte[] a, byte[] b) {
        return arrayIsEqual(a, b);
    }

    /***
     * compare tow byte[]
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isEquals(byte[] a, byte[] b) {
        return arrayIsEqual(a, b);
    }

    /***
     * is equals to
     * <code>public static boolean isEquals(byte[] bytes1, byte[] bytes2)</code>
     *
     * @param bytes1
     * @param bytes2
     * @return
     */
    public static boolean isSame(byte[] bytes1, byte[] bytes2) {
        return isEqualBytes(bytes1, bytes2);
    }

    public static boolean isSame(int[] bytes1, int[] bytes2) {
        return arrayIsEqual(bytes1, bytes2);
    }

    public static boolean isEqualChars(char[] chars1, char[] chars2) {
        // �Ƚϳ����Ƿ�һ��
        if (chars1.length != chars2.length) {
            return false;
        }
        // �Ƚϳ�Ա�Ƿ��Ӧ���
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSame(char[] bytes1, char[] bytes2) {
        return isEqualChars(bytes1, bytes2);
    }

    /***
     * //
     * D:\xxx\eclipse\workspace\.metadata\.plugins\org.eclipse.wst.server.core
     * \tmp0\wtpwebapps\shop_goods\images //
     * D:\xxx\eclipse\workspace\shop_goods\ upload
     *
     * @param realPath2
     * @param projectName
     * @return
     */
    public static String getRealPath(String realPath2, String projectName) {
        String realpath = realPath2.replaceAll(".metadata.*(" + projectName
                + ")", "$1");
        return realpath;
    }

    /***
     * convert List to String[]
     *
     * @param list
     * @return
     */
    public static String[] list2Array(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    /***
     * print per
     *
     * @param strs
     */
    public static void printArray(Object[] strs, boolean isNewLine,
                                  String delimiter) {
        List<Object> list = Arrays.asList(strs);
        printList(list, isNewLine, delimiter);
        // for(int i=0;i<strs.length;i++){
        // System.out.println(strs[i]);
        // }
    }

    public static void printArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            if (i < ints.length - 1) {
                System.out.print(" ,");
            }
        }
        System.out.println();
    }

    /***
     * Print two-dimensional array 0_0 0_1 0_2 0_3 0_4 1_0 1_1 1_2 1_3 1_4
     *
     * @param arrays
     */
    public static void printArrays(Object[][] arrays, String delimiter) {
        for (int i = 0; i < arrays.length; i++) {
            Object[] objs = arrays[i];
            if (objs != null && objs.length > 0) {
                printArray(objs, false, delimiter);
                System.out.println();
            }
        }
    }


    /***
     * convert boolean to string
     *
     * @param bool
     * @return
     */
    public static String getBooleanString(boolean bool) {
        return String.valueOf(bool);
    }


    public static Object[][] filterEmpty(Object[][] arrays) {
        int sumNotNull = 0;
        /***
         * ͳ�Ʒǿ�Ԫ�ص��ܸ���
         */
        for (int i = 0; i < arrays.length; i++) {
            Object object = arrays[i];
            if (!ValueWidget.isNullOrEmpty(object)
                    && !SystemUtil.isNullOrEmpty((Object[]) object)) {// �ж�Ԫ���Ƿ�Ϊ��
                sumNotNull = sumNotNull + 1;
            }
        }
        Object[][] filtedObjs = new Object[sumNotNull][];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            Object[] object_tmp = arrays[i];
            if (!ValueWidget.isNullOrEmpty(object_tmp)
                    && !SystemUtil.isNullOrEmpty((Object[]) object_tmp)) {// �ж�Ԫ���Ƿ�Ϊ��
                filtedObjs[index++] = object_tmp;
            }
        }
        return filtedObjs;
    }

    /***
     * [, , ]-->true
     *
     * @param objs
     * @return
     */
    public static boolean isNullOrEmpty(Object[] objs) {
        if (objs == null || objs.length == 0) {
            return true;
        } else {
            boolean isEmpty = true;
            for (int i = 0; i < objs.length; i++) {
                Object object = objs[i];
                if (!ValueWidget.isNullOrEmpty(object)) {
                    isEmpty = false;
                    break;
                }
            }
            return isEmpty;
        }
    }

    /***
     * [, , ]-->true
     *
     * @param objs
     * @return
     */
    public static boolean isNullOrEmpty(String[] objs) {
        if (objs == null || objs.length == 0) {
            return true;
        } else {
            boolean isEmpty = true;
            for (int i = 0; i < objs.length; i++) {
                Object object = objs[i];
                if (!ValueWidget.isNullOrEmpty(object)) {
                    isEmpty = false;
                    break;
                }
            }
            return isEmpty;
        }
    }

    public static int parseObj(Object obj) {
        if (null == obj) {
            return NEGATIVE_ONE;
        }
        return Integer.parseInt(obj.toString());
    }


    /***
     * Join all Strings in the Array into a Single String separator is ,
     *
     * @param strs
     * @return
     */
    public static String arrToString(String[] strs) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (ValueWidget.isHasValue(str)) {
                sb.append(str);
            }
            if (i < strs.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * �������ظ�������� sumInt:������ (0....sumInt-1) resultSum�� ��������������� ��������
     *
     * @return
     */
    public static int[] randoms(int sumInt, int resultSum) {
        // Total sample
        int send[] = new int[sumInt];// 0....(sumInt-1)
        for (int i = 0; i < sumInt; i++) {
            send[i] = i;
        }
        return randoms(send, resultSum);
    }

    /***
     * ��������
     *
     * @param totalSample
     *            :total sample
     * @param resultSum
     *            :Specified number
     * @return
     */
    public static int[] randoms(int[] totalSample, int resultSum) {
        if(resultSum<=0){
            return new int[0];
        }
        int temp1, temp2;
        Random r = new Random();
        int len = totalSample.length;// The length of the total sample
        if(len<=0){
            return new int[0];
        }
        int returnValue[] = new int[resultSum];// Random number to return
        for (int i = 0; i < resultSum; i++) {
            // temp1 = Math.abs(r.nextInt()) % len;
            temp1 = r.nextInt(len);// between 0 (inclusive) and the specified
            // value (exclusive)
            temp2 = totalSample[temp1];
            returnValue[i] = temp2;
            if (temp1 != len - 1) {
                totalSample[temp1] = totalSample[len - 1];
                totalSample[len - 1] = temp2;
            }
            len--;
        }
        return returnValue;
    }

    /***
     * ��ȡ�����������������
     *
     * @param totalSample
     * @return
     */
    public static int randoms(int[] totalSample) {
        int temp1, temp2;
        Random r = new Random();
        int len = totalSample.length;// The length of the total sample
        // temp1 = Math.abs(r.nextInt()) % len;
        temp1 = r.nextInt(len);// between 0 (inclusive) and the specified
        // value (exclusive)
        temp2 = totalSample[temp1];
        return temp2;
    }

    /***
     * ��ȡ�����������������
     *
     * @param sumInt
     * @return
     */
    public static int randoms(int sumInt) {
        // Total sample
        int send[] = new int[sumInt];// 0....(sumInt-1)
        for (int i = 0; i < sumInt; i++) {
            send[i] = i;
        }
        return randoms(send);
    }

    /***
     * whether j is involved in <code>int[] intArray</code>
     *
     * @param intArray
     * @param j
     * @return
     */
    public static boolean isContains(int[] intArray, int j) {
        boolean initBool = false;
        for (int i : intArray) {
            if (i == j) {
                initBool = true;
                break;
            }
        }
        return initBool;
    }

    /***
     * whether strArray contains j<br> test ok
     * @param strArray
     * @param j
     * @return
     */
    public static int isContains(String[] strArray, String j) {
        int index = SystemUtil.NEGATIVE_ONE;
        if(ValueWidget.isNullOrEmpty(strArray)){
            return index;
        }
        int length2=strArray.length;
        for (int ii=0;ii<length2;ii++ ) {
            String i =strArray[ii];
            if (i == j||(i!=null&&i.equals(j)) ) {
                index = ii;
                break;
            }
        }
        return index;
    }

    /***
     * ȥ����ͬ��Ԫ��
     * @param strs
     */
    public static String[] unique(String strs[]){
        Set set=convert2Set(strs);
        int length=set.size();
        set=null;
        String strs_new[]=new String[length];
        int count=0;
        for(int i=0;i<strs.length;i++){
            if(SystemUtil.isContains(strs_new, strs[i])==SystemUtil.NEGATIVE_ONE){
                strs_new[count]=strs[i];
                count++;
            }
        }
        return strs_new;
    }
    public static boolean isContains2(int[] intArray, int j) {
        return isContains(intArray, j, 2);
    }

    /***
     * Match the specified number(times)
     *
     * @param intArray
     * @param j
     * @param time
     * @return
     */
    public static boolean isContains(int[] intArray, int j, int time) {
        boolean initBool = false;
        int count = 0;
        for (int i : intArray) {
            if (i == j) {
                count++;
            }
        }
        if (count == time) {
            return true;
        }
        return initBool;
    }

    /***
     * Match the specified number(times)<br> test ok
     *
     * @param intArray
     * @param j
     * @param time
     * @return
     */
    public static boolean isContains(String[] intArray, String j, int time) {
        boolean initBool = false;
        if(ValueWidget.isNullOrEmpty(intArray)){
            return initBool;
        }
        int count = 0;
        for (String i : intArray) {
            if (i == j||i.equals(j)) {
                count++;
            }
        }
        if (count == time) {
            return true;
        }
        return initBool;
    }


    /***
     * Filter out the elements of the same
     *
     * @param intArray
     * @return
     */
    public static boolean uniqueInt(int[] intArray) {
        boolean initBool = true;
        for (int j : intArray) {
            if (!isContains(intArray, j, 1)) {
                initBool = false;
                break;
            }
        }
        return initBool;
    }

    /***
     * Filter out the elements of the same
     *
     * @param strArray
     * @return
     */
    public static boolean uniqueStr(String[] strArray) {
        boolean initBool = true;
        if(ValueWidget.isNullOrEmpty(strArray)){
            return initBool;
        }
        for (String j : strArray) {
            if (!isContains(strArray, j, 1)) {
                initBool = false;
                break;
            }
        }
        return initBool;
    }


    public static boolean isEquals(List<String> aa, List<String> bb) {
        if (null == aa || null == bb)
            return false;
        boolean isEqual = true;
        if (aa.size() == bb.size()) {
            for (int i = 0; i < aa.size(); i++) {
                String aaStr = aa.get(i);
                String bbStr = bb.get(i);
                if (!aaStr.equals(bbStr)) {
                    isEqual = false;
                    break;
                }
            }
        } else {
            return false;
        }

        return isEqual;
    }

    /***
     *
     * @param input
     *            �� 0 or 1 or false or true
     * @return true:1,true ; false:0,false
     */
    public static boolean parse33(String input) {
        boolean result = false;
        if (input.equals("0") || input.equals("1")) {
            int resultint = Integer.parseInt(input);
            result = (resultint == 1);
        } else {
            result = Boolean.parseBoolean(input);
        }
        return result;
    }

    /***
     * reverse map Note : value in oldMap must be unique. rever
     *
     * @param oldMap
     * @return
     */
    public static Map reverseMap(Map oldMap) {
        Map newMap = new HashMap<Object, Object>();
        for (Iterator it = oldMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Object, String> entry = (Map.Entry<Object, String>) it
                    .next();
            newMap.put(entry.getValue(), entry.getKey());
        }
        return newMap;
    }

    /***
     *
     * @param arrays
     * @param columnIndex
     *            : start from one
     * @return
     */
    public static Object[] getProjection(Object[][] arrays, int columnIndex) {
        int length = arrays.length;
        Object[] objs = new Object[length];
        for (int i = 0; i < length; i++) {
            if (arrays[i] == null) {
                objs[i] = null;
            } else {
                objs[i] = arrays[i][columnIndex - 1];
            }
        }
        return objs;
    }

    /***
     * convert request query string to map
     *
     * @param queryString
     * @return
     */
    public static Map<String, Object> parseQueryString(String queryString) {
        Map<String, Object> argMap = new HashMap<String, Object>();
        String[] queryArr = queryString.split("&");
        for (int i = 0; i < queryArr.length; i++) {
            String string = queryArr[i];
            String keyAndValue[] = string.split("=");
            if (keyAndValue.length != 2) {
                argMap.put(keyAndValue[0], EMPTY);
            } else {
                argMap.put(keyAndValue[0], keyAndValue[1]);
            }
        }
        return argMap;
    }

    /***
     * convert Map<String, Object> to Map<String, String>
     *
     * @param oldMap
     * @return
     */
    public static Map<String, String> convertMap(Map<String, Object> oldMap) {
        Map<String, String> newMap = new HashMap<String, String>();
        for (Iterator it = oldMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it
                    .next();
            newMap.put(entry.getKey(), (String) entry.getValue());
        }
        return newMap;
    }

    public static String getFilecharset(File sourceFile) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(sourceFile));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1) {
                return charset; // �ļ�����Ϊ ANSI
            } else if (first3Bytes[0] == (byte) 0xFF
                    && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE"; // �ļ�����Ϊ Unicode
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE"; // �ļ�����Ϊ Unicode big endian
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8"; // �ļ�����Ϊ UTF-8
                checked = true;
            }
            bis.reset();
            if (!checked) {
                int loc = 0;
                while ((read = bis.read()) != -1) {
                    loc++;
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // ��������BF���µģ�Ҳ����GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // ˫�ֽ� (0xC0 - 0xDF)
                            // (0x80
                            // - 0xBF),Ҳ������GB������
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {// Ҳ�п��ܳ������Ǽ��ʽ�С
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }

    /***
     * convert String[] to ArrayList<String>
     *
     * @param strs
     * @return
     */
    public static ArrayList<String> asArrayList(String[] strs) {
        ArrayList<String> arrs = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            arrs.add(strs[i]);
        }
        return arrs;
    }

    public static ArrayList<Object> asArrayList(Object[] strs) {
        ArrayList<Object> arrs = new ArrayList<Object>();
        for (int i = 0; i < strs.length; i++) {
            arrs.add(strs[i]);
        }
        return arrs;
    }

    /***
     * open Browser
     *
     * @param url
     * @return
     */
    public static boolean openURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Mac OS")) {
                // mac
                Class fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL",
                        new Class[] { String.class });
                openURL.invoke(null, new Object[] { url });
            } else if (osName.startsWith("Windows")) {
                // Windows
                Runtime.getRuntime().exec(
                        "rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                // assume Unix or Linux
                String[] browsers = { "firefox", "opera", "konqueror",
                        "epiphany", "mozilla", "netscape" };
                String browser = null;
                for (int count = 0; count < browsers.length && browser == null; count++) {
                    if (Runtime.getRuntime()
                            .exec(new String[] { "which", browsers[count] })
                            .waitFor() == 0) {
                        browser = browsers[count];
                    }
                }
                if (browser != null) {
                    Runtime.getRuntime().exec(new String[] { browser, url });
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /***
     * Determine whether it is an absolute path.
     *
     * @param input
     * @return
     */
    public static boolean isAbsolutePath(String input) {
        if (ValueWidget.isNullOrEmpty(input)) {
            throw new RuntimeException("can not be null");
        }
        if (isWindows) {
            return input.matches("^[a-zA-Z]:\\\\?.*");// "^[a-zA-Z]:\\\\.*"
        } else {
            return input.matches("^/.*");
        }
    }

    public static byte[] getCerInfo(X509Certificate cServer)
            throws CertificateException {
        byte certbytes[] = cServer.getEncoded();
        X509CertImpl x509certimpl = new X509CertImpl(certbytes);
        X509CertInfo x509certinfo = (X509CertInfo) x509certimpl
                .get("x509.info");
        byte[] bse = x509certinfo.getEncodedInfo();
        return bse;
    }

    /**
     * ���KeyStore
     *
     * @param keyStorePath
     *            ��Կ��·��
     * @param password
     *            ����
     * @return KeyStore ��Կ��
     */
    public static KeyStore getKeyStore(String keyStorePath, String password)
            throws Exception {
        // ʵ������Կ��
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        // �����Կ���ļ���
        FileInputStream is = new FileInputStream(keyStorePath);
        // ������Կ��
        ks.load(is, password.toCharArray());
        // �ر���Կ���ļ���
        is.close();
        return ks;
    }

    /***
     *
     * @param keyStorePath
     *            : create by keytool,suffix is ".keystore"
     * @param password
     *            : specified by keytool
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyByKeystore(String keyStorePath,
                                                     String password, String alias) throws Exception {
        // �����Կ��
        KeyStore ks = getKeyStore(keyStorePath, password);
        // ���˽Կ
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias,
                password.toCharArray());
        return privateKey;
    }

    /***
     * Whether the files is in the specified directory.
     *
     * @param filepath
     * @param folder
     *            : directory
     * @return
     */
    public static boolean isDirIncludeFile(String filepath, String folder) {
        // folder:D:\eclipse\workspace\shop_goods\ upload
        if (folder.contains("\\")) {
            folder = folder.replaceAll("\\\\", "/");
        }
        boolean isContain = filepath.contains(folder);
        if (!isContain) {
            isContain = filepath.replaceAll("//", "/").contains(
                    folder.replaceAll("//", "/"));
        }
        return isContain;
    }

    /***
     * ��ʽ������, new String[]{"a","b","c","d"} -->a,b,c,d
     *
     * @param strs
     * @param seperate
     * @return
     */
    public static String formatArr(String[] strs, String seperate) {
        StringBuffer sbuffer = new StringBuffer();
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            sbuffer.append(strs[i]);
            if (i < length - 1) {
                sbuffer.append(seperate);
            }
        }
        return sbuffer.toString();
    }
    /***
     * convert "[243873,253305]" to List
     * @param tokenIds
     * @return
     */
    public static List<Long> getLongList(String tokenIds){
        if(ValueWidget.isNullOrEmpty(tokenIds)){
            return null;
        }
        tokenIds=deletebrackets(tokenIds);
        String[] tokenIdStrs = null;
        List<Long> tokenIdLongs = new ArrayList<Long>();
        tokenIdStrs = tokenIds.split("[ ,]");
        for (int i = 0; i < tokenIdStrs.length; i++) {
            if (!ValueWidget.isNullOrEmpty(tokenIdStrs[i])) {
                tokenIdLongs.add(Long.parseLong(tokenIdStrs[i]));
            }
        }
        return tokenIdLongs;
    }

    /***
     * ��ʽ������, new String[]{"a","b","c","d"} -->a,b,c,d
     *
     * @param strs
     * @param seperate
     * @return
     */
    public static String formatArr(List<String> strs, String seperate) {
        StringBuffer sbuffer = new StringBuffer();
        int length = strs.size();
        for (int i = 0; i < length; i++) {
            sbuffer.append(strs.get(i));
            if (i < length - 1) {
                sbuffer.append(seperate);
            }
        }
        return sbuffer.toString();
    }

    /***
     * convert a byte to hex string.
     *
     * @param b
     * @return
     */
    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return String.valueOf(HEXCHAR[d1]) + HEXCHAR[d2];
    }

    /***
     * �ж� source �Ƿ���� ����keywords �е������ַ�.
     *
     * @param source
     * @param keywords
     * @return
     */
    public static boolean isContains(String source, String[] keywords) {
        if (ValueWidget.isNullOrEmpty(source)) {
            throw new RuntimeException("source must not be null");
        }
        for (int i = 0; i < keywords.length; i++) {
            String string = keywords[i];
            if (source.contains(string)) {
                return true;
            }
        }
        return false;
    }

    /***
     * �ж�list���Ƿ����ظ���Ԫ��,test ok!
     *
     * @param list2
     * @return : [boolean,String]
     */
    public static Object[] isDuplicate(List<String> list2) {
        Object[] obj = new Object[2];
        int length = list2.size();
        for (int i = 0; i < length; i++) {
            String str = list2.get(i);
            int count = count(list2, str);
            if (count > 1) {
                obj[0] = Boolean.TRUE;
                obj[1] = str;
                return obj;
            }

        }
        obj[0] = Boolean.FALSE;
        return obj;
    }

    /***
     * �ж�arrayList ���Ƿ���� apkId
     *
     * @param arrayList
     * @param propertyValue
     * @return
     */
    public static boolean isContainMap(List<HashMap<String, String>> arrayList,
                                       String propertyName, String propertyValue) {
        if (ValueWidget.isNullOrEmpty(arrayList)) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            HashMap<String, String> map = arrayList.get(i);
            String apkTmp = map.get(propertyName);
            if (apkTmp.equalsIgnoreCase(propertyValue)) {
                return true;
            }
        }
        return false;
    }

    /***
     * �ж��ļ�·�����Ƿ��к�׺��
     *
     * @param filepath
     * @return
     */
    public static boolean isHasSuffix(String filepath) {
        Pattern p = Pattern.compile("\\.[\\w]+$");
        // Pattern p = Pattern.compile("(begin)\n(\\1)", Pattern.DOTALL);
        Matcher mc = p.matcher(filepath);
        return mc.find();
    }

    /***
     * �ж��ļ�·�����Ƿ��к�׺��
     *
     * @param filepath
     * @return
     */
    public static boolean isHasSuffix(File filepath) {
        return isHasSuffix(filepath.getAbsolutePath());
    }

    /***
     * ��ȡ�ļ����ơ�����"aa/bb����#.txt"--����bb����#.txt��
     *
     * @param filepath
     * @return
     */
    public static String getFileNameOnly(String filepath) {
        String result = filepath.replaceAll(".*\\b[/\\\\]([\\w\\.]+)", "$1");
        return result;
    }

    /***
     * �ж�list���Ƿ����keyWord
     *
     * @param list
     * @param keyWord
     * @return
     */
    public static boolean isContains(List<String> list, String keyWord) {
        if (ValueWidget.isNullOrEmpty(list)) {
            return false;
        }
        return list.contains(keyWord);
    }
    /***
     *
     * @param source
     * @param byCompare : ֻҪ��һ������ source.startWith,�ͷ���true
     * @return
     */
    public static boolean isStartWithAnyone(String source,String[]byCompare){
        for (int i = 0; i < byCompare.length; i++) {
            if(source.startsWith(byCompare[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean isStartWithAnyone(String source,List<String>byCompare){
        for (int i = 0; i < byCompare.size(); i++) {
            if(source.startsWith(byCompare.get(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean isEndWithAnyone(String source,String[]byCompare){
        for (int i = 0; i < byCompare.length; i++) {
            if(source.endsWith(byCompare[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean isEndWithAnyone(String source,List<String>byCompare){
        for (int i = 0; i < byCompare.size(); i++) {
            if(source.endsWith(byCompare.get(i))){
                return true;
            }
        }
        return false;
    }
    /***
     * copy list
     * @param srcList
     * @param start
     * @param length
     * @return
     */
    public static List copyList(List srcList,int start,int length){
        if(ValueWidget.isNullOrEmpty(srcList)){
            return null;
        }
        List resultList=new ArrayList();
        for(int i=start;i<length+start&& i<srcList.size();i++){
            resultList.add(srcList.get(i));
        }
        return resultList;
    }
    /***
     * Get location of element in a array
     * @param arr : a array
     * @param value2 : element of array
     * @return
     */
    public static int indexOfArr(String[] arr,String value2){
        if(ValueWidget.isNullOrEmpty(arr)){
            return SystemUtil.NEGATIVE_ONE;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(value2)){
                return i;
            }else{//�����ݴ�,������ȫƥ��
                if(value2.startsWith(arr[i])){
                    return i;
                }
            }
        }
        return SystemUtil.NEGATIVE_ONE;
    }
}

