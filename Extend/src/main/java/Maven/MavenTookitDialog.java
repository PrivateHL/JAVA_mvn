package Maven;

import cmd.CmdUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @Description: maven 安装jar文件小程序
 * Problem1:cmd 能执行mvn命令，runtime.exe不能执行提示"mvn不是可执行的命令" ####还未解决
* @Author:  HeLing
* @Date: 2019/7/30 15:48
*/ 
public class MavenTookitDialog extends JFrame {

    String filePath = "";
    String group = "";
    String artifactid = "";
    String version = "";
    String packaging = "";

    private JPanel contentPane;
    private JTextField txtJar  = new JTextField();
    private JTextField txtGroup = new JTextField();
    private JTextField txtArtifactid = new JTextField();
    private JTextField txtVersion = new JTextField();
    private JTextField txtPackage = new JTextField();
    private JButton btnJarFile ;
    public static final String MAVEN_INSTALL_JAR_CMD=
            "mvn install:install-file  -Dfile=%s  -DgroupId=%s  -DartifactId=%s -Dversion=%s -Dpackaging=%s";
    private TextArea txtsResult = new TextArea();

    private JButton btnOk;
    private JButton btnCancle;
    /**
    * @Description: launch the application
    * @param:   [args]
    * @return:  void
    * @Author:  HeLing
    * @Date: 2019/7/30 10:26
    */ 
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    MavenTookitDialog frame = new MavenTookitDialog();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public MavenTookitDialog(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("install jar to local maven Repository");
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        BorderLayout bdl_contenPanel = new BorderLayout();
        contentPane.setLayout(bdl_contenPanel);

        JPanel pnlCenter = new JPanel();
        GridLayout gdl_pnlCenter = new GridLayout(0,1);
        pnlCenter.setLayout(gdl_pnlCenter);

        JLabel lbl_file = new JLabel("文件     ");
        btnJarFile = new JButton("选择");
        JPanel pnlJar = new JPanel();
        BorderLayout bdl_pnl_File = new BorderLayout();
        pnlJar.setLayout(bdl_pnl_File);
        pnlJar.add(lbl_file, BorderLayout.WEST);
        pnlJar.add(txtJar,BorderLayout.CENTER);
        pnlJar.add(btnJarFile,BorderLayout.EAST);
        pnlCenter.add(pnlJar);

        JLabel lblGroupid = new JLabel("GroupId   ");
        JPanel pnlGroupId = new JPanel();
        BorderLayout bdl_onlGroupId = new BorderLayout();
        pnlGroupId.setLayout(bdl_onlGroupId);
        pnlGroupId.add(lblGroupid,BorderLayout.WEST);
        pnlGroupId.add(txtGroup,BorderLayout.CENTER);
        pnlCenter.add(pnlGroupId);

        JLabel lblArtifactId = new JLabel("ArtifactId");
        JPanel pnlArtifactId = new JPanel();
        BorderLayout bdl_pnlArtifactId = new BorderLayout();
        pnlArtifactId.setLayout(bdl_pnlArtifactId);
        pnlArtifactId.add(lblArtifactId,BorderLayout.WEST);
        pnlArtifactId.add(txtArtifactid,BorderLayout.CENTER);
        pnlCenter.add(pnlArtifactId);

        JLabel lblVersion = new JLabel("Version   ");
        JPanel pnlVersion = new JPanel();
        BorderLayout bdl_pnlVersion = new BorderLayout();
        pnlVersion.setLayout(bdl_pnlVersion);
        pnlVersion.add(lblVersion,BorderLayout.WEST);
        pnlVersion.add(txtVersion,BorderLayout.CENTER);
        pnlCenter.add(pnlVersion);

        JLabel lblPackage = new JLabel("Package\t");
        JPanel pnlPackage = new JPanel();
        BorderLayout bdl_pnlPackage = new BorderLayout();
        pnlPackage.setLayout(bdl_pnlPackage);
        pnlPackage.add(lblPackage,BorderLayout.WEST);
        pnlPackage.add(txtPackage,BorderLayout.CENTER);
        pnlCenter.add(pnlPackage);

        btnOk = new JButton("安装");
        btnCancle = new JButton("取消");
        JPanel pnlNorth = new JPanel();
        JPanel pnlBtns = new JPanel();
        BorderLayout bdl_pnlNorth = new BorderLayout();
        pnlNorth.setLayout(bdl_pnlNorth);
        pnlNorth.add(pnlBtns,BorderLayout.EAST);
        FlowLayout fwl_pnlBtns = new FlowLayout();
        pnlBtns.setLayout(fwl_pnlBtns);
        pnlBtns.add(btnOk);
        pnlBtns.add(btnCancle);

        pnlCenter.add(new JLabel(""));

        JScrollPane pnlRes = new JScrollPane();
        ScrollPaneLayout scl_pnlRes = new ScrollPaneLayout();
        pnlRes.setLayout(scl_pnlRes);
        pnlRes.add(txtsResult);
        pnlCenter.add(pnlRes);

        contentPane.add(pnlCenter,BorderLayout.CENTER);
        contentPane.add(pnlNorth,BorderLayout.SOUTH);

        btnJarFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                //chooser.setFileSelectionMode(JFileChooser.FILES_ONLY );
                MavenInstallFileFilter filter = new MavenInstallFileFilter();
                chooser.addChoosableFileFilter(filter);//选择
                chooser.setFileFilter(filter);//显示
                chooser.showDialog(new JLabel(), "选择");
                File file = chooser.getSelectedFile();
                if(file.isFile()){

                    filePath = file.getPath();
                    txtJar.setText(filePath);
                    if(filePath.toLowerCase().endsWith(".jar")){
                        packaging = "jar";
                    }else if(filePath.toLowerCase().endsWith(".pom")){
                        packaging = "pom";
                    }else{
                        packaging = "";
                    }
                    txtPackage.setText(packaging);
                    version = findSubVersion(file.getName());
                    txtVersion.setText(version);
                }else{
                    JOptionPane.showMessageDialog(null,"文件选取错误");
                }
            }
        });

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtsResult.setText("");
                filePath = txtJar.getText();
                group = txtGroup.getText();
                artifactid = txtArtifactid.getText();
                version = txtVersion.getText();
                packaging = txtPackage.getText();
                String cmd = String.format(MAVEN_INSTALL_JAR_CMD,filePath,group,artifactid,version,packaging);
                txtsResult.setText( CmdUtils.getResult4cmd(cmd));
            }
        });
        btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtPackage.setText("");
                txtVersion.setText("");
                txtArtifactid.setText("");
                txtGroup.setText("");
                txtsResult.setText("");
            }
        });
    }

    private String findSubVersion(String filename){
        String regex = "[0-9,\\.]*";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher (filename);
        if(matcher.matches()){
            return matcher.group(0);
        }else{
            return "";
        }
    }


    class MavenInstallFileFilter extends FileFilter {
        public String getDescription() {
            return "*.jar;*.pom";
        }

        public boolean accept(File file) {
            String name = file.getName();
            return file.isDirectory() || name.toLowerCase().endsWith(".jar") || name.toLowerCase().endsWith(".pom");  // 仅显示目录和xls、xlsx文件
        }
    }
}
