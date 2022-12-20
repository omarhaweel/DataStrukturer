
class Stabel<T> extends LenkeListe<T> {

  @Override
  public void leggTil(T x) {
    if (erTom()) {
      start = new Node(x);
    } else {
      Node midl = start;
      start = new Node(x);
      start.neste = midl;

    }
    iBruk++;
  }

  public T hent() {
    if (erTom()) {
      return null;
    } else {
      return start.data;
    }
  }

  public T fjern() throws UgyldigListeindeks {
    if (erTom()) {
      throw new UgyldigListeindeks(iBruk);
    } else {
      Node midl = start;

      start = midl.neste;
      iBruk--;
      return midl.data;

    }
  }

  public int stoerrelse() {
    return iBruk;
  }

  public boolean erTom() {
    return start == null;
  }

  public String toString() {
    String str = " ";
    Node node = start;
    for (int i = 0; i < this.stoerrelse(); i++) {
      str += node.data + " ";
      node = node.neste;
    }
    return str;
  }

}
