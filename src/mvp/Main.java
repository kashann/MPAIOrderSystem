package mvp;

import mvp.model.Angajat;
import mvp.presenter.PresenterClass;
import mvp.view.ViewClass;

public class Main {

	public static void main(String[] args) {
		ViewClass v = new ViewClass();
		//Angajat angajat = new Angajat("Ionel", 2000);
		PresenterClass presenter = new PresenterClass(v);
		//presenter.setAngajat(angajat);
		//v.refreshUI(presenter.getAngajat());
	}

}
