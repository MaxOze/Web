<#import "parts/base.ftl" as b>

<@b.base title="Add book">
    <form method="post">
        <div><label>Book name: <input type="text" name="name"></label></div>
        <div><label>Book author: <input type="text" name="author"></label></div>
        <div><label>Book price: <input type="number" name="price"></label></div>
        <div><input type="submit" value="Add book"></div>
    </form>
</@b.base>