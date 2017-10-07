<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
  <title>Upload Multiple File Request Page</title>
</head>
<body>
<form method="POST" action="uploadFile" enctype="multipart/form-data">
  File1 to upload: <input type="file" name="file">


  <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>