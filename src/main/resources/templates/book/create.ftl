<#import "../parts/base.ftl" as b>
<#import "../parts/forms.ftl" as forms>

<@b.base title="Add book" session=session>
        <@forms.bookForm value=book button="Add book" />
</@b.base>