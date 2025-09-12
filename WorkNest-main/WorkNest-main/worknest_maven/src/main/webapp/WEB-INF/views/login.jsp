<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Login</title></head>
<body>
<h2>WorkNest Login</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/login">
  <label>Username: <input type="text" name="username" required/></label><br/>
  <label>Password: <input type="password" name="password" required/></label><br/>
  <button type="submit">Login</button>
</form>
<p>No account? <a href="${pageContext.request.contextPath}/register">Register</a></p>
</body>
</html>
