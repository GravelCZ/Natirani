This program will calculate these things about the shapes from input.txt(see below):
Perimeter of all the shapes, regardless of if they are inside of another shape or not
Total required amount of color for all the shapes
Detailed amount of all the colors required

Limitations:
Triangle can only be a right angle one
Shapes that are inside of another shape include the whole shape, not part of it
Path to input file is not variable
Shape that is inside of another one cannot have other shapes inside of it, no nested shapes, only one "layer"
Incorrect calculation might happen when the order of shapes is not corrent (this SHOULD work, but I did not test it properly)
 - Always define the shapes that are not inside of any shapes then the shapes that are inside of another shape
The amount of shapes that are in other shape is NOT LIMITED, you can have 500 shapes in another one
Bigger shapes cannot be inside smaller shapes (obviously) 
Shape cannot be inside of it self (obviously)
You can put 2 shapes perfectly half the size of the shape they are inside of and it will bring the area down to 0

Usage:
A file called input.txt has to be in the same directory as the runnable file

input.txt format:

Only one shape per line

[] is required
<> is optional
() is the type

[shape type](String) [color](String) [shape index](Integer) [size x](Double) <size y>(Double)

Example:
TRIANGLE red -1 2 5
CIRCLE blue 0 2
RECTANGLE lime -1 5 4

Valid shape types:

SQUARE
RECTANGLE
CIRLCLE
ELLIPSE
TRIANGLE (only right angle)

Color can be any string, not limited by any definition

Shape index is the the index of another shape that this one is inside of
0 is for the first shape, 1 for second, etc.
-1 is for no shape

Size X:
The side length of a square or a rectangle
For Circle that is the radius
For Ellipse that is the length of axis X
For Triangle that is the length of side a

Size Y:
**NOT USED FOR CIRCLE AND SQUARE**
The other side length of a rectangle
For Ellipse that is the length of axis y
For Triangle that is the length of side b
