package cn.com.enjoystudy.oa.bean.sys;

import cn.com.enjoystudy.oa.bean.SOSupport;

import java.util.List;

/**
 * 数字字典
 * @author 广州新咨力科技有限公司-杜永生
 */
public class BaseDictionarySO extends SOSupport {
    /** 字典编号 */
    private String code;
    /** 字典名称 */
    private String name;
    /** 备注信息 */
    private String caption;
    /** 显示状态 */
    private Boolean showState;
    private List<BaseDictionaryItem> itemList;
    private String[] itemCodes;
    private String[] itemNames;
    private Boolean[] itemStates;
    private Integer[] itemSorts;

    public BaseDictionarySO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public List<BaseDictionaryItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BaseDictionaryItem> itemList) {
        this.itemList = itemList;
    }

    public String[] getItemCodes() {
        return itemCodes;
    }

    public void setItemCodes(String[] itemCodes) {
        this.itemCodes = itemCodes;
    }

    public String[] getItemNames() {
        return itemNames;
    }

    public void setItemNames(String[] itemNames) {
        this.itemNames = itemNames;
    }

    public Boolean[] getItemStates() {
        return itemStates;
    }

    public void setItemStates(Boolean[] itemStates) {
        this.itemStates = itemStates;
    }

    public Integer[] getItemSorts() {
        return itemSorts;
    }

    public void setItemSorts(Integer[] itemSorts) {
        this.itemSorts = itemSorts;
    }
}
