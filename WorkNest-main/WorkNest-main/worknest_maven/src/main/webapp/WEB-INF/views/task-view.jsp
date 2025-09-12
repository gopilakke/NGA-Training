<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Task</title></head>
<body>
<h2>${task.title}</h2>
<p>${task.description}</p>
<p><b>Status:</b> ${task.status} | <b>Start:</b> ${task.startDate} | <b>Due:</b> ${task.dueDate}</p>

<h3>Update Status</h3>
<form method="post" action="${pageContext.request.contextPath}/tasks/${task.id}/status">
  <select name="status">
    <option ${task.status == 'PENDING' ? 'selected' : ''}>PENDING</option>
    <option ${task.status == 'IN_PROGRESS' ? 'selected' : ''}>IN_PROGRESS</option>
    <option ${task.status == 'COMPLETED' ? 'selected' : ''}>COMPLETED</option>
    <option ${task.status == 'DELAYED' ? 'selected' : ''}>DELAYED</option>
  </select>
  <button type="submit">Save</button>
</form>

<h3>Comments</h3>
<form method="post" action="${pageContext.request.contextPath}/comments/add">
  <input type="hidden" name="taskId" value="${task.id}"/>
  <textarea name="text" rows="3" cols="60" placeholder="Write a comment..."></textarea>
  <br/><button type="submit">Add Comment</button>
</form>

<ul>
  <c:forEach var="cmt" items="${comments}">
    <li><b>${cmt.user.username}</b> (${cmt.createdAt}): ${cmt.text}</li>
  </c:forEach>
</ul>

<p><a href="${pageContext.request.contextPath}/user/dashboard">Back</a></p>
</body>
</html>
