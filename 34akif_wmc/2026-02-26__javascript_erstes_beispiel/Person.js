export class Person {

    constructor(name, geburtsjahr, geschlecht) {
        if (typeof name !== "string" || name.trim() === "") {
            throw new Error("Name muss ein nicht-leerer String sein.");
        }

        const aktuellesJahr = new Date().getFullYear();
        if (
            typeof geburtsjahr !== "number" ||
            geburtsjahr < 1900 ||
            geburtsjahr > aktuellesJahr
        ) {
            throw new Error("Geburtsjahr ist ungültig.");
        }

        // Geschlecht prüfen
        const erlaubteGeschlechter = ["w", "m", "x"];
        if (!erlaubteGeschlechter.includes(geschlecht)) {
            throw new Error(
                `Geschlecht muss eines von ${erlaubteGeschlechter.join(", ")} sein.`
            );
        }

        this.name = name;
        this.geburtsjahr = geburtsjahr;
        this.geschlecht = geschlecht;
    }

    getAlter() {
        return new Date().getFullYear() - this.geburtsjahr;
    }

    vorstellen() {
        return `Ich heiße ${this.name}, bin ${this.getAlter()} Jahre alt und mein Geschlecht ist ${this.geschlecht}.`;
    }
}
