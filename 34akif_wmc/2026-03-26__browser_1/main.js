
// document.addEventListener("DOMContentLoaded", function() {
//     // Code
// });


// debugger;
console.log("Hallo 4AKIF");

const div1 = document.getElementById("div1");
// div1.style.color = "red";
div1.classList.add("blue-class");

const div2 = document.getElementById("div2");
div2.classList.add("red-class");

const btn1 = document.getElementById("btn1");

const eingabe = document.getElementById("eingabe");

btn1.addEventListener("click", event => {

    if (div1.classList.contains("blue-class")) {
        div1.classList.remove("blue-class");
        div1.classList.add("green-class");
    } else if (div1.classList.contains("green-class")) {
        div1.classList.remove("green-class");
        div1.classList.add("blue-class");
    }

    // debugger;

    div2.innerHTML = eingabe.value;

});




