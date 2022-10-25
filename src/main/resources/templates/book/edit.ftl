<#import "../parts/base.ftl" as b>
<#import "../parts/forms.ftl" as forms>

<@b.base title="Add book" session=session>
    <@forms.bookForm value=book button="Change book details">

    </@forms.bookForm>
</@b.base>