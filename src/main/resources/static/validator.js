const form = document.getElementById('form')
const firstname = document.getElementById('floatingFirstname')
const email = document.getElementById('floatingEmail')
const login = document.getElementById('floatingLogin')
const password = document.getElementById('floatingPassword')

form.addEventListener('submit', e => {
    if(checkInputs() > 0) {
        e.preventDefault()
    }
});

function checkInputs() {
    const firstnameValue = firstname.value.trim();
    const emailValue = email.value.trim();
    const loginValue = login.value.trim();
    const passwordValue = password.value.trim();
    let result = 0;

    if(firstnameValue === '' || firstnameValue == null) {
        setErrorFor(firstname, 'Firstname cannot be blank')
        result = result + 1
    } else {
        setSuccessFor(firstname)
    }


    if(!isEmail(emailValue)) {
        setErrorFor(email, 'Not a valid email!')
        result = result + 1
    } else if (emailValue === '' || emailValue == null) {
        setErrorFor(email, 'Email cannot be blank!')
        result = result + 1
    } else {
        setSuccessFor(email);
    }

    if(loginValue === '' || loginValue == null) {
        setErrorFor(login, 'Login cannot be blank')
        result = result + 1
    } else {
        setSuccessFor(login)
    }

    if(passwordValue.length < 6) {
        setErrorFor(password, 'Password cannot be less then 6 chars!')
        result = result + 1
    } else {
        setSuccessFor(password);
    }

    return result
}

function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-floating error';
    small.innerText = message;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-floating success';
}

function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}