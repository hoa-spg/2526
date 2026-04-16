const tierArten = [
    { art: "Axolotl", farbe: "#8ecae6" },
    { art: "Fuchs", farbe: "#ffb703" },
    { art: "Waschbaer", farbe: "#adb5bd" }
];

const nameInput = document.getElementById("name-input");
const addButton = document.getElementById("add-btn");
const removeButton = document.getElementById("remove-btn");
const status = document.getElementById("status");
const tierList = document.getElementById("tier-list");

let index = 0;

addButton.addEventListener("click", function () {
    const name = nameInput.value.trim();

    if (name === "") {
        status.textContent = "Bitte zuerst einen Tiernamen eingeben.";
        return;
    }

    const artInfo = tierArten[index];

    const li = document.createElement("li");
    li.textContent = name + " - " + artInfo.art;
    li.style.borderColor = artInfo.farbe;
    tierList.append(li);

    status.textContent = "Tiere im Tierheim: " + tierList.children.length;
    nameInput.value = "";

    index = index + 1;
    if (index >= tierArten.length) {
        index = 0;
    }
});

removeButton.addEventListener("click", function () {
    if (tierList.children.length === 0) {
        status.textContent = "Es gibt kein Tier zum Vermitteln.";
        return;
    }

    tierList.firstElementChild.remove();
    status.textContent = "Tiere im Tierheim: " + tierList.children.length;
});
