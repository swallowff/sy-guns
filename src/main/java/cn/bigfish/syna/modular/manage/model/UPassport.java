package cn.bigfish.syna.modular.manage.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户通行证表
 * </p>
 *
 * @author yu
 * @since 2018-12-19
 */
@TableName("sy_u_passport")
public class UPassport extends Model<UPassport> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 登录名
     */
    @TableField("login_name")
    private String loginName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String telephone;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录盐值
     */
    private String salt;
    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regTime;
    /**
     * 注册IP
     */
    @TableField("reg_ip")
    private String regIp;
    /**
     * 注册方式
     */
    @TableField("reg_type")
    private Integer regType;
    /**
     * 注册类型
     */
    @TableField("reg_from")
    private Integer regFrom;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 冻结原因
     */
    private String reason;
    /**
     * 备注
     */
    private String memo;
    /**
     * 是否测试
     */
    @TableField("test")
    private Integer test;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getRegTime() {
        return regTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public Integer getRegFrom() {
        return regFrom;
    }

    public void setRegFrom(Integer regFrom) {
        this.regFrom = regFrom;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer isTest) {
        this.test = test;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UPassport{" +
        ", id=" + id +
        ", loginName=" + loginName +
        ", email=" + email +
        ", telephone=" + telephone +
        ", password=" + password +
        ", salt=" + salt +
        ", regTime=" + regTime +
        ", regIp=" + regIp +
        ", regType=" + regType +
        ", regFrom=" + regFrom +
        ", status=" + status +
        ", reason=" + reason +
        ", memo=" + memo +
        ", isTest=" + test +
        "}";
    }
}
