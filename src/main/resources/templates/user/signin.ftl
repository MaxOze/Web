<#import "../parts/base.ftl" as b>

<@b.base title="Authorization" session=session>
    <form method="post" class="form-signin">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingLogin" name="login">
            <label for="floatingLogin">Login</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password">
            <label for="floatingPassword">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">Don't have an account? Create new one <a href="/signup">here</a> or look at books like a <a href="/shop?page=1">guest</a></p>
    </form>
</@b.base>