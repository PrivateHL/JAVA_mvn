package Tool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqlStringToolTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setNvarcharSql() {

        String sql1 = "Select * from BOM_027";
        String sql2 = "Insert into BOM_027 (*) values ('','','')";
        String sql3 = "update BOM_027 set index =''";
        String sql4 = " Insert int BOM_027 ('''',''''' ')";
        String sql6 = " Insert int BOM_027 ('''','''''')";
        String sql5 = "insert into x(c1) values ('aaa''aa')";

        String nsql2 = "Insert into BOM_027 (*) values (N'','','')";
        String nsql3 = "update BOM_027 set index =''";
        String nsql4 = " Insert int BOM_027 ('''',N''''' ')";
        String nsql6 = " Insert int BOM_027 ('''',N'''''')";
        String nsql5 = "insert into x(c1) values (N'aaa''aa')";
        String nsql7 = "Insert into BOM_027 (*) values ('',N'','')";

        String newsql2 = "Insert into BOM_027 (*) values (N'',N'',N'')";
        String newsql3 = "update BOM_027 set index =N''";
        String newsql4 = " Insert int BOM_027 (N'''',N''''' ')";
        String newsql6 = " Insert int BOM_027 (N'''',N'''''')";
        String newsql5 = "insert into x(c1) values (N'aaa''aa')";

        String sql8 = "insert into BOM_027(*) values('','''''''''''','','''')";
        String newsql8 = "insert into BOM_027(*) values(N'',N'''''''''''',N'',N'''')";

        String sql9 = "insert into BOM_027(*) values('',''''''''''' ''  '''' ''''''','','''')";
        String newsql9 = "insert into BOM_027(*) values(N'',N''''''''''' ''  '''' ''''''',N'',N'''')";

        assertEquals(sql1, SqlStringTool.setNvarcharSql(sql1));
        assertEquals(newsql2, SqlStringTool.setNvarcharSql(sql2));
        assertEquals(newsql3, SqlStringTool.setNvarcharSql(sql3));
        assertEquals(newsql4, SqlStringTool.setNvarcharSql(sql4));
        assertEquals(newsql5, SqlStringTool.setNvarcharSql(sql5));
        assertEquals(newsql6, SqlStringTool.setNvarcharSql(sql6));

        assertEquals(newsql2, SqlStringTool.setNvarcharSql(nsql2));
        assertEquals(newsql2, SqlStringTool.setNvarcharSql(nsql7));
        assertEquals(newsql3, SqlStringTool.setNvarcharSql(nsql3));
        assertEquals(newsql4, SqlStringTool.setNvarcharSql(nsql4));
        assertEquals(newsql5, SqlStringTool.setNvarcharSql(nsql5));
        assertEquals(newsql6, SqlStringTool.setNvarcharSql(nsql6));

        assertEquals(newsql8,SqlStringTool.setNvarcharSql(sql8));
        assertEquals(newsql9,SqlStringTool.setNvarcharSql(sql9));
        System.out.println(SqlStringTool.setNvarcharSql(sql8));

    }
}