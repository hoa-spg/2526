const profil = {
    username: "user123",
    punkte: 42,
    print: () => {
            console.log(`Name: ${profil.username}`);
        },
    aktiv: true,
    kontakt: {
        email: "user123@gmx.at",
        ort: "Wien"
    },
    interessen: ["JavaScript", "CSS", "Programmieren"]
}



profil.level = "Anfänger";
profil.punkte += 3;


console.log(profil);
profil.print();


const profilJson = JSON.stringify(profil);

console.log(profilJson);

const geparsed = JSON.parse(profilJson);

console.log(geparsed);