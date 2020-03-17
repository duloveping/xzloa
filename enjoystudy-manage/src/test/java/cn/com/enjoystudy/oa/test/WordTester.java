package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.util.MSWordTool;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordTester {
    public static void main(String[] args) {

        XWPFDocument document = null;
        try {
            InputStream is = new FileInputStream("G:\\workspaces\\gddh\\enjoystudy\\enjoystudy-manage\\src\\main\\webapp\\static\\certificate\\a.docx");
            document = new XWPFDocument(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> contentMap = Maps.newHashMap();
        contentMap.put("studentName", "杜永生");

        List<XWPFParagraph> paragraphs = document.getParagraphs();
        if (CollectionUtils.isNotEmpty(paragraphs)) {
            for (XWPFParagraph paragraph : paragraphs) {
                List<XWPFRun> runs = paragraph.getRuns();
                if (CollectionUtils.isNotEmpty(runs)) {
                    for (XWPFRun run : runs) {
                        String text = run.getText(0);
                        System.out.println(text);
                    }
                }
            }
        }

        List<XWPFTable> allTable = document.getTables();
        if (CollectionUtils.isNotEmpty(allTable)) {
            for (XWPFTable xwpfTable : allTable) {
                List<XWPFTableRow> rows = xwpfTable.getRows();
                if (CollectionUtils.isNotEmpty(rows)) {
                    for (XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        if (CollectionUtils.isNotEmpty(cells)) {
                            for (XWPFTableCell cell : cells) {

                                List<XWPFParagraph> cellParagraphs = cell.getParagraphs();
                                if (CollectionUtils.isNotEmpty(cellParagraphs)) {
                                    for (XWPFParagraph paragraph : cellParagraphs) {
                                        List<XWPFRun> runs = paragraph.getRuns();
                                        if (CollectionUtils.isNotEmpty(runs)) {
                                            for (XWPFRun run : runs) {
                                                String text = run.getText(0);
                                                System.out.println(text);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
