package model;

import java.util.ArrayList;

public class WorkflowMaster {
	
	private int workflowID;
	private String workflowName;
	private String workflowDescription;
	private String workflowDomain;
	private ArrayList<WorkflowDetails> objWorkFlowDetails;
	
	public WorkflowMaster(){
		
	}
	
	
	public WorkflowMaster(String workflowName,
			String workflowDescription, String workflowDomain, ArrayList<WorkflowDetails> objWorkFlowDetails ) {
		//this.workflowID = workflowID;
		this.workflowName = workflowName;
		this.workflowDescription = workflowDescription;
		this.workflowDomain = workflowDomain;
		this.objWorkFlowDetails=objWorkFlowDetails;
	}
	public int getWorkflowID() {
		return workflowID;
	}
	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getWorkflowDescription() {
		return workflowDescription;
	}
	public void setWorkflowDescription(String workflowDescription) {
		this.workflowDescription = workflowDescription;
	}
	public String getWorkflowDomain() {
		return workflowDomain;
	}
	public void setWorkflowDomain(String workflowDomain) {
		this.workflowDomain = workflowDomain;
	}
	public ArrayList<WorkflowDetails> getObjWorkFlowDetails() {
		return objWorkFlowDetails;
	}
	public void setObjWorkFlowDetails(ArrayList<WorkflowDetails> objWorkFlowDetails) {
		this.objWorkFlowDetails = objWorkFlowDetails;
	}
}