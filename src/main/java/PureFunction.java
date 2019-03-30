public class PureFunction {

    int value;
    /*
     *
     * A method, which modifies neither the state of its enclosing class
     * nor the state of any other objects and returns its entire results
     * using return, is called pure or side-effect free.
     */
    public int pureFunction(final int a, final  int b){
        return a*b;
    }

    //non pure
    public int nonPureFunction(final int a){
        this.value +=a;
        return this.value;
    }

}
