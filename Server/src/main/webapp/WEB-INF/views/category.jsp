<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <title>Category List page</title>
</head>
<h3>Category List</h3>
<c:if test="${!empty categoryList}">
  <table class="tg" border="solid 1px">
    <tr>
      <th width="80">Category ID</th>
      <th width="120">Category Name</th>
      <th width="120">Category Parent ID</th>
    </tr>
    <c:forEach items="${categoryList}" var="category">
      <tr>
        <td>${category.id}</td>
        <td>${category.categoryName}</td>
        <td align="center">${category.parentId}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<%--<a href="${pageContext.request.contextPath}/">Home page</a>--%>
</body>
</html>