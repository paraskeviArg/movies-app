<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="style.css">
    <title>Registration Form</title>

    <style type="text/css">
  span.error{
    color: red;
    margin-left: 5px;
  }

    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class='container'>
<div id="main">
    <h1>Register</h1>
    <form action="register" id="rform" method="get" name="form">
        <table class="table">
            <tr>
                <td>Email:</td>
                <td><input name="email" type="text"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input name="password" type="text"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Submit</button>
                </td>
            </tr>
        </table>
        <script src='generic_functions.js'></script>
    </form>
    <button type="button" id="home">Home</button>
</div>
<script src='generic_functions.js'></script>
<script src='login_register_functions.js'></script>
<footer>
    Created by:
    Paris Miglis - 3160268 & Paraskevi Argyroudaki - 3160009
</footer>
</body>
</html>