<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>My Tasks</title></head>
<body>
<h2>My Tasks</h2>
<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
<table border="1" cellpadding="6">
  <tr><th>Title</th><th>Status</th><th>Due</th><th>Action</th></tr>
  <c:forEach var="t" items="${tasks}">
    <tr>
      <td>${t.title}</td>
      <td>${t.status}</td>
      <td>${t.dueDate}</td>
      <td><a href="${pageContext.request.contextPath}/tasks/${t.id}">Open</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
