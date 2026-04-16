const bands = [
    { name: "Pixel Beat", lautstaerke: 72, farbe: "#bde0fe" },
    { name: "Laser Jam", lautstaerke: 88, farbe: "#cdb4db" },
    { name: "Echo Crew", lautstaerke: 65, farbe: "#ffd6a5" }
];

const showButton = document.getElementById("show-btn");
const markButton = document.getElementById("mark-btn");
const info = document.getElementById("info");
const bandList = document.getElementById("band-list");

showButton.addEventListener("click", function () {
    if (bandList.children.length > 0) {
        return;
    }

    for (let i = 0; i < bands.length; i = i + 1) {
        const li = document.createElement("li");
        li.textContent = bands[i].name + " - " + bands[i].lautstaerke + " dB";
        li.style.backgroundColor = bands[i].farbe;
        bandList.append(li);
    }
});

markButton.addEventListener("click", function () {
    if (bandList.children.length === 0) {
        for (let i = 0; i < bands.length; i = i + 1) {
            const li = document.createElement("li");
            li.textContent = bands[i].name + " - " + bands[i].lautstaerke + " dB";
            li.style.backgroundColor = bands[i].farbe;
            bandList.append(li);
        }
    }

    let lautesteIndex = 0;

    for (let i = 1; i < bands.length; i = i + 1) {
        if (bands[i].lautstaerke > bands[lautesteIndex].lautstaerke) {
            lautesteIndex = i;
        }
    }

    for (let i = 0; i < bandList.children.length; i = i + 1) {
        bandList.children[i].classList.remove("mark");
    }

    bandList.children[lautesteIndex].classList.add("mark");
    info.textContent = "Lauteste Band: " + bands[lautesteIndex].name;
});
