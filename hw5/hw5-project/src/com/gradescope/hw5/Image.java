package com.gradescope.hw5;
import java.util.Arrays;


/**
 * The Image class represents an image as a 2 dimensional array.
 * 
 * 
 * @author - CS60
 */
public class Image {
	
	private char[][] image;
	private int height;
	private int width;

	static char[][] smiley = {
		{' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' '},
		{'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
		{'*', ' ', ' ', '^', ' ', ' ', ' ', '^', ' ', ' ', '*'},
		{'*', ' ', ' ', ' ', ' ', 'N', ' ', ' ', ' ', ' ', '*'},
		{'*', ' ', '\\',' ', ' ', ' ', ' ', ' ', '/', ' ', '*'},
		{'*', ' ', ' ', '-', '-', '-', '-', '-', ' ', ' ', '*'},
		{'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
		{' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' '}		
	};

	/**
	 * Initializes a new Image with n array or character arrays.
	 * heigth and width are obtained from number of arrays and subarrays respectively
	 *  
	 * @param contents - an array or character arrays
	 */
	public Image(char[][] contents) {
		image = contents;
		
		// always assume the array is at least of size 1x1
		height = image.length;
		width = image[0].length;
	}
	

	/**
	 * Rotates an Image by 90 degrees.
	 * 
	 * @return - Image of rotated contents
	 */
    public Image rotateRight() {
		char[][] rotatedContents = new char[this.width][this.height];

    	for(int row=0; row < this.height; row++){
			for(int col=0; col < this.width; col++){
				rotatedContents[col][this.height-1 - row] = this.image[row][col];
			}
		}
		return new Image(rotatedContents);
	}

	/**
	 * Flips an image vertically.
	 * 
	 * @return - Image of vertically flipped contents
	 */
    public Image flipVertical() {
		char[][] flippedContents = new char[this.height][this.width];

    	for(int row=0; row < this.height; row++){
			for(int col=0; col < this.width; col++){
				flippedContents[this.height - 1 -row][col] = this.image[row][col];
			}
		}
		Image flippedImage = new Image(flippedContents); 
		return flippedImage;
    }

	/**
	 * Flips an image along its diagonal.
	 * 
	 * @return - Image of contents flipped along the diagonal
	 */
    public Image flipDiagonal() {
		char[][] flippedContents = new char[this.height][this.width];

    	for(int row=0; row < this.height; row++){
			for(int col=0; col < this.width; col++){
				flippedContents[col][row] = this.image[row][col];
			}
		}
		Image flippedImage = new Image(flippedContents); 
		return flippedImage;
    }

	/**
	 * The method prints the contents of the image a row at a time.
	 * 
	 */
    public void printImage() {
    	for(int row=0; row < this.height; row++){
			System.out.println(this.image[row]);
		}
    }
    
	/**
	 * The method compares the arrys of characters of this with other.
	 * Returns true if all characters are simila and false otherwise.
	 * 
	 * @param other - Image to check if equal to this
	 * @return - true if all characters similar, false if not
	 */
    public boolean equals(Image other) {
    	for(int row=0; row < this.height; row++){
			if (!Arrays.equals(this.image[row], other.image[row])){ //if the rows are not equal
				return false;
			}
		}
		return true;
    }

    public static void main (String [] args) {
		System.out.println("CS60 Face");
		Image face = new Image(smiley);
		face.printImage();

		System.out.println("\nUpside Down");
		face = new Image(smiley).flipVertical();
		face.printImage();

		System.out.println("\nFlip Diagonal");
		face = new Image(smiley).flipDiagonal();
		face.printImage();

		System.out.println("\nRotate Right");
		face = new Image(smiley).rotateRight();
		face.printImage();
    }
}

