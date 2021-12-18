<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
<h1>Edit Form</h1>
<form action="/myapp/board/editok" method="get">
<input type="hidden" name="no" value="${editNo}"/>
<table>
<tr><td>Title:</td><td><input type="text" name="title" value="${boardVO.getTitle()}"/></td></tr>
<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content">${boardVO.getContent()}</textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>
</body>
</html>