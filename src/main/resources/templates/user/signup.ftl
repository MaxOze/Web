<#import "../parts/base.ftl" as b>
<#import "../parts/forms.ftl" as forms>

<@b.base title="Registration" session=session>
    <@forms.userForm value=user button="Sign up">
        <div><label>Login: <input type="text" name="login"></label></div>
        <div><label>Password: <input type="text" name="password"></label></div>
    </@forms.userForm>
</@b.base>