package org.jsp.demo.helper;

public class ResponseStructure<T> {
	int Statuscode;
	String messege;
	T data;

	public int getStatuscode() {
		return Statuscode;
	}

	public void setStatuscode(int statuscode) {
		Statuscode = statuscode;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
