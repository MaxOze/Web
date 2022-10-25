<#import "../parts/base.ftl" as b>

<@b.base title="Orders" session=session>
    <h2>Your orders</h2>
    <#list orders as order>
        <div>
            <p>
                <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample${order.order_id}" role="button" aria-expanded="false" aria-controls="collapseExample${order.order_id}">
                    ${order.order_date}
                </a>
            </p>
            <div class="collapse" id="collapseExample${order.order_id}">
                <#list order.books_id as book>
                    <div class="card card-body">
                        ${book.name} / ${book.author} / ${book.price}
                    </div>
                </#list>
            </div>
        </div>
    </#list>
</@b.base>