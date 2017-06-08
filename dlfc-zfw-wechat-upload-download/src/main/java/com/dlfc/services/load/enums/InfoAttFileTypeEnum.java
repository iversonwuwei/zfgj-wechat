
/**
 * 附件类型枚举枚举
 * 
* @name: InfoAttFileTypeEnum.java 
*
* @Copyright: (c) 2015 DLFC. All rights reserved. 
*
* @description: 
*
* @version: 1.0
* @date : 2015年11月27日 
* @author: Sun.Zhi 
*
* @Modification  History:<br>
*  Date          Author         Version        Discription
*  2015年11月27日        Sun.Zhi        1.0             <修改原因描述>
*/
package com.dlfc.services.load.enums;

import org.apache.commons.lang.enums.ValuedEnum;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 附件类型枚举
 * 
 * @name: InfoAttFileTypeEnum
 * @description: 
 * 
 * @version 1.0
 * @author Sun.Zhi
 *
 */
public class InfoAttFileTypeEnum extends ValuedEnum {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3305561255485119822L;
	

	/**
	 * 合同正面
	 */
	private static final int ONE_SIDE = 1;
	/**
	 * 合同背面
	 */
	private static final int OTHER_SIDE = 2;
	/**
	 * 解约协议
	 */
	private static final int DISS_AGR = 3;
	/**
	 * 押金分配协议
	 */
	private static final int DEPO_DIST_AGR = 4;
	/**
	 * 合同代理协议
	 */
	private static final int PROXY_AGR = 5;
	/**
	 * 下载合同PDF
	 */
	private static final int DW_CON_PDF = 6;
	/**
	 * 下载解约协议PDF
	 */
	private static final int DW_DISS_PDF = 7;
	/**
	 * 下载押金分配协议PDF
	 */
	private static final int DW_DEPO_DIST_PDF = 8;
	/**
	 * 下载承诺书PDF
	 */
	private static final int DW_COMMITBOOK_PDF = 9;
	//房源图片
	private static final int HOUSE_PIC = 11;
	//房间图片
	private static final int ROOM_PIC = 12;
	/**
	 * 广告房源图片
	 */
	private static final int AD_HOUSE_PIC = 13;
	/**
	 * 广告媒体图片
	 */
	private static final int AD_MEDIA_PIC = 14;
	/**
	 * 意见反馈图片
	 */
	private static final int FEEDBACK_PIC = 15;
	/**
	 * 经纪人资格认证
	 */
	private static final int EMP_CERT_CARD = 16;
	/**
	 * 用户身份认证证件图片
	 */
	private static final int USER_CERT_CARD = 17;
	/**
	 * 用户证件图片
	 */
	private static final int USER_ID_CARD = 18;
	/**
	 * 用户头像图片
	 */
	private static final int AVATAR = 19;
	/**
	 * 经纪人头像图片
	 */
	private static final int EMP_AVATAR = 20;
	/**
	 * 经纪人二维码
	 */
	private static final int EMP_ERWEIMA = 21;
	/**
	 * 治安责任保证书
	 */
	private static final int SECURITY_BOOK = 22;
	
	/**
	 * 宽带业务图片
	 */
	private static final int BROADBAND_PIC = 23;
	/**
	 * 呼入录音
	 */
	private static final int IN_AUDIO = 24;
	/**
	 * 呼出录音
	 */
	private static final int OUT_AUDIO = 25;
	/**
	 * 租金分期房主协议
	 */
	private static final int STAGES_LESSOR = 26;
	/**
	 * 租金分期房客协议
	 */
	private static final int STAGES_LESSEE = 27;
	/**
	 * 备案服务房客身份证图片
	 */
	private static final int BAZX_TENANT_ID = 28;
	/**
	 * 备案服务房主身份证图片
	 */
	private static final int BAZX_OWNER_ID = 29;
	/**
	 * 备案服务产权图片
	 */
	private static final int BAZX_PROPERTY = 30;
	
	private InfoAttFileTypeEnum(String name, int value) {
		super(name, value);
	}
	
	/**
	 * 合同正面
	 */
	public static final InfoAttFileTypeEnum ONE_SIDE_ENUM = new InfoAttFileTypeEnum("合同正面", ONE_SIDE);
	/**
	 * 合同背面
	 */
	public static final InfoAttFileTypeEnum OTHER_SIDE_ENUM = new InfoAttFileTypeEnum("合同背面", OTHER_SIDE);
	/**
	 * 解约协议
	 */
	public static final InfoAttFileTypeEnum DISS_AGR_ENUM = new InfoAttFileTypeEnum("解约协议", DISS_AGR);
	/**
	 * 押金分配协议
	 */
	public static final InfoAttFileTypeEnum DEPO_DIST_AGR_ENUM = new InfoAttFileTypeEnum("押金分配协议", DEPO_DIST_AGR);
	/**
	 * 合同代理协议
	 */
	public static final InfoAttFileTypeEnum PROXY_AGR_ENUM = new InfoAttFileTypeEnum("合同代理协议", PROXY_AGR);
	/**
	 * 下载合同PDF
	 */
	public static final InfoAttFileTypeEnum DW_CON_PDF_ENUM = new InfoAttFileTypeEnum("下载合同PDF", DW_CON_PDF);
	/**
	 * 下载解约协议PDF
	 */
	public static final InfoAttFileTypeEnum DW_DISS_PDF_ENUM = new InfoAttFileTypeEnum("下载解约协议PDF", DW_DISS_PDF);
	/**
	 * 下载押金分配协议PDF
	 */
	public static final InfoAttFileTypeEnum DW_DEPO_DIST_PDF_ENUM = new InfoAttFileTypeEnum("下载押金分配协议PDF", DW_DEPO_DIST_PDF);
	
	public static final InfoAttFileTypeEnum HOUSE_PIC_ENUM = new InfoAttFileTypeEnum("房源图片", HOUSE_PIC);
	
	public static final InfoAttFileTypeEnum ROOM_PIC_ENUM = new InfoAttFileTypeEnum("房间图片", ROOM_PIC);
	
	public static final InfoAttFileTypeEnum AD_HOUSE_PIC_ENUM = new InfoAttFileTypeEnum("广告房源图片", AD_HOUSE_PIC);
	
	public static final InfoAttFileTypeEnum AD_MEDIA_PIC_ENUM = new InfoAttFileTypeEnum("广告媒体图片", AD_MEDIA_PIC);
	
	public static final InfoAttFileTypeEnum FEEDBACK_PIC_ENUM = new InfoAttFileTypeEnum("意见反馈图片", FEEDBACK_PIC);
	
	public static final InfoAttFileTypeEnum IN_AUDIO_ENUM = new InfoAttFileTypeEnum("呼入录音", IN_AUDIO);
	
	public static final InfoAttFileTypeEnum OUT_AUDIO_ENUM = new InfoAttFileTypeEnum("呼出录音", OUT_AUDIO);
	/**
	 * 头像图片
	 */
	public static final InfoAttFileTypeEnum AVATAR_ENUM = new InfoAttFileTypeEnum("头像图片", AVATAR);
	/**
	 * 经纪人头像图片
	 */
	public static final InfoAttFileTypeEnum EMP_AVATAR_ENUM = new InfoAttFileTypeEnum("经纪人头像图片", EMP_AVATAR);
	/**
	 * 经纪人二维码图片
	 */
	public static final InfoAttFileTypeEnum EMP_ERWEIMA_ENUM = new InfoAttFileTypeEnum("经纪人二维码", EMP_ERWEIMA);
	/**
	 * 宽带业务图片
	 */
	public static final InfoAttFileTypeEnum BROADBAND_PIC_ENUM = new InfoAttFileTypeEnum("宽带业务图片", BROADBAND_PIC);
	/**
	 * 经纪人资格认证
	 */
	public static final InfoAttFileTypeEnum EMP_CERT_CARD_ENUM = new InfoAttFileTypeEnum("经纪人资格认证图片", EMP_CERT_CARD);
	/**
	 * 用户身份认证证件图片
	 */
	public static final InfoAttFileTypeEnum USER_ID_CARD_ENUM = new InfoAttFileTypeEnum("用户身份认证证件图片", USER_ID_CARD);
	/**
	 * 用户证件图片
	 */
	public static final InfoAttFileTypeEnum USER_CERT_CARD_ENUM = new InfoAttFileTypeEnum("用户证件图片", USER_CERT_CARD);
	/**
	 * 备案服务房客身份证图片
	 */
	public static final InfoAttFileTypeEnum BAZX_TENANT_ID_ENUM = new InfoAttFileTypeEnum("备案服务房客身份证图片",BAZX_TENANT_ID);
	/**
	 * 备案服务房主身份证图片
	 */
	public static final InfoAttFileTypeEnum BAZX_OWNER_ID_ENUM = new InfoAttFileTypeEnum("备案服务房主身份证图片",BAZX_OWNER_ID);
	/**
	 * 备案服务产权图片
	 */
	public static final InfoAttFileTypeEnum BAZX_PROPERTY_ENUM = new InfoAttFileTypeEnum("备案服务产权图片",BAZX_PROPERTY);
	/**
	 * 下载承诺书PDF
	 */
	public static final InfoAttFileTypeEnum DW_COMMITBOOK_PDF_ENUM = new InfoAttFileTypeEnum("下载承诺书PDF", DW_COMMITBOOK_PDF);
	/**
	 * 治安责任保证书图片
	 */
	public static final InfoAttFileTypeEnum SECURITY_BOOK_ENUM = new InfoAttFileTypeEnum("治安责任保证书", SECURITY_BOOK);
	/**
	 * 租金分期房主协议图片
	 */
	public static final InfoAttFileTypeEnum STAGES_LESSOR_ENUM = new InfoAttFileTypeEnum("租金分期房主协议图片", STAGES_LESSOR);
	/**
	 * 租金分期房客协议图片
	 */
	public static final InfoAttFileTypeEnum STAGES_LESSEE_ENUM = new InfoAttFileTypeEnum("租金分期房客协议图片", STAGES_LESSEE);
	

	public static InfoAttFileTypeEnum getEnum(int temp) {
		return (InfoAttFileTypeEnum) getEnum(InfoAttFileTypeEnum.class, temp);
	}

	@SuppressWarnings("rawtypes")
	public static Map getEnumMap() {
		return getEnumMap(InfoAttFileTypeEnum.class);
	}

	@SuppressWarnings("rawtypes")
	public static List getEnumList() {
		return getEnumList(InfoAttFileTypeEnum.class);
	}

	@SuppressWarnings("rawtypes")
	public static Iterator iterator() {
		return iterator(InfoAttFileTypeEnum.class);
	}
	
	public static String getName(int value) {
		return getName(String.valueOf(value));
	}
	
	@SuppressWarnings("rawtypes")
	public static String getName(String value) {
		List list = getEnumList();
		for (int i = 0; i < list.size(); i++) {
			ValuedEnum type = (ValuedEnum) list.get(i);
			String val = String.valueOf(type.getValue());
			if (val.equals(value)) {
				return type.getName();
			}
		}
		
		return null;
	}
}
