/**
 * Um die Klasse außerhalb dieser Datei verwenden zu können 
 * muss sie exportiert werden.
 */
export class Sortieren {

    /**
     * In Javascript gibt es nur einen einzigen Konstruktor, und er heißt constructor
     */
    constructor(n) {
        if (typeof n !== "number" || n <= 0) {
            throw new Error("n muss eine positive Zahl sein.");
        }

        // Hier wird 
        this.werte = []; // Erzeugen eines neuen Arrays

        // Array mit Zufallszahlen zwischen 0 und 100 initialisieren
        for (let i = 0; i < n; i++) {
            // Push fügt einen Wert einem Array hinzu
            this.werte.push(Math.floor(Math.random() * 101));
        }
    }


    bubbleSort() {
        const len = this.werte.length;
        let swapped = true;

        for (let i = 0; i < len - 1 && swapped; i++) {
            swapped = false;
            for (let j = 0; j < len - 1 - i; j++) {
                if (this.werte[j] > this.werte[j + 1]) {
                    this.swap(j, j + 1);
                    swapped = true;
                }
            }
        }
    }

    swap(i, j) {
        const tmp = this.werte[i];
        this.werte[i] = this.werte[j];
        this.werte[j] = tmp;
    }

    print() {
        console.log(this.werte.join(", "));
    }

}
