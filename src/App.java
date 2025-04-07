import presenter.PresenterClass;

public class App {
    private PresenterClass presenter;
    public static void main(String[] args) throws Exception {
        App app = new App();
        try {
            app.presenter = new PresenterClass();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}