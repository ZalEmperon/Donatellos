package Donatellos;

public class program {
  public static void main(String[] args) {
    service LayananMain = new service();
    view MainView = new view(LayananMain);
    MainView.viewStart();
  }
}
