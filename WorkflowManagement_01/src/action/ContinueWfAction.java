package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.WorkflowDetails;

import utility.DBService;
import utility.WorkflowDBService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ContinueWfAction extends ActionSupport {

	private int stageId;
	private String stageName;
	private String stageDescription;
	private int stageSLA;
	private int stageSequenceNo;
	private int stageLeadId;
	private String stageLeadName;
	private int wfId;
	private Map<String, Object> session;
	private WorkflowDetails objWorkflowDetails;
	private String table_suffix;

	public ContinueWfAction() {
	}

	public ContinueWfAction(int stageId, String stageName,
			String stageDescription, int stageSLA, int stageSequenceNo,
			int stageLeadId, String stageLeadName, int wfId) {
		this.stageId = stageId;
		this.stageName = stageName;
		this.stageDescription = stageDescription;
		this.stageSLA = stageSLA;
		this.stageSequenceNo = stageSequenceNo;
		this.stageLeadId = stageLeadId;
		this.stageLeadName = stageLeadName;
		this.wfId = wfId;
	}

	public String addLater() {
		return "success";
	}

	public String addStage() {
		setParams();

		objWorkflowDetails = new WorkflowDetails(this.getStageName(),
				this.getStageDescription(), this.getStageSLA(),
				this.getStageSequenceNo(), this.getStageLeadId(),
				this.getWfId());

		ArrayList<String> values = new ArrayList<String>();
		try {
			values.add(this.objWorkflowDetails.getStageName());
			values.add(this.objWorkflowDetails.getStageDescription());
			values.add(this.objWorkflowDetails.getStageSLA() + "");
			values.add(this.objWorkflowDetails.getStageSequenceNo() + "");
			values.add(this.objWorkflowDetails.getStageLeadId() + "");//fetch data from drop down
			values.add(getWfId() + "");

			if (WorkflowDBService.insertObjectInDB("workflow"
					+ this.table_suffix, values) != 0)
				return "success";
			else
				return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	private void setParams() {
		session = ActionContext.getContext().getSession();
		ResultSet result = null;

		String selectQuery = "SELECT table_suffix,w_id FROM workflow_master ";
		String whereClause = "where workflow_name = '"
				+ session.get("workflow").toString() + "'";

		try {
			result = DBService.dbExecuteQuery(selectQuery, whereClause);
			while (result.next()) {
				this.table_suffix = result.getString(1);
				this.setWfId(result.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	public int getWfId() {
		return wfId;
	}

	public void setWfId(int wfId) {
		this.wfId = wfId;
	}

	public WorkflowDetails getObjWorkflowDetails() {
		return objWorkflowDetails;
	}

	public void setObjWorkflowDetails(WorkflowDetails objWorkflowDetails) {
		this.objWorkflowDetails = objWorkflowDetails;
	}

	public String getTable_suffix() {
		return table_suffix;
	}

	public void setTable_suffix(String table_suffix) {
		this.table_suffix = table_suffix;
	}

}
