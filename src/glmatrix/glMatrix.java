package glmatrix;

public final class glMatrix {

    private glMatrix() {
    }

    public static final float EPSILON = 0.000001f;
    public static final float PI      = (float) Math.PI;

    public static float min(float a, float b) {
        return (float) Math.min(a, b);
    }

    public static float min(float a, float b, float c) {
        return min(a, min(b, c));
    }

    public static float max(float a, float b) {
        return (float) Math.max(a, b);
    }

    public static float max(float a, float b, float c) {
        return max(a, max(b, c));
    }

    public static float abs(float a) {
        return (float) Math.abs(a);
    }

    public static float sqrt(float a) {
        return (float) Math.sqrt(a);
    }

    public static float hypot(float a, float b) {
        return sqrt(a * a + b * b);
    }

    public static float hypot(float a, float b, float c) {
        return sqrt(a * a + b * b + c * c);
    }

    public static float hypot(
        float a, float b, float c,
        float d, float e, float f,
        float g, float h, float i
    ) {
        return sqrt(
            a * a + b * b + c * c +
            d * d + e * e + f * f +
            g * g + h * h + i * i
        );
    }

    public static float hypot(
        float a, float b, float c, float d,
        float e, float f, float g, float h,
        float i, float j, float k, float l,
        float m, float n, float o, float p
    ) {
        return sqrt(
            a * a + b * b + c * c + d * d +
            e * e + f * f + g * g + h * h +
            i * i + j * j + k * k + l * l +
            m * m + n * n + o * o + p * p
        );
    }

    public static float floor(float a) {
        return (float) Math.floor(a);
    }

    public static float round(float a) {
        return (float) Math.round(a);
    }

    public static float ceil(float a) {
        return (float) Math.ceil(a);
    }

    public static float sin(float a) {
        return (float) Math.sin(a);
    }

    public static float cos(float a) {
        return (float) Math.cos(a);
    }

    public static float tan(float a) {
        return (float) Math.tan(a);
    }

    public static float acos(float a) {
        return (float) Math.acos(a);
    }

    public static float toRadian(float a) {
        return (float) Math.toRadians(a);
    }

    public static float random() {
        return (float) Math.random();
    }
}
