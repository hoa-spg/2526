const autos = [
    { team: "Blitz", runden: 3, farbe: "#ffadad" },
    { team: "Turbo", runden: 5, farbe: "#ffd6a5" },
    { team: "Comet", runden: 4, farbe: "#caffbf" }
];

const showButton = document.getElementById("show-btn");
const leadButton = document.getElementById("lead-btn");
const info = document.getElementById("info");
const raceList = document.getElementById("race-list");

showButton.addEventListener("click", function () {
    if (raceList.children.length > 0) {
        return;
    }

    for (let i = 0; i < autos.length; i = i + 1) {
        const li = document.createElement("li");
        li.textContent = autos[i].team + " - Runden: " + autos[i].runden;
        li.style.backgroundColor = autos[i].farbe;
        raceList.append(li);
    }
});

leadButton.addEventListener("click", function () {
    if (raceList.children.length === 0) {
        for (let i = 0; i < autos.length; i = i + 1) {
            const li = document.createElement("li");
            li.textContent = autos[i].team + " - Runden: " + autos[i].runden;
            li.style.backgroundColor = autos[i].farbe;
            raceList.append(li);
        }
    }

    let leaderIndex = 0;

    for (let i = 1; i < autos.length; i = i + 1) {
        if (autos[i].runden > autos[leaderIndex].runden) {
            leaderIndex = i;
        }
    }

    for (let i = 0; i < raceList.children.length; i = i + 1) {
        raceList.children[i].classList.remove("leader");
    }

    raceList.children[leaderIndex].classList.add("leader");
    info.textContent = "Führend: " + autos[leaderIndex].team;
});
