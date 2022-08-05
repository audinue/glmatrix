package glmatrix;

public final class vec3 {

    private vec3() {
    }

    public static float[] create() {
        return new float[3];
    }

    public static float[] clone(float[] a) {
        float[] out = new float[3];
        out[0] = a[0];
        out[1] = a[1];
        out[2] = a[2];
        return out;
    }

    public static float length(float[] a) {
        float x = a[0];
        float y = a[1];
        float z = a[2];
        return glMatrix.hypot(x, y, z);
    }

    public static float[] fromValues(float x, float y, float z) {
        float[] out = new float[3];
        out[0] = x;
        out[1] = y;
        out[2] = z;
        return out;
    }

    public static float[] copy(float[] out, float[] a) {
        out[0] = a[0];
        out[1] = a[1];
        out[2] = a[2];
        return out;
    }

    public static float[] set(float[] out, float x, float y, float z) {
        out[0] = x;
        out[1] = y;
        out[2] = z;
        return out;
    }

    public static float[] add(float[] out, float[] a, float[] b) {
        out[0] = a[0] + b[0];
        out[1] = a[1] + b[1];
        out[2] = a[2] + b[2];
        return out;
    }

    public static float[] subtract(float[] out, float[] a, float[] b) {
        out[0] = a[0] - b[0];
        out[1] = a[1] - b[1];
        out[2] = a[2] - b[2];
        return out;
    }

    public static float[] multiply(float[] out, float[] a, float[] b) {
        out[0] = a[0] * b[0];
        out[1] = a[1] * b[1];
        out[2] = a[2] * b[2];
        return out;
    }

    public static float[] divide(float[] out, float[] a, float[] b) {
        out[0] = a[0] / b[0];
        out[1] = a[1] / b[1];
        out[2] = a[2] / b[2];
        return out;
    }

    public static float[] ceil(float[] out, float[] a) {
        out[0] = glMatrix.ceil(a[0]);
        out[1] = glMatrix.ceil(a[1]);
        out[2] = glMatrix.ceil(a[2]);
        return out;
    }

    public static float[] floor(float[] out, float[] a) {
        out[0] = glMatrix.floor(a[0]);
        out[1] = glMatrix.floor(a[1]);
        out[2] = glMatrix.floor(a[2]);
        return out;
    }

    public static float[] min(float[] out, float[] a, float[] b) {
        out[0] = glMatrix.min(a[0], b[0]);
        out[1] = glMatrix.min(a[1], b[1]);
        out[2] = glMatrix.min(a[2], b[2]);
        return out;
    }

    public static float[] max(float[] out, float[] a, float[] b) {
        out[0] = glMatrix.max(a[0], b[0]);
        out[1] = glMatrix.max(a[1], b[1]);
        out[2] = glMatrix.max(a[2], b[2]);
        return out;
    }

    public static float[] round(float[] out, float[] a) {
        out[0] = glMatrix.round(a[0]);
        out[1] = glMatrix.round(a[1]);
        out[2] = glMatrix.round(a[2]);
        return out;
    }

    public static float[] scale(float[] out, float[] a, float b) {
        out[0] = a[0] * b;
        out[1] = a[1] * b;
        out[2] = a[2] * b;
        return out;
    }

    public static float[] scaleAndAdd(float[] out, float[] a, float[] b, float scale) {
        out[0] = a[0] + b[0] * scale;
        out[1] = a[1] + b[1] * scale;
        out[2] = a[2] + b[2] * scale;
        return out;
    }

    public static float distance(float[] a, float[] b) {
        float x = b[0] - a[0];
        float y = b[1] - a[1];
        float z = b[2] - a[2];
        return glMatrix.hypot(x, y, z);
    }

    public static float squaredDistance(float[] a, float[] b) {
        float x = b[0] - a[0];
        float y = b[1] - a[1];
        float z = b[2] - a[2];
        return x * x + y * y + z * z;
    }

    public static float squaredLength(float[] a) {
        float x = a[0];
        float y = a[1];
        float z = a[2];
        return x * x + y * y + z * z;
    }

    public static float[] negate(float[] out, float[] a) {
        out[0] = -a[0];
        out[1] = -a[1];
        out[2] = -a[2];
        return out;
    }

    public static float[] inverse(float[] out, float[] a) {
        out[0] = 1 / a[0];
        out[1] = 1 / a[1];
        out[2] = 1 / a[2];
        return out;
    }

    public static float[] normalize(float[] out, float[] a) {
        float x = a[0];
        float y = a[1];
        float z = a[2];
        float len = x * x + y * y + z * z;
        if (len > 0) {
            len = 1 / glMatrix.sqrt(len);
        }
        out[0] = a[0] * len;
        out[1] = a[1] * len;
        out[2] = a[2] * len;
        return out;
    }

    public static float dot(float[] a, float[] b) {
        return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
    }

    public static float[] cross(float[] out, float[] a, float[] b) {
        float ax = a[0],
            ay = a[1],
            az = a[2];
        float bx = b[0],
            by = b[1],
            bz = b[2];
        out[0] = ay * bz - az * by;
        out[1] = az * bx - ax * bz;
        out[2] = ax * by - ay * bx;
        return out;
    }

    public static float[] lerp(float[] out, float[] a, float[] b, float t) {
        float ax = a[0];
        float ay = a[1];
        float az = a[2];
        out[0] = ax + t * (b[0] - ax);
        out[1] = ay + t * (b[1] - ay);
        out[2] = az + t * (b[2] - az);
        return out;
    }

    public static float[] slerp(float[] out, float[] a, float[] b, float t) {
        float angle = glMatrix.acos(glMatrix.min(glMatrix.max(dot(a, b), -1), 1));
        float sinTotal = glMatrix.sin(angle);
        float ratioA = glMatrix.sin((1 - t) * angle) / sinTotal;
        float ratioB = glMatrix.sin(t * angle) / sinTotal;
        out[0] = ratioA * a[0] + ratioB * b[0];
        out[1] = ratioA * a[1] + ratioB * b[1];
        out[2] = ratioA * a[2] + ratioB * b[2];
        return out;
    }

    public static float[] hermite(float[] out, float[] a, float[] b, float[] c, float[] d, float t) {
        float factorTimes2 = t * t;
        float factor1 = factorTimes2 * (2 * t - 3) + 1;
        float factor2 = factorTimes2 * (t - 2) + t;
        float factor3 = factorTimes2 * (t - 1);
        float factor4 = factorTimes2 * (3 - 2 * t);
        out[0] = a[0] * factor1 + b[0] * factor2 + c[0] * factor3 + d[0] * factor4;
        out[1] = a[1] * factor1 + b[1] * factor2 + c[1] * factor3 + d[1] * factor4;
        out[2] = a[2] * factor1 + b[2] * factor2 + c[2] * factor3 + d[2] * factor4;
        return out;
    }

    public static float[] bezier(float[] out, float[] a, float[] b, float[] c, float[] d, float t) {
        float inverseFactor = 1 - t;
        float inverseFactorTimesTwo = inverseFactor * inverseFactor;
        float factorTimes2 = t * t;
        float factor1 = inverseFactorTimesTwo * inverseFactor;
        float factor2 = 3 * t * inverseFactorTimesTwo;
        float factor3 = 3 * factorTimes2 * inverseFactor;
        float factor4 = factorTimes2 * t;
        out[0] = a[0] * factor1 + b[0] * factor2 + c[0] * factor3 + d[0] * factor4;
        out[1] = a[1] * factor1 + b[1] * factor2 + c[1] * factor3 + d[1] * factor4;
        out[2] = a[2] * factor1 + b[2] * factor2 + c[2] * factor3 + d[2] * factor4;
        return out;
    }

    public static float[] random(float[] out, float scale) {
        float r = glMatrix.random() * 2 * glMatrix.PI;
        float z = glMatrix.random() * 2 - 1;
        float zScale = glMatrix.sqrt(1 - z * z) * scale;
        out[0] = glMatrix.cos(r) * zScale;
        out[1] = glMatrix.sin(r) * zScale;
        out[2] = z * scale;
        return out;
    }

    public static float[] random(float[] out) {
        return random(out, 1);
    }

    public static float[] transformMat4(float[] out, float[] a, float[] m) {
        float x = a[0],
            y = a[1],
            z = a[2];
        float w = m[3] * x + m[7] * y + m[11] * z + m[15];
        if (w == 0) {
            w = 1;
        }
        out[0] = (m[0] * x + m[4] * y + m[8] * z + m[12]) / w;
        out[1] = (m[1] * x + m[5] * y + m[9] * z + m[13]) / w;
        out[2] = (m[2] * x + m[6] * y + m[10] * z + m[14]) / w;
        return out;
    }

    public static float[] transformMat3(float[] out, float[] a, float[] m) {
        float x = a[0],
            y = a[1],
            z = a[2];
        out[0] = x * m[0] + y * m[3] + z * m[6];
        out[1] = x * m[1] + y * m[4] + z * m[7];
        out[2] = x * m[2] + y * m[5] + z * m[8];
        return out;
    }

    public static float[] transformQuat(float[] out, float[] a, float[] q) {
        float qx = q[0],
            qy = q[1],
            qz = q[2],
            qw = q[3];
        float x = a[0],
            y = a[1],
            z = a[2];
        float uvx = qy * z - qz * y,
            uvy = qz * x - qx * z,
            uvz = qx * y - qy * x;
        float uuvx = qy * uvz - qz * uvy,
            uuvy = qz * uvx - qx * uvz,
            uuvz = qx * uvy - qy * uvx;
        float w2 = qw * 2;
        uvx *= w2;
        uvy *= w2;
        uvz *= w2;
        uuvx *= 2;
        uuvy *= 2;
        uuvz *= 2;
        out[0] = x + uvx + uuvx;
        out[1] = y + uvy + uuvy;
        out[2] = z + uvz + uuvz;
        return out;
    }

    public static float[] rotateX(float[] out, float[] a, float[] b, float rad) {
        float[] p = new float[3], // GARBAGE
            r = new float[3];     // GARBAGE
        p[0] = a[0] - b[0];
        p[1] = a[1] - b[1];
        p[2] = a[2] - b[2];
        r[0] = p[0];
        r[1] = p[1] * glMatrix.cos(rad) - p[2] * glMatrix.sin(rad);
        r[2] = p[1] * glMatrix.sin(rad) + p[2] * glMatrix.cos(rad);
        out[0] = r[0] + b[0];
        out[1] = r[1] + b[1];
        out[2] = r[2] + b[2];
        return out;
    }

    public static float[] rotateY(float[] out, float[] a, float[] b, float rad) {
        float[] p = new float[3], // GARBAGE
            r = new float[3];     // GARBAGE
        p[0] = a[0] - b[0];
        p[1] = a[1] - b[1];
        p[2] = a[2] - b[2];
        r[0] = p[2] * glMatrix.sin(rad) + p[0] * glMatrix.cos(rad);
        r[1] = p[1];
        r[2] = p[2] * glMatrix.cos(rad) - p[0] * glMatrix.sin(rad);
        out[0] = r[0] + b[0];
        out[1] = r[1] + b[1];
        out[2] = r[2] + b[2];
        return out;
    }

    public static float[] rotateZ(float[] out, float[] a, float[] b, float rad) {
        float[] p = new float[3], // GARBAGE
            r = new float[3];     // GARBAGE
        p[0] = a[0] - b[0];
        p[1] = a[1] - b[1];
        p[2] = a[2] - b[2];
        r[0] = p[0] * glMatrix.cos(rad) - p[1] * glMatrix.sin(rad);
        r[1] = p[0] * glMatrix.sin(rad) + p[1] * glMatrix.cos(rad);
        r[2] = p[2];
        out[0] = r[0] + b[0];
        out[1] = r[1] + b[1];
        out[2] = r[2] + b[2];
        return out;
    }

    public static float angle(float[] a, float[] b) {
        float ax = a[0],
            ay = a[1],
            az = a[2],
            bx = b[0],
            by = b[1],
            bz = b[2],
            mag = glMatrix.sqrt((ax * ax + ay * ay + az * az) * (bx * bx + by * by + bz * bz)),
            cosine = mag == 0 ? mag : dot(a, b) / mag;
        return glMatrix.acos(glMatrix.min(glMatrix.max(cosine, -1), 1));
    }

    public static float[] zero(float[] out) {
        out[0] = 0;
        out[1] = 0;
        out[2] = 0;
        return out;
    }

    public static String str(float[] a) {
        return "vec3(" + a[0] + ", " + a[1] + ", " + a[2] + ")";
    }

    public static boolean exactEquals(float[] a, float[] b) {
        return a[0] == b[0] && a[1] == b[1] && a[2] == b[2];
    }

    public static boolean equals(float[] a, float[] b) {
        float a0 = a[0],
            a1 = a[1],
            a2 = a[2];
        float b0 = b[0],
            b1 = b[1],
            b2 = b[2];
        return glMatrix.abs(a0 - b0) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a0), glMatrix.abs(b0)) &&
            glMatrix.abs(a1 - b1) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a1), glMatrix.abs(b1)) &&
            glMatrix.abs(a2 - b2) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a2), glMatrix.abs(b2));
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

    public static float len(float[] a) {
        return length(a);
    }

    public static float sqrLen(float[] a) {
        return squaredLength(a);
    }
}
