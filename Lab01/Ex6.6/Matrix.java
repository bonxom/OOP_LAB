
public class Matrix {
    private int width, height;
    private int[][] nums;

    public Matrix(int height, int width, int[][] nums) {
        this.width = width;
        this.height = height;
        this.nums = nums;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getNums() {
        return nums;
    }
    
    public Matrix add (Matrix a){
        int[][] sum = new int[this.height][this.width];
        int[][] a_nums = a.getNums();
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                sum[i][j] = this.nums[i][j] + a_nums[i][j];
            }
        }
        return new Matrix(this.height, this.width, sum);
    }
    
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                res.append(this.nums[i][j]);
                res.append(" ");
            }
            res.append("\n");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
