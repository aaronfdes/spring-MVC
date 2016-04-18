<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>FirstMVC</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Languages</th>
			<th>Date Of Joining</th>
			<th>Months Of Experience</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="emp" items="${employeeList}">
			<tr>
				<td><c:out value="${emp.empID}" /></td>
				<td><c:out value="${emp.empName}" /></td>
				<fmt:formatDate value="${emp.dateOfBirth}" var="dateString" pattern="dd/MM/yyyy"/>
				<td><c:out value="${dateString}" /></td>
				<td><c:out value="${emp.languages}" /></td>
				<td><c:out value="${emp.dateOfJoining}" /></td>
				<td><c:out value="${emp.monthsOfExperience}" /></td>
				<td><a href="/SpringMVCAnnotations/employee/${emp.empID}">View</a></td>
				<td><a href="/SpringMVCAnnotations/employee/remove/${emp.empID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/SpringMVCAnnotations/employee/add">Add Employee</a>
	<c:if test="${not empty message}">
		${message}
	</c:if>
</body>
</html>