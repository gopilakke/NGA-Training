<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<h2>Admin Dashboard</h2>
<p>
  <a href="${pageContext.request.contextPath}/admin/users">Manage Users</a> |
  <a href="${pageContext.request.contextPath}/admin/tasks/new">Allocate Task</a> |
  <a href="${pageContext.request.contextPath}/logout">Logout</a>
</p>

<h3>Pending</h3>
<ul>
  <c:forEach var="t" items="${pending}">
    <li><a href="${pageContext.request.contextPath}/tasks/${t.id}">${t.title}</a> &mdash; ${t.assignedTo.username}</li>
  </c:forEach>
</ul>

<h3>In Progress</h3>
<ul>
  <c:forEach var="t" items="${inprogress}">
    <li><a href="${pageContext.request.contextPath}/tasks/${t.id}">${t.title}</a> &mdash; ${t.assignedTo.username}</li>
  </c:forEach>
</ul>

<h3>Completed</h3>
<ul>
  <c:forEach var="t" items="${completed}">
    <li><a href="${pageContext.request.contextPath}/tasks/${t.id}">${t.title}</a> &mdash; ${t.assignedTo.username}</li>
  </c:forEach>
</ul>

<h3>Delayed</h3>
<ul>
  <c:forEach var="t" items="${delayed}">
    <li><a href="${pageContext.request.contextPath}/tasks/${t.id}">${t.title}</a> &mdash; ${t.assignedTo.username}</li>
  </c:forEach>
</ul>
</body>
</html>
