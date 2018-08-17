package javabasis;

public class Derived extends Base {

    public String whenAmISet;

    @Override
    void preProcess() {

        whenAmISet = "set in preProcess";

    }

    public static void main(String[] args) {
        Derived d = new Derived();
        System.out.println(d.whenAmISet);
    }
}
class Base {

    Base() {
        preProcess();
    }

    void preProcess() {
    }
}