const snacks = [
    { name: "Pizza-Pop", farbe: "#f4a261" },
    { name: "Nudel-Nebel", farbe: "#fedd8b" },
    { name: "Keks-Komet", farbe: "#90be6d" }
];

// console.log(snacks);

const nameInput = document.getElementById("name-input");
const bestellButton = document.getElementById("order-btn");
const deleteButton = document.querySelector("#delete-btn");

const statusMesssage = document.getElementById("status-message");
const orderList = document.getElementById("order-list");

bestellButton.addEventListener('click', () => {

    if (nameInput.value.trim() !== "") {
        const li = document.createElement('li');

        const idx = Math.floor(Math.random() * snacks.length);
        const snack = snacks[idx];

        li.innerHTML = `${nameInput.value.trim()} bestellt ${snack.name} ;-) `;
        li.style.backgroundColor = snack.farbe;
        orderList.append(li);

        statusMesssage.innerHTML = "Bestellung aufgenommen";
        statusMesssage.style.color = "green";
    } else {
        statusMesssage.innerHTML = "Fehler: kein Name angegeben";
        statusMesssage.style.color = "red";
    }
});

deleteButton.addEventListener('click', () => {
    if (orderList.children.length > 0) {
        orderList.removeChild(orderList.lastChild);
        statusMesssage.innerText = "Letzte Bestellung gelöscht.";
        statusMesssage.style.color = "green";
    } else {
        statusMesssage.innerText = "Keine Bestellungen vorhanden. Löschen nicht möglich.";
        statusMesssage.style.color = "red";  
    }
});