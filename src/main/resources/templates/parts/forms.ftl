<#macro bookForm value button>
    <form method="post">
        <div><label>Book name: <input type="text" name="name" value="${value.name}"></label></div>
        <div><label>Book author: <input type="text" name="author" value="${value.author}"></label></div>
        <div><label>Book price: <input type="number" name="price" value="${value.price}"></label></div>
        <div><input type="submit" value="${button}"></div>
    </form>
</#macro>

<#macro userForm value button>
    <form method="post">
        <div><label>Firstname: <input type="text" name="firstname" value="${value.firstname}"></label></div>
        <div><label>Email: <input type="email" name="email" value="${value.email}"></label></div>
        <#nested>
        <div><input type="submit" value="${button}"></div>
    </form>
</#macro>