<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html lang="true">
<head>
<title><bean:message key="welcome.title" /></title>
<html:base />
</head>
<body bgcolor="white">

<logic:notPresent name="org.apache.struts.action.MESSAGE"
	scope="application">
	<font color="red"> ERROR: Application resources not loaded --
	check servlet container logs for error messages. </font>
</logic:notPresent>

<h3><bean:message key="welcome.heading" /></h3>
<p><bean:message key="welcome.message" /></p>

<html:form action="Welcome.do">
	<html:hidden property="operation" />
	<html:hidden property="line" />
	<table>
		<tr>
			<td colspan="3"></td>
			<img alt="add line" src="images/plus.png" onclick="addLine()" />
		</tr>

		<logic:notEmpty name="myForm" property="list">

			<logic:iterate name="myForm" property="list" id="it" indexId="ctr">
				<tr>
					<td>FNAME:</td>
					<td><html:text property='<%= "list[" + ctr + "].fname" %>' /></td>
					<td>LNAME:</td>
					<td><html:text property='<%= "list[" + ctr + "].lname" %>' /></td>
					<td><img alt="remove index" src="images/delete.gif" onclick='removeLine("<%= ctr %>")' /></td>
				</tr>
			</logic:iterate>

		</logic:notEmpty>
	</table>
	<input type="button" value="click" onclick="merge()" />

</html:form>

<script type="text/javascript">
	function addLine(){
		document.forms["myForm"].operation.value="1";
		document.forms["myForm"].submit();
	}
	
	function removeLine(index){
		document.forms["myForm"].operation.value="2";
		document.forms["myForm"].line.value=index;
		document.forms["myForm"].submit();
	}
	
	function merge(){
				document.forms["myForm"].operation.value="3";
				document.forms["myForm"].submit();
	}
	
</script>

</body>
</html:html>
