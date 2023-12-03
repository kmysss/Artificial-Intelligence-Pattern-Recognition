public class Threshold {
    static public int image[][] = {
        {38, 153, 151, 154, 59, 0, 2, 0, 0, 0},
        {66, 255, 255, 255, 104, 0, 4, 0, 0, 0},
        {62, 252, 248, 252, 98, 0, 4, 0, 0, 0},
        {64, 255, 253, 255, 101, 4, 8, 1, 0, 0},
        {12, 50, 48, 51, 18, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 3, 105, 107, 9, 0, 1},
        {1, 3, 5, 3, 157, 255, 255, 161, 1, 2},
        {0, 1, 0, 2, 228, 252, 251, 233, 4, 0},
        {0, 0, 2, 0, 121, 255, 255, 127, 0, 3},
        {0, 0, 0, 0, 0, 64, 65, 0, 0, 1}
    };
    
public static void main(String args[]) {
for(int i = 0; i < 10; i++) {
for (int j = 0; j <10; j++) {
if(image[i][j] <= 18)
image[i][j]=0;
else
image[i][j]=1;
}
}
for(int q= 0; q<10; q++) {
 
 System.out.println( image[q][0]+" "+ image[q][1]+" "+image[q][2]+" "+image[q][3]+" "+image[q][4] +" "+image[q][5]+" "+image[q][6]+" "+image[q][7]+" "+image[q][8]+" "+image[q][9]);

}
}
}