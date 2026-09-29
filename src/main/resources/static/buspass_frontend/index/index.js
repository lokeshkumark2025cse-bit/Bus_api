document.getElementById("loginForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const role = document.getElementById("role").value;
    const message = document.getElementById("loginMessage");

    if (role === "student") {

        window.location.href = "../student/student.html";

    }

    else if (role === "admin") {

        window.location.href = "../admin/admin_dash.html";

    }

    else {

        message.textContent = "Please select a role.";

    }

});