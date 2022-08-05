package glmatrix;

public final class vec2 {

    private vec2() {
    }

    public static float[] create() {
        float[] out = new float[2];
        out[0] = 0;
        out[1] = 0;
        return out;
    }

    public static float[] clone(float[] a) {
        float[] out = new float[2];
        out[0] = a[0];
        out[1] = a[1];
        return out;
    }

    public static float[] fromValues(float x, float y) {
        float[] out = new float[2];
        out[0] = x;
        out[1] = y;
        return out;
    }

    public static float[] copy(float[] out, float[] a) {
        out[0] = a[0];
        out[1] = a[1];
        return out;
    }

    public static float[] set(float[] out, float x, float y) {
        out[0] = x;
        out[1] = y;
        return out;
    }

    public static float[] add(float[] out, float[] a, float[] b) {
        out[0] = a[0] + b[0];
        out[1] = a[1] + b[1];
        return out;
    }

    public static float[] subtract(float[] out, float[] a, float[] b) {
        out[0] = a[0] - b[0];
        out[1] = a[1] - b[1];
        return out;
    }

    public static float[] multiply(float[] out, float[] a, float[] b) {
        out[0] = a[0] * b[0];
        out[1] = a[1] * b[1];
        return out;
    }

    public static float[] divide(float[] out, float[] a, float[] b) {
        out[0] = a[0] / b[0];
        out[1] = a[1] / b[1];
        return out;
    }

    public static float[] ceil(float[] out, float[] a) {
        out[0] = glMatrix.ceil(a[0]);
        out[1] = glMatrix.ceil(a[1]);
        return out;
    }

    public static float[] floor(float[] out, float[] a) {
        out[0] = glMatrix.floor(a[0]);
        out[1] = glMatrix.floor(a[1]);
        return out;
    }

    public static float[] min(float[] out, float[] a, float[] b) {
        out[0] = glMatrix.min(a[0], b[0]);
        out[1] = glMatrix.min(a[1], b[1]);
        return out;
    }

    public static float[] max(float[] out, float[] a, float[] b) {
        out[0] = glMatrix.max(a[0], b[0]);
        out[1] = glMatrix.max(a[1], b[1]);
        return out;
    }

    public static float[] round(float[] out, float[] a) {
        out[0] = glMatrix.round(a[0]);
        out[1] = glMatrix.round(a[1]);
        return out;
    }

    public static float[] scale(float[] out, float[] a, float b) {
        out[0] = a[0] * b;
        out[1] = a[1] * b;
        return out;
    }

    public static float[] scaleAndAdd(float[] out, float[] a, float[] b, float scale) {
        out[0] = a[0] + b[0] * scale;
        out[1] = a[1] + b[1] * scale;
        return out;
    }

    public static float distance(float[] a, float[] b) {
        float x = b[0] - a[0],
            y = b[1] - a[1];
        return glMatrix.hypot(x, y);
    }

    public static float squaredDistance(float[] a, float[] b) {
        float x = b[0] - a[0],
            y = b[1] - a[1];
        return x * x + y * y;
    }

    public static float length(float[] a) {
        float x = a[0],
            y = a[1];
        return glMatrix.hypot(x, y);
    }

    public static float squaredLength(float[] a) {
        float x = a[0],
            y = a[1];
        return x * x + y * y;
    }

    public static float[] negate(float[] out, float[] a) {
        out[0] = -a[0];
        out[1] = -a[1];
        return out;
    }

    public static float[] inverse(float[] out, float[] a) {
        out[0] = 1 / a[0];
        out[1] = 1 / a[1];
        return out;
    }

    public static float[] normalize(float[] out, float[] a) {
        float x = a[0],
            y = a[1];
        float len = x * x + y * y;
        if (len > 0) {
            len = 1 / glMatrix.sqrt(len);
        }
        out[0] = a[0] * len;
        out[1] = a[1] * len;
        return out;
    }

    public static float dot(float[] a, float[] b) {
        return a[0] * b[0] + a[1] * b[1];
    }

    public static float[] cross(float[] out, float[] a, float[] b) {
        float z = a[0] * b[1] - a[1] * b[0];
        out[0] = out[1] = 0;
        out[2] = z;
        return out;
    }

    public static float[] lerp(float[] out, float[] a, float[] b, float t) {
        float ax = a[0],
            ay = a[1];
        out[0] = ax + t * (b[0] - ax);
        out[1] = ay + t * (b[1] - ay);
        return out;
    }

    public static float[] random(float[] out, float scale) {
        float r = glMatrix.random() * 2 * glMatrix.PI;
        out[0] = glMatrix.cos(r) * scale;
        out[1] = glMatrix.sin(r) * scale;
        return out;
    }

    public static float[] random(float[] out) {
        return random(out, 1);
    }

    public static float[] transformMat2(float[] out, float[] a, float[] m) {
        float x = a[0],
            y = a[1];
        out[0] = m[0] * x + m[2] * y;
        out[1] = m[1] * x + m[3] * y;
        return out;
    }

    public static float[] transformMat2d(float[] out, float[] a, float[] m) {
        float x = a[0],
            y = a[1];
        out[0] = m[0] * x + m[2] * y + m[4];
        out[1] = m[1] * x + m[3] * y + m[5];
        return out;
    }

    public static float[] transformMat3(float[] out, float[] a, float[] m) {
        float x = a[0],
            y = a[1];
        out[0] = m[0] * x + m[3] * y + m[6];
        out[1] = m[1] * x + m[4] * y + m[7];
        return out;
    }

    public static float[] transformMat4(float[] out, float[] a, float[] m) {
        float x = a[0];
        float y = a[1];
        out[0] = m[0] * x + m[4] * y + m[12];
        out[1] = m[1] * x + m[5] * y + m[13];
        return out;
    }

    public static float[] rotate(float[] out, float[] a, float[] b, float rad) {
        float p0 = a[0] - b[0],
            p1 = a[1] - b[1],
            sinC = glMatrix.sin(rad),
            cosC = glMatrix.cos(rad);
        out[0] = p0 * cosC - p1 * sinC + b[0];
        out[1] = p0 * sinC + p1 * cosC + b[1];
        return out;
    }

    public static float angle(float[] a, float[] b) {
        float x1 = a[0],
            y1 = a[1],
            x2 = b[0],
            y2 = b[1],
            mag = glMatrix.sqrt((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2)),
            cosine = mag == 0 ? mag : (x1 * x2 + y1 * y2) / mag;
        return glMatrix.acos(glMatrix.min(glMatrix.max(cosine, -1), 1));
    }

    public static float[] zero(float[] out) {
        out[0] = 0;
        out[1] = 0;
        return out;
    }

    public static String str(float[] a) {
        return "vec2(" + a[0] + ", " + a[1] + ")";
    }

    public static boolean exactEquals(float[] a, float[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public static boolean equals(float[] a, float[] b) {
        float a0 = a[0],
            a1 = a[1];
        float b0 = b[0],
            b1 = b[1];
        return glMatrix.abs(a0 - b0) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a0), glMatrix.abs(b0)) &&
            glMatrix.abs(a1 - b1) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a1), glMatrix.abs(b1));
    }

    public static float len(float[] a) {
        return length(a);
    }

    public static float[] sub(float[] out, float[] a, float[] b) {
        return subtract(out, a, b);
    }

    public static float[] mul(float[] out, float[] a, float[] b) {
        return multiply(out, a, b);
    }

    public static float[] div(float[] out, float[] a, float[] b) {
        return divide(out, a, b);
    }

    public static float dist(float[] a, float[] b) {
        return distance(a, b);
    }

    public static float sqrDist(float[] a, float[] b) {
        return squaredDistance(a, b);
    }

    public static float sqrLen(float[] a) {
        return squaredLength(a);
    }
}
