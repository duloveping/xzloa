package cn.com.enjoystudy.oa.bean.sys;

import cn.com.enjoystudy.oa.bean.EntitySupport;

/**
 * 数字字典选项
 * @author 广州新咨力科技有限公司-杜永生
 */
public class BaseDictionaryItem extends EntitySupport {
    /** 所属字典 */
    private BaseDictionary dictionary;
    /** 所属字典ID */
    private String dictionaryId;
    /** 所属字典ID */
    private String dictionaryName;
    /** 选项文本 */
    private String itemText;
    /** 选项数值 */
    private String itemValue;
    /** 显示状态 */
    private Boolean showState;

    public BaseDictionaryItem() {
    }

    public BaseDictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(BaseDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

}
