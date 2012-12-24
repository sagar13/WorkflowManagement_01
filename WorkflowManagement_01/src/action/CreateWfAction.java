package action;

import java.util.ArrayList;

import utility.DBService;

import com.opensymphony.xwork2.ActionSupport;
import model.*;

public class CreateWfAction extends ActionSupport {

	private String wf_name;
	private String wf_description;
	private String wf_domain;

	public String execute() {
		WorkflowMaster objWorkflow = new WorkflowMaster(this.getWf_name(),
				this.getWf_description(), this.getWf_domain(), null);/* update this null value */
		String insertQuery = "INSERT INTO `workflow_master`(`workflow_name`, `workflow_description`, `workflow_domain`) VALUES (?,?,?)";
		ArrayList<String> values = new ArrayList<String>();
		values.add(objWorkflow.getWorkflowName());
		values.add(objWorkflow.getWorkflowDescription());
		values.add(objWorkflow.getWorkflowDomain());

		int result = DBService.insertObjectInDB(insertQuery, values);

		if (result == 0)
			return "error";
		else
			return "createwf_continue";
		// return "createwf_continue" //to continue adding details

	}

	public String getWf_name() {
		return wf_name;
	}

	public void setWf_name(String wf_name) {
		this.wf_name = wf_name;
	}

	public String getWf_description() {
		return wf_description;
	}

	public void setWf_description(String wf_description) {
		this.wf_description = wf_description;
	}

	public String getWf_domain() {
		return wf_domain;
	}

	public void setWf_domain(String wf_domain) {
		this.wf_domain = wf_domain;
	}

}
