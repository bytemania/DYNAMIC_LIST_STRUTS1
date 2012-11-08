package utils.form;

import utils.list.DynamicActionList;

public class MyForm extends DynamicActionList {

	private static final long serialVersionUID = 1L;
	
	private Integer operation = new Integer(0);
	private Integer line = new Integer(-1);
	
	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Integer getOperation() {
		return operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}
	
}
