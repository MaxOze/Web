<#import "../parts/base.ftl" as b>
<#import "../parts/forms.ftl" as forms>

<@b.base title="Registration" session=session>
    <@forms.userForm value=usr button="Sign up">
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingLogin" name="login">
            <label for="floatingLogin">Login</label>
            <small id="loginMsg">Error message</small>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" required minlength="6">
            <label for="floatingPassword">Password</label>
            <small>Error message</small>
        </div>
    </@forms.userForm>
</@b.base>