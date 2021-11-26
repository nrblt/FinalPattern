package Observer;

public interface IObservable {
    void addUser(Observer obj);
    void deleteUser(Observer obj);
    void sendMessage();
//    void setScore(int x);
    Object getUpdate(IObserver obj);
}
