<#import "parts/base.ftl" as b>

<@b.base title="Add book">
    <form method="post">
        <div><label>Book name: <input type="text" name="name" value="${book.name}"></label></div>
        <div><label>Book author: <input type="text" name="author" value="${book.author}"></label></div>
        <div><label>Book price: <input type="number" name="price" value="${book.price}"></label></div>
        <div><input type="submit" value="Change book details"></div>
    </form>
</@b.base>