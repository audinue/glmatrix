package glmatrix;

public final class mat4 {

    private mat4() {
    }

    public static float[] create() {
        float[] out = new float[16];
        out[0] = 1;
        out[5] = 1;
        out[10] = 1;
        out[15] = 1;
        return out;
    }

    public static float[] clone(float[] a) {
        float[] out = new float[16];
        out[0] = a[0];
        out[1] = a[1];
        out[2] = a[2];
        out[3] = a[3];
        out[4] = a[4];
        out[5] = a[5];
        out[6] = a[6];
        out[7] = a[7];
        out[8] = a[8];
        out[9] = a[9];
        out[10] = a[10];
        out[11] = a[11];
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
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
        out[9] = a[9];
        out[10] = a[10];
        out[11] = a[11];
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
        return out;
    }

    public static float[] fromValues(
        float m00,
        float m01,
        float m02,
        float m03,
        float m10,
        float m11,
        float m12,
        float m13,
        float m20,
        float m21,
        float m22,
        float m23,
        float m30,
        float m31,
        float m32,
        float m33
    ) {
        float[] out = new float[16];
        out[0] = m00;
        out[1] = m01;
        out[2] = m02;
        out[3] = m03;
        out[4] = m10;
        out[5] = m11;
        out[6] = m12;
        out[7] = m13;
        out[8] = m20;
        out[9] = m21;
        out[10] = m22;
        out[11] = m23;
        out[12] = m30;
        out[13] = m31;
        out[14] = m32;
        out[15] = m33;
        return out;
    }

    public static float[] set(
        float[] out,
        float m00,
        float m01,
        float m02,
        float m03,
        float m10,
        float m11,
        float m12,
        float m13,
        float m20,
        float m21,
        float m22,
        float m23,
        float m30,
        float m31,
        float m32,
        float m33
    ) {
        out[0] = m00;
        out[1] = m01;
        out[2] = m02;
        out[3] = m03;
        out[4] = m10;
        out[5] = m11;
        out[6] = m12;
        out[7] = m13;
        out[8] = m20;
        out[9] = m21;
        out[10] = m22;
        out[11] = m23;
        out[12] = m30;
        out[13] = m31;
        out[14] = m32;
        out[15] = m33;
        return out;
    }

    public static float[] identity(float[] out) {
        out[0] = 1;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = 1;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = 1;
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] transpose(float[] out, float[] a) {
        if (out == a) {
            float a01 = a[1],
                a02 = a[2],
                a03 = a[3];
            float a12 = a[6],
                a13 = a[7];
            float a23 = a[11];
            out[1] = a[4];
            out[2] = a[8];
            out[3] = a[12];
            out[4] = a01;
            out[6] = a[9];
            out[7] = a[13];
            out[8] = a02;
            out[9] = a12;
            out[11] = a[14];
            out[12] = a03;
            out[13] = a13;
            out[14] = a23;
        } else {
            out[0] = a[0];
            out[1] = a[4];
            out[2] = a[8];
            out[3] = a[12];
            out[4] = a[1];
            out[5] = a[5];
            out[6] = a[9];
            out[7] = a[13];
            out[8] = a[2];
            out[9] = a[6];
            out[10] = a[10];
            out[11] = a[14];
            out[12] = a[3];
            out[13] = a[7];
            out[14] = a[11];
            out[15] = a[15];
        }
        return out;
    }

    public static float[] invert(float[] out, float[] a) {
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
        float det =
            b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06;
        if (det == 0) {
            return null;
        }
        det = 1 / det;
        out[0] = (a11 * b11 - a12 * b10 + a13 * b09) * det;
        out[1] = (a02 * b10 - a01 * b11 - a03 * b09) * det;
        out[2] = (a31 * b05 - a32 * b04 + a33 * b03) * det;
        out[3] = (a22 * b04 - a21 * b05 - a23 * b03) * det;
        out[4] = (a12 * b08 - a10 * b11 - a13 * b07) * det;
        out[5] = (a00 * b11 - a02 * b08 + a03 * b07) * det;
        out[6] = (a32 * b02 - a30 * b05 - a33 * b01) * det;
        out[7] = (a20 * b05 - a22 * b02 + a23 * b01) * det;
        out[8] = (a10 * b10 - a11 * b08 + a13 * b06) * det;
        out[9] = (a01 * b08 - a00 * b10 - a03 * b06) * det;
        out[10] = (a30 * b04 - a31 * b02 + a33 * b00) * det;
        out[11] = (a21 * b02 - a20 * b04 - a23 * b00) * det;
        out[12] = (a11 * b07 - a10 * b09 - a12 * b06) * det;
        out[13] = (a00 * b09 - a01 * b07 + a02 * b06) * det;
        out[14] = (a31 * b01 - a30 * b03 - a32 * b00) * det;
        out[15] = (a20 * b03 - a21 * b01 + a22 * b00) * det;
        return out;
    }

    public static float[] adjoint(float[] out, float[] a) {
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
        out[0] = a11 * b11 - a12 * b10 + a13 * b09;
        out[1] = a02 * b10 - a01 * b11 - a03 * b09;
        out[2] = a31 * b05 - a32 * b04 + a33 * b03;
        out[3] = a22 * b04 - a21 * b05 - a23 * b03;
        out[4] = a12 * b08 - a10 * b11 - a13 * b07;
        out[5] = a00 * b11 - a02 * b08 + a03 * b07;
        out[6] = a32 * b02 - a30 * b05 - a33 * b01;
        out[7] = a20 * b05 - a22 * b02 + a23 * b01;
        out[8] = a10 * b10 - a11 * b08 + a13 * b06;
        out[9] = a01 * b08 - a00 * b10 - a03 * b06;
        out[10] = a30 * b04 - a31 * b02 + a33 * b00;
        out[11] = a21 * b02 - a20 * b04 - a23 * b00;
        out[12] = a11 * b07 - a10 * b09 - a12 * b06;
        out[13] = a00 * b09 - a01 * b07 + a02 * b06;
        out[14] = a31 * b01 - a30 * b03 - a32 * b00;
        out[15] = a20 * b03 - a21 * b01 + a22 * b00;
        return out;
    }

    public static float determinant(float[] a) {
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
        float b0 = a00 * a11 - a01 * a10;
        float b1 = a00 * a12 - a02 * a10;
        float b2 = a01 * a12 - a02 * a11;
        float b3 = a20 * a31 - a21 * a30;
        float b4 = a20 * a32 - a22 * a30;
        float b5 = a21 * a32 - a22 * a31;
        float b6 = a00 * b5 - a01 * b4 + a02 * b3;
        float b7 = a10 * b5 - a11 * b4 + a12 * b3;
        float b8 = a20 * b2 - a21 * b1 + a22 * b0;
        float b9 = a30 * b2 - a31 * b1 + a32 * b0;
        return a13 * b6 - a03 * b7 + a33 * b8 - a23 * b9;
    }

    public static float[] multiply(float[] out, float[] a, float[] b) {
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
        float b0 = b[0],
            b1 = b[1],
            b2 = b[2],
            b3 = b[3];
        out[0] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[1] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[2] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[3] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        b0 = b[4];
        b1 = b[5];
        b2 = b[6];
        b3 = b[7];
        out[4] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[5] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[6] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[7] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        b0 = b[8];
        b1 = b[9];
        b2 = b[10];
        b3 = b[11];
        out[8] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[9] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[10] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[11] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        b0 = b[12];
        b1 = b[13];
        b2 = b[14];
        b3 = b[15];
        out[12] = b0 * a00 + b1 * a10 + b2 * a20 + b3 * a30;
        out[13] = b0 * a01 + b1 * a11 + b2 * a21 + b3 * a31;
        out[14] = b0 * a02 + b1 * a12 + b2 * a22 + b3 * a32;
        out[15] = b0 * a03 + b1 * a13 + b2 * a23 + b3 * a33;
        return out;
    }

    public static float[] translate(float[] out, float[] a, float[] v) {
        float x = v[0],
            y = v[1],
            z = v[2];
        float a00, a01, a02, a03;
        float a10, a11, a12, a13;
        float a20, a21, a22, a23;
        if (a == out) {
            out[12] = a[0] * x + a[4] * y + a[8] * z + a[12];
            out[13] = a[1] * x + a[5] * y + a[9] * z + a[13];
            out[14] = a[2] * x + a[6] * y + a[10] * z + a[14];
            out[15] = a[3] * x + a[7] * y + a[11] * z + a[15];
        } else {
            a00 = a[0];
            a01 = a[1];
            a02 = a[2];
            a03 = a[3];
            a10 = a[4];
            a11 = a[5];
            a12 = a[6];
            a13 = a[7];
            a20 = a[8];
            a21 = a[9];
            a22 = a[10];
            a23 = a[11];
            out[0] = a00;
            out[1] = a01;
            out[2] = a02;
            out[3] = a03;
            out[4] = a10;
            out[5] = a11;
            out[6] = a12;
            out[7] = a13;
            out[8] = a20;
            out[9] = a21;
            out[10] = a22;
            out[11] = a23;
            out[12] = a00 * x + a10 * y + a20 * z + a[12];
            out[13] = a01 * x + a11 * y + a21 * z + a[13];
            out[14] = a02 * x + a12 * y + a22 * z + a[14];
            out[15] = a03 * x + a13 * y + a23 * z + a[15];
        }
        return out;
    }

    public static float[] scale(float[] out, float[] a, float[] v) {
        float x = v[0],
            y = v[1],
            z = v[2];
        out[0] = a[0] * x;
        out[1] = a[1] * x;
        out[2] = a[2] * x;
        out[3] = a[3] * x;
        out[4] = a[4] * y;
        out[5] = a[5] * y;
        out[6] = a[6] * y;
        out[7] = a[7] * y;
        out[8] = a[8] * z;
        out[9] = a[9] * z;
        out[10] = a[10] * z;
        out[11] = a[11] * z;
        out[12] = a[12];
        out[13] = a[13];
        out[14] = a[14];
        out[15] = a[15];
        return out;
    }

    public static float[] rotate(float[] out, float[] a, float rad, float[] axis) {
        float x = axis[0],
            y = axis[1],
            z = axis[2];
        float len = glMatrix.hypot(x, y, z);
        float s, c, t;
        float a00, a01, a02, a03;
        float a10, a11, a12, a13;
        float a20, a21, a22, a23;
        float b00, b01, b02;
        float b10, b11, b12;
        float b20, b21, b22;
        if (len < glMatrix.EPSILON) {
            return null;
        }
        len = 1 / len;
        x *= len;
        y *= len;
        z *= len;
        s = glMatrix.sin(rad);
        c = glMatrix.cos(rad);
        t = 1 - c;
        a00 = a[0];
        a01 = a[1];
        a02 = a[2];
        a03 = a[3];
        a10 = a[4];
        a11 = a[5];
        a12 = a[6];
        a13 = a[7];
        a20 = a[8];
        a21 = a[9];
        a22 = a[10];
        a23 = a[11];
        b00 = x * x * t + c;
        b01 = y * x * t + z * s;
        b02 = z * x * t - y * s;
        b10 = x * y * t - z * s;
        b11 = y * y * t + c;
        b12 = z * y * t + x * s;
        b20 = x * z * t + y * s;
        b21 = y * z * t - x * s;
        b22 = z * z * t + c;
        out[0] = a00 * b00 + a10 * b01 + a20 * b02;
        out[1] = a01 * b00 + a11 * b01 + a21 * b02;
        out[2] = a02 * b00 + a12 * b01 + a22 * b02;
        out[3] = a03 * b00 + a13 * b01 + a23 * b02;
        out[4] = a00 * b10 + a10 * b11 + a20 * b12;
        out[5] = a01 * b10 + a11 * b11 + a21 * b12;
        out[6] = a02 * b10 + a12 * b11 + a22 * b12;
        out[7] = a03 * b10 + a13 * b11 + a23 * b12;
        out[8] = a00 * b20 + a10 * b21 + a20 * b22;
        out[9] = a01 * b20 + a11 * b21 + a21 * b22;
        out[10] = a02 * b20 + a12 * b21 + a22 * b22;
        out[11] = a03 * b20 + a13 * b21 + a23 * b22;
        if (a != out) {
            out[12] = a[12];
            out[13] = a[13];
            out[14] = a[14];
            out[15] = a[15];
        }
        return out;
    }

    public static float[] rotateX(float[] out, float[] a, float rad) {
        float s = glMatrix.sin(rad);
        float c = glMatrix.cos(rad);
        float a10 = a[4];
        float a11 = a[5];
        float a12 = a[6];
        float a13 = a[7];
        float a20 = a[8];
        float a21 = a[9];
        float a22 = a[10];
        float a23 = a[11];
        if (a != out) {
            out[0] = a[0];
            out[1] = a[1];
            out[2] = a[2];
            out[3] = a[3];
            out[12] = a[12];
            out[13] = a[13];
            out[14] = a[14];
            out[15] = a[15];
        }
        out[4] = a10 * c + a20 * s;
        out[5] = a11 * c + a21 * s;
        out[6] = a12 * c + a22 * s;
        out[7] = a13 * c + a23 * s;
        out[8] = a20 * c - a10 * s;
        out[9] = a21 * c - a11 * s;
        out[10] = a22 * c - a12 * s;
        out[11] = a23 * c - a13 * s;
        return out;
    }

    public static float[] rotateY(float[] out, float[] a, float rad) {
        float s = glMatrix.sin(rad);
        float c = glMatrix.cos(rad);
        float a00 = a[0];
        float a01 = a[1];
        float a02 = a[2];
        float a03 = a[3];
        float a20 = a[8];
        float a21 = a[9];
        float a22 = a[10];
        float a23 = a[11];
        if (a != out) {
            out[4] = a[4];
            out[5] = a[5];
            out[6] = a[6];
            out[7] = a[7];
            out[12] = a[12];
            out[13] = a[13];
            out[14] = a[14];
            out[15] = a[15];
        }
        out[0] = a00 * c - a20 * s;
        out[1] = a01 * c - a21 * s;
        out[2] = a02 * c - a22 * s;
        out[3] = a03 * c - a23 * s;
        out[8] = a00 * s + a20 * c;
        out[9] = a01 * s + a21 * c;
        out[10] = a02 * s + a22 * c;
        out[11] = a03 * s + a23 * c;
        return out;
    }

    public static float[] rotateZ(float[] out, float[] a, float rad) {
        float s = glMatrix.sin(rad);
        float c = glMatrix.cos(rad);
        float a00 = a[0];
        float a01 = a[1];
        float a02 = a[2];
        float a03 = a[3];
        float a10 = a[4];
        float a11 = a[5];
        float a12 = a[6];
        float a13 = a[7];
        if (a != out) {
            out[8] = a[8];
            out[9] = a[9];
            out[10] = a[10];
            out[11] = a[11];
            out[12] = a[12];
            out[13] = a[13];
            out[14] = a[14];
            out[15] = a[15];
        }
        out[0] = a00 * c + a10 * s;
        out[1] = a01 * c + a11 * s;
        out[2] = a02 * c + a12 * s;
        out[3] = a03 * c + a13 * s;
        out[4] = a10 * c - a00 * s;
        out[5] = a11 * c - a01 * s;
        out[6] = a12 * c - a02 * s;
        out[7] = a13 * c - a03 * s;
        return out;
    }

    public static float[] fromTranslation(float[] out, float[] v) {
        out[0] = 1;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = 1;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = 1;
        out[11] = 0;
        out[12] = v[0];
        out[13] = v[1];
        out[14] = v[2];
        out[15] = 1;
        return out;
    }

    public static float[] fromScaling(float[] out, float[] v) {
        out[0] = v[0];
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = v[1];
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = v[2];
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] fromRotation(float[] out, float rad, float[] axis) {
        float x = axis[0],
            y = axis[1],
            z = axis[2];
        float len = glMatrix.hypot(x, y, z);
        float s, c, t;
        if (len < glMatrix.EPSILON) {
            return null;
        }
        len = 1 / len;
        x *= len;
        y *= len;
        z *= len;
        s = glMatrix.sin(rad);
        c = glMatrix.cos(rad);
        t = 1 - c;
        out[0] = x * x * t + c;
        out[1] = y * x * t + z * s;
        out[2] = z * x * t - y * s;
        out[3] = 0;
        out[4] = x * y * t - z * s;
        out[5] = y * y * t + c;
        out[6] = z * y * t + x * s;
        out[7] = 0;
        out[8] = x * z * t + y * s;
        out[9] = y * z * t - x * s;
        out[10] = z * z * t + c;
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] fromXRotation(float[] out, float rad) {
        float s = glMatrix.sin(rad);
        float c = glMatrix.cos(rad);
        out[0] = 1;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = c;
        out[6] = s;
        out[7] = 0;
        out[8] = 0;
        out[9] = -s;
        out[10] = c;
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] fromYRotation(float[] out, float rad) {
        float s = glMatrix.sin(rad);
        float c = glMatrix.cos(rad);
        out[0] = c;
        out[1] = 0;
        out[2] = -s;
        out[3] = 0;
        out[4] = 0;
        out[5] = 1;
        out[6] = 0;
        out[7] = 0;
        out[8] = s;
        out[9] = 0;
        out[10] = c;
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] fromZRotation(float[] out, float rad) {
        float s = glMatrix.sin(rad);
        float c = glMatrix.cos(rad);
        out[0] = c;
        out[1] = s;
        out[2] = 0;
        out[3] = 0;
        out[4] = -s;
        out[5] = c;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = 1;
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] fromRotationTranslation(float[] out, float[] q, float[] v) {
        float x = q[0],
            y = q[1],
            z = q[2],
            w = q[3];
        float x2 = x + x;
        float y2 = y + y;
        float z2 = z + z;
        float xx = x * x2;
        float xy = x * y2;
        float xz = x * z2;
        float yy = y * y2;
        float yz = y * z2;
        float zz = z * z2;
        float wx = w * x2;
        float wy = w * y2;
        float wz = w * z2;
        out[0] = 1 - (yy + zz);
        out[1] = xy + wz;
        out[2] = xz - wy;
        out[3] = 0;
        out[4] = xy - wz;
        out[5] = 1 - (xx + zz);
        out[6] = yz + wx;
        out[7] = 0;
        out[8] = xz + wy;
        out[9] = yz - wx;
        out[10] = 1 - (xx + yy);
        out[11] = 0;
        out[12] = v[0];
        out[13] = v[1];
        out[14] = v[2];
        out[15] = 1;
        return out;
    }

    private static final float[] translation = new float[3];

    public static float[] fromQuat2(float[] out, float[] a) {
        // float[] translation = new float[3]; // GARBAGE
        float bx = -a[0],
            by = -a[1],
            bz = -a[2],
            bw = a[3],
            ax = a[4],
            ay = a[5],
            az = a[6],
            aw = a[7];
        float magnitude = bx * bx + by * by + bz * bz + bw * bw;
        if (magnitude > 0) {
            translation[0] = ((ax * bw + aw * bx + ay * bz - az * by) * 2) / magnitude;
            translation[1] = ((ay * bw + aw * by + az * bx - ax * bz) * 2) / magnitude;
            translation[2] = ((az * bw + aw * bz + ax * by - ay * bx) * 2) / magnitude;
        } else {
            translation[0] = (ax * bw + aw * bx + ay * bz - az * by) * 2;
            translation[1] = (ay * bw + aw * by + az * bx - ax * bz) * 2;
            translation[2] = (az * bw + aw * bz + ax * by - ay * bx) * 2;
        }
        fromRotationTranslation(out, a, translation);
        return out;
    }

    public static float[] getTranslation(float[] out, float[] mat) {
        out[0] = mat[12];
        out[1] = mat[13];
        out[2] = mat[14];
        return out;
    }

    public static float[] getScaling(float[] out, float[] mat) {
        float m11 = mat[0];
        float m12 = mat[1];
        float m13 = mat[2];
        float m21 = mat[4];
        float m22 = mat[5];
        float m23 = mat[6];
        float m31 = mat[8];
        float m32 = mat[9];
        float m33 = mat[10];
        out[0] = glMatrix.hypot(m11, m12, m13);
        out[1] = glMatrix.hypot(m21, m22, m23);
        out[2] = glMatrix.hypot(m31, m32, m33);
        return out;
    }

    private static final float[] scaling = new float[3];

    public static float[] getRotation(float[] out, float[] mat) {
        // float[] scaling = new float[3]; // GARBAGE
        getScaling(scaling, mat);
        float is1 = 1 / scaling[0];
        float is2 = 1 / scaling[1];
        float is3 = 1 / scaling[2];
        float sm11 = mat[0] * is1;
        float sm12 = mat[1] * is2;
        float sm13 = mat[2] * is3;
        float sm21 = mat[4] * is1;
        float sm22 = mat[5] * is2;
        float sm23 = mat[6] * is3;
        float sm31 = mat[8] * is1;
        float sm32 = mat[9] * is2;
        float sm33 = mat[10] * is3;
        float trace = sm11 + sm22 + sm33;
        float S = 0;
        if (trace > 0) {
            S = glMatrix.sqrt(trace + 1) * 2;
            out[3] = 0.25f * S;
            out[0] = (sm23 - sm32) / S;
            out[1] = (sm31 - sm13) / S;
            out[2] = (sm12 - sm21) / S;
        } else if (sm11 > sm22 && sm11 > sm33) {
            S = glMatrix.sqrt(1 + sm11 - sm22 - sm33) * 2;
            out[3] = (sm23 - sm32) / S;
            out[0] = 0.25f * S;
            out[1] = (sm12 + sm21) / S;
            out[2] = (sm31 + sm13) / S;
        } else if (sm22 > sm33) {
            S = glMatrix.sqrt(1 + sm22 - sm11 - sm33) * 2;
            out[3] = (sm31 - sm13) / S;
            out[0] = (sm12 + sm21) / S;
            out[1] = 0.25f * S;
            out[2] = (sm23 + sm32) / S;
        } else {
            S = glMatrix.sqrt(1 + sm33 - sm11 - sm22) * 2;
            out[3] = (sm12 - sm21) / S;
            out[0] = (sm31 + sm13) / S;
            out[1] = (sm23 + sm32) / S;
            out[2] = 0.25f * S;
        }
        return out;
    }

    public static float[] decompose(float[] out_r, float[] out_t, float[] out_s, float[] mat) {
        out_t[0] = mat[12];
        out_t[1] = mat[13];
        out_t[2] = mat[14];
        float m11 = mat[0];
        float m12 = mat[1];
        float m13 = mat[2];
        float m21 = mat[4];
        float m22 = mat[5];
        float m23 = mat[6];
        float m31 = mat[8];
        float m32 = mat[9];
        float m33 = mat[10];
        out_s[0] = glMatrix.hypot(m11, m12, m13);
        out_s[1] = glMatrix.hypot(m21, m22, m23);
        out_s[2] = glMatrix.hypot(m31, m32, m33);
        float is1 = 1 / out_s[0];
        float is2 = 1 / out_s[1];
        float is3 = 1 / out_s[2];
        float sm11 = m11 * is1;
        float sm12 = m12 * is2;
        float sm13 = m13 * is3;
        float sm21 = m21 * is1;
        float sm22 = m22 * is2;
        float sm23 = m23 * is3;
        float sm31 = m31 * is1;
        float sm32 = m32 * is2;
        float sm33 = m33 * is3;
        float trace = sm11 + sm22 + sm33;
        float S = 0;
        if (trace > 0) {
            S = glMatrix.sqrt(trace + 1) * 2;
            out_r[3] = 0.25f * S;
            out_r[0] = (sm23 - sm32) / S;
            out_r[1] = (sm31 - sm13) / S;
            out_r[2] = (sm12 - sm21) / S;
        } else if (sm11 > sm22 && sm11 > sm33) {
            S = glMatrix.sqrt(1 + sm11 - sm22 - sm33) * 2;
            out_r[3] = (sm23 - sm32) / S;
            out_r[0] = 0.25f * S;
            out_r[1] = (sm12 + sm21) / S;
            out_r[2] = (sm31 + sm13) / S;
        } else if (sm22 > sm33) {
            S = glMatrix.sqrt(1 + sm22 - sm11 - sm33) * 2;
            out_r[3] = (sm31 - sm13) / S;
            out_r[0] = (sm12 + sm21) / S;
            out_r[1] = 0.25f * S;
            out_r[2] = (sm23 + sm32) / S;
        } else {
            S = glMatrix.sqrt(1 + sm33 - sm11 - sm22) * 2;
            out_r[3] = (sm12 - sm21) / S;
            out_r[0] = (sm31 + sm13) / S;
            out_r[1] = (sm23 + sm32) / S;
            out_r[2] = 0.25f * S;
        }
        return out_r;
    }

    public static float[] fromRotationTranslationScale(float[] out, float[] q, float[] v, float[] s) {
        float x = q[0],
            y = q[1],
            z = q[2],
            w = q[3];
        float x2 = x + x;
        float y2 = y + y;
        float z2 = z + z;
        float xx = x * x2;
        float xy = x * y2;
        float xz = x * z2;
        float yy = y * y2;
        float yz = y * z2;
        float zz = z * z2;
        float wx = w * x2;
        float wy = w * y2;
        float wz = w * z2;
        float sx = s[0];
        float sy = s[1];
        float sz = s[2];
        out[0] = (1 - (yy + zz)) * sx;
        out[1] = (xy + wz) * sx;
        out[2] = (xz - wy) * sx;
        out[3] = 0;
        out[4] = (xy - wz) * sy;
        out[5] = (1 - (xx + zz)) * sy;
        out[6] = (yz + wx) * sy;
        out[7] = 0;
        out[8] = (xz + wy) * sz;
        out[9] = (yz - wx) * sz;
        out[10] = (1 - (xx + yy)) * sz;
        out[11] = 0;
        out[12] = v[0];
        out[13] = v[1];
        out[14] = v[2];
        out[15] = 1;
        return out;
    }

    public static float[] fromRotationTranslationScaleOrigin(float[] out, float[] q, float[] v, float[] s, float[] o) {
        float x = q[0],
            y = q[1],
            z = q[2],
            w = q[3];
        float x2 = x + x;
        float y2 = y + y;
        float z2 = z + z;
        float xx = x * x2;
        float xy = x * y2;
        float xz = x * z2;
        float yy = y * y2;
        float yz = y * z2;
        float zz = z * z2;
        float wx = w * x2;
        float wy = w * y2;
        float wz = w * z2;
        float sx = s[0];
        float sy = s[1];
        float sz = s[2];
        float ox = o[0];
        float oy = o[1];
        float oz = o[2];
        float out0 = (1 - (yy + zz)) * sx;
        float out1 = (xy + wz) * sx;
        float out2 = (xz - wy) * sx;
        float out4 = (xy - wz) * sy;
        float out5 = (1 - (xx + zz)) * sy;
        float out6 = (yz + wx) * sy;
        float out8 = (xz + wy) * sz;
        float out9 = (yz - wx) * sz;
        float out10 = (1 - (xx + yy)) * sz;
        out[0] = out0;
        out[1] = out1;
        out[2] = out2;
        out[3] = 0;
        out[4] = out4;
        out[5] = out5;
        out[6] = out6;
        out[7] = 0;
        out[8] = out8;
        out[9] = out9;
        out[10] = out10;
        out[11] = 0;
        out[12] = v[0] + ox - (out0 * ox + out4 * oy + out8 * oz);
        out[13] = v[1] + oy - (out1 * ox + out5 * oy + out9 * oz);
        out[14] = v[2] + oz - (out2 * ox + out6 * oy + out10 * oz);
        out[15] = 1;
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
        out[1] = yx + wz;
        out[2] = zx - wy;
        out[3] = 0;
        out[4] = yx - wz;
        out[5] = 1 - xx - zz;
        out[6] = zy + wx;
        out[7] = 0;
        out[8] = zx + wy;
        out[9] = zy - wx;
        out[10] = 1 - xx - yy;
        out[11] = 0;
        out[12] = 0;
        out[13] = 0;
        out[14] = 0;
        out[15] = 1;
        return out;
    }

    public static float[] frustum(float[] out, float left, float right, float bottom, float top, float near, float far) {
        float rl = 1 / (right - left);
        float tb = 1 / (top - bottom);
        float nf = 1 / (near - far);
        out[0] = near * 2 * rl;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = near * 2 * tb;
        out[6] = 0;
        out[7] = 0;
        out[8] = (right + left) * rl;
        out[9] = (top + bottom) * tb;
        out[10] = (far + near) * nf;
        out[11] = -1;
        out[12] = 0;
        out[13] = 0;
        out[14] = far * near * 2 * nf;
        out[15] = 0;
        return out;
    }

    public static float[] perspectiveNO(float[] out, float fovy, float aspect, float near, float far) {
        float f = 1 / glMatrix.tan(fovy / 2);
        out[0] = f / aspect;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = f;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[11] = -1;
        out[12] = 0;
        out[13] = 0;
        out[15] = 0;
        if (far != Float.POSITIVE_INFINITY) {
            float nf = 1 / (near - far);
            out[10] = (far + near) * nf;
            out[14] = 2 * far * near * nf;
        } else {
            out[10] = -1;
            out[14] = -2 * near;
        }
        return out;
    }

    public static float[] perspective(float[] out, float fovy, float aspect, float near, float far) {
        return perspectiveNO(out, fovy, aspect, near, far);
    }

    public static float[] perspectiveZO(float[] out, float fovy, float aspect, float near, float far) {
        float f = 1 / glMatrix.tan(fovy / 2);
        out[0] = f / aspect;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = f;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[11] = -1;
        out[12] = 0;
        out[13] = 0;
        out[15] = 0;
        if (far != Float.POSITIVE_INFINITY) {
            float nf = 1 / (near - far);
            out[10] = far * nf;
            out[14] = far * near * nf;
        } else {
            out[10] = -1;
            out[14] = -near;
        }
        return out;
    }

    public static float[] perspectiveFromFieldOfView(float[] out, float[] fov, float near, float far) {
        float upTan = glMatrix.tan(fov[0] * glMatrix.PI / 180);
        float downTan = glMatrix.tan(fov[1] * glMatrix.PI / 180);
        float leftTan = glMatrix.tan(fov[2] * glMatrix.PI / 180);
        float rightTan = glMatrix.tan(fov[3] * glMatrix.PI / 180);
        float xScale = 2 / (leftTan + rightTan);
        float yScale = 2 / (upTan + downTan);
        out[0] = xScale;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = yScale;
        out[6] = 0;
        out[7] = 0;
        out[8] = -((leftTan - rightTan) * xScale * 0.5f);
        out[9] = (upTan - downTan) * yScale * 0.5f;
        out[10] = far / (near - far);
        out[11] = -1;
        out[12] = 0;
        out[13] = 0;
        out[14] = (far * near) / (near - far);
        out[15] = 0;
        return out;
    }

    public static float[] orthoNO(float[] out, float left, float right, float bottom, float top, float near, float far) {
        float lr = 1 / (left - right);
        float bt = 1 / (bottom - top);
        float nf = 1 / (near - far);
        out[0] = -2 * lr;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = -2 * bt;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = 2 * nf;
        out[11] = 0;
        out[12] = (left + right) * lr;
        out[13] = (top + bottom) * bt;
        out[14] = (far + near) * nf;
        out[15] = 1;
        return out;
    }

    public static float[] ortho(float[] out, float left, float right, float bottom, float top, float near, float far) {
        return orthoNO(out, left, right, bottom, top, near, far);
    }

    public static float[] orthoZO(float[] out, float left, float right, float bottom, float top, float near, float far) {
        float lr = 1 / (left - right);
        float bt = 1 / (bottom - top);
        float nf = 1 / (near - far);
        out[0] = -2 * lr;
        out[1] = 0;
        out[2] = 0;
        out[3] = 0;
        out[4] = 0;
        out[5] = -2 * bt;
        out[6] = 0;
        out[7] = 0;
        out[8] = 0;
        out[9] = 0;
        out[10] = nf;
        out[11] = 0;
        out[12] = (left + right) * lr;
        out[13] = (top + bottom) * bt;
        out[14] = near * nf;
        out[15] = 1;
        return out;
    }

    public static float[] lookAt(float[] out, float[] eye, float[] center, float[] up) {
        float x0, x1, x2, y0, y1, y2, z0, z1, z2, len;
        float eyex = eye[0];
        float eyey = eye[1];
        float eyez = eye[2];
        float upx = up[0];
        float upy = up[1];
        float upz = up[2];
        float centerx = center[0];
        float centery = center[1];
        float centerz = center[2];
        if (
            glMatrix.abs(eyex - centerx) < glMatrix.EPSILON &&
            glMatrix.abs(eyey - centery) < glMatrix.EPSILON &&
            glMatrix.abs(eyez - centerz) < glMatrix.EPSILON
        ) {
            return identity(out);
        }
        z0 = eyex - centerx;
        z1 = eyey - centery;
        z2 = eyez - centerz;
        len = 1 / glMatrix.hypot(z0, z1, z2);
        z0 *= len;
        z1 *= len;
        z2 *= len;
        x0 = upy * z2 - upz * z1;
        x1 = upz * z0 - upx * z2;
        x2 = upx * z1 - upy * z0;
        len = glMatrix.hypot(x0, x1, x2);
        if (len == 0) {
            x0 = 0;
            x1 = 0;
            x2 = 0;
        } else {
            len = 1 / len;
            x0 *= len;
            x1 *= len;
            x2 *= len;
        }
        y0 = z1 * x2 - z2 * x1;
        y1 = z2 * x0 - z0 * x2;
        y2 = z0 * x1 - z1 * x0;
        len = glMatrix.hypot(y0, y1, y2);
        if (len == 0) {
            y0 = 0;
            y1 = 0;
            y2 = 0;
        } else {
            len = 1 / len;
            y0 *= len;
            y1 *= len;
            y2 *= len;
        }
        out[0] = x0;
        out[1] = y0;
        out[2] = z0;
        out[3] = 0;
        out[4] = x1;
        out[5] = y1;
        out[6] = z1;
        out[7] = 0;
        out[8] = x2;
        out[9] = y2;
        out[10] = z2;
        out[11] = 0;
        out[12] = -(x0 * eyex + x1 * eyey + x2 * eyez);
        out[13] = -(y0 * eyex + y1 * eyey + y2 * eyez);
        out[14] = -(z0 * eyex + z1 * eyey + z2 * eyez);
        out[15] = 1;
        return out;
    }

    public static float[] targetTo(float[] out, float[] eye, float[] target, float[] up) {
        float eyex = eye[0],
            eyey = eye[1],
            eyez = eye[2],
            upx = up[0],
            upy = up[1],
            upz = up[2];
        float z0 = eyex - target[0],
            z1 = eyey - target[1],
            z2 = eyez - target[2];
        float len = z0 * z0 + z1 * z1 + z2 * z2;
        if (len > 0) {
            len = 1 / glMatrix.sqrt(len);
            z0 *= len;
            z1 *= len;
            z2 *= len;
        }
        float x0 = upy * z2 - upz * z1,
            x1 = upz * z0 - upx * z2,
            x2 = upx * z1 - upy * z0;
        len = x0 * x0 + x1 * x1 + x2 * x2;
        if (len > 0) {
            len = 1 / glMatrix.sqrt(len);
            x0 *= len;
            x1 *= len;
            x2 *= len;
        }
        out[0] = x0;
        out[1] = x1;
        out[2] = x2;
        out[3] = 0;
        out[4] = z1 * x2 - z2 * x1;
        out[5] = z2 * x0 - z0 * x2;
        out[6] = z0 * x1 - z1 * x0;
        out[7] = 0;
        out[8] = z0;
        out[9] = z1;
        out[10] = z2;
        out[11] = 0;
        out[12] = eyex;
        out[13] = eyey;
        out[14] = eyez;
        out[15] = 1;
        return out;
    }

    public static String str(float[] a) {
        return "mat4(" +
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
            ", " +
            a[9] +
            ", " +
            a[10] +
            ", " +
            a[11] +
            ", " +
            a[12] +
            ", " +
            a[13] +
            ", " +
            a[14] +
            ", " +
            a[15] +
            ")";
    }

    public static float frob(float[] a) {
        return glMatrix.hypot(
            a[0],
            a[1],
            a[2],
            a[3],
            a[4],
            a[5],
            a[6],
            a[7],
            a[8],
            a[9],
            a[10],
            a[11],
            a[12],
            a[13],
            a[14],
            a[15]
        );
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
        out[9] = a[9] + b[9];
        out[10] = a[10] + b[10];
        out[11] = a[11] + b[11];
        out[12] = a[12] + b[12];
        out[13] = a[13] + b[13];
        out[14] = a[14] + b[14];
        out[15] = a[15] + b[15];
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
        out[9] = a[9] - b[9];
        out[10] = a[10] - b[10];
        out[11] = a[11] - b[11];
        out[12] = a[12] - b[12];
        out[13] = a[13] - b[13];
        out[14] = a[14] - b[14];
        out[15] = a[15] - b[15];
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
        out[9] = a[9] * b;
        out[10] = a[10] * b;
        out[11] = a[11] * b;
        out[12] = a[12] * b;
        out[13] = a[13] * b;
        out[14] = a[14] * b;
        out[15] = a[15] * b;
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
        out[9] = a[9] + b[9] * scale;
        out[10] = a[10] + b[10] * scale;
        out[11] = a[11] + b[11] * scale;
        out[12] = a[12] + b[12] * scale;
        out[13] = a[13] + b[13] * scale;
        out[14] = a[14] + b[14] * scale;
        out[15] = a[15] + b[15] * scale;
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
            a[8] == b[8] &&
            a[9] == b[9] &&
            a[10] == b[10] &&
            a[11] == b[11] &&
            a[12] == b[12] &&
            a[13] == b[13] &&
            a[14] == b[14] &&
            a[15] == b[15];
    }

    public static boolean equals(float[] a, float[] b) {
        float a0 = a[0],
            a1 = a[1],
            a2 = a[2],
            a3 = a[3];
        float a4 = a[4],
            a5 = a[5],
            a6 = a[6],
            a7 = a[7];
        float a8 = a[8],
            a9 = a[9],
            a10 = a[10],
            a11 = a[11];
        float a12 = a[12],
            a13 = a[13],
            a14 = a[14],
            a15 = a[15];
        float b0 = b[0],
            b1 = b[1],
            b2 = b[2],
            b3 = b[3];
        float b4 = b[4],
            b5 = b[5],
            b6 = b[6],
            b7 = b[7];
        float b8 = b[8],
            b9 = b[9],
            b10 = b[10],
            b11 = b[11];
        float b12 = b[12],
            b13 = b[13],
            b14 = b[14],
            b15 = b[15];
        return glMatrix.abs(a0 - b0) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a0), glMatrix.abs(b0)) &&
            glMatrix.abs(a1 - b1) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a1), glMatrix.abs(b1)) &&
            glMatrix.abs(a2 - b2) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a2), glMatrix.abs(b2)) &&
            glMatrix.abs(a3 - b3) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a3), glMatrix.abs(b3)) &&
            glMatrix.abs(a4 - b4) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a4), glMatrix.abs(b4)) &&
            glMatrix.abs(a5 - b5) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a5), glMatrix.abs(b5)) &&
            glMatrix.abs(a6 - b6) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a6), glMatrix.abs(b6)) &&
            glMatrix.abs(a7 - b7) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a7), glMatrix.abs(b7)) &&
            glMatrix.abs(a8 - b8) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a8), glMatrix.abs(b8)) &&
            glMatrix.abs(a9 - b9) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a9), glMatrix.abs(b9)) &&
            glMatrix.abs(a10 - b10) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a10), glMatrix.abs(b10)) &&
            glMatrix.abs(a11 - b11) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a11), glMatrix.abs(b11)) &&
            glMatrix.abs(a12 - b12) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a12), glMatrix.abs(b12)) &&
            glMatrix.abs(a13 - b13) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a13), glMatrix.abs(b13)) &&
            glMatrix.abs(a14 - b14) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a14), glMatrix.abs(b14)) &&
            glMatrix.abs(a15 - b15) <= glMatrix.EPSILON * glMatrix.max(1, glMatrix.abs(a15), glMatrix.abs(b15));
    }

    public static float[] mul(float[] out, float[] a, float[] b) {
        return multiply(out, a, b);
    }

    public static float[] sub(float[] out, float[] a, float[] b) {
        return subtract(out, a, b);
    }
}
