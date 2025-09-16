import controller.RacingController;

public class Application {
    public static void main(String[] args) {
      try {
        new RacingController().run();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
}