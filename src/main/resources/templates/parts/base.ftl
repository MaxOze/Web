<#macro base title>
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
            <a class="navbar-brand" href="<#-- -->">BookShop</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="">Shop</a>
                    </li>
<#--                    {% if user.is_authenticated %}-->
<#--                    <li class="nav-item">-->
<#--                        <a class="nav-link" href="{% url 'create' %}">Add new book</a>-->
<#--                    </li>-->
<#--                    {% else %}-->
                    <li class="nav-item">
                        <a class="nav-link active<#--disabled-->" href="/create" tabindex="-1" aria-disabled="true">Sign in to add new book</a>
                    </li>
<#--                    {% endif %}-->
                </ul>
                <ul class="navbar-nav ms-auto mx-5 mb-lg-0">
<#--                    {% if user.is_authenticated %}-->
<#--                    <li class="nav-item dropdown">-->
<#--                        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<#--                            Hello, {{ user.username }}!-->
<#--                        </a>-->
<#--                        <ul class="dropdown-menu col-xs-12" role="menu" aria-labelledby="dLabel">-->
<#--                            <li><a class="dropdown-item" href="&lt;#&ndash; &ndash;&gt;">Profile</a></li>-->
<#--                            <li><a class="dropdown-item" href="#">Cart</a></li>-->
<#--                            <li><hr class="dropdown-divider"></li>-->
<#--                            <li><a class="dropdown-item" href="http://127.0.0.1:8000/logout">Logout</a></li>-->
<#--                        </ul>-->
<#--                    </li>-->
<#--                    {% else %}-->
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<#-- -->">Sign in!</a>
                    </li>
<#--                    {% endif %}-->
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