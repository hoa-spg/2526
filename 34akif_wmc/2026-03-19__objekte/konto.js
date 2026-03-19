
class Konto {

    #pin;

    constructor(username, pin) {
        this.username = username;
        this.#pin = pin;
        this.balance = 0;
    }

    checkPin(pin) {
        return this.#pin === pin;
    }

    einzahlen(betrag) {
        if (typeof betrag === 'number') {
            if (Number.isFinite(betrag) && betrag > 0) {
                this.balance += betrag;
            } else {
                throw new Error(`Fehler: ungueltiger Betrag: ${betrag}`);
            }
        } else {
            throw new Error(`Fehler: ungueltiger Parameter: ${betrag}`);
        }
    }

    toString() {
        return `User: ${this.username}, Kontostand: ${this.balance}`;
    }
}


const k = new Konto("ab34xy", 1234);
console.log(`Konto: ${k}`);
console.log(`Pin Versuch 1: ${k.checkPin(5555)}`);
console.log(`Pin Versuch 2: ${k.checkPin(1234)}`);

try {
    k.einzahlen(350);
    console.log(`Konto: ${k}`);

    k.einzahlen('xyz');
    console.log(`Konto: ${k}`);
} catch (e) {
    console.error(`FEHLER: ${e}`);
}

k.einzahlen(3);
console.log(`Konto: ${k}`);

const i = 1/0;
console.log(typeof i);
k.einzahlen(i);
console.log(`Konto: ${k}`);

const kontoStand = k.balance;