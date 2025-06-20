package com.gradescope.hw5;

/**
 * The Complex class represents a complex number and includes methods for
 * performing basic operations with complex numbers.
 */
public class Complex {

	/**
	 * The real component.
	 */
	private double real;

	/**
	 * The imaginary component.
	 */
	private double imag;

	/**
	 * The difference at which numbers are considered equal.
	 */
	public final static double EPSILON = 0.000001;

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	/**
	 * Initializes a new complex object at the origin.
	 */
	public Complex() {
		this(0.0, 0.0); // calls generalized constructor
	}

	/**
	 * Initializes a new complex object.
	 * 
	 * @param real - The real component
	 * @param imag - The imaginary component
	 */
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	/**
	 * Returns a string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Complex [real=" + real + ", imag=" + imag + "]";
	}

	/**
	 * Compares this complex number to the specified object. The result is true if
	 * and only if this complex object represents the same complex number as the
	 * specified object, up to an error margin.
	 * 
	 * @param obj - The object to compare this complex object against
	 * @return true if the two complex objects represent the same location
	 */
	@Override
	public boolean equals(Object obj) {
		// See Point.equals(obj) for more details.
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Complex other = (Complex) obj;
		if (Math.abs(this.real - other.real) >= EPSILON) {
			return false;
		}
		if (Math.abs(this.imag - other.imag) >= EPSILON) {
			return false;
		}
		return true;
	}

	/**
	 * Computes the magnitude of this complex number.
	 * 
	 * To compute the magnitude complex number:<br/>
	 * mag(a + bi) = square_root( a*a + b*b )<br/>
	 * via the Pythagorean Theorem
	 * 
	 * @return The magnitude of this complex number
	 */
	public double magnitude() {
		return Math.sqrt(real * real + imag * imag);
	}

	/**
	 * Negates this complex number.
	 * 
	 * To negate a complex number, compute its additive inverse:<br/>
	 * neg(a + bi) = -a - bi
	 * 
	 * @return A new complex object that is the negation of this complex number
	 */
	public Complex negate() {
		return new Complex(-1 * real, -1 * imag);
	}

	/**
	 * Destructively negates this complex number.
	 */
	public void negateDest() {
		this.setReal(real * -1);
		this.setImag(imag * -1);
	}

	/**
	 * Conjugates this complex number.
	 * 
	 * To conjugate complex number:<br/>
	 * conj(a + bi) = a - bi
	 * 
	 * @return A new complex object that is the conjugate of this complex number
	 */
	public Complex conjugate() {
		return new Complex(real, imag * -1);
	}

	/**
	 * Destructively conjugates this complex number.
	 */
	public void conjugateDest() {
		this.setImag(imag * -1);
	}

	/**
	 * Adds this complex number and another complex number.
	 * 
	 * To add two complex numbers':<br/>
	 * (a + bi) + (c + di) = (a+c) + (b+d)i
	 * 
	 * @param other - The other complex object
	 * @return A new complex object that is the sum of this complex number and the
	 *         other complex number
	 */
	public Complex add(Complex other) {
		return new Complex(this.real + other.real, this.imag + other.imag);
	}

	/**
	 * Destructively adds another complex number to this one. The other object does
	 * not change.
	 * 
	 * @param other - The other complex object
	 */
	public void addDest(Complex other) {
		this.setReal(this.real + other.real);
		this.setImag(this.imag + other.imag);
	}

	/**
	 * Multiples this complex number and another complex number.
	 *
	 * To multiply two complex numbers:<br/>
	 * (a + bi) * (c + di) = ac + adi + bci + bd(i^2) = (ac - bd) + (ad + bc)i
	 *
	 * @param other - The other complex object
	 * @return A new complex object that is the product of this complex number and
	 *         the other complex number
	 */
	public Complex multiply(Complex other) {
		return new Complex((this.real * other.real) - (this.imag * other.imag), (this.real * other.imag) + (this.imag * other.real));
	}

	/**
	 * Divides this complex number by another complex number.
	 * 
	 * If other == 0, returns Double.NaN + Double.NaN * i.
	 * 
	 * To compute the quotient of two complex numbers,<br/>
	 * use the conjugate of the denominator, and simplifies
	 * like so:
	 * 
	 * <pre>
	 * a + bi
	 * ------
	 * c + di
	 * 
	 *   a + bi   c - di
	 * = ------ . ------
	 *   c + di   c - di
	 * 
	 *   ac - adi + bci - bdii
	 * = ---------------------
	 *         cc - ddii
	 *
	 *   (ac + bd) + (bc - ad)i
	 * = ----------------------
	 *          cc + dd
	 * 
	 *   (ac + bd)   (bc - ad)
	 * = --------- + --------- i
	 *    cc + dd     cc + dd
	 * </pre>
	 * 
	 * @param other - The other complex object
	 * @return A new complex number that is the quotient of this number and the
	 *         other complex number
	 */
	public Complex divide(Complex other) {
		double a = this.real;
		double b = this.imag;
		double c = other.real;
		double d = other.imag;

		return new Complex(((a * c) + (b * d))/((c * c) + (d * d)), ((b * c) - (a * d))/((c * c) + (d * d)));
	}
}
