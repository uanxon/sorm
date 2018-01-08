package com.uanxon.model;

import java.util.Date;
import java.util.Date;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Date;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;

public class DrClaimsLoan {

	//借款合同编号
	private String no;
	//还款周期
	private Integer repayDeadline;
	//还款日期
	private Date endDate;
	//添加人
	private Integer addUser;
	//开户行
	private String bankName;
	//债权类型: 1:信用贷,2车贷,3房贷
	private Integer type;
	//还款方式
	private Integer repayType;
	//修改时间
	private Date updDate;
	//是否要审核修改:0:否,1:是
	private Integer isAuditEdit;
	//贷款户名
	private String loanName;
	//违约金比例
	private BigDecimal defaultersRate;
	//
	private BigDecimal serviceCharge;
	//融资顾问时间开始
	private Date creditDate;
	//日期模式
	private String dateType;
	//应收利息
	private BigDecimal receiveInterest;
	//年利率
	private BigDecimal rate;
	//修改人
	private Integer updUser;
	//融资申请单编号（代收付系统债权唯一编号）
	private String payLoanNo;
	//账号
	private String bankNo;
	//融资顾问期限
	private Integer financingDeadline;
	//币种
	private String currency;
	//贷款项目基本信息
	private Integer id;
	//管理咨询费率
	private BigDecimal advisoryRate;
	//贷款期限（天）
	private String loanDeadline;
	//融资顾问时间结束
	private Date overDate;
	//贷款用途
	private String loanUse;
	//1-企业借款 2-个人借款
	private Integer borrowingType;
	//0-对私 1-对公
	private Integer cardFlag;
	//债权来源（1-聚胜财富，2-代收付）
	private Integer claimsOriginate;
	//关闭和显示资产，默认为1为显示状态，0为关闭状态
	private Integer showStatus;
	//添加时间
	private Date addDate;
	//开户行地址
	private String bankAddress;
	//贷款金额
	private BigDecimal loanAmount;
	//逾期罚息比率
	private BigDecimal overduePenaltyRate;
	//风险保证金比例
	private BigDecimal riskRate;
	//逾期利率
	private BigDecimal overdueRate;
	//产品名称
	private String name;
	//服务费率
	private BigDecimal serviceRate;
	//放款日期
	private Date startDate;
	//债权状态
	private Integer status;
	//渠道商户id
	private Integer cid;


	public String getno(){
		return no;
	}
	public Integer getrepayDeadline(){
		return repayDeadline;
	}
	public Date getendDate(){
		return endDate;
	}
	public Integer getaddUser(){
		return addUser;
	}
	public String getbankName(){
		return bankName;
	}
	public Integer gettype(){
		return type;
	}
	public Integer getrepayType(){
		return repayType;
	}
	public Date getupdDate(){
		return updDate;
	}
	public Integer getisAuditEdit(){
		return isAuditEdit;
	}
	public String getloanName(){
		return loanName;
	}
	public BigDecimal getdefaultersRate(){
		return defaultersRate;
	}
	public BigDecimal getserviceCharge(){
		return serviceCharge;
	}
	public Date getcreditDate(){
		return creditDate;
	}
	public String getdateType(){
		return dateType;
	}
	public BigDecimal getreceiveInterest(){
		return receiveInterest;
	}
	public BigDecimal getrate(){
		return rate;
	}
	public Integer getupdUser(){
		return updUser;
	}
	public String getpayLoanNo(){
		return payLoanNo;
	}
	public String getbankNo(){
		return bankNo;
	}
	public Integer getfinancingDeadline(){
		return financingDeadline;
	}
	public String getcurrency(){
		return currency;
	}
	public Integer getid(){
		return id;
	}
	public BigDecimal getadvisoryRate(){
		return advisoryRate;
	}
	public String getloanDeadline(){
		return loanDeadline;
	}
	public Date getoverDate(){
		return overDate;
	}
	public String getloanUse(){
		return loanUse;
	}
	public Integer getborrowingType(){
		return borrowingType;
	}
	public Integer getcardFlag(){
		return cardFlag;
	}
	public Integer getclaimsOriginate(){
		return claimsOriginate;
	}
	public Integer getshowStatus(){
		return showStatus;
	}
	public Date getaddDate(){
		return addDate;
	}
	public String getbankAddress(){
		return bankAddress;
	}
	public BigDecimal getloanAmount(){
		return loanAmount;
	}
	public BigDecimal getoverduePenaltyRate(){
		return overduePenaltyRate;
	}
	public BigDecimal getriskRate(){
		return riskRate;
	}
	public BigDecimal getoverdueRate(){
		return overdueRate;
	}
	public String getname(){
		return name;
	}
	public BigDecimal getserviceRate(){
		return serviceRate;
	}
	public Date getstartDate(){
		return startDate;
	}
	public Integer getstatus(){
		return status;
	}
	public Integer getcid(){
		return cid;
	}
	public void setno(String no){
		this.no=no;
	}
	public void setrepayDeadline(Integer repayDeadline){
		this.repayDeadline=repayDeadline;
	}
	public void setendDate(Date endDate){
		this.endDate=endDate;
	}
	public void setaddUser(Integer addUser){
		this.addUser=addUser;
	}
	public void setbankName(String bankName){
		this.bankName=bankName;
	}
	public void settype(Integer type){
		this.type=type;
	}
	public void setrepayType(Integer repayType){
		this.repayType=repayType;
	}
	public void setupdDate(Date updDate){
		this.updDate=updDate;
	}
	public void setisAuditEdit(Integer isAuditEdit){
		this.isAuditEdit=isAuditEdit;
	}
	public void setloanName(String loanName){
		this.loanName=loanName;
	}
	public void setdefaultersRate(BigDecimal defaultersRate){
		this.defaultersRate=defaultersRate;
	}
	public void setserviceCharge(BigDecimal serviceCharge){
		this.serviceCharge=serviceCharge;
	}
	public void setcreditDate(Date creditDate){
		this.creditDate=creditDate;
	}
	public void setdateType(String dateType){
		this.dateType=dateType;
	}
	public void setreceiveInterest(BigDecimal receiveInterest){
		this.receiveInterest=receiveInterest;
	}
	public void setrate(BigDecimal rate){
		this.rate=rate;
	}
	public void setupdUser(Integer updUser){
		this.updUser=updUser;
	}
	public void setpayLoanNo(String payLoanNo){
		this.payLoanNo=payLoanNo;
	}
	public void setbankNo(String bankNo){
		this.bankNo=bankNo;
	}
	public void setfinancingDeadline(Integer financingDeadline){
		this.financingDeadline=financingDeadline;
	}
	public void setcurrency(String currency){
		this.currency=currency;
	}
	public void setid(Integer id){
		this.id=id;
	}
	public void setadvisoryRate(BigDecimal advisoryRate){
		this.advisoryRate=advisoryRate;
	}
	public void setloanDeadline(String loanDeadline){
		this.loanDeadline=loanDeadline;
	}
	public void setoverDate(Date overDate){
		this.overDate=overDate;
	}
	public void setloanUse(String loanUse){
		this.loanUse=loanUse;
	}
	public void setborrowingType(Integer borrowingType){
		this.borrowingType=borrowingType;
	}
	public void setcardFlag(Integer cardFlag){
		this.cardFlag=cardFlag;
	}
	public void setclaimsOriginate(Integer claimsOriginate){
		this.claimsOriginate=claimsOriginate;
	}
	public void setshowStatus(Integer showStatus){
		this.showStatus=showStatus;
	}
	public void setaddDate(Date addDate){
		this.addDate=addDate;
	}
	public void setbankAddress(String bankAddress){
		this.bankAddress=bankAddress;
	}
	public void setloanAmount(BigDecimal loanAmount){
		this.loanAmount=loanAmount;
	}
	public void setoverduePenaltyRate(BigDecimal overduePenaltyRate){
		this.overduePenaltyRate=overduePenaltyRate;
	}
	public void setriskRate(BigDecimal riskRate){
		this.riskRate=riskRate;
	}
	public void setoverdueRate(BigDecimal overdueRate){
		this.overdueRate=overdueRate;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setserviceRate(BigDecimal serviceRate){
		this.serviceRate=serviceRate;
	}
	public void setstartDate(Date startDate){
		this.startDate=startDate;
	}
	public void setstatus(Integer status){
		this.status=status;
	}
	public void setcid(Integer cid){
		this.cid=cid;
	}
}
