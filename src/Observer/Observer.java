package Observer;

public class Observer implements IObserver{
    private Observable observable;
    private String name;
    private String msg;
    public Observer(Observable observable,String name){
        setObservable(observable);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update(String curUser) {
//        System.out.println("User "+ name+" won all 3 battles");
        msg="User "+curUser+" won all 3 battles";
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }
}
