<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adds titles</title>
<script src="/title-text-adder-app/js/jquery-1.12.2.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
		var title = $('#title').val();
		var title_text = $('#title_text').val();

		$.ajax({
			type : "POST",
			url : "/title-text-adder-app/AddsTitle.htm",
			data : "title=" + title + "&text=" + title_text,
			success : function(response) {
				$('#info').html(response);
				$('#title').val('');
				$('#text').val('');
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
</script>
</head>
<body>
	<h1>Title text adder:</h1>
	<table>
		<tr>
			<td>Enter title :</td>
			<td><input type="text" id="title"><br /></td>
		</tr>
		<tr>
			<td>Enter Text :</td>
			<td><input type="text" id="title_text"><br /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="Add Title"
				onclick="doAjaxPost()"><br /></td>
		</tr>
		<tr>
			<td colspan="2"><div id="info" style="color: green;"></div></td>
		</tr>
	</table>
	<a href="/title-text-adder-app/ShowTitles.htm">Show All Titles</a>
</body>
</html>