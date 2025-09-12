<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Allocate Task</title></head>
<body>
<h2>Allocate New Task</h2>
<form method="post" action="${pageContext.request.contextPath}/admin/tasks">
  <label>Title: <input type="text" name="title" required/></label><br/>
  <label>Description:<br/>
    <textarea name="description" rows="4" cols="50"></textarea>
  </label><br/>
  <label>Start Date: <input type="date" name="startDate" required/></label><br/>
  <label>Due Date: <input type="date" name="dueDate" required/></label><br/>
  <label>Assign To:
    <select name="assignedTo">
      <c:forEach var="u" items="${users}">
        <option value="${u.id}">${u.username} (${u.role})</option>
      </c:forEach>
    </select>
  </label><br/>
  <button type="submit">Create</button>
</form>
<p><a href="${pageContext.request.contextPath}/admin/dashboard">Cancel</a></p>
</body>
</html>
