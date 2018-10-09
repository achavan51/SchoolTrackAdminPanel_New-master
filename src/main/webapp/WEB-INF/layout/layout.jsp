<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<head>
 
<!--   <meta charset="utf-8"> -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>


</head>
<body>
	<table border="1" cellpadding="2" cellspacing="2" align="center">
		<tr>
			<td width="20%" height="15%"><tiles:insertAttribute name="logo" /></td>
			<td width="80%" height="15%"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td width="20%" height="70%"><tiles:insertAttribute name="menu" /></td>
			<td width="80%" height="70%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td height="15%" colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>  