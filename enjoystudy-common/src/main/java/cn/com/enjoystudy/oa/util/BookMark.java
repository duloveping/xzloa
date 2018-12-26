package cn.com.enjoystudy.oa.util;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Stack;

public class BookMark {
    // 以下为定义的常量
    /** 替换标签时，设于标签的后面   **/
    public static final int INSERT_AFTER = 0;
    /** 替换标签时，设于标签的前面   **/
    public static final int INSERT_BEFORE = 1;
    /** 替换标签时，将内容替换书签   **/
    public static final int REPLACE = 2;
    /** docx中定义的部分常量引用  **/
    public static final String RUN_NODE_NAME = "w:r";
    public static final String TEXT_NODE_NAME = "w:t";
    public static final String BOOKMARK_START_TAG = "bookmarkStart";
    public static final String BOOKMARK_END_TAG = "bookmarkEnd";
    public static final String BOOKMARK_ID_ATTR_NAME = "w:id";
    public static final String STYLE_NODE_NAME = "w:rPr";

    /** 内部的标签定义类  **/
    private CTBookmark ctBookmark = null;
    /** 标签所处的段落  **/
    private XWPFParagraph para = null;
    /** 标签所在的表cell对象  **/
    private XWPFTableCell tableCell = null;
    /** 标签名称 **/
    private String bookmarkName = null;
    /** 该标签是否处于表格内  **/
    private boolean isCell = false;

    /**
     * 构造函数
     * @param ctBookmark
     * @param para
     */
    public BookMark(CTBookmark ctBookmark, XWPFParagraph para) {
        this.ctBookmark = ctBookmark;
        this.para = para;
        this.bookmarkName = ctBookmark.getName();
        this.tableCell = null;
        this.isCell = false;
    }

    /**
     * 构造函数，用于表格中的标签
     * @param ctBookmark
     * @param para
     * @param tableCell
     */
    public BookMark(CTBookmark ctBookmark, XWPFParagraph para, XWPFTableCell tableCell) {
        this(ctBookmark, para);
        this.tableCell = tableCell;
        this.isCell = true;
    }

    public boolean isInTable() {
        return this.isCell;
    }

    public XWPFTable getContainerTable() {
        return this.tableCell.getTableRow().getTable();
    }

    public XWPFTableRow getContainerTableRow() {
        return this.tableCell.getTableRow();
    }

    public String getBookmarkName() {
        return  this.bookmarkName;
    }

    public void insertTextAtBookMark(String bookmarkValue, int where) {

        //根据标签的类型，进行不同的操作
        if(this.isCell) {
            this.handleBookmarkedCells(bookmarkValue, where);
        } else {

            //普通标签，直接创建一个元素
            XWPFRun run = this.para.createRun();
            run.setText(bookmarkValue);
            switch(where) {
                case BookMark.INSERT_AFTER:
                    this.insertAfterBookmark(run);
                    break;
                case BookMark.INSERT_BEFORE:
                    this.insertBeforeBookmark(run);
                    break;
                case BookMark.REPLACE:
                    this.replaceBookmark(run);
                    break;
            }
        }
    }

    private void insertAfterBookmark(XWPFRun run) {
        Node nextNode = null;
        Node insertBeforeNode = null;
        Node styleNode = null;
        int bookmarkStartID = 0;
        int bookmarkEndID = -1;


        bookmarkStartID = this.ctBookmark.getId().intValue();

        nextNode = this.ctBookmark.getDomNode();
        while (bookmarkStartID != bookmarkEndID) {
            nextNode = nextNode.getNextSibling();
            if (nextNode.getNodeName().contains(BookMark.BOOKMARK_END_TAG)) {
                try {
                    bookmarkEndID = Integer.parseInt(
                            nextNode.getAttributes().getNamedItem(
                                    BookMark.BOOKMARK_ID_ATTR_NAME).getNodeValue());
                } catch (NumberFormatException nfe) {
                    bookmarkEndID = bookmarkStartID;
                }
            } else {
                if (nextNode.getNodeName().equals(BookMark.RUN_NODE_NAME)) {
                    styleNode = this.getStyleNode(nextNode);
                }
            }
        }

        insertBeforeNode = nextNode.getNextSibling();

        if (styleNode != null) {
            run.getCTR().getDomNode().insertBefore(
                    styleNode.cloneNode(true), run.getCTR().getDomNode().getFirstChild());
        }

        if (insertBeforeNode != null) {
            this.para.getCTP().getDomNode().insertBefore(
                    run.getCTR().getDomNode(), insertBeforeNode);
        }
    }

    private void insertBeforeBookmark(XWPFRun run) {
        Node insertBeforeNode = null;
        Node childNode = null;
        Node styleNode = null;


        insertBeforeNode = this.ctBookmark.getDomNode();
        childNode = insertBeforeNode.getPreviousSibling();

        if (childNode != null) {
            styleNode = this.getStyleNode(childNode);

            if (styleNode != null) {
                run.getCTR().getDomNode().insertBefore(
                        styleNode.cloneNode(true), run.getCTR().getDomNode().getFirstChild());
            }
        }

        this.para.getCTP().getDomNode().insertBefore(
                run.getCTR().getDomNode(), insertBeforeNode);
    }

    private void replaceBookmark(XWPFRun run) {
        Node nextNode = null;
        Node styleNode = null;
        Node lastRunNode = null;
        Stack<Node> nodeStack = null;
        int bookmarkStartID = 0;
        int bookmarkEndID = -1;

        nodeStack = new Stack<Node>();
        bookmarkStartID = this.ctBookmark.getId().intValue();
        nextNode = this.ctBookmark.getDomNode();
        nodeStack.push(nextNode);

        while (bookmarkStartID != bookmarkEndID) {
            nextNode = nextNode.getNextSibling();
            nodeStack.push(nextNode);

            if (nextNode.getNodeName().contains(BookMark.BOOKMARK_END_TAG)) {
                try {
                    bookmarkEndID = Integer.parseInt(
                            nextNode.getAttributes().getNamedItem(
                                    BookMark.BOOKMARK_ID_ATTR_NAME).getNodeValue());
                } catch (NumberFormatException nfe) {
                    bookmarkEndID = bookmarkStartID;
                }
            }
        }

        if (!nodeStack.isEmpty()) {
            lastRunNode = nodeStack.peek();

            if ((lastRunNode.getNodeName().equals(BookMark.RUN_NODE_NAME))) {
                styleNode = this.getStyleNode(lastRunNode);
                if (styleNode != null) {
                    run.getCTR().getDomNode().insertBefore(styleNode.cloneNode(true), run.getCTR().getDomNode().getFirstChild());
                }
            }
            this.deleteChildNodes(nodeStack);
        }

        this.para.getCTP().getDomNode().insertBefore(run.getCTR().getDomNode(), nextNode);
    }

    private void deleteChildNodes(Stack<Node> nodeStack) {
        Node toDelete = null;
        int bookmarkStartID = 0;
        int bookmarkEndID = 0;
        boolean inNestedBookmark = false;

        for(int i = 1; i < nodeStack.size(); i++) {
            toDelete = nodeStack.elementAt(i);
            if(toDelete.getNodeName().contains(BookMark.BOOKMARK_START_TAG)) {
                bookmarkStartID = Integer.parseInt(
                        toDelete.getAttributes().getNamedItem(BookMark.BOOKMARK_ID_ATTR_NAME).getNodeValue());
                inNestedBookmark = true;
            } else if(toDelete.getNodeName().contains(BookMark.BOOKMARK_END_TAG)) {
                bookmarkEndID = Integer.parseInt(
                        toDelete.getAttributes().getNamedItem(BookMark.BOOKMARK_ID_ATTR_NAME).getNodeValue());
                if(bookmarkEndID == bookmarkStartID) {
                    inNestedBookmark = false;
                }
            } else {
                if(!inNestedBookmark) {
                    this.para.getCTP().getDomNode().removeChild(toDelete);
                }
            }
        }
    }

    private Node getStyleNode(Node parentNode) {
        Node childNode = null;
        Node styleNode = null;
        if (parentNode != null) {
            if (parentNode.getNodeName().equalsIgnoreCase(BookMark.RUN_NODE_NAME)
                    && parentNode.hasChildNodes()) {
                childNode = parentNode.getFirstChild();
                if (childNode.getNodeName().equals("w:rPr")) {
                    styleNode = childNode;
                } else {
                    while ((childNode = childNode.getNextSibling()) != null) {
                        if (childNode.getNodeName().equals(BookMark.STYLE_NODE_NAME)) {
                            styleNode = childNode;
                            childNode = null;
                        }
                    }
                }
            }
        }
        return (styleNode);
    }

    public String getBookmarkText() throws XmlException {
        StringBuilder builder = null;
        if(this.tableCell != null) {
            builder = new StringBuilder(this.tableCell.getText());
        }
        else {
            builder = this.getTextFromBookmark();
        }
        return(builder == null ? null : builder.toString());
    }

    private StringBuilder getTextFromBookmark() throws XmlException {
        int startBookmarkID = 0;
        int endBookmarkID = -1;
        Node nextNode = null;
        StringBuilder builder = null;

        startBookmarkID = this.ctBookmark.getId().intValue();
        nextNode = this.ctBookmark.getDomNode();
        builder = new StringBuilder();

        while (startBookmarkID != endBookmarkID) {

            nextNode = nextNode.getNextSibling();
            if (nextNode.getNodeName().contains(BookMark.BOOKMARK_END_TAG)) {

                try {
                    endBookmarkID = Integer.parseInt(
                            nextNode.getAttributes().
                                    getNamedItem(BookMark.BOOKMARK_ID_ATTR_NAME).getNodeValue());
                } catch (NumberFormatException nfe) {
                    endBookmarkID = startBookmarkID;
                }
            } else {
                if (nextNode.getNodeName().equals(BookMark.RUN_NODE_NAME)
                        && nextNode.hasChildNodes()) {
                    builder.append(this.getTextFromChildNodes(nextNode));
                }
            }
        }
        return (builder);
    }

    private String getTextFromChildNodes(Node node) throws XmlException {
        NodeList childNodes = null;
        Node childNode = null;
        CTText text = null;
        StringBuilder builder = new StringBuilder();
        int numChildNodes = 0;

        childNodes = node.getChildNodes();
        numChildNodes = childNodes.getLength();

        for (int i = 0; i < numChildNodes; i++) {
            childNode = childNodes.item(i);
            if (childNode.getNodeName().equals(BookMark.TEXT_NODE_NAME)) {
                if (childNode.getNodeType() == Node.TEXT_NODE) {
                    builder.append(childNode.getNodeValue());
                } else {
                    text = CTText.Factory.parse(childNode);
                    builder.append(text.getStringValue());
                }
            }
        }
        return (builder.toString());
    }

    private void handleBookmarkedCells(String bookmarkValue, int where) {
        List<XWPFParagraph> paraList = null;
        XWPFParagraph para = null;
        paraList = this.tableCell.getParagraphs();
        for(int i = 0; i < paraList.size(); i++) {
            this.tableCell.removeParagraph(i);
        }
        para = this.tableCell.addParagraph();
        para.createRun().setText(bookmarkValue);
    }

}
