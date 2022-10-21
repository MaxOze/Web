<#import "parts/base.ftl" as b>

<@b.base title="Shop">
    <h2>Список книг</h2>
    <table class="table table-striped table-hover">
        <thead style="background-color: #0f3341; color: #ffffff;">
            <th>Название</th><th>Автор</th><th>Цена</th>
        </thead>
        <#list books as book>
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <div class="btn-group">
                    <a href="/edit?id=${book.id}" class="btn btn-primary">Сhange</a>
                    <a href="/delete" class="btn btn-danger">Delete</a>
                </div>
            </td>
        </tr>
        </#list>
    </table>
    <nav aria-label="Page navigation example">
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
