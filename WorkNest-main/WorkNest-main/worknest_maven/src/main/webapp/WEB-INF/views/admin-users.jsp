<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Users</title></head>
<body>
<h2>Users</h2>
<p><a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a></p>
<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Username</th><th>Email</th><th>Role</th><th>Action</th></tr>
  <c:forEach var="u" items="${users}">
    <tr>
      <td>${u.id}</td><td>${u.username}</td><td>${u.email}</td><td>${u.role}</td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/admin/users/delete/${u.id}" style="display:inline">
          <button type="submit" onclick="return confirm('Delete user?')">Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
