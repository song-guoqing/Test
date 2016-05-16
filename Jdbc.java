
public class Jdbc {
    public <T> void selectOne(Object param, T t) {
    	T ret = t;
    	return;
    }
    
    public void call() {
    	int ss = 1;
    	selectOne(ss,ss);
    	System.out.println(ss+"sdfsdfsdfs");
    }
    
    public static void main(String[] args) {
		new Jdbc().call();
	}
}
