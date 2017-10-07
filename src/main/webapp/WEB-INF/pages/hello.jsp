<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
	<title>title</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <script type="text/javascript" src="resources/js/jquery-3.0.0.min.js">
    </script>
</head>
<body>
    <div class="actionbar">video hoster</div>
    <video width="400" height="300" controls="controls" poster="resources/images/icon_video.png">
        <source src="video" type='video/ogg; codecs="theora, vorbis"'>
        <source src="video" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"'>
        <source src="video" type='video/webm; codecs="vp8, vorbis"'>
    </video>
    <div class="maindiv">
        <h1>Загрузить видео</h1>

        <form method="post" action="" enctype="multipart/form-data">

      <textarea name="description">
        описание к видео
      </textarea><br>



            <input type="file" id="file" name="userfile[]" multiple="multiple"/>
            <br>
            <input type="submit" value="отпрaвить"/>

        </form>

    </div>
	<a href="myjsp">myjsp</a>.
</body>
</html>