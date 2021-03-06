<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="res/img/original.png" type="image/png">
  <title>${titl}</title>
  <link rel="stylesheet" type="text/css" href="res/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="res/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="res/css/main.css">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Alexander Ki<i style="font-size: 24px" class="fa fa-facebook"></i></a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        ${links}
        <li><a href="mailto:alexander_kif@mail.ru?subject=From%20SahaSpring%20site" target="_blank"><i class="fa fa-envelope-o" aria-hidden="true"></i></a></li>
      </ul>
    </div>
  </div>
</div>
<div>
  <div class="container">
    <div class="row centered">
      <div class="col-lg-8" id="headerwrap">
        <h1>Spring</h1>
        <h2>I try to use Spring</h2>
        <br/>
        <br/>
        ${lform}
      </div>
    </div>
  </div>
</div>
<div class="container bo">
  <br>
  <div class="row centered">
    <div class="col-lg-4 col-sm-4">
      <i class="fa fa-heart"></i>
      <h4>Design</h4>
      <p>The whole design was made around the standard Windows picture.</p>
    </div>
    <div class="col-lg-4 col-sm-4">
      <i class="fa fa-laptop"></i>
      <h4>Computers</h4>
      <p>All the work I did on my laptop. And also thanks Heroku for hosting.</p>
    </div>
    <div class="col-lg-4 col-sm-4">
      <i class="fa fa-trophy"></i>
      <h4>Help</h4>
      <p>Special thanks to the Internet for the provided training materials.</p>
    </div>
  </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
</body>
</html>
