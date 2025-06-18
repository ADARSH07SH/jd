

class a {
    public void show1() {
        System.out.println("from a");
    }
}

class b extends a {
    
    public void show2() {
        System.out.println("from b");
    }
}

public class Demo {

    public static void main(String[] args) {

        a obj = new b();
        obj.show1();
        b obj1 = (b) obj;
                obj1.show2();

    }

}
