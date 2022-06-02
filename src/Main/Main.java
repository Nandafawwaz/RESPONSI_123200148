package Main;

public class Main {

public static void main(String[] args) {

        view v = new view();
        model m = new model();
        controller c = new controller(m,v);
        }

}
