//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
  // to see how IntelliJ IDEA suggests fixing it.
  int wert = 2;

  switch (wert) {
    case 0: {
      System.out.println("Null");
      break;
    }
    case 1:
      System.out.println("Eins");
      break;
    case 2:
      System.out.println("Zwei");
      break;
    case 3:
      System.out.println("Drei");
      break;
    default:
      System.out.println("Andere Wert");
  }

}
