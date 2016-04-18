<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>FirstMVC</title>
</head>
<body>
	<h1>Employee Detail</h1>

	<h3>Add New Employee</h3>
	<form:form method="post" action="./add" commandName="employee">
		<table>
			<tr>
				<td><form:label path="empID">ID</form:label></td>
				<td><form:input path="empID" /></td>
				<td><form:errors path="empID" /></td>
			</tr>
			<tr>
				<td><form:label path="empName">Name</form:label></td>
				<td><form:input path="empName" /></td>
				<td><form:errors path="empName" /></td>
			</tr>
			<tr>
				<fmt:formatDate value="${employee.dateOfBirth}" var="dateString"
					pattern="dd/MM/yyyy" />
				<td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
				<td><form:input path="dateOfBirth" value="${dateString}" /></td>
				<td><form:errors path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td><form:label path="languages">Languages</form:label></td>
				<td><form:checkboxes path="languages" items="${languageList}"
						multiple="true" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfJoining">Date Of Joining</form:label></td>
				<td><form:input path="dateOfJoining" /></td>
				<td><form:errors path="dateOfJoining" /></td>
			</tr>
			<tr>
				<td><form:label path="monthsOfExperience">Months Of Experience</form:label></td>
				<td><form:input path="monthsOfExperience" /></td>
				<td><form:errors path="monthsOfExperience" /></td>
			</tr>
			<c:if test="${empty employee.empID}">
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</c:if>
		</table>
	</form:form>
	<c:if test="${empty details}">
		${details}			
	</c:if>
	<c:if test="${fields.hasErrors('empName')}">
		${empName}			
	</c:if>

</body>
</html>
