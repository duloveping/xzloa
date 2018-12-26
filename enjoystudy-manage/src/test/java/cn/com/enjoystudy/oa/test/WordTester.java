package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.util.MSWordTool;

import java.util.HashMap;
import java.util.Map;

public class WordTester {
    public static void main(String[] args) {
        MSWordTool tool = new MSWordTool();
        tool.setTemplate("E:\\temp\\test\\iso14000.docx");
        Map<String,String> content = new HashMap<String,String>();
        content.put("fullName", "杜永生");
        tool.replaceBookMark(content);
        tool.saveAs("E:\\temp\\test\\iso14000A.docx");
//        InputStream is = null;
//        try {
//            is = new FileInputStream("E:\\temp\\test\\iso14000.docx");
//            XWPFDocument document = new XWPFDocument(is);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (null != is) {
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }


    }
}
