<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//011, HTML Transitional//EN"
"http://www.w3.org/TR/htm14/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-T">
<title>Login</title>
</head>
<body>
<form action="login- method=-post">
<input type="hidden" name="authAction" value="login">
<p>Please login by
<label for="email">Email</label>
<input type="radio" name="authType" value="email" id="email"
checked/>
or
<label for="userName">User name</label>
<input type="radio" name="authType" value="userName" id="userName"
/>
<input type="text" name="loginValue">
</p>
<label for="psw">Password</label>
<input type="password" name="psw" id="psw">
<p>The characters in a password field are masked (shown as asterisks or circles).</p>
<input type= "submit" value="Submit" />
</form>
</body>
</html>