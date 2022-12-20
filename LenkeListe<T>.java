
abstract class LenkeListe<T> implements Liste<T> {

  protected Node start;
  protected int iBruk = 0;

  @Override
  public void leggTil(T x) {
    Node ny = new Node(x);
    if (stoerrelse() == 0) {
      start = ny;
      iBruk++;
    } else {
      Node midl = start;
      for (int i = 0; i < stoerrelse() - 1; i++) {
        midl = midl.neste;
      }
      midl.neste = ny;
      iBruk++;
    }

  }

  public T fjern() throws UgyldigListeindeks {
    if (stoerrelse() == 0) {
      throw new UgyldigListeindeks(iBruk);
    } else {
      Node midl = start;

      start = midl.neste;
      iBruk--;
      return midl.data;
    }
  }

  public T hent() throws UgyldigListeindeks {
    if (stoerrelse() != 0) {
      return start.data;
    } else {
      throw new UgyldigListeindeks(stoerrelse());
    }

  }

  public int stoerrelse() {
    return iBruk;
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

  public class Node {
    protected T data;
    protected Node neste;

    protected Node(T data) {
      this.data = data;
    }
  }
}
