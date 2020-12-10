package inflearn.spring_basic_lecture.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService(){

    }

    public static SingletonService getInstance(){
        return instance;
    }

    private void logic(){
        System.out.println("싱글톤 로직 호출");
    }
}
