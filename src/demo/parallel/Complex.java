/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package demo.parallel;


/**
 * A complex number is a number that can be expressed in the form a + b * i, where
 * a and b are real numbers and i is the imaginary unit, which satisfies the
 * equation i ^ 2 = -1. a is the real part and b is the imaginary part of the
 * complex number.
 * <p><i>
 * This source code is provided to illustrate the usage of a given feature
 * or technique and has been deliberately simplified. Additional steps
 * required for a production-quality application, such as security checks,
 * input validation and proper error handling, might not be present in
 * this sample code.</i>
 * @author Alexander Kouznetsov, Tristan Yan
 */
public class Complex {
    private double re;
    private double im;

    public Complex(double real, double imag) {
        this.re = real;
        this.im = imag;
    }

    public Complex plus(Complex b) {
        this.re += b.re;
        this.im += b.im;
        return this;
    }

    public Complex times(Complex b) {
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        this.re = real;
        this.im = imag;
        return this;
    }

    public Complex minus(Complex b) {
        this.re -= b.re;
        this.im -= b.im;
        return this;
    }

    public Complex divide(Complex b) {
        double denominator = b.re * b.re + b.im * b.im;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double real = (this.re * b.re + this.im * b.im) / denominator;
        double imag = (this.im * b.re - this.re * b.im) / denominator;
        this.re = real;
        this.im = imag;
        return this;
    }

    public double lengthSQ() {
        return this.re * this.re + this.im * this.im;
    }
}