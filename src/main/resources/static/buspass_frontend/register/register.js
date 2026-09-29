document.getElementById("registerForm").addEventListener("submit", async function(event) {

    event.preventDefault();

    const name = document.getElementById("name").value.trim();
    const regnumber = document.getElementById("regnumber").value.trim();
    const year = document.getElementById("year").value;
    const dept = document.getElementById("dept").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    const message = document.getElementById("registerMessage");

    if (phone.length !== 10 || isNaN(phone)) {

        message.textContent = "Please enter a valid 10-digit phone number.";
        message.style.color = "#dc2626";

        return;
    }

    if (password !== confirmPassword) {

        message.textContent = "Passwords do not match.";
        message.style.color = "#dc2626";

        return;
    }

    const student = {
        name: name,
        regnumber: regnumber,
        year: Number(year),
        dept: dept,
        phone: phone,
        email: email,
        password: password
    };

    try {

        const response = await fetch("/api/students/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(student)
        });

        if (response.ok) {

            message.textContent =
                "Registration successful. Redirecting to login...";

            message.style.color = "#16a34a";

            setTimeout(function() {
                window.location.href = "../index/index.html";
            }, 1500);

        } else {

            message.textContent = "Registration failed.";
            message.style.color = "#dc2626";

        }

    } catch (error) {

        message.textContent =
            "Unable to connect to server.";

        message.style.color = "#dc2626";

    }

});     