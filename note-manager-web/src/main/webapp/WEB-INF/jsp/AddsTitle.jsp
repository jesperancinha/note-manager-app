<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adds titles</title>
<script src="/note-manager-web/resources/js/addnote.min.js"></script>
</head>
<body>
	<h1>Title text adder</h1>
	<h2>Edit text</h2>
	<div ng-app="NoteManager" ng-controller="AddNote">
        <p>Title: <input type="text" name="title" ng-model="title" required /></p>
        <p>Text: <input type="text" name="text" ng-model="text" required /></p>
        <button ng-click="addNote()">Submit</button>
        <hr />
        {{ PostDataResponse }}
    </div>

	<form method="post" action="/note-manager-web/ShowTitles.htm">
	<table>
		<tr>
			<td><input type="text" name="text_filter"><br /></td>
			<td><input type="submit" value="Show filtered Titles">
		</tr>
	</table>
	</form>
</body>
</html>
