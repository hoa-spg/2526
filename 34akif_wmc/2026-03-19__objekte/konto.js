
export class Konto {

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