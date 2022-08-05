package glmatrix;

public final class mat3 {

    private mat3() {
    }

    public static float[] create() {
        float[] out = new float[9];
        out[0] = 1;
        out[4] = 1;
        out[8] = 1;
        return out;
    }

    public static float[] fromMat4(float[] out, float[] a) {
        out[0] = a[0];
        out[1] = a[1];
        out[2] = a[2];
        out[3] = a[4];
        out[4] = a[5];
        out[5] = a[6];
        out[6] = a[8];
        out[7] = a[9];
        out[8] = a[10];
        return out;
    }

    public static float[] clone(float[] a) {
        float[] out = new float[9];
        out[0] = a[0];
        out[1] = a[1];
        out[2] = a[2];
        out[3] = a[3];
        out[4] = a[4];
        out[5] = a[5];
        out[6] = a[6];
        out[7] = a[7];
        out[8] = a[8];
        return out;
    }

    public static float[] copy(float[] out, float[] a) {
        out[0] = a[0];
        out[1] = a[1];
        out[2] = a[2];
        out[3] = a[3];
        out[4] = a[4];
        out[5] = a[5];
        out[6] = a[6];
        out[7] = a[7];
        out[8] = a[8];
        return out;
    }

    public static float[] fromValues(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        float[] out = new float[9];
        out[0] = m00;
        out[1] = m01;
        out[2] = m02;
        out[3] = m10;
        out[4] = m11;
        out[5] = m12;
        out[6] = m20;
        out[7] = m21;
        out[8] = m22;
        return out;
    }

    public static float[] set(float[] out, float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        out[0] = m00;
        out[1] = m01;
        out[2] = m02;
        out[3] = m10;
        out[4] = m11;
        out[5] = m12;
        out[6] = m20;
        out[7] = m21;
        out[8] = m22;
        return out;
    }

    public static float[] identity(float[] out) {
        out[0] = 1;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 1;
        out[5] = 0;
        out[6] = 0;
        out[7] = 0;
        out[8] = 1;
        return out;
    }

    public static float[] transpose(float[] out, float[] a) {
        if (out == a) {
            float a01 = a[1],
                a02 = a[2],
                a12 = a[5];
            out[1] = a[3];
            out[2] = a[6];
            out[3] = a01;
            out[5] = a[7];
            out[6] = a02;
            out[7] = a12;
        } else {
            out[0] = a[0];
            out[1] = a[3];
            out[2] = a[6];
            out[3] = a[1];
            out[4] = a[4];
            out[5] = a[7];
            out[6] = a[2];
            out[7] = a[5];
            out[8] = a[8];
        }
        return out;
    }

    public static float[] invert(float[] out, float[] a) {
        float a00 = a[0],
            a01 = a[1],
            a02 = a[2];
        float a10 = a[3],
            a11 = a[4],
            a12 = a[5];
        float a20 = a[6],
            a21 = a[7],
            a22 = a[8];
        float b01 = a22 * a11 - a12 * a21;
        float b11 = -a22 * a10 + a12 * a20;
        float b21 = a21 * a10 - a11 * a20;
        float det = a00 * b01 + a01 * b11 + a02 * b21;
        if (det == 0) {
            return null;
        }
        det = 1 / det;
        out[0] = b01 * det;
        out[1] = (-a22 * a01 + a02 * a21) * det;
        out[2] = (a12 * a01 - a02 * a11) * det;
        out[3] = b11 * det;
        out[4] = (a22 * a00 - a02 * a20) * det;
        out[5] = (-a12 * a00 + a02 * a10) * det;
        out[6] = b21 * det;
        out[7] = (-a21 * a00 + a01 * a20) * det;
        out[8] = (a11 * a00 - a01 * a10) * det;
        return out;
    }

    public static float[] adjoint(float[] out, float[] a) {
        float a00 = a[0],
        a01 = a[1],
        a02 = a[2];
        float a10 = a[3],
        a11 = a[4],
        a12 = a[5];
        float a20 = a[6],
        a21 = a[7],
        a22 = a[8];
        out[0] = a11 * a22 - a12 * a21;
        out[1] = a02 * a21 - a01 * a22;
        out[2] = a01 * a12 - a02 * a11;
        out[3] = a12 * a20 - a10 * a22;
        out[4] = a00 * a22 - a02 * a20;
        out[5] = a02 * a10 - a00 * a12;
        out[6] = a10 * a21 - a11 * a20;
        out[7] = a01 * a20 - a00 * a21;
        out[8] = a00 * a11 - a01 * a10;
        return out;
    }

    public static float determinant(float[] a) {
        float a00 = a[0],
            a01 = a[1],
            a02 = a[2];
        float a10 = a[3],
            a11 = a[4],
            a12 = a[5];
        float a20 = a[6],
            a21 = a[7],
            a22 = a[8];
        return a00 * (a22 * a11 - a12 * a21) +
            a01 * (-a22 * a10 + a12 * a20) +
            a02 * (a21 * a10 - a11 * a20);
    }

    public static float[] multiply(float[] out, float[] a, float[] b) {
        float a00 = a[0],
            a01 = a[1],
            a02 = a[2];
        float a10 = a[3],
            a11 = a[4],
            a12 = a[5];
        float a20 = a[6],
            a21 = a[7],
            a22 = a[8];
        float b00 = b[0],
            b01 = b[1],
            b02 = b[2];
        float b10 = b[3],
            b11 = b[4],
            b12 = b[5];
        float b20 = b[6],
            b21 = b[7],
            b22 = b[8];
        out[0] = b00 * a00 + b01 * a10 + b02 * a20;
        out[1] = b00 * a01 + b01 * a11 + b02 * a21;
        out[2] = b00 * a02 + b01 * a12 + b02 * a22;
        out[3] = b10 * a00 + b11 * a10 + b12 * a20;
        out[4] = b10 * a01 + b11 * a11 + b12 * a21;
        out[5] = b10 * a02 + b11 * a12 + b12 * a22;
        out[6] = b20 * a00 + b21 * a10 + b22 * a20;
        out[7] = b20 * a01 + b21 * a11 + b22 * a21;
        out[8] = b20 * a02 + b21 * a12 + b22 * a22;
        return out;
    }

    public static float[] translate(float[] out, float[] a, float[] v) {
        float a00 = a[0],
            a01 = a[1],
            a02 = a[2],
            a10 = a[3],
            a11 = a[4],
            a12 = a[5],
            a20 = a[6],
            a21 = a[7],
            a22 = a[8],
            x = v[0],
            y = v[1];
        out[0] = a00;
        out[1] = a01;
        out[2] = a02;
        out[3] = a10;
        out[4] = a11;
        out[5] = a12;
        out[6] = x * a00 + y * a10 + a20;
        out[7] = x * a01 + y * a11 + a21;
        out[8] = x * a02 + y * a12 + a22;
        return out;
    }

    public static float[] rotate(float[] out, float[] a, float rad) {
        float a00 = a[0],
            a01 = a[1],
            a02 = a[2],
            a10 = a[3],
            a11 = a[4],
            a12 = a[5],
            a20 = a[6],
            a21 = a[7],
            a22 = a[8],
            s = glMatrix.sin(rad),
            c = glMatrix.cos(rad);
        out[0] = c * a00 + s * a10;
        out[1] = c * a01 + s * a11;
        out[2] = c * a02 + s * a12;
        out[3] = c * a10 - s * a00;
        out[4] = c * a11 - s * a01;
        out[5] = c * a12 - s * a02;
        out[6] = a20;
        out[7] = a21;
        out[8] = a22;
        return out;
    }

    public static float[] scale(float[] out, float[] a, float[] v) {
        float x = v[0],
            y = v[1];
        out[0] = x * a[0];
        out[1] = x * a[1];
        out[2] = x * a[2];
        out[3] = y * a[3];
        out[4] = y * a[4];
        out[5] = y * a[5];
        out[6] = a[6];
        out[7] = a[7];
        out[8] = a[8];
        return out;
    }

    public static float[] fromTranslation(float[] out, float[] v) {
        out[0] = 1;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 1;
        out[5] = 0;
        out[6] = v[0];
        out[7] = v[1];
        out[8] = 1;
        return out;
    }

    public static float[] fromRotation(float[] out, float rad) {
        float s = glMatrix.sin(rad),
            c = glMatrix.cos(rad);
        out[0] = c;
        out[1] = s;
        out[2] = 0;
        out[3] = -s;
        out[4] = c;
        out[5] = 0;
        out[6] = 0;
        out[7] = 0;
        out[8] = 1;
        return out;
    }

    public static float[] fromScaling(float[] out, float[] v) {
        out[0] = v[0];
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = v[1];
        out[5] = 0;
        out[6] = 0;
        out[7] = 0;
        out[8] = 1;
        return out;
    }

    public static float[] fromMat2d(float[] out, float[] a) {
        out[0] = a[0];
        out[1] = a[1];
        out[2] = 0;
        out[3] = a[2];
        out[4] = a[3];
        out[5] = 0;
        out[6] = a[4];
        out[7] = a[5];
        out[8] = 1;
        return out;
    }

    public static float[] fromQuat(float[] out, float[] q) {
        float x = q[0],
            y = q[1],
            z = q[2],
            w = q[3];
        float x2 = x + x;
        float y2 = y + y;
        float z2 = z + z;
        float xx = x * x2;
        float yx = y * x2;
        float yy = y * y2;
        float zx = z * x2;
        float zy = z * y2;
        float zz = z * z2;
        float wx = w * x2;
        float wy = w * y2;
        float wz = w * z2;
        out[0] = 1 - yy - zz;
        out[3] = yx - wz;
        out[6] = zx + wy;
        out[1] = yx + wz;
        out[4] = 1 - xx - zz;
        out[7] = zy - wx;
        out[2] = zx - wy;
        out[5] = zy + wx;
        out[8] = 1 - xx - yy;
        return out;
    }

    public static float[] normalFromMat4(float[] out, float[] a) {
        float a00 = a[0],
            a01 = a[1],
            a02 = a[2],
            a03 = a[3];
        float a10 = a[4],
            a11 = a[5],
            a12 = a[6],
            a13 = a[7];
        float a20 = a[8],
            a21 = a[9],
            a22 = a[10],
            a23 = a[11];
        float a30 = a[12],
            a31 = a[13],
            a32 = a[14],
            a33 = a[15];
        float b00 = a00 * a11 - a01 * a10;
        float b01 = a00 * a12 - a02 * a10;
        float b02 = a00 * a13 - a03 * a10;
        float b03 = a01 * a12 - a02 * a11;
        float b04 = a01 * a13 - a03 * a11;
        float b05 = a02 * a13 - a03 * a12;
        float b06 = a20 * a31 - a21 * a30;
        float b07 = a20 * a32 - a22 * a30;
        float b08 = a20 * a33 - a23 * a30;
        float b09 = a21 * a32 - a22 * a31;
        float b10 = a21 * a33 - a23 * a31;
        float b11 = a22 * a33 - a23 * a32;
        float det = b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;
        if (det == 0) {
            return null;
        }
        det = 1 / det;
        out[0] = (a11 * b11 - a12 * b10 + a13 * b09) * det;
        out[1] = (a12 * b08 - a10 * b11 - a13 * b07) * det;
        out[2] = (a10 * b10 - a11 * b08 + a13 * b06) * det;
        out[3] = (a02 * b10 - a01 * b11 - a03 * b09) * det;
        out[4] = (a00 * b11 - a02 * b08 + a03 * b07) * det;
        out[5] = (a01 * b08 - a00 * b10 - a03 * b06) * det;
        out[6] = (a31 * b05 - a32 * b04 + a33 * b03) * det;
        out[7] = (a32 * b02 - a30 * b05 - a33 * b01) * det;
        out[8] = (a30 * b04 - a31 * b02 + a33 * b00) * det;
        return out;
    }

    public static float[] projection(float[] out, float width, float height) {
        out[0] = 2 / width;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = -2 / height;
        out[5] = 0;
        out[6] = -1;
        out[7] = 1;
        out[8] = 1;
        return out;
    }

    public static String str(float[] a) {
        return "mat3(" +
            a[0] +
            ", " +
            a[1] +
            ", " +
            a[2] +
            ", " +
            a[3] +
            ", " +
            a[4] +
            ", " +
            a[5] +
            ", " +
            a[6] +
            ", " +
            a[7] +
            ", " +
            a[8] +
            ")";
    }

    public static float frob(float[] a) {
        return glMatrix.hypot(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8]);
    }

    public static float[] add(float[] out, float[] a, float[] b) {
        out[0] = a[0] + b[0];
        out[1] = a[1] + b[1];
        out[2] = a[2] + b[2];
        out[3] = a[3] + b[3];
        out[4] = a[4] + b[4];
        out[5] = a[5] + b[5];
        out[6] = a[6] + b[6];
        out[7] = a[7] + b[7];
        out[8] = a[8] + b[8];
        return out;
    }

    public static float[] subtract(float[] out, float[] a, float[] b) {
        out[0] = a[0] - b[0];
        out[1] = a[1] - b[1];
        out[2] = a[2] - b[2];
        out[3] = a[3] - b[3];
        out[4] = a[4] - b[4];
        out[5] = a[5] - b[5];
        out[6] = a[6] - b[6];
        out[7] = a[7] - b[7];
        out[8] = a[8] - b[8];
        return out;
    }

    public static float[] multiplyScalar(float[] out, float[] a, float b) {
        out[0] = a[0] * b;
        out[1] = a[1] * b;
        out[2] = a[2] * b;
        out[3] = a[3] * b;
        out[4] = a[4] * b;
        out[5] = a[5] * b;
        out[6] = a[6] * b;
        out[7] = a[7] * b;
        out[8] = a[8] * b;
        return out;
    }

    public static float[] multiplyScalarAndAdd(float[] out, float[] a, float[] b, float scale) {
        out[0] = a[0] + b[0] * scale;
        out[1] = a[1] + b[1] * scale;
        out[2] = a[2] + b[2] * scale;
        out[3] = a[3] + b[3] * scale;
        out[4] = a[4] + b[4] * scale;
        out[5] = a[5] + b[5] * scale;
        out[6] = a[6] + b[6] * scale;
        out[7] = a[7] + b[7] * scale;
        out[8] = a[8] + b[8] * scale;
        return out;
    }

    public static boolean exactEquals(float[] a, float[] b) {
        return a[0] == b[0] &&
            a[1] == b[1] &&
            a[2] == b[2] &&
            a[3] == b[3] &&
            a[4] == b[4] &&
            a[5] == b[5] &&
            a[6] == b[6] &&
            a[7] == b[7] &&
            a[8] == b[8];
    }

    public static boolean equals(float[] a, float[] b) {
        float a0 = a[0],
            a1 = a[1],
            a2 = a[2],
            a3 = a[3],
            a4 = a[4],
            a5 = a[5],
            a6 = a[6],
            a7 = a[7],
            a8 = a[8];
        float b0 = b[0],
            b1 = b[1],
            b2 = b[2],
            b3 = b[3],
            b4 = b[4],
            b5 = b[5],
            b6 = b[6],
            b7 = b[7],
            b8 = b[8];
        return glMatrix.abs(a0 - b0) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a0), glMatrix.abs(b0)) &&
            glMatrix.abs(a1 - b1) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a1), glMatrix.abs(b1)) &&
            glMatrix.abs(a2 - b2) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a2), glMatrix.abs(b2)) &&
            glMatrix.abs(a3 - b3) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a3), glMatrix.abs(b3)) &&
            glMatrix.abs(a4 - b4) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a4), glMatrix.abs(b4)) &&
            glMatrix.abs(a5 - b5) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a5), glMatrix.abs(b5)) &&
            glMatrix.abs(a6 - b6) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a6), glMatrix.abs(b6)) &&
            glMatrix.abs(a7 - b7) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a7), glMatrix.abs(b7)) &&
            glMatrix.abs(a8 - b8) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a8), glMatrix.abs(b8));
    }

    public static float[] mul(float[] out, float[] a, float[] b) {
        return multiply(out, a, b);
    }

    public static float[] sub(float[] out, float[] a, float[] b) {
        return subtract(out, a, b);
    }
}
