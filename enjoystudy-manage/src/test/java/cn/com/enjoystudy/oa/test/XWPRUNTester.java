package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.util.WorderToNewWordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XWPRUNTester {
    public static void main(String[] args) {
//        try {
//            //解析docx模板并获取document对象
//            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage("G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\ISO9001.docx"));
//            //获取整个文本对象
//            List<XWPFParagraph> allParagraph = document.getParagraphs();
//
//            //获取XWPFRun对象输出整个文本内容
//            StringBuffer tempText = new StringBuffer();
//            for (XWPFParagraph xwpfParagraph : allParagraph) {
//                List<XWPFRun> runList = xwpfParagraph.getRuns();
//                for (XWPFRun xwpfRun : runList) {
//                    tempText.append(xwpfRun);
//                }
//            }
//            System.out.println(StringUtils.trim(tempText.toString()));
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        //模板文件地址
        String inputUrl = "G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\test.docx";
        //新生产的模板文件
        String outputUrl = "G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\ISO9001-new.docx";

        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("{studentName}", "杜永生");

        List<String[]> testList = new ArrayList<String[]>();
        testList.add(new String[]{"1","1AA","1BB","1CC"});
        testList.add(new String[]{"2","2AA","2BB","2CC"});
        testList.add(new String[]{"3","3AA","3BB","3CC"});
        testList.add(new String[]{"4","4AA","4BB","4CC"});

        WorderToNewWordUtils.changWord(inputUrl, outputUrl, testMap, testList);

//
//        try {
//            //获取word文档解析对象
//            XWPFDocument doucument = new XWPFDocument(POIXMLDocument.openPackage("G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\ISO9001.docx"));
//            //获取段落文本对象
//            List<XWPFParagraph> paragraph = doucument.getParagraphs();
//            //获取首行run对象
//            XWPFRun run = paragraph.get(0).getRuns().get(0);
//            //设置文本内容
//            run.setText("修改了的word");
//            //生成新的word
//            File file = new File("G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\ISO9001-1.docx");
//
//            FileOutputStream stream = new FileOutputStream(file);
//            doucument.write(stream);
//            stream.close();
//       } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        try {
//        StringBuffer tableText = new StringBuffer();
//
//        //解析docx模板并获取document对象
//        XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage("G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\ISO9001.docx"));
//        //获取全部表格对象
//        List<XWPFTable> allTable = document.getTables();
//
//        for (XWPFTable xwpfTable : allTable) {
//            //获取表格行数据
//            List<XWPFTableRow> rows = xwpfTable.getRows();
//            for (XWPFTableRow xwpfTableRow : rows) {
//                //获取表格单元格数据
//                List<XWPFTableCell> cells = xwpfTableRow.getTableCells();
//                for (XWPFTableCell xwpfTableCell : cells) {
//                    List<XWPFParagraph> paragraphs = xwpfTableCell.getParagraphs();
//                    for (XWPFParagraph xwpfParagraph : paragraphs) {
//                        List<XWPFRun> runs = xwpfParagraph.getRuns();
//                        for(int i = 0; i < runs.size();i++){
//                            XWPFRun run = runs.get(i);
//                            tableText.append(run.toString());
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(tableText.toString());
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }
}
