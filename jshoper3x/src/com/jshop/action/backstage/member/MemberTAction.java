package com.jshop.action.backstage.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.action.backstage.tools.MD5Code;
import com.jshop.action.backstage.tools.Serial;
import com.jshop.action.backstage.tools.StaticString;
import com.jshop.entity.MemberT;
import com.jshop.redis.dao.RedisMemberDao;
import com.jshop.redis.service.RedisMemberService;
import com.jshop.service.MemberTService;
import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class MemberTAction extends ActionSupport {
	
	private Serial serial;
	private MemberTService memberTService;
	private RedisMemberService redisMemberService;
	private String id;
	private String loginname;
	private String loginpwd;
	private String nick;
	private String realname;
	private String city;
	private String district;
	private String sex;
	private String whichsex;
	private String merrystatus;
	private String birthday;
	private String blood;
	private String constellation;
	private String des;
	private String email;
	private String mobile;
	private String qq;
	private String weixin;
	private String sinaweibo;
	private String tag;
	private Integer belove;
	private Integer loveother;
	private Integer postingcount;
	private String question;
	private String answer;
	private String userstate;
	private String headpath;
	private Date createtime;
	private String creatorid;
	private String query;//text
	private String qtype;//select
	private String basepath;
	private MemberT bean=new MemberT();
	private List<Map<String,Object>> rows=new ArrayList<Map<String,Object>>();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String message;
	private boolean sucflag;
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize = false)
	public RedisMemberService getRedisMemberService() {
		return redisMemberService;
	}

	public void setRedisMemberService(RedisMemberService redisMemberService) {
		this.redisMemberService = redisMemberService;
	}

	@JSON(serialize = false)
	public MemberTService getMemberTService() {
		return memberTService;
	}

	public void setMemberTService(MemberTService memberTService) {
		this.memberTService = memberTService;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWhichsex() {
		return whichsex;
	}

	public void setWhichsex(String whichsex) {
		this.whichsex = whichsex;
	}

	public String getMerrystatus() {
		return merrystatus;
	}

	public void setMerrystatus(String merrystatus) {
		this.merrystatus = merrystatus;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getSinaweibo() {
		return sinaweibo;
	}

	public void setSinaweibo(String sinaweibo) {
		this.sinaweibo = sinaweibo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getBelove() {
		return belove;
	}

	public void setBelove(Integer belove) {
		this.belove = belove;
	}

	public Integer getLoveother() {
		return loveother;
	}

	public void setLoveother(Integer loveother) {
		this.loveother = loveother;
	}

	public Integer getPostingcount() {
		return postingcount;
	}

	public void setPostingcount(Integer postingcount) {
		this.postingcount = postingcount;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public String getHeadpath() {
		return headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public MemberT getBean() {
		return bean;
	}

	public void setBean(MemberT bean) {
		this.bean = bean;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 增加会员
	 * @return
	 */
	@Action(value = "saveMemberT", results = { @Result(name = "json", type = "json") })
	public String saveMemberT(){
		if(StringUtils.isNotBlank(this.getLoginname())&&StringUtils.isNotBlank(this.getLoginpwd())){
			List<MemberT>list=this.getMemberTService().findMemberTByloginname(this.getLoginname().trim());
			if(list.isEmpty()){
				MD5Code md5=new MD5Code();
				MemberT mt=new MemberT();
				mt.setId(this.getSerial().Serialid(Serial.MEMBER));
				mt.setLoginname(this.getLoginname().trim());
				mt.setLoginpwd(md5.getMD5ofStr(this.getLoginpwd().trim()));
				mt.setNick(this.getNick().trim());
				mt.setRealname(this.getRealname().trim());
				mt.setCity(this.getCity().trim());
				mt.setDistrict(this.getDistrict().trim());
				mt.setSex(this.getSex().trim());
				mt.setWhichsex(this.getWhichsex().trim());
				mt.setMerrystatus(this.getMerrystatus().trim());
				mt.setBirthday(this.getBirthday().trim());
				mt.setBlood(this.getBlood().trim());
				mt.setConstellation(this.getConstellation().trim());
				mt.setDes(this.getDes().trim());
				mt.setEmail(this.getEmail().trim());
				mt.setMobile(this.getMobile().trim());
				mt.setQq(this.getQq().trim());
				mt.setWeixin(this.getWeixin().trim());
				mt.setSinaweibo(this.getSinaweibo().trim());
				mt.setTag(this.getTag().trim());
				mt.setBelove(0);//关注0
				mt.setLoveother(0);//喜欢别人0
				mt.setPostingcount(0);//发布信息总数0
				mt.setQuestion(this.getQuestion().trim());
				mt.setAnswer(this.getAnswer().trim());
				mt.setMemberstate(StaticString.MEMBERSTATE_ONE_NUM);//激活
				mt.setHeadpath(this.getHeadpath().trim());
				mt.setCreatetime(BaseTools.systemtime());
				mt.setCreatorid(BaseTools.adminCreateId());
				mt.setUpdatetime(mt.getCreatetime());
				mt.setVersiont(0);
				this.getMemberTService().saveMemberT(mt);
//				//放置到redis中去
//				this.getRedisMemberService().save(mt);
				this.setSucflag(true);
				return "json";
			}else{
				this.setMessage("该用户已经存在");
				return "json";
			}
			
		}
		return "json";
		
	}
	
	/**
	 * 获取所有会员列表
	 * @return
	 */
	@Action(value = "findAllMemberT", results = {@Result(name = "json",type="json")})
	public String findAllMemberT(){
		if(StaticString.SC.equals(this.getQtype())){
			this.findDefaultAllMemberT();
			
		}else{
			if(StringUtils.isBlank(this.getQtype())){
				return "json";
			}else{
				return "json";
			}
		}
		return "json";
	}

	private void findDefaultAllMemberT() {
		int currentPage=page;
		int lineSize=rp;
		total=this.getMemberTService().countfindAllMemberT();
		List<MemberT>list=this.getMemberTService().findAllMemberT(currentPage, lineSize);
		if(!list.isEmpty()){
			this.ProcessMemberList(list);
		}
	}

	private void ProcessMemberList(List<MemberT> list) {
		for(Iterator it=list.iterator();it.hasNext();){
			MemberT mt=(MemberT) it.next();
			if(mt.getSex().equals(StaticString.ONE)){
				mt.setSex(StaticString.SEXMAN);
			}else{
				mt.setSex(StaticString.SEXFEMAL);
			}
			if(mt.getMemberstate().equals(StaticString.MEMBERSTATE_ONE_NUM)){
				mt.setMemberstate(StaticString.DOACTIVE);
			}else{
				mt.setMemberstate(StaticString.DONOTACTIVE);
			}
			Map<String,Object>cellMap=new HashMap<String, Object>();
			cellMap.put("id", mt.getId());
			cellMap.put("cell", new Object[]{
				mt.getLoginname(),
				mt.getNick(),
				mt.getRealname(),
				mt.getCity(),
				mt.getSex(),
				mt.getMobile(),
				mt.getQq(),
				mt.getWeixin(),
				mt.getSinaweibo(),
				getPersonalTag(mt.getTag()),
				mt.getMemberstate(),
				BaseTools.formateDbDate(mt.getCreatetime()),
				mt.getCreatorid(),
				"<a id='editmember' href='member.jsp?operate=edit&folder=member&id="+mt.getId()+"' name='editmember'>[编辑]</a>"
			});
			rows.add(cellMap);
		}
		
	}

	/**
	 * 转化个人标签
	 * @param tag
	 * @return
	 */
	private String getPersonalTag(String tag){
		String tagstr = "";
		if(tag!=null){
			JSONArray ja=(JSONArray) JSONValue.parse(tag);
			int jsonsize=ja.size();
			for(int i=0;i<jsonsize;i++){
				JSONObject jo=(JSONObject) ja.get(i);
				tagstr+=jo.get(StaticString.TAG).toString()+",";
			}
			tagstr="["+tagstr.substring(0,tagstr.length()-1)+"]";
		}
		return tagstr;
	}
	
	
	/**
	 * 更新会员
	 * @return
	 */
	@Action(value = "updateMemberT", results = {@Result(name = "json",type="json")})
	public String updateMemberT(){
		if(StringUtils.isBlank(this.getId())){
			return "json";
		}
		bean=this.getMemberTService().findMemberTById(this.getId().trim());
		if(bean!=null){
			bean.setNick(this.getNick().trim());
			bean.setRealname(this.getRealname().trim());
			bean.setCity(this.getCity().trim());
			bean.setDistrict(this.getDistrict().trim());
			bean.setSex(this.getSex().trim());
			bean.setWhichsex(this.getWhichsex().trim());
			bean.setMerrystatus(this.getMerrystatus().trim());
			bean.setBirthday(this.getBirthday().trim());
			bean.setBlood(this.getBlood().trim());
			bean.setConstellation(this.getConstellation().trim());
			bean.setDes(this.getDes().trim());
			bean.setEmail(this.getEmail().trim());
			bean.setMobile(this.getMobile().trim());
			bean.setQq(this.getQq().trim());
			bean.setWeixin(this.getWeixin().trim());
			bean.setSinaweibo(this.getSinaweibo().trim());
			bean.setTag(this.getTag().trim());
			bean.setQuestion(this.getQuestion().trim());
			bean.setAnswer(this.getAnswer().trim());
			bean.setMemberstate(StaticString.ONE);//激活
			bean.setHeadpath(this.getHeadpath().trim());
			bean.setUpdatetime(BaseTools.systemtime());
			bean.setCreatorid(BaseTools.adminCreateId());
			bean.setVersiont(bean.getVersiont()+1);
			this.getMemberTService().updateMemberT(bean);
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	/**
	 * 根据主键id获取会员
	 * @return
	 */
	@Action(value = "findMemberTById", results = {@Result(name = "json",type="json")})
	public String findMemberTById(){
		if(StringUtils.isBlank(this.getId())){
			return "json";
		}
//		MemberT mt=this.getRedisMemberService().read(this.getId());
//		if(mt!=null){
//			System.out.println(mt.getNick());
//		}
		bean=this.getMemberTService().findMemberTById(this.getId().trim());
		if(bean!=null){
			bean.setTag(this.getPersonalTag(bean.getTag()));
			this.setBasepath(BaseTools.getBasePath());
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	
	/**
	 * 批量删除会员
	 * @return
	 */
	@Action(value = "delMemberT", results = {@Result(name = "json",type="json")})
	public String delMemberT(){
		if(StringUtils.isBlank(this.getId())){
			return "json";
		}
		String []strs=StringUtils.split(this.getId(), ",");
		if(this.getMemberTService().delMemberT(strs)>0){
			this.setSucflag(true);
			return "json";
		}
		return "json";
		
	}
	
	/**
	 * 根据登录名查询会员
	 * @return
	 */
	@Action(value = "findMemberByloginname", results = {@Result(name = "json",type="json")})
	public String findMemberByloginname(){
		if(StringUtils.isBlank(this.getLoginname())){
			return "json";
		}
		List<MemberT>beanlist=this.getMemberTService().findMemberTByloginname(this.getLoginname());
		if(!beanlist.isEmpty()){
			this.setBean(beanlist.get(0));
			this.setSucflag(true);
			return "json";
		}
		return "json";
	}
	
	
	
}
