/*

1) 
  - Prioritäten für die TODO Items verwenden/anzeigen
  - Items nach Prioritäten sortiert anzeigen
  - Prioritäten änderbar über Buttons
  - Bei max/min Prio den jeweiligen Button deaktivieren/aktivieren

2) 
  - Bei Löschen: Rückfrage ob wirklich gelöscht werden soll
*/

import TodoItem from './todo-item.js';

// 1. APPLICATION STATE
const todos = [
  new TodoItem('WMC programmieren', false, 1),
  new TodoItem('CABS lernen', false, 3),
  new TodoItem('NSCS lernen', true, 2),
  new TodoItem('POS/Theorie lernen', false, 2),
  new TodoItem('POS/Java üben', false, 1)
];


// 2. STATE ACCESSORS/MUTATORS FN'S

function deleteTodoItem(todo) {
  const idx = todos.indexOf(todo);
  if (idx !== -1) {
    todos.splice(idx, 1);
  }
}

function addNewTodoItemToState(text) {
  todos.push(new TodoItem(text));
}

// 3. DOM Node Refs
const newTodoText = document.getElementById("todo-input");
const addBtn = document.getElementById("todo-add");
const todoList = document.getElementById("todo-list");
const todoListDone = document.getElementById("todo-list-done");

// 4. DOM Node Creation Fn's
function createTodoElement(todo) {
  const element = document.createElement("li");
  element.className = 'todo-item';

  const cb = document.createElement("input");
  cb.type = "checkbox";
  if (todo.completed) {
    cb.checked = true;
  }
  cb.addEventListener("change", _ => onTodoStatusChanged(todo));

  const delBtn = document.createElement("button");
  delBtn.textContent = "delete";
  delBtn.className = "todo-delete";
  delBtn.addEventListener("click", _ => onTodoObjectDelete(todo));

  const text = document.createElement("span");
  text.innerHTML = todo.text;
  
  element.append(cb, text, delBtn);

  return element;
}


// 5. RENDER FN
function render() {
  todoList.innerHTML = "";
  todoListDone.innerHTML = "";
  for (let todoItem of todos) {
    const todoElement = createTodoElement(todoItem);
    if (!todoItem.completed) {
      todoList.append(todoElement);
    } else {
      todoListDone.append(todoElement);
    }
  }
}

// 6. EVENT HANDLERS
function onAddButtonPressed() {
  console.log("Add Button gedrückt");
  const text = newTodoText.value.trim();
  if (!text) {
    return;
  }
  addNewTodoItemToState(text);
  newTodoText.value = "";
  render();
}

function onTodoStatusChanged(todo) {
  todo.toggleCompleted();
  render();
}

function onTodoObjectDelete(todo) {
  deleteTodoItem(todo);
  render();
}

// 7. INIT BINDINGS
addBtn.addEventListener("click", _ => onAddButtonPressed());

// 8. INITIAL RENDER
render();