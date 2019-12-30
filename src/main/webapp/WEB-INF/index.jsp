<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head><title>SpringBoot</title>

    </head>
    <body>
        <hr/>
        <form method="post" action="/login">
            Username:<br>
            <input type="text" name="username" id="username" placeholder="Username"><br>
            Password:<br>
            <input type="password" name="password" id="password" placeholder="Password"><br>
            <input type="submit" value="Save">
        </form> 
          <a href="user/register">Register</a>
    </body>
</html>
