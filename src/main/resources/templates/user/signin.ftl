<#import "../parts/base.ftl" as b>

<@b.base title="Authorization" session=session>
    <form method="post">
        <div><label>Login: <input type="text" name="login"></label></div>
        <div><label>Password: <input type="password" name="password"></label></div>
        <div><input type="submit" value="Login"></div>
    </form>
</@b.base>