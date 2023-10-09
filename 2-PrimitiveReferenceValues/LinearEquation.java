public class LinearEquation
{
    private float m, b; // "private" is for encapsulation
        // m is for slope, b is for the y-intercept

    // constructors:
    public LinearEquation( float m1, float b1)
    {
        m = m1;
        b = b1;
    }

    // getters:
    public float getM()
    {
        return m;
    }
    public float getB()
    {
        return b;
    }
}
