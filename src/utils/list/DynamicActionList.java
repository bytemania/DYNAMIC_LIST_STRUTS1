package utils.list;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class DynamicActionList extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	List list = new ArrayList();
	
	public List getList(){
		return list;
	}

	public void setList(int index, Object object){
		while(list.size() <= index)
			list.add(null);
		list.set(index, object);
	}
	
	public void removeList(int index){
		while(list.size() <= index)
			list.add(null);
		list.remove(index);
	}
	
	public void resetList(){
		list = new ArrayList();
	}
}
