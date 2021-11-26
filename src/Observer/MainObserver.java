package Observer;

public class MainObserver {

    public static void main(String[] args) {
        Observable me=new Observable("aibek");//
        Observer obs=new Observer(me,"nurbolat");
        Observer er=new Observer(me,"lkelkhar");

        me.addUser(obs);
        me.addUser(er);

//        me.setScore(100);
//        me.setScore(90);
        me.sendMessage();
//        System.out.println(er.getMsg());
        System.out.println(obs.getMsg());

    }
}
