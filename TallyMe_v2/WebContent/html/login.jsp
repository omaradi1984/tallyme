<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome to TallyMe</title>
    <link rel="stylesheet" type="text/css" href="css/login-style.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
</head>
<body>
<div class="container tagline">
			<%
				if (request.getAttribute("error") != null) {
			%>
			<%=request.getAttribute("error")%><br />
			<%
				}
			%>
<div class="container" id="homeContainer">
            <h1 class="title" id="homeTitle">Welcome to TallyMe</h1>
            <h2 name="subtitle" class="subtitle" id="homeSubtitle">Enter your username and password to login</h2>
            <div class="container" id="formContainer">
                <form name="loginForm" id="loginForm" class="form" action="login" method="post">
                    <table id="loginTable">
                        <tr>
                            <td>
                                 <label for="username">Username: </label>
                                 <input type="text" name="username" class="usernameField" id="usernameField" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                 <label for="password">Password: </label>
                                 <input type="text" name="password" class="passwordField" id="passwordField" required>
                            </td>
                        </tr>
                        <tr>
                            <td id="loginCol">
                                <input type="submit" id="loginButton" value="Login">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="" class="link link--metis" id="recoverPasswordLink">Recover password</a>
                            </td>
                        </tr>
                    <tr>
                        <td colspan="2">
                            <a href="" class="link link--metis" id="recoverPasswordLink">Recover username</a>
                        </td>
                    </tr>
                    </table>
            </form>
            </div>
        </div>
</body>
</html>