<#import "parts/base.ftl" as b>

<@b.base title="Shop" session=session>
<#--    <h2> ${session.getAttribute("role")} </h2>-->
    <table class="table table-striped table-hover">
        <thead style="background-color: #0f3341; color: #ffffff;">
        <#if session.getAttribute("role")?has_content>
            <#if session.getAttribute("role") == "user">
            <th>Name</th><th>Author</th><th>Price</th><th> </th><th> </th>
            <#else>
                <th>Name</th><th>Author</th><th>Price</th><th>Edit</th><th> </th><th> </th>
            </#if>
        <#else>
            <th>Name</th><th>Author</th><th>Price</th>
        </#if>
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
                            <a href="/edit?book_id=${book.book_id}" class="btn btn-primary">Сhange</a>
                            <a href="/delete/${book.book_id}" class="btn btn-danger">Delete</a>
                        </div>
                    </td>
                </#if>
                <form method="post">
                    <td><input class="tocart" type="text" name="name" value="${book.name}"></td>
                    <td class=""><input type="submit" value="To cart" class="btn btn-dark"></td>
                </form>
            </#if>
        </tr>
        </#list>
    </table>
    <nav aria-label="Page navigation" class="nav justify-content-center">
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
