package presenter;

import view.ViewClass;

public class PresenterClass {
    private ViewClass view;

    public PresenterClass() {
        view = new ViewClass();
        this.inicioSecion();
    }

    public void inicioSecion(){
        view.showMenuSession();
    }
    
}
