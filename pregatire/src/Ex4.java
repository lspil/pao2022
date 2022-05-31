public class Ex4 {
}

class A {
  public A met1() { return new A(); }
    final void met2() {}
    public void met3() {}
    public static void met4() {}
    private int met5(int i) {return 5;}
}

class B extends  A {
    @Override
    public B met1() {return new B();}  // override

    //public void met2() {}  error

    //private void met3() {} error

    //public static void met4() {} error
}