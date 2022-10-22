<#macro base title session>
    <!DOCTYPE html>
    <html lang="eu">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${title}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body style="background-color: #f2f2f2;">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/shop">BookShop</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/shop?page=1">Shop</a>
                    </li>
                    <#if session.getAttribute("role")?has_content>
                        <li class="nav-item">
                            <a class="nav-link" href="/create">Add new book</a>
                        </li>
                    <#else>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="" tabindex="-1" aria-disabled="true">Sign in to add new book</a>
                        </li>
                    </#if>
                </ul>
                <ul class="navbar-nav ms-auto mx-5 mb-lg-0">
                    <#if session.getAttribute("role")?has_content>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Hello, ${session.getAttribute("name")}!
                            </a>
                            <ul class="dropdown-menu col-xs-12" role="menu" aria-labelledby="dLabel">
                                <li><a class="dropdown-item" href="/profile">Profile</a></li>
                                <li><a class="dropdown-item" href="/cart">Cart</a></li>
                                <li><a class="dropdown-item" href="/orders">Orders</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/logout">Logout</a></li>
                            </ul>
                        </li>
                    <#else>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/signin">Sign in!</a>
                    </li>
                    </#if>
                </ul>
<#--                {#            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">#}-->
<#--                {#            <button class="btn btn-outline-success" type="submit">Search</button>#}-->
            </div>
        </div>
    </nav>
    <div class="container"><#nested></div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>

    </body>
    </html>
</#macro>