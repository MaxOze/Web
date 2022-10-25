<#import "../parts/base.ftl" as b>
<#import "../parts/forms.ftl" as f>

<@b.base title="Cart" session=session>
    <@f.userForm value=usr button="Save"/>
    <h2>${message}</h2>
</@b.base>