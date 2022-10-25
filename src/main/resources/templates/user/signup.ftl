<#import "../parts/base.ftl" as b>
<#import "../parts/forms.ftl" as forms>

<@b.base title="Registration" session=session>
    <@forms.userForm value=usr button="Sign up">
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingLogin" name="login">
            <label for="floatingLogin">Login</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password">
            <label for="floatingPassword">Password</label>
        </div>
    </@forms.userForm>
</@b.base>