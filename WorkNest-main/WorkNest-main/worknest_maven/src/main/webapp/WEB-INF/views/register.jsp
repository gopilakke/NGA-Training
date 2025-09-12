<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Create Account</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/register">
  <label>Username: <input type="text" name="username" required/></label><br/>
  <label>Email: <input type="email" name="email" required/></label><br/>
  <label>Password: <input type="password" name="password" required/></label><br/>
  <label>Role:
    <select name="role">
      <option value="USER">USER</option>
      <option value="ADMIN">ADMIN</option>
    </select>
  </label><br/>
  <button type="submit">Register</button>
</form>
</body>
</html>
