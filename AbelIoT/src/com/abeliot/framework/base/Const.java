package com.abeliot.framework.base;


/**
 * 常量定义
 * 
 */
public interface Const {

	public static final String ERROR_OBJECT_ID_IS_NULL = "对象编号为空!";

	public static final String ERROR_OBJECT_IS_NOT_EXIST = "对象不存在!";

	public static final String OPERATE_SUCCESS = "操作成功!";

	public static final String DATETIME_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public static final String DATETIME_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String DATETIME_FORMAT_YYYY_MM_DD_HH_MM_SS_FFF = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String DATETIME_FORMAT_YYYYMMDD = "yyyyMMdd";

	public static final String DATETIME_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String[] course_years = new String[] { "2005", "2006",
			"2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014" };

	/**
	 * 状态1为真，0为假
	 */
	public static final String TRUE = "1";

	public static final String FALSE = "0";

	/**
	 * 状态0为普通信息,1为申请信息
	 */
	public static final String normal = "0";

	public static final String apply = "1";

	/**
	 * 状态0为待分配,1为未分配,2为已分配
	 */
	public static final String sending = "0";

	public static final String nosend = "1";

	public static final String sended = "2";


	/**
	 * 未认证
	 */
	public static final String unchecked = "3";

	/**
	 * 状态0为未审核1为通过审核 推荐日志
	 */
	public static final String NOPASS = "0";

	public static final String PASS = "1";

	/**
	 * 进度状态 0表示预先，1表示正常，2表示中止，3表示结束
	 */
	public static final String PRE = "0";

	public static final String NORMAL = "1";

	public static final String STOP = "2";

	public static final String FINISH = "3";

	/**
	 * 考勤状态 0表示缺勤，1表示正常，2表示迟到，3表示早退，4表示请假
	 */
	public static final String ABSENT = "0";

	public static final String ATTEVD = "1";

	public static final String LATE = "2";

	public static final String LEAVE = "3";

	public static final String ASKFORLEAVE = "4";

	/**
	 * 消息类别
	 */
	public static final String MESSAGE_TYPE = "system";

	/**
	 * 系统消息
	 */
	public static final String MESSAGE_SYSTEM = "系统消息";

	/**
	 * 请选择文件分类
	 */
	public static final String SOURCES_CLASS_NO = "sources_class not null";

	/**
	 * 请选择文件
	 */
	public static final String FILE_NO = "file not null";

	/**
	 * 公共
	 */
	public static final String COMMON = "公共";

	/**
	 * 菜单审核状态:1通过审核，2表示未通过，3表示未审核
	 */
	public static final String CHECKED = "1";

	public static final String NO_PASS = "2";

	public static final String UNCHECK = "3";
	
	/**
	 * 处理过程标识:0表示未处理，1表示处理中，2表示已处理
	 */
	public static final String PROCESS_UN = "0";
	public static final String PROCESS_ING = "1";
	public static final String PROCESS_ED = "2";
	
	/**
	 * 排序标识
	 */
	public static final String ORDER_BY_ASC = "asc";
	public static final String ORDER_BY_DESC = "desc";
	
	/**
	 * 答案分隔符
	 */
	public static final String ANSWER_SEPARATOR = ",";

	public static final String[] SELECT_CODE = { "A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	//数字常量
	public static final String LAB_CONST0 =  "0" ;
	public static final String LAB_CONST1 =  "1" ;
	public static final String LAB_CONST2 =  "2" ;
	public static final String LAB_CONST3 =  "3" ;
	public static final String LAB_CONST4 =  "4" ;
	public static final String LAB_CONST5 =  "5" ;
	public static final String LAB_CONST6 =  "6" ;
}
