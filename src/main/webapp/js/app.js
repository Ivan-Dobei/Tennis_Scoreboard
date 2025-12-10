document.addEventListener("DOMContentLoaded", function () {
    const navToggle = document.querySelector(".nav-toggle");
    const navLinks = document.querySelector(".nav-links");

    navToggle.addEventListener("click", function () {
        navLinks.classList.toggle("active");
    });
});

let newMatchButton = document.querySelector("#start_btn", () => {
    fetch("http://localhost:8080/Tennis_app_war_exploded/new-match", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP ошибка: ${response.status}`);
        }
        return response.json();
    })
        .then(data => console.log(data))
        .catch(error => console.error("Ошибка:", error));
})

let matchResultButton = document.querySelector("#result_btn")

document.querySelectorAll(".homepage-action-button").forEach(element => {
    element.addEventListener("click", (event) => {
        event.preventDefault();
    })
})

matchResultButton.addEventListener("click", () => {
    console.log("it's working");
})