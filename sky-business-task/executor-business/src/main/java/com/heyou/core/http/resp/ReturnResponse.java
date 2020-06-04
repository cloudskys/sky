package com.heyou.core.http.resp;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 返回前端或者移动端的数据
 * <p>
 *
 * @param <T>
 * @author
 */
public class ReturnResponse<T> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态
	 *
	 * @see StateEnum
	 */
	private int state;

	/**
	 * 返回消息内容
	 */
	private String msg;

	/**
	 * 业务code
	 */
	private int code;

	/**
	 * 返回数据
	 */
	private T data;

	public ReturnResponse() {
	}

	public ReturnResponse(int state) {
		this.state = state;
	}

	public ReturnResponse(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public ReturnResponse(int state, String msg, T data) {
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

	public enum StateEnum {
		SUCCESS(1), ERROR(2), UNSIGN(3);

		private int value;

		private StateEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	public int getState() {
		return state;
	}

	public ReturnResponse<T> setState(int state) {
		this.state = state;
		return this;
	}

	public int getCode() {
		return code;
	}

	public ReturnResponse<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ReturnResponse<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ReturnResponse<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * 设置成功
	 *
	 * @return
	 */
	public ReturnResponse<T> success() {
		this.state = StateEnum.SUCCESS.getValue();
		return this;
	}

	/**
	 * 设置失败
	 *
	 * @return
	 */
	public ReturnResponse<T> error() {
		this.state = StateEnum.ERROR.getValue();
		return this;
	}

	/**
	 * 设置失败
	 *
	 * @return
	 */
	public ReturnResponse<T> error(String msg) {
		this.msg = msg;
		this.state = StateEnum.ERROR.getValue();
		return this;
	}

	/**
	 * 设置unsign
	 *
	 * @return
	 */
	public ReturnResponse<T> unsign() {
		this.state = StateEnum.UNSIGN.getValue();
		return this;
	}

	public ReturnResponse fail(String msg) {
		this.state = ReturnResponse.StateEnum.ERROR.getValue();
		this.msg = msg;
		return this;
	}

	/**
	 * 返回是否成功
	 *
	 * @return
	 */
	public boolean checkSuccess() {
		return this.state == StateEnum.SUCCESS.getValue();
	}

	@Override
	public String toString() {
		return "ReturnResponse{" +
				"state=" + state +
				", msg='" + msg + '\'' +
				", code=" + code +
				", data=" + JSON.toJSONString(data) +
				'}';
	}
}
