package utils.action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import utils.data.Friend;
import utils.form.MyForm;

public class DisplayAction extends Action{
		   
	    private final static String SUCCESS = "success";  
	   
	   
	    public ActionForward execute(ActionMapping mapping, ActionForm form,  
	            HttpServletRequest request, HttpServletResponse response)  
	            throws Exception {  
	         
	    	try{
	    		display(form);
	    	}
	    	catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    		
	         return mapping.findForward(SUCCESS);  
	  
	}
	    
	public void display( ActionForm form){
		MyForm myForm = (MyForm)form;
		Friend f;
		if(myForm.getList().size() == 0){
			f = new Friend();
			f.setFname("Antonio");
			f.setLname("Silva");

			myForm.setList(0, f);

			f = new Friend();
			f.setFname("Dario");
			f.setLname("Matos");

			myForm.setList(1, f);

			f = new Friend();
			f.setFname("Angela");
			f.setLname("Baptista");

			myForm.setList(2, f);
		}
		
		switch(myForm.getOperation().intValue()){
			case 1:
				System.out.println("ADDED");
				f = new Friend();
				myForm.setList(myForm.getList().size(), f);
				break;
			case 2:
				System.out.println("DELETE");
				System.out.println("LINE INDEX:" + myForm.getLine().intValue());
				myForm.removeList( myForm.getLine().intValue());
				break;
			case 3:
				System.out.println("Merge");
				Iterator it= myForm.getList().iterator();
				
				if(!it.hasNext())
					System.out.println("Where are my friends?");
				
				while(it.hasNext()){
					f = (Friend)it.next();
					System.out.println("FRIEND:" + f.getFname() + " " + f.getLname());
				}
				
				break;
			default:
				System.out.println("Nothing");
		}
		
		myForm.setOperation(new Integer(0));
		
	}    

}
