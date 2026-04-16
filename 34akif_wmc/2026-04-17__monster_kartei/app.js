const monsterListe = [
    { name: "Glubsch", farbe: "#9bdb4d", augen: 3 },
    { name: "Funki", farbe: "#ffb703", augen: 1 },
    { name: "Nebelix", farbe: "#8ecae6", augen: 2 }
];

const monsterCard = document.getElementById("monster-card");
const monsterName = document.getElementById("monster-name");
const monsterEyes = document.getElementById("monster-eyes");
const history = document.getElementById("history");
const nextButton = document.getElementById("next-btn");

let index = 0;

nextButton.addEventListener("click", function () {
    const monster = monsterListe[index];

    monsterName.textContent = monster.name;
    monsterEyes.textContent = "Augen: " + monster.augen;
    monsterCard.style.backgroundColor = monster.farbe;

    const li = document.createElement("li");
    li.textContent = monster.name;
    history.append(li);

    index = index + 1;
    if (index >= monsterListe.length) {
        index = 0;
    }
});
