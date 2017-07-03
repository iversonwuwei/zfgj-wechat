/**
 * @name: FeedBackEnum.java
 * @Copyright: (c) 2017 DLFC. All rights reserved.
 * @description: 意见反馈类型
 * @version: 1.0
 * @date : 2017年6月19日
 * @author: yuanjw
 * @Modification History:<br>
 * Date          Author         Version        Discription
 * 2017年6月19日       yuanjw        1.0             <修改原因描述>
 */
package com.dlfc.services.feedback.enums;

/**
 * @name: FeedBackEnum
 * @description:
 *
 * @version 1.0
 * @author yuanjw
 *
 */
public enum FeedBackEnum {

    ZFGJ_APP("经纪人在线APP", "1"),
    ZFGJ("经纪人在线", "2"),
    HOUSECENTER_WeChat("租房网微信端", "3"),
    HOUSECENTER("租房网", "4"),
    HOUSECENTER_APP("租房网APP", "5");

    private String name;

    private String value;

    private FeedBackEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
