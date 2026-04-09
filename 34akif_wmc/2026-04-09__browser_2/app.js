const btn = document.querySelector("#input-form>button");
const input = document.getElementById("user-input");
const output = document.getElementById("output");
const log = document.getElementById("log-list");

btn.addEventListener('click', () => {

    if (input.value.trim() !== "") {
        output.value = `Hallo ${input.value.trim()}`;
        output.classList.add("success");
        output.classList.remove("error");
        addLogEntry(input.value.trim());
    } else {
       output.value = "Ungültige Eingabe"; 
       output.classList.add("error");
       output.classList.remove("success");
    }
    
});

function addLogEntry(wert) {
    if (input.value.trim() !== "") {
        const li = document.createElement('li');
        li.textContent = wert;
        log.append(li);
    } else {
        console.error("Ungueltiger Wert für addLogEntry");
    }
}