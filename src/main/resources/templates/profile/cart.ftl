<#import "../parts/base.ftl" as b>

<@b.base title="Cart" session=session>
    <h2>Your card</h2>
    <table class="table table-striped table-hover">
        <thead style="background-color: #0f3341; color: #ffffff;">
            <th>Название</th><th>Цена</th>
        </thead>
        <#list session.getAttribute("cart") as book>
            <tr>
            <td>${book.name}</td>
            <td>${book.price}</td>
            </tr>
        </#list>
    </table>
        <h2>Total price: ${price}</h2>
        <form method="post">
            <input type="submit" value="Make order" class="btn btn-primary">
        </form>
</@b.base>