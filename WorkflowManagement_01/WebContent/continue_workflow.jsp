<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WFMS: Workflow Details</title>
</head>
<body>
	<h2>Add Details</h2>
	<s:actionerror />
	<s:form action="continue_wf.action" method="post">
		<s:textfield name="stageName" label="Stage Name" size="30" />
		<s:textfield name="stageDescription" label="Stage Description"
			size="100" />
		<s:textfield name="stageSLA" label="Stage SLA(in hrs)"
			size="5" />
		<s:textfield name="stageSequenceNo" label="Stage Sequence Number"
			size="5" />
		<s:select label="Select a Lead" headerKey="-1"
			headerValue="Select Lead"
			list="#{'1':'Raghav', '2':'Sagar'}"
			name="stageLeadId" />
		<s:submit name="button" value="Create"
			action="addStageWorkflow" align="center" />
		<s:submit name="button"  value="Later"
			action="addLaterWorkflow" align="center" />
	</s:form>
</body>
</html>