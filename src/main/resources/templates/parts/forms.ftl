<#macro bookForm value button>
    <form method="post" class="form-signup">
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingName" name="name" value="${value.name}">
            <label for="floatingName">Book name</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingAuthor" name="author" value="${value.author}">
            <label for="floatingAuthor">Author</label>
        </div>
        <div class="form-floating">
            <input type="number" class="form-control" id="floatingPrice" name="price" value="${value.price}">
            <label for="floatingPrice">Price</label>
        </div>
        <#nested>
        <button class="w-100 btn btn-lg btn-primary" type="submit">${button}</button>
    </form>
</#macro>

<#macro userForm value button>
    <form method="post" class="form-signup">
        <div class="form-floating">
                <input type="text" class="form-control" id="floatingFirstname" name="firstname" value="${value.firstname}">
                <label for="floatingFirstname">Firstname</label>
        </div>
        <div class="form-floating">
                <input type="email" class="form-control" id="floatingEmail" name="email" value="${value.email}">
                <label for="floatingEmail">Email</label>
        </div>
        <#nested>
        <button class="w-100 btn btn-lg btn-primary" type="submit">${button}</button>
    </form>
</#macro>