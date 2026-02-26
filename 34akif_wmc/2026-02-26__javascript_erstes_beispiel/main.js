import { Person } from "./Person.js"
import { Sortieren } from "./Sortieren.js"



const bs = new Sortieren(10);
bs.bubbleSort();
bs.print();

const p = new Person("Alice", 1987, 'w');
const v = p.vorstellen();
console.log(`Person stellt sich vor: ${v}`);
