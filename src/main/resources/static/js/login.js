function handleLogin(event) {
    event.preventDefault();

    //get user input
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const user = {
        email: email,
        password: password
    };

    fetch('http://localhost:8080/api/v1/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(response => {
        if (!response.ok) {
            alert('Invalid email or password');
        }
        return response.json();
    }).then((response) => {
        localStorage.setItem('connectedUser', JSON.stringify(response));
        window.location.href = 'index.html';
    }).catch(error => {
        console.log("POST request failed", error);
    });
}


const loginForm = document.getElementById('loginForm');
loginForm.addEventListener("submit", handleLogin);