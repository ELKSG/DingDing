package com.example.dingding.utils;


/**
 * 返回结果不成功的状态的枚举类
 */
public enum ResultErrorEnum {
    Not_Litigant(101, "找不到对应当事人！"),
    Not_LawCase(101, "找不到对应案件!"),
    Not_SendType(101, "请选择对应的送达类型!"),
    Not_LawCaseId(102, "案件id不能为空!"),
    Not_Diploms(101, "请选择要送达的文书!"),
    Not_Message_Template(101, "找不到短信模板!"),
    Not_Found_Diploms(101, "没有找到对应的文书!"),
    Not_Build_Diploms(102, "尚未生成历史文书!"),
    Not_Court(101, "找不到对应的法院!"),
    Not_Found_Law_Case(101, "找不到对应案件!"),
    Not_Found_Brief(101, "找不到对应的案由!"),
    Not_Oddnumber(101, "请输入快递单号!"),
    Not_Send_Address(101, "请输入送达地址!"),
    Not_EmailAddress(101, "请输入邮箱地址!"),
    Oddnumber_Already(101, "快递单号已存在!"),
    Not_Send_Court_Name(101, "请输入送达法院名称!"),
    Not_Send_Court_Address(101, "请输入送达法院地址!"),
    Not_Send_Court_Telephone(101, "请输入送达法院联系电话!"),
    Not_Native_Place(101, "请输入户籍地址!"),
    Not_Send_Phone(101, "请输入电话号码!"),
    Moblie_Not_Accord(101, "手机号码格式不正确!"),
    Not_All_Name(101, "请输入委托法院全称!"),
    Not_Send_Latter(101, "请选择委托送达函!"),
    Not_Arrow_Choice_Latter(101, "不是委托送达，不能只选择委托送达函!"),
    Not_Schedulding(101, "当前案件尚未排班或排班时间为空!"),
    Not_Tribunal_Name(101, "当前案件排班的开庭法庭尚未确定或排班的法庭名称为空!"),
    Not_WxCode_Or_Bulid_Diploms_Error(101, "文书生成失败!"),
    Not_Diploms_Template(101, "没有找到对应的文书模板!"),
    Not_Litigant_Diploms(101, "没有找到当事人的文书!"),
    Not_Sms_Message_Template(101, "找不到短信模板!"),
    Not_Send_Type(101, "请选择正确的送达类型"),
    Not_Arrow_Send_Stub(101, "不可以只发送传票存根!"),
    Not_Email_Template(101, "没有找到邮件模板!"),
    Email_Send_Error(101, "邮件发送失败!"),
    Excute_Diploms_Not_WxCode(101, "裁判文书没有二维码!"),
    Not_Judge_Id_Or_Clerk_Id(101, "请选择法官或书记员!"),
    Not_Judge(101, "找不到对应法官!"),
    Not_Clerk(101, "找不到对应书记员!"),
    Law_Case_Is_Complete(101, "排班失败，请确认案件信息是否完整!"),
    Not_Set_Schedulding_Day(102, "没有设置自动排班的计算天数!"),
    Not_Tribunal(101, "当前法院没有设置下属法庭!"),
    Not_Set_Schedulding_Rule(101, "请设定当前法庭的排班规则!"),
    Not_Set_Day_Time(101, "没有设置法院的一天排班次数!"),
    Not_Get_Validate_Code(101, "请先获取验证码！"),
    Not_Validate_Code(101, "请输入验证码！"),
    Validate_Code_Error(101, "验证码错误！"),
    Not_Username_Or_Password(101, "请输入账号或密码!"),
    Username_Or_Password_Error(101, "账号或密码错误!"),
    Not_Found_Login_Type(101, "登录类型不符!"),
    Not_Certification(102, "请进行实名认证!"),
    Not_LoginId(101, "登录失败,请确认登录用户是否存在!"),
    Not_Login_Type(101, "请选择登录的角色类型!"),
    Not_Set_Role(101, "没有设置用户角色"),
    Not_Found_Role_Type(101, "找不到对应的角色!"),
    Not_Found_Schedulding_Rule(101, "没有找到排班规则，请添加!"),
    Not_Found_Rule(102, "没有找到排班规则，请添加!"),
    Not_Found_Summer_Schedulding_Rule(101, "没有找到夏令时排班规则!"),
    Not_Found_Ordiary_Summer_Schedulding_Rule(101, "请先添加普通夏令时排班规则!"),
    Schedulding_Rule_Aready(101, "排班规则已存在!"),
    InValid_Time(101, "请选择正确的时间!"),
    Holiday(102, "当前时间是节假日!"),
    Not_Choice_Tribunal(101, "请选择法庭地点!"),
    Not_Group_Day_Time(101, "请选择组合排班的组合规则!"),
    Not_Choice_Bing_Schedulding_Rule(101, "没有选择夏令时对应的冬令时排班规则!"),
    Not_Choice_Winter_Schedulding_Rule(101, "设置夏令时排班规则,请选择绑定的冬令时排班规则!"),
    Not_Found_Winter_Schedulding_Rule(102, "请先添加当前夏令时排班规则对应的冬令时排班规则!"),
    Winter_Schedulding_Rule_Aready(102, "修改的排班规则和绑定的冬令时规则是同一个规则!"),
    Not_Support_Winter_Swap_Summer(101, "不支持冬令时转换夏令时,请自行添加一条夏令时排班规则!"),
    Schedulding_Not_Set_Tribunal(101, "排班规则没有关联法庭!"),
    Not_Found_Law_Case_Count(101, "没有找到案件时间节点统计数据!"),
    Not_Found_Judge(101, "没有找到对应的法院工作人员!"),
    Not_Set_Super(102, "没有设置超级管理员!"),
    Not_Found_Court(101, "没有找到对应的法院!"),
    Validate_Date_Format(101, "时间格式错误!"),
    Aready_Exist(101, "请勿重复添加!"),
    Not_Choice_Start_Time(101, "请选择开庭时间!"),
    Not_Found_Schedulding(101, "没有找到排班记录!"),
    Aready_Open(101, "已开庭的案件不能排班或修改!"),
    Group_Day_Time_Is_Null(101, "组合排班的排班规则为空!"),
    Validate_Start_Time(101, "开庭场次无效!"),
    Aready_Schedulding(101, "请勿重复排班!"),
    Not_Found_Judge_Vacation(101, "请选择正确的休假"),
    Not_Choice_Year_Month(101, "开庭的年份或月份不能为空"),
    Schedulding_State_Error(101, "请选择正确的开庭状态"),
    Not_Found_Login_Info(101, "找不到对应用户信息!"),
    Not_Found_Litigant(102, "找不到对应当事人!"),
    Not_Choice_Litigant(101, "请选择当事人!"),
    Not_Found_Lawyer(102, "找不到对应代理人!"),
    Schedulding_Not_Newly(101, "当前选择的排班不是最新排班!"),
    Not_Found_Progress(101, "请选择正确的案件所处阶段!"),
    Build_Type_Error(101, "生成类型不符!"),
    Not_Choice_Diploms(101, "请选择文书!"),
    Not_Found_Diploms_Template(101, "找不到对应的文书模板!"),
    Not_Found_LitigationStatus(101, "找不到对应诉讼地位"),
    Validate_Case_No(101, "案号不符合规范"),
    Not_Choice_Send(101, "请选择送达信息!"),
    Not_Found_Email_Template(101, "没有找到对应的邮件模板!"),
    Not_Choice_Address_Or_Oddnumber(101, "请选择收件地址或邮单号!"),
    Not_Found_Send_Type(101, "请选择送达类型!"),
    Validate_Email_Info(101, "发送邮件信息不全!"),
    Not_Found_Send(101, "找不到对应送达记录!"),
    Not_Telephone_Code(101, "请输入唯一识别码!"),
    Not_Telephone_Note(101, "找不到通话记录!"),
    Not_Choice_Send_Person(101, "请选择送达对象!"),
    Aready_Confirm_Send(101, "请勿重复确认送达!"),
    Merge_Diploms_Error(101, "合并文书失败,请确认文书是否存在!"),
    Not_Found_Notice(101, "找不到对应的消息通知记录!"),
    Not_Found_Notice_List(102, "找不到对应的消息通知列表！"),
    Not_Found_Tribunals(101, "没有找到审判法庭！"),
    Batch_Parm_Error(102, "参数错误!请确认参数是否符合规范!"),
    Not_Litigant_Status_All(101, "缺少原告或被告!"),
    Build_Wx_Code_Diploms_Error(101, "生成微信二维码文书失败!请确认参数是否正确!"),
    Not_Found_Law_Case_No(101, "没有找到案件编号!"),
    File_Name_Or_Suffix_Not_Null(101, "文件名称或后缀不能为空!"),
    Not_Definition_Diploms(101, "未定义的卷宗类型!"),
    Not_choice_File_Type(101, "请选择卷宗类型!"),
    Validate_Litigant_Or_LitgantStatus(101, "当事人或诉讼地位不能为空!"),
    Validate_Send_Or_Send_Number(101, "送达记录或送达次数不能为空!"),
    Dir_Type_Case_No_Not_Null(101, "卷宗的案号或文书名称不能为空!"),
    Not_Choice_Dir_Type(101, "请选择卷宗的文件列表或卷宗目录!"),
    Not_Found_File_Name(101, "文件名称不能为空!"),
    Not_Found_Dir_Type(101, "没有找到对应的电子卷宗目录!"),
    Not_Found_Dir_Type_File_List(101, "没有找到对应的文件清单列表!"),
    Not_Found_File_Path_Or_File_Name(101, "没有找到文件路径或文件名称!"),
    Save_File_Error(101, "保存文件失败!"),
    Not_Found_Case_Table(102, "没有找到对应的卷宗!"),
    Not_choice_Download_File(101, "请选择要下载的文件!"),
    Not_choice_Vaild_File(101, "请选择要验证的文件!"),
    Not_Found_Judge_Image(101, "没有找到法官照片!"),
    Storage_Rrror(101, "存储空间类型非法!"),
    Send_Way_Error(101, "送达方式错误!"),
    File_Type_Error(101, "上传文件类型错误!"),
    Not_Found_Close_Type(101, "没有找到对应结案类型!"),
    Close_Law_Case_Error(101, "请勿重复结案!"),
    Validate_Role_Type(101, "角色类型非法!"),
    Not_Set_Role_Type(101, "登陆角色未定义!"),
    Validate_Login_Error(101, "请勿重复登陆!"),
    Not_Found_Yp_Diploms(101, "未定义易判系统的文书!"),
    Not_Choice_Law_Case(101, "请选择案件!"),
    Build_Diploms_Error(101, "文书生成失败!"),
    Not_Found_Judge_Name(101,"法院工作人员未定义名字!"),
    Not_Found_PeopleAssessor(101, "没有找到对应陪审员!"),
    Not_Found_PeopleAssessor_Name(101, "陪审员未定义名称!"),
    Zip_Error(101,"文件压缩失败!"),
    Not_Wechat_Template(101, "找不到微信模板！"),
    Not_Wechat_Number(101, "微信号不能为空！")
    ;
    private Integer state;
    private String message;

    ResultErrorEnum(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }
}
