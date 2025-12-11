const newMatchButton = document.querySelector("#start_match_btn");

newMatchButton.addEventListener("click", (event) => {
    event.preventDefault();

    const playerOne = document.querySelector("#playerOne").value;
    const playerTwo = document.querySelector("#playerTwo").value;

    fetch("http://localhost:8080/Tennis_app_war_exploded/new-match", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            firstPlayer: playerOne,
            secondPlayer: playerTwo
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error: ${response.status}`);
            }
            return response.json(); // expect { uuid: "..." }
        })
        .then(data => {
            const newMatchId = data.uuid;
            console.log("New match ID:", newMatchId);

            window.location.href = `http://localhost:8080/Tennis_app_war_exploded/match-score?uuid=${newMatchId}`;
        })
        .catch(error => console.error("Error:", error));
});
