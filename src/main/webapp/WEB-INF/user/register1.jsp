<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head><title>SpringBoot</title>

    </head>
    <body>
        <hr/>
        <form method="post" action="/user/save">
            <input type="hidden" name="id" id="id" value="">
            Username:<br>
            <input type="text" name="username" id="username" placeholder="Username"><br>
            Email:<br>
            <input type="email" name="email" id="email" placeholder="Example@gmail.com"><br>
            Password:<br>
            <input type="password" name="password" id="password" placeholder="Password"><br>
            Retype password:<br>
            <input type="password" name="password1" id="password1" placeholder="Retype Password"><br>
            <input type="submit" value="Save">
        </form> 

    </body>
</html>
