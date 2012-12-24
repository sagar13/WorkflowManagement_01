package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ContinueWfAction extends ActionSupport{
	
	private int stageId;
	private String stageName;
	private String stageDescription;
	private int stageSLA;
	private int stageSequenceNo;
	private int stageLeadId;
	private String stageLeadName;
	private String wfId;
	
	public ContinueWfAction(){
	}

	public ContinueWfAction(int stageId, String stageName,
			String stageDescription, int stageSLA, int stageSequenceNo,
			int stageLeadId, String stageLeadName, String wfId) {
		this.stageId = stageId;
		this.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageSLA = stageSLA;
		this.stageSequenceNo = stageSequenceNo;
		this.stageLeadId = stageLeadId;
		this.stageLeadName = stageLeadName;
		this.wfId = wfId;
	}
	
	public String execute(){
		return null;
		
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


	public String getStageLeadName() {
		return stageLeadName;
	}


	public void setStageLeadName(String stageLeadName) {
		this.stageLeadName = stageLeadName;
	}


	public String getWfId() {
		return wfId;
	}


	public void setWfId(String wfId) {
		this.wfId = wfId;
	}
	
	
	
	

}
