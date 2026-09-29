document.getElementById("applicationForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const phone = document.getElementById("phone").value.trim();
    const message = document.getElementById("applicationMessage");

    if (phone.length !== 10 || isNaN(phone)) {

        message.textContent = "Please enter a valid 10-digit phone number.";
        message.style.color = "#dc2626";

        return;
    }

    message.textContent = "Application submitted successfully.";
    message.style.color = "#16a34a";

    setTimeout(function() {

        window.location.href = "../student/student.html";

    }, 1500);

});


document.getElementById("backBtn").addEventListener("click", function() {

    window.location.href = "../student/student.html";

});