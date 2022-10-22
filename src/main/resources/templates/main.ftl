<#import "parts/base.ftl" as b>

<@b.base title="Shop" session=session>
    <#if session.getAttribute("role")?has_content>
        <h2>Hello ${session.getAttribute("name")}</h2>
    </#if>
    <table class="table table-striped table-hover">
        <thead style="background-color: #0f3341; color: #ffffff;">
            <th>Название</th><th>Автор</th><th>Цена</th>
        </thead>
        <#list books as book>
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <#if session.getAttribute("role")?has_content>
                <#if session.getAttribute("role") == "superuser">
                    <td>
                        <div class="btn-group">
                            <a href="/edit?id=${book.id}" class="btn btn-primary">Сhange</a>
                            <a href="/delete" class="btn btn-danger">Delete</a>
                        </div>
                    </td>
                </#if>
                <td><a class="btn btn-primary">To cart</a></td>
            </#if>
        </tr>
        </#list>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <#if number != 1>
            <li class="page-item"><a class="page-link" href="?page=1">First</a></li>
            <li class="page-item"><a class="page-link" href="?page=${number-1}">Previous</a></li>
            <#else>
            <li class="page-item disabled"><a class="page-link">First</a></li>
            <li class="page-item disabled"><a class="page-link">Previous</a></li>
            </#if>
            <#list pages as page>
                <li class="page-item"><a class="page-link" href="?page=${page}">${page}</a></li>
            </#list>
            <#if number != count>
            <li class="page-item"><a class="page-link" href="?page=${number+1}">Next</a></li>
            <li class="page-item"><a class="page-link" href="?page=${count}">Last</a></li>
            <#else>
            <li class="page-item disabled"><a class="page-link">Next</a></li>
            <li class="page-item disabled"><a class="page-link">Last</a></li>
            </#if>
        </ul>
    </nav>
</@b.base>
