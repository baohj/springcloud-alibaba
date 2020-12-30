package com.tjgx.product.common.exception;

public enum ErrorCode {

	MYB_000000("000000", "成功"),
	MYB_111111("111111", "系统错误,请联系管理员"),
	MYB_111001("111001", "必填项不能为空"),
	MYB_111002("111002", "被限流了"),
	MYB_111003("111003", "页码或分页条数错误"),
	MYB_111004("111004", "被降级了"),

	MYB_200000("200000", "微信token验证失败"),
	MYB_200001("200001", "被热点限流了"),
	MYB_200002("200002", "用户没登陆"),
	MYB_200003("200003", "被授权规则限制访问了"),
	MYB_200004("200004", "被系统规则限制了"),

	MYB_200006("200006", "当前地址不存在"),
	MYB_200007("200007", "地址Id错误"),
	MYB_200009("200009", "订单ID错误"),
	MYB_200010("200010", "is_good 只能传0或1"),
	MYB_200011("200011", "您不是该订单的主人,请重新输入订单ID"),
	MYB_200012("200012", "微信回调异常"),


	//优惠券
	MYB_210001("210001", "优惠券不存在");

	
	


	private String code;
	private String des;

	ErrorCode(String code, String des) {
		this.code = code;
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
