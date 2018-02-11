package com.jsjf.model.sys;

import java.math.BigDecimal;
import java.util.Date;

public class DrProductInvest {

	//主键ID
	private Integer id;
	//会员ID
	private Integer uid;
	//产品ID
	private Integer pid;
	//投资总金额
	private BigDecimal amount;
	//投资时间
	private Date investTime;
	//状态(0-未处理 1-成功 2-失败,3=已回款)
	private Integer status;
	//实际投资金额
	private BigDecimal factAmount;
	//利息
	private BigDecimal interest;
	//实收利息
	private BigDecimal factInterest;
	//其它活动利率
	private BigDecimal specialRate;
	//优惠券ID
	private Integer fid;
	//体验金id集合,以","分割
	private String experience;
	//加入方式0为PC,1为IOS,2为android,3为微信
	private Integer joinType;
	//协议编号
	private String agreementNo;
	//划拨备注
	private String message;
	//划拨流水号
	private String remitMchntTxnSsn;
	//预授权合同号
	private String contract_no;
	//报文流水
	private String fuiouMessageNo;
	//报备状态：1报备中 2报备成功 3报备失败
	private Integer fileStatus;
	//失败原因
	private String failureCause;
	//投标流水号
	private String mchnt_txn_ssn;
	//用户奖励类型()
	private String rewarsType;
	//0-未发放，1-已发放
	private Integer rewarsStatus;
	//安心签合同编号 
	private String anxinContractNo;


	public Integer getId(){
		return id;
	}
	public Integer getUid(){
		return uid;
	}
	public Integer getPid(){
		return pid;
	}
	public BigDecimal getAmount(){
		return amount;
	}
	public Date getInvestTime(){
		return investTime;
	}
	public Integer getStatus(){
		return status;
	}
	public BigDecimal getFactAmount(){
		return factAmount;
	}
	public BigDecimal getInterest(){
		return interest;
	}
	public BigDecimal getFactInterest(){
		return factInterest;
	}
	public BigDecimal getSpecialRate(){
		return specialRate;
	}
	public Integer getFid(){
		return fid;
	}
	public String getExperience(){
		return experience;
	}
	public Integer getJoinType(){
		return joinType;
	}
	public String getAgreementNo(){
		return agreementNo;
	}
	public String getMessage(){
		return message;
	}
	public String getRemitMchntTxnSsn(){
		return remitMchntTxnSsn;
	}
	public String getContractNo(){
		return contract_no;
	}
	public String getFuiouMessageNo(){
		return fuiouMessageNo;
	}
	public Integer getFileStatus(){
		return fileStatus;
	}
	public String getFailureCause(){
		return failureCause;
	}
	public String getMchntTxnSsn(){
		return mchnt_txn_ssn;
	}
	public String getRewarsType(){
		return rewarsType;
	}
	public Integer getRewarsStatus(){
		return rewarsStatus;
	}
	public String getAnxinContractNo(){
		return anxinContractNo;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setUid(Integer uid){
		this.uid=uid;
	}
	public void setPid(Integer pid){
		this.pid=pid;
	}
	public void setAmount(BigDecimal amount){
		this.amount=amount;
	}
	public void setInvestTime(Date investTime){
		this.investTime=investTime;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public void setFactAmount(BigDecimal factAmount){
		this.factAmount=factAmount;
	}
	public void setInterest(BigDecimal interest){
		this.interest=interest;
	}
	public void setFactInterest(BigDecimal factInterest){
		this.factInterest=factInterest;
	}
	public void setSpecialRate(BigDecimal specialRate){
		this.specialRate=specialRate;
	}
	public void setFid(Integer fid){
		this.fid=fid;
	}
	public void setExperience(String experience){
		this.experience=experience;
	}
	public void setJoinType(Integer joinType){
		this.joinType=joinType;
	}
	public void setAgreementNo(String agreementNo){
		this.agreementNo=agreementNo;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public void setRemitMchntTxnSsn(String remitMchntTxnSsn){
		this.remitMchntTxnSsn=remitMchntTxnSsn;
	}
	public void setContractNo(String contract_no){
		this.contract_no=contract_no;
	}
	public void setFuiouMessageNo(String fuiouMessageNo){
		this.fuiouMessageNo=fuiouMessageNo;
	}
	public void setFileStatus(Integer fileStatus){
		this.fileStatus=fileStatus;
	}
	public void setFailureCause(String failureCause){
		this.failureCause=failureCause;
	}
	public void setMchntTxnSsn(String mchnt_txn_ssn){
		this.mchnt_txn_ssn=mchnt_txn_ssn;
	}
	public void setRewarsType(String rewarsType){
		this.rewarsType=rewarsType;
	}
	public void setRewarsStatus(Integer rewarsStatus){
		this.rewarsStatus=rewarsStatus;
	}
	public void setAnxinContractNo(String anxinContractNo){
		this.anxinContractNo=anxinContractNo;
	}
}
