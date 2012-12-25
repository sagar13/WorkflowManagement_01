package model;

public class WorkflowDetails {
	
	private int stageId;
	private String stageName;
	private String stageDescription;
	private int stageSLA;
	private int stageSequenceNo;
	private int stageLeadId;
	private int wfId;
	
	
	public WorkflowDetails(){
		
	}
	
	public WorkflowDetails(String stageName,
			String stageDescription, int stageSLA, int stageSequenceNo,
			int stageLeadId, int wfId) {
		//this.stageId = stageId;
		this.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageSLA = stageSLA;
		this.stageSequenceNo = stageSequenceNo;
		this.stageLeadId = stageLeadId;
		this.wfId = wfId;
	}
	public int getStageId() {
		return stageId;
	}
	public void setStageId(int stageId) {
		this.stageId = stageId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getStageDescription() {
		return stageDescription;
	}
	public void setStageDescription(String stageDescription) {
		this.stageDescription = stageDescription;
	}
	public int getStageSLA() {
		return stageSLA;
	}
	public void setStageSLA(int stageSLA) {
		this.stageSLA = stageSLA;
	}
	public int getStageSequenceNo() {
		return stageSequenceNo;
	}
	public void setStageSequenceNo(int stageSequenceNo) {
		this.stageSequenceNo = stageSequenceNo;
	}
	public int getStageLeadId() {
		return stageLeadId;
	}
	public void setStageLeadId(int stageLeadId) {
		this.stageLeadId = stageLeadId;
	}
	public int getWfId() {
		return wfId;
	}
	public void setWfId(int wfId) {
		this.wfId = wfId;
	}
	
}
