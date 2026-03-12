
class Fahrzeug {

    #fahrgestellnummer;

    constructor(marke, typ, baujahr, fahrgestellnummer) {
        this.marke = marke;
        this.typ = typ;
        if (typeof baujahr === "number") {
            this.baujahr = baujahr;
        } else {
            throw new Error("Baujahr muss eine Zahl sein.");
        }
        this.baujahr = baujahr;
        this.#fahrgestellnummer = fahrgestellnummer;
    }

    toString() {
        return `Fahrzeug: ${this.marke} ${this.typ} (${this.baujahr})`;
    }
}

try {
    const fzg = new Fahrzeug("Fiat", "Punto", "zweitausend1", "xa134-by54");
    console.log("Fahrzeug: " + fzg);
    console.log(`Typ: ${fzg.typ}`)
    // delete fzg.typ;
    // console.log(`Typ: ${fzg.typ}`)
    // console.log("Fahrzeug: " + fzg);
    console.log(`Fahrgestellnummer: ${fzg.fahrgestellnummer}`);

    console.log(JSON.stringify(fzg));
} catch (error) {
    console.error("Fehler beim Erstellen des Fahrzeugs: " + error.message);
}